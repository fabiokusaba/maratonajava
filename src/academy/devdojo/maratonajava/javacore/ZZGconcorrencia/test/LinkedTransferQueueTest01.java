package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

// Basicamente essa LinkedTransferQueue é uma classe que na verdade é uma junção de outras três queues
// Nós temos a ConcurrentLinkedQueue, SynchronousQueue e LinkedBlockingQueue, a funcionalidade dessas
// três foram juntadas na LinkedTransferQueue
public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Object> tq = new LinkedTransferQueue<>();

        // Quais são as funcionalidades que ela adiciona? Basicamente ela adiciona as funcionalidades de
        // bloquear e de não bloquear
        // Por exemplo, temos um método add que vai inserir um elemento se for possível fazer imediatamente
        // sem violar a capacidade de elementos de dentro, e vai retornar true ou ele vai dar uma exceção
        // Basicamente se você não tiver espaço para colocar um elemento lá dentro ele vai lançar essa exceção
        // IllegalStateException
        System.out.println(tq.add("william"));

        // Se você não estiver feliz com add porque ele lança uma exceção caso não tenha espaço você pode utilizar
        // o offer, então o offer faz a mesma coisa que o add, mas ele vai retornar true se ele conseguir inserir
        // com sucesso e false se não tiver espaço disponível
        System.out.println(tq.offer("william"));

        // E nós temos o offer também, digamos que você queira tentar ao invés de ser imediatamente tentar colocar
        // você quer tentar por 10s, esse cara vai lançar uma exceção InterruptedException
        // Basicamente nessa versão aqui ele vai tentar inserir esse elemento e vai esperar até 10s, o tempo que você
        // definiu lá, o espaço ficar disponível
        System.out.println(tq.offer("william", 10, TimeUnit.SECONDS));

        // E nós temos o put, o put como nós já vimos na aula anterior ele tenta ele insere um elemento e espera, ou seja,
        // se não tiver espaço o put simplesmente vai bloquear esperando até que um espaço seja disponível exatamente como
        // vimos na última aula do BlockingQueue
        tq.put("DevDojo");

        // O que você poderia fazer seria hasWaitingConsumer que vai verificar se você tem um consumidor esperando, ou seja,
        // se alguém tentou dar um take e não tem nenhum valor
        if (tq.hasWaitingConsumer()) {
            // Temos um método que é bem interessante que é o transfer, esse transfer vai literalmente bloquear a sua thread,
            // ou seja, vai ficar esperando um elemento tentar pegar o valor que você colocou, então isso é uma característica
            // da SynchronousQueue ela começa com tamanho zero quando você adiciona um valor aquele valor imediatamente fica
            // esperando até que uma outra thread pegue
            // Então, o conceito de consumidor producer e consumer, aquele que produz e aquele que consome, é utilizado aqui nesse
            // transfer
            // Quando você adiciona um elemento ele vai ficar esperando até que um outro elemento venha e pegue o elemento através
            // do take ou do poll
            tq.transfer("DevDojo");
        }

        // Caso você não queira fazer o if você tem uma outra opção, qual é a outra opção? É você utilizar o tryTransfer
        // Então, tryTransfer ele vai basicamente tentar transferir o elemento imediatamente, caso não tenha ele vai retornar false
        System.out.println(tq.tryTransfer("Academy"));

        // Caso você queira esperar
        // Ele vai esperar até um consumidor aparecer em 5s e aí caso alguém apareça se não ele só vai retornar false
        System.out.println(tq.tryTransfer("Academy", 5, TimeUnit.SECONDS));

        // E nós temos outros também, nós temos o element que vai exibir o primeiro elemento dessa fila, a cabeça, mas não vai remover
        // A única diferença desse método é que ele vai lançar uma exceção se a lista estiver vazia
        System.out.println(tq.element());

        // Caso você só queira pegar nós já vimos como funciona o peek ele só traz o valor que nós temos lá e null se for vazio
        System.out.println(tq.peek());

        // E temos também o poll que pega e remove o primeiro elemento dessa fila ou vai retornar null se essa fila for vazia
        System.out.println(tq.poll());

        // O poll e o remove eles trabalham meio que similarmente a diferença é que o remove ele vai lançar uma exceção caso a fila esteja
        // vazia
        System.out.println(tq.remove());

        // E por último nós temos o take que já conhecemos como você pode ver aqui o take pega o primeiro valor, ou seja, ele mostra e retira
        // da fila e vai ficar esperando caso não tenha, caso seja vazia ele vai ficar esperando alguém colocar um valor lá dentro
        System.out.println(tq.take());

        // Esse LinkedTransferQueue apesar de não ter nenhuma opção pra você colocar uma determinada capacidade
        // ele tem uma capacidade
        System.out.println(tq.remainingCapacity());
    }
}
