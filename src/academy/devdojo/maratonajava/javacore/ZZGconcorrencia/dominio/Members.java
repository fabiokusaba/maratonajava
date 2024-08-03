package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Quando você está trabalhando com ReentrantLock para você utilizar o wait e o notifyAll você precisa
// utilizar uma classe que tem dentro do pacote concurrent que é a Condition esse cara aqui vai ser o
// responsável por trabalhar com as condições do lock
// Então, pra pegar um condition você pega a condição do lock.newCondition que vai retornar uma condição
// para aquela instância do lock, se você tivesse mais de um lock você teria que provavelmente pegar
// diferentes condições
// Então, essa condição suporta wait, notify, notifyAll
public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    public void addMemberEmail(String email) {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);

            // E agora para notificar todas as Threads que estão esperando utilizamos
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        lock.lock();
        try {
            while (this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");

                // E aqui aonde tínhamos o wait vamos trocar para a condição
                condition.await();
            }
            return this.emails.poll();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando emails");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
