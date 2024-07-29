package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExampleRunnable2 implements Runnable {
    private final String c;

    public ThreadExampleRunnable2(String c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
            Thread.yield();
        }
    }
}

// O Yield é um método que foi criado pra você falar para a Thread que está em execução dar uma pausa, você quer que o
// agendador a JVM o scheduler ele passa a Thread voltar para Runnable, mas ele não tem muita garantia porque ele pode
// ser ignorado pelo scheduler
// A gente tem a Thread main que é a Thread que está executando tudo, você tem outras Threads que é a t1 e t2 e elas
// estão executando esse método run
// A Thread main funciona basicamente dessa forma quando você dá o t1.start você está deixando essa Thread de um estado
// New para Runnable, continuando o fluxo do programa a Thread main vai dar um start no t2, e essas duas Threads t1 e t2
// vão trabalhar no método run
// O que o Join faz? Quando você inicia não tem garantia que o t1 vai ser executado até o final antes do t2 ser
// executado, mas as vezes você quer que, por exemplo, antes de você chamar a Thread t2 você precisa que a Thread t1
// finalize o trabalho dela e nesse caso você usa o Join, o Join você está falando pra Thread main, ou seja, a Thread
// que está iniciando as outras duas Join, ou seja, junte-se a Thread que você der o Join, então pode ser, por exemplo,
// a t1
// Basicamente o Join vai falar para a Thread que está executando o join, nesse caso a Thread main está executando o
// join, você está falando Thread main agora você vai dar um join, ou seja, você vai se juntar a t1 enquanto ela não
// terminar você não dá procedimento na sua linha de execução, ou seja, esse código aqui fica bloqueado
public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"));
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME"));
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t1.join();
        t2.start();
    }
}