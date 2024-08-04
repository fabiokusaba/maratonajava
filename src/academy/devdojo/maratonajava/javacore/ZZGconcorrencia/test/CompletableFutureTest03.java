package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceDeprecated;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesCompletableFuture(storeServiceDeprecated);
    }

    // Basicamente o que você está fazendo? Você tem um serviço que só tem uma opção de fazer as coisas de forma
    // síncrona, mas aí você está fazendo uma camada em cima aonde você está executando de forma assíncrona
    // E aí vem os pontos legais do CompletableFuture digamos assim eu quero passar um Executor o supplyAsync ele
    // é sobrecarregado e você vai ver que ele aceita um Executor
    private static void searchPricesCompletableFuture(StoreServiceDeprecated storeServiceDeprecated) {
        long start = System.currentTimeMillis();

        // Criar um custom executor é bem legal porque a gente pode fazer o seguinte podemos definir um thread factory
        // então, digamos que você quer trocar um pouco o comportamento das threads você vê aqui que o método é
        // sobrecarregado aí você tem esse ThreadFactory que podemos utilizar lambda aqui pra falar olha eu quero que
        // as threads sejam criadas de uma forma diferente
        ExecutorService executor = Executors.newFixedThreadPool(10, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        // Como eu posso fazer para executar assincronicamente? Utilizando o mesmo stream que nós temos aqui nós
        // poderíamos fazer da mesma forma
        // Nós vamos criar aqui o CompletableFuture.supplyAsync, ou seja, aí ele está pedindo um supplier dentro
        // desse próprio stream e qual o supplier que a gente está passando? Bom, o supplier que a gente vai passar
        // é exatamente o do nosso serviço aqui StoreServiceDeprecated
        // E repare que caímos no mesmo problema da aula passada
        List<CompletableFuture<Double>> completableFutures = stores.stream()
            .map(s -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSync(s), executor))
            .collect(Collectors.toList());

        List<Double> prices = completableFutures.stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());

        System.out.println(prices);
        long end = System.currentTimeMillis();
        executor.shutdown();
        System.out.printf("Time passed to searchPrices %dms%n", (end - start));
    }
}
