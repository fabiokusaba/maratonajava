package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Bom, então o pacote de framework de coleções do Java possuem várias classes que foram criadas
// especificamente para trabalhar com concorrência e essa BlockingQueue é exatamente uma delas
// Então, BlockingQueue é especial por dois motivos: um é uma classe aonde você tem um BlockingQueue
// que nós chamamos de bounded, ou seja, você tem um limite de valores pra você colocar lá dentro e
// o segundo é que se você tentar colocar algo, digamos vou colocar capacidade 1, eu coloquei um valor
// se eu tentar colocar o segundo valor a thread vai ficar bloqueada porque você só tem um espaço e
// enquanto você não tirar aquele espaço você não vai poder colocar um novo valor, então ele bloqueia
// realmente a thread
public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);

        // Digamos que a gente quer colocar aqui um nome
        // peek vai nos retornar o valor sem remover daquela lista
        // Perceba que aqui a thread main adicionou o nome William
        bq.put("William");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.println("Trying to add another value");

        // Então, você pode ver que a main adicionou William, está tentando adicionar outro valor mas está
        // bloqueado, a outra thread está dormindo por 5s, a thread removeu o valor William em seguida a
        // main conseguiu adicionar o valor Suane
        // Então, esse é um dos principais comportamentos da ArrayBlockingQueue
        new Thread(new RemoveFromQueue(bq)).start();

        // E aqui ele está esperando o espaço ser liberado para ele conseguir adicionar o novo nome, então
        // ele bloqueia a thread enquanto você não liberar tirando um valor, liberar espaço, ele não vai
        // deixar o programa continuar
        bq.put("Suane");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
    }

    // Criando uma thread separada
    static class RemoveFromQueue implements Runnable {
        private final BlockingQueue bq;

        public RemoveFromQueue(BlockingQueue bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            // O que essa thread está fazendo? Vou colocar ela primeiro para dormir 
            System.out.printf("%s going to sleep for 5s%n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);

                // Para remover a gente usa o take, a documentação do take fala que ele pega e remove o primeiro elemento
                // dessa fila ou ele vai esperar até um elemento ser adicionado
                System.out.printf("%s removing value from queue %s%n", Thread.currentThread().getName(), bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
