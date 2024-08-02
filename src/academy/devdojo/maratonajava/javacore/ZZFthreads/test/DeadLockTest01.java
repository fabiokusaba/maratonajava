package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

// Vamos imaginar que temos duas Threads Natsu e Lucy, Natsu está segurando o lock do objeto A e Lucy está segurando o
// lock do objeto B, por um acaso do destino você precisa que o Natsu acesse o objeto B, mas nessa hora ele vê que Lucy
// está segurando lock, ou seja, Natsu vai ficar esperando e a Lucy vai estar fazendo o seu processamento, mas aí você
// por algum motivo acabou desenvolvendo um código que Lucy agora vai precisar acessar o objeto A, mas para isso ela
// precisa que Natsu libere o lock de A, mas o Natsu pra liberar o lock de A ele precisa terminar o lock de B, esse caso
// é chamado de DeadLock
// Quando acontece um DeadLock não tem o que você fazer só reiniciando a aplicação
public class DeadLockTest01 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable r1 = () -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Segurando lock 1");
                System.out.println("Thread 1: Esperando lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Segurando lock 2");
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Esperando lock 1");
                synchronized (lock1) {
                    System.out.println("Thread 2: Segurando lock 1");
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
