package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreService {
    // Digamos que nós temos dois métodos: um método pra pegar preço que é síncrono e um método pra pegar
    // preço que é assíncrono
    // Preço aleatório que vamos retornar simulando como se nós tivéssemos consultando várias lojas pra
    // descobrir o preço, então é isso que nós queremos fazer vamos passar tipo o nome da loja, digamos que
    // cada uma vai retornar um preço específico

    private static final ExecutorService ex = Executors.newCachedThreadPool();

    // Vamos gerar primeiro o que pega os preços de forma síncrona
    public double getPriceSync(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return priceGenerator();
    }

    public Future<Double> getPricesAsyncFuture(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);

        // E você precisa de um Executor, você precisa chamar o priceGenerator passando Callable
        return ex.submit(this::priceGenerator);
    }

    public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);

        // O que que muda? O CompletableFuture tem algumas vantagens uma delas é que você não precisa mais do
        // Executor, o CompletableFuture tem um método chamado supplyAsync onde ele passa um supplier, ou seja,
        // você pode utilizar lambda aqui
        // A gente não está utilizando Executor, mas por trás ele vai utilizar esse ForkJoinPool ele vai criar
        // as threads utilizando esse framework
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }

    private double priceGenerator() {
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    // Podemos criar aqui um método shutdown
    public static void shutdown() {
        ex.shutdown();
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
