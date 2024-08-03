package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Imagine que você tem uma coleção aonde você tem uma thread que está fazendo escrita naquela coleção
// e você tem, por exemplo, 5 threads que estão fazendo a leitura
// Quando você está fazendo escrita na coleção geralmente você não quer que ninguém leia para não pegar
// um valor errado, então esse lock toma conta disso se você está escrevendo ele não consegue adquirir
// o lock de leitura e se você está lendo o lock de escrita tem que esperar até a leitura ser finalizada

class MapReadWrite {
    private final Map<String, String> map = new LinkedHashMap<>();

    // Como você pode ver o objetivo dessa ReentrantReadWriteLock basicamente é você ter o controle sobre
    // leitura e escrita no mesmo objeto
    // Quando você está escrevendo você bloqueia a leitura, não é ideal você estar escrevendo e as pessoas
    // estarem lendo ao mesmo tempo isso pode dar problema e basicamente é um lock que funciona em par
    private final ReentrantReadWriteLock rwl;

    public MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value) {
        // Como estou escrevendo a primeira coisa que eu quero fazer é obter o lock
        // Aqui nós obtemos o lock de escrita
        rwl.writeLock().lock();

        // Aqui não muda nada continuamos utilizando try-finally porque temos que liberar esse lock
        // Então, sempre precisamos fazer esse passo a passo pegou o lock de escrita libera o lock de escrita
        // pegou o lock de leitura libera o lock de leitura
        try {
            if (rwl.isWriteLocked()) {
                System.out.printf("%s obteve o WRITE lock%n", Thread.currentThread().getName());
            }
            // Adicionamos um sleep para simular um processamento
            Thread.sleep(500);

            // Após adicionamos os valores no nosso map
            map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Set<String> allKeys() {
        // Agora teremos o lock de leitura
        // Você pode ter mais de uma thread obtendo lock de leitura, mas lock de escrita somente uma thread
        rwl.readLock().lock();

        try {
            return map.keySet();
        } finally {
            rwl.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);

        // Criamos os Runnables
        Runnable writer = () -> {
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i), String.valueOf(i));
            }
        };

        Runnable reader = () -> {
            // Estou falando olha essa aqui é a thread de leitura e ela está bloqueada porque tem alguém segurando
            // o lock de escrita
            if (rwl.isWriteLocked()) {
                System.out.println("WRITE LOCKED!");
            }

            // Pegando o lock de leitura, mas eu não posso pegar o lock de leitura se o lock de escrita tiver bloqueado
            rwl.readLock().lock();
            System.out.println("FINALLY I GOT THE DAMN LOCK");

            // Agora a gente precisa do try-finally
            // Por que estou usando o readLock aqui dentro dessa thread? Porque como vou usar o print pode ser que dê
            // problema não tenho certeza se vai dar problema ou não
            try {
                System.out.println(Thread.currentThread().getName() + " " + mapReadWrite.allKeys());
            } finally {
                rwl.readLock().unlock();
            }
        };

        // Partiu criar as threads
        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);

        // Iniciando as threads
        t1.start();
        t2.start();
        t3.start();
    }
}
