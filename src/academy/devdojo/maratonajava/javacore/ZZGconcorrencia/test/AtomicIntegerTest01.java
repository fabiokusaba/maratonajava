package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Vamos imaginar que a gente tem o seguinte problema: imagine que você está fazendo um joguinho e nesse joguinho você
// tem uma determinada quantidade de monstros que aparecem no mapa, imagine que você tem duas Threads uma Thread que vai
// trabalhar criando a quantidade de monstros, sempre tenha que ter 20 mil monstros dentro do mapa, e existe também a
// Thread do jogador, você como jogador está lá matando os monstros e você precisa que a Thread que conte esses monstros
// e adicione esses monstros saiba o que você está fazendo
// Então, no final das contas o pacote concorrência adiciona uma camada acima da camada básica de Threads, mas você
// precisa ter um bom conhecimento do que é sincronismo, lock, wait, notify, notifyAll e assim por diante, você precisa
// saber muito bem como funciona das Threads para trabalhar nesse nível da concorrência
class Counter {
    private int count;

    // Então, a gente está trabalhando agora com pacote de concorrência e a gente vai adicionar aqui uma variável
    // chamada AtomicInteger
    // Essa variável foi criada dentro do pacote de concorrência justamente pra trabalhar em situações onde você precisa
    // fazer contagem de forma atômica e você não precisa do lock porque ele vai se encarregar, ele utiliza um mecanismo
    // chamado compare and swap é uma técnica utilizada pra você fazer o design de algorítmos que trabalham em
    // concorrência que basicamente ele faz uma comparação e troca os valores baseado se o valor da variável temporária
    // é o valor concreto o valor correto ou não
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // Nós temos duas formas de trabalhar com lock utilizando synchronized e a outra é utilizando a interface Lock, tem
    // algumas diferenças mas no final das contas o resultado é o mesmo
    // Qual a diferença do synchronized e dessa classe ReentrantLock? Basicamente quando você utiliza synchronized você
    // não tem muito controle o lock é totalmente gerenciado pela JVM, mas quando você está trabalhando com essa classe
    // você tem algumas vantagens a primeira delas é que esse construtor ele tem esse conceito de fair que basicamente
    // é você falar olha agora que estou com lock quando eu for liberar esse lock se esse fair estiver true ele vai
    // tentar passar a bola para a Thread que está esperando a mais tempo quando você está utilizando synchronized não
    // tem isso
    // Outra diferença significante é que você pode tentar obter o lock, esse lock tem um método chamado tryLock onde
    // você pode falar olha tenta aí esperar esse lock por três segundos caso você não consiga continua na execução
    // então você consegue obter quando você está usando synchronized ele simplesmente travas as Threads elas ficam em
    // estado de waiting until aquele lock é liberado
    // E outra diferença que vale a pena mencionar é que você tem a possibilidade de interromper a Thread que está
    // esperando pelo lock
    // Mas, tem uma grande desvantagem que é que o código fica muito feio porque agora você está trabalhando manualmente
    // com lock e quando você trabalha manualmente com o lock você tem que ter a certeza absoluta que vai liberar
    private Lock lock = new ReentrantLock(true);

    void increment() {
        // Para pegar o lock
        // Você obteu o lock, mas o problema que quando você obtém o lock é que você tem que ter certeza absoluta que
        // você vai liberar esse lock porque se não você vai acabar tendo o que chamamos de memory leak ou você pode até
        // mesmo fazer o seu programa travar
        lock.lock();

        try {
            // Essa linha apesar de parecer apenas uma linha de instrução na verdade quando você compila o código e isso vai
            // lá pra linguagem de máquina na verdade você tem mais de uma linha, então geralmente essa é a parte do
            // processador que vai fazer essa contagem você não sabe o que o processador está fazendo ele pode guardar o
            // valor numa variável temporária aí depois ele pode verificar se essa variável temporária o valor foi alterado
            // ou então ele só soma diretamente, depende do processador
            // O que podemos fazer aqui é adicionar synchronized e aí você vai ter os 20 mil, mas quando você adiciona o
            // sincronismo você acaba perdendo um pouco na performance porque você só pode ter uma Thread acessando aquele
            // método naquele determinado momento e você está trabalhando com baixo nível
            count++;

            // Eu quero contar de forma atômica, ou seja, quero ter a certeza que esses valores não vão ser alterados
            atomicInteger.incrementAndGet();
        } finally {
            // Para liberar o lock, geralmente é feito no final
            // Mas, se tiver exceção em alguma dessas linhas simplesmente vai deixar aquela Thread com o lock, para a gente
            // resolver isso podemos usar try-finally
            // Caso dê algum problema, independente de ter exceção ou não, o finally sempre será executado e você tem que
            // fazer isso todas as vezes que você tentar adquirir o lock manualmente, no fim das contas o código acaba
            // ficando bem poluído
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}

public class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable r = () -> {
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        // Eu preciso que a minha Thread main espere que esses dois trabalhos sejam finalizados porque eu quero imprimir
        // aqui o meu counter.getCount, então eu vou falar Thread main se junte primeiro ao trabalho de t1 e depois você
        // se junte ao trabalho de t2
        t1.join();
        t2.join();

        // Quando a gente executa você tem um pequeno probleminha como você pode ver a contagem é bem diferente do que
        // nós temos e por que isso acontece?
        System.out.println(counter.getCount());

        System.out.println(counter.getAtomicInteger());
    }
}
