package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

// Dando sequência ao nosso pacote de concorrência nós vamos falar agora de um irmão do Runnable que é
// o Callable, qual a diferença? Runnable tem tipo de retorno void e o Callable tem o tipo de retorno
// definido aqui com generics
// O Callable trabalha em parceria com um Executor, então você pode utilizar os ExecutorService para gerar
// a thread pool e passar esse Callable
// Vamos fazer um exemplo bem simples onde vamos gerar um número aleatório e retornar esse número aleatório

class RandomNumberCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Você tem duas formas de pegar um número aleatório: utilizando Math.random e ThreadLocalRandom a
        // diferença é que o Math.random ele é sincronizado o que vai acontecer é que vai ter um lock
        // envolvendo múltiplas threads se você pegar o lock as threads vão ficar em estado de wait como nós
        // já vimos, então quando você estiver trabalhando em ambientes multi-thread dê preferência ao
        // ThreadLocalRandom que vai basicamente gerar um número aleatório para cada uma das threads que
        // executar esse cara
        int num = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < num; i++) {
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s finished and the random number is %d", Thread.currentThread().getName(), num);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // E agora como a gente faz? Temos um objeto que precisa ser criado pra gente passar para o nosso Executor
        // Uma coisa importante quando você está trabalhando com Executor e com thread pools evita utilizar o wait
        // e o notify porque lembre-se você está desacoplando a submissão das threads com a execução, você não sabe
        // como aquela classe vai ser executada, então não é uma boa ideia você ficar travando/bloqueando as threads
        // dentro de um método call ou run se você estiver usando Executor
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // E como a gente faz agora para executar o Callable? Bom, não tem como necessariamente a gente garantir que a
        // execução vai ser feita no momento da chamada, novamente é a parte do Scheduled, mas o que a gente pode fazer
        // aqui é utilizar o submit e nós temos aqui um Runnable ou um Callable
        // Porém, o que ele retorna? Ele retorna um Future e o que significa esse Future? Significa que a resposta vai vim
        // no futuro
        Future<String> future = executorService.submit(randomNumberCallable);

        // Como é que você pega o valor do future? Quando você utiliza esse get como você pode ver aqui ele vai esperar a 
        // execução desse Callable, então meio que o programa vai ficar parado aqui nessa linha até que ele tenha o resultado
        // Ele precisa tratar duas exceções uma é o ExecutionException e o InterruptedException
        String s = future.get();

        // Basicamente a thread main foi até o final a gente executou o Callable, mas nós não temos o resultado
        System.out.printf("Program finished %s%n", s);
        executorService.shutdown();

        // Agora, como você pode ver obtivemos o valor gerado de forma aleatória pelo nosso ThreadLocalRandom
    }
}
