package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Account;

public class ThreadAccountTest01 implements Runnable {
    // Você precisa criar a variável como final porque se eu não criar ele como final significa que depois em algum
    // momento você pode pegar esse account e fazer o seguinte: account = new Account() aí você tem um novo objeto em
    // memória e você está dando lock em quem? Então, para evitar esse tipo de problema você define que essa variável de
    // referência sempre vai fazer referência para esse objeto não pode trocar porque eu defini ele como final
    private final Account account = new Account();

    public static void main(String[] args) {
        // O que está acontecendo aqui? Eu tenho esse objeto ThreadAccountTest01 e esse objeto tem uma Account, ou seja,
        // lá na memória a gente tem um objeto só, a minha conta tem um valor lá dentro o balance que é 50 e eu estou
        // falando que eu vou ter a Thread t1 e vou ter a Thread t2 acessando o mesmo objeto, ou seja, eles vão estar
        // fazendo operações matemáticas diretamente no mesmo objeto, vão acessar concorrentemente o mesmo objeto, o
        // mesmo valor em memória
        // Realmente nós temos um sério problema, esse é o maior problema da concorrência, você tem duas Threads
        // acessando o mesmo objeto
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Hestia");
        Thread t2 = new Thread(threadAccountTest01, "Bell Cranel");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("FODEO");
            }
        }
    }

    // Você também pode sincronizar métodos estáticos, esse synchronized você está sincronizando com o método estático
    // pertence a classe você está sincronizando praticamente a classe o que você pode fazer além disso daqui
    private static void print() {
        // É você utilizar também dessa forma:
        synchronized (ThreadAccountTest01.class) {}
    }

    // Eu preciso que esse pedaço de código seja executado de forma atômica, ou seja, a Thread que começar a executar
    // esse método withdrawal tem que terminar esse método withdrawal uma outra Thread não pode entrar no mesmo
    // momento, isso significa que a gente precisa dar um lock
    // Todos os objetos tem o que chamamos de lock, lock é como se fosse uma chave que você tem naquele objeto que, por
    // exemplo, se uma Thread pegar aquele lock outra Thread não vai conseguir executar o mesmo objeto, então quando a
    // gente coloca aqui synchronized a gente está falando que esse método agora é um método sincronizado, ou seja, não
    // vai existir paralelismo porque duas Threads não vão poder acessar esse método ao mesmo tempo
    private void withdrawal(int amount) {
        // Como você pode ver o que está fora do synchronized pode ser executado por qualquer Thread, mas o que está
        // dentro só pode ser executado por um Thread por vez
        System.out.println(getThreadName() + " ###### fora do synchronized");

        // O synchronized pode ser utilizado aqui no método ou você pode criar um bloco de código, digamos que você
        // queira sincronizar apenas o objeto account, você quer pegar o lock dele daí você pode fazer o seguinte:
        // Mas, quando você faz isso você tem que tomar cuidado com um pequeno probleminha que pode acontecer
        // geralmente quando você quer sincronizar um determinado objeto você precisa criar a variável como final
        synchronized (account) {
            System.out.println(getThreadName() + " ***** dentro do synchronized");

            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " está indo sacar dinheiro");
                account.withdrawal(amount);
                System.out.println(getThreadName() + " completou o saque, valor atual da conta " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
            }
        }
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
