package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

// Thread tem duas definições: pode ser um objeto porque nós temos uma classe chamada Thread onde nós podemos criar
// literalmente um objeto do tipo Thread e nós temos um processo uma linha de execução
// No sistema operacional você tem diversos tipos de Threads, são como se fossem trabalhadores que divide a carga de
// tarefas de um determinado processo
// Basicamente quando estamos trabalhando com Threads pouca coisa é garantida a JVM no caso o Java vai tomar conta da
// execução dessas Threads e na maioria dos casos você não tem muito o que fazer você pode meio que dar indicações do
// que gostaria que acontecesse, mas a parte de escalonamento quando a Thread vai ser executada, quando ela vai ser
// parada, quando ela vai ser terminada é tudo parte da JVM
// Quando você tem processador geralmente o processador tem os núcleos e os processadores lógicos que geralmente é o
// dobro
// Você tem dois tipos de Threads: Daemon x User -> o que você precisa saber é que o Java encerra o programa quando
// todas as Threads do tipo User são terminadas, Threads do tipo Daemon não tem tanta prioridade é por exemplo a Thread
// que toma conta do Garbage Collector, ou seja, que vai remover e limpar os objetos de memória, ou seja, se aquela
// Thread estiver sendo executada e as Threads de User tiverem sido finalizadas o programa vai acabar independente dessa
// Thread Daemon estar rodando ou não
// E como nós falamos se você tem múltiplas Threads em algumas operações você consegue executar em paralelo, assim como
// nós vimos na última aula Parallel Streams aqui a gente vai fazer manualmente o processo de trabalhar com Threads

// Existem algumas formas de você criar uma Thread, uma dessas formas é você extendendo da classe Thread, por exemplo
class ThreadExample extends Thread {
    private final char c;

    public ThreadExample(char c) {
        this.c = c;
    }

    // Agora você tem um objeto que é do tipo Thread que passa no teste é uma Thread e o código que você quer que seja
    // executado por Thread diferente precisa ir no método
    // E dentro desse método run é o código que você colocar que vai ser executado pela Thread separada
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
        }
    }
}

// Outra forma de você trabalhar com Threads é você implementando a interface Runnable
class ThreadExampleRunnable implements Runnable {
    private final char c;

    public ThreadExampleRunnable(char c) {
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
            // Por exemplo, as vezes você quer utilizar uma Thread, a Thread está dentro de um loop e esse loop vai
            // consultar um estoque, consulta uma API a cada determinado momento, e você não quer que ele fique
            // executando, geralmente existe a possibilidade de você utilizar o sleep
            // O sleep precisa estar dentro de um try/catch porque se ela não dormir os 2s você vai ser uma exceção
            // Então, é uma das poucas garantias das Threads que ela vai dormir por 2s
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {
        // Primeira coisa o programa tem uma Thread e toda Thread tem um nome e podemos pegar o seu nome da seguinte
        // forma
        // Você vai ver que a Thread é a main, a Thread que executa um programa no Java é chamada de Thread main
//        System.out.println(Thread.currentThread().getName());

        // Primeiro a gente cria um objeto
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');

        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "T1A");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "T2B");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "T3C");
        Thread t4 = new Thread(new ThreadExampleRunnable('D'), "T4D");

        // As Threads tem prioridade geralmente a prioridade vai de 1 a 10, digamos que você gostaria que a t4 começasse
        // primeiro, então você pode setar a sua prioridade
        // Quando você coloca uma prioridade 10 você está dizendo que você está dando uma indicação para o scheduler pra
        // ele dar uma prioridade para essa Thread t4, mas não é garantido que ela tenha prioridade
        t4.setPriority(Thread.MAX_PRIORITY);

        // Quando nós executamos assim não estamos executando em Threads diferentes
        // O que você pode perceber aqui é que ele começou pela Thread main imprimiu A até o final, em seguida com a
        // Thread main também imprimiu B e assim por diante, ou seja, a gente utilizou apenas uma Thread porque a gente
        // não deu start
        // Quando você está trabalhando com múltiplas Threads ao invés de você chamar run, quando você chama run você
        // fala Thread main executa o método run do objeto t1, mas aí quando você dá um start as coisas mudam porque
        // agora você está falando para JVM começar uma nova Thread, ou seja, todas as vezes que a Thread main chegar
        // aqui nesse t1 a Thread main vai dar um start em uma outra Thread
//        t1.run();
//        t2.run();
//        t3.run();
//        t4.run();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Você vai ver que lá no comecinho em algum lugar você tem esse método main possivelmente após essa linha a
        // Thread main morreu, mas você tem as outras Threads sendo executadas, lembre-se que o programa para quando
        // todas as Threads de usuário, que são as Threads que nós criamos, mudam de estado para Thread morta
        // O scheduler que decide quem vai continuar em execução
        System.out.println("###################### " + Thread.currentThread().getName());

        // A primeira coisa que a gente precisa saber é que a gente não pode dar dois start, uma vez que você já deu
        // um start na Thread você não pode dar um start novamente porque você vai ter uma exceção IllegalThreadState
//        t1.start();

        // Outra coisa é você entender como elas funcionam, por exemplo, toda vez que você starta o método main você tem
        // a Thread main sendo executada
        // Imagine a Thread main como se fosse um corredor, a Thread main vai executar linha por linha sequencialmente
        // e quando chegar no objeto t1 e vai falar você pode startar e vai continuar, mas não necessariamente
        // significa que vai acontecer na sequência porque quando você inicia uma Thread o scheduler pode decidir o
        // tempo de execução, mas no final das contas a Thread main que é a principal nunca vai entrar nesse método run
        // porque para entrar você precisaria chamar a t1.run e não t1.start

        // Os estados das Threads são esses: você tem New, Runnable, Running, Waiting/Blocked, Dead
        // Runnable -> preparada para ser executada
        // Running -> executando
        // Waiting/Blocked -> aguardando e depois volta para Runnable, Running para depois Dead
        // Dead -> terminou a execução, a única forma de você reiniciar uma Thread que morreu é criando uma nova não tem
        // como você reutilizar a mesma Thread
    }
}
