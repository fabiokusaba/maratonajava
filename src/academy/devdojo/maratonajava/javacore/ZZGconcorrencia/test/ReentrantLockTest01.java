package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            // Se a gente trocar aqui para tentar obter o lock e falar: você tenta obter o lock por 2s e se não
            // der as Threads simplesmente não vão ficar esperando, mas aí vem um problema que se você tentar
            // executar esse código e você tentar dar unlock numa Thread que não tem o lock você vai ter uma
            // pequena exceção porque as Threads tentaram unlock sendo que elas não estavam segurando aquele
            // lock aí sim aquele código if que utilizamos fica interessante e você não vai mais ver aquela
            // exceção
            lock.tryLock(2, TimeUnit.SECONDS);

            // Verificando qual a Thread que pegou o lock
            if (lock.isHeldByCurrentThread()) {
                System.out.printf("Thread %s pegou o LOCK%n", name);
            }

            // Basicamente vai verificar se o lock está nas mãos da Thread que está executando esse código agora
            // Aqui dentro sempre teremos o lock, e isso seria interessante se a gente tentasse obter o lock
            // if (lock.isHeldByCurrentThread()) {
            //     // A sessão crítica é a sessão que nós temos dentro do lock
            //     System.out.printf("Thread %s entrou em uma sessão crítica%n", name);
            // }

            // Esse método basicamente retorna o valor estimado do número de Threads esperando para adquirir esse lock
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
            System.out.printf("Thread %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
public class ReentrantLockTest01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}
