package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();

        // Como você viu levou 8s, por que 8s? Porque para cada uma das lojas a gente está com um delay de 2s
        // searchPricesSync(storeService);

        // Você está vendo que ele gerou o primeiro aí RejectedExecutionException porque a gente desligou a gente
        // não pode dar um shutdown porque quando você dá um shutdown você meio que está falando para aquele Executor
        // olha não aceita mais ninguém

        // Mas, isso ainda não resolve o problema você tem agora uma thread e você está vendo que ela está indo de uma
        // por uma porque a gente está falando olha você cria esse Future e logo em seguida você pega, ou seja, você
        // está criando as threads meio que de forma síncrona, você está vendo que estamos sempre utilizando a mesma
        // thread, então como é que a gente resolve esse problema?
        
        // Você pode ver que agora você gerou 4 threads para cada uma dessas tarefas e você depois mandou pegar todas elas
        // O que acontece? Cada uma das threads tem que esperar 2s como você iniciou as threads praticamente ao mesmo tempo
        // com aquela diferença em milisegundos

        // Tem uma forma melhor de fazer isso? Porque o Future apesar dele ser bom ele tem algumas limitações, então por
        // exemplo, ele não consegue ser manualmente completado, por exemplo, se uma API está down você tem que trabalhar
        // com timeout que fala 
        // searchPricesAsyncFuture(storeService);

        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService) {
        long start = System.currentTimeMillis();

        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }

    private static void searchPricesAsyncFuture(StoreService storeService) {
        long start = System.currentTimeMillis();

        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");

        // Você precisa desacoplar a criação desses Futures no momento em que você pega, por que? Se você chamar
        // aqui o get você precisa tratar as exceções e temos que nos preocupar também em fechar o Executor
        try {
            pricesAsyncFuture1.get();
            pricesAsyncFuture2.get();
            pricesAsyncFuture3.get();
            pricesAsyncFuture4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));

        // Agora aqui no finalzinho do nosso método posso chamar e aí ele já vai desligar todas as threads
        StoreService.shutdown();
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();

        CompletableFuture<Double> pricesAsyncFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");
 
        // E uma outra vantagem também é que ao invés do get o CompletableFuture tem o join, qual a diferença? O join
        // você não precisa tratar essas exceções porque ele não lança exceções do tipo checked, então o código fica
        // um pouquinho mais organizado
        pricesAsyncFuture1.join();
        pricesAsyncFuture2.join();
        pricesAsyncFuture3.join();
        pricesAsyncFuture4.join();
 
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));

        // Como a gente não precisa mais do Executor a gente não precisa tecnicamente dar o shutdown, se você executar
        // depois que ele pegar tudo ele simplesmente para
    }
}
