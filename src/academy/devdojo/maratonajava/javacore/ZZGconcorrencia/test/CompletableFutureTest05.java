package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        // Poucas mudanças são necessárias para a gente atingir esse objetivo aqui primeiro vamos continuar começando
        // com stores.stream, vamos continuar da mesma forma só que a diferença é que agora eu quero fazer o seguinte
        // quando eu tiver os meus dados no meu store eu quero imprimir
        // Quando você chamar os preços getPriceSync e você criar um novo orçamento newQuote em seguida você aplicar o
        // desconto applyDiscount eu quero que você thenAccept, basicamente thenAccept vai realizar uma ação e que ação
        // eu quero fazer? Eu quero pegar essa store e eu quero imprimir da mesma forma que a gente estava imprimindo
        // antes
        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        // Então, o que é o allOf e o anyOf? Começando pelo allOf é um método do CompletableFuture que ele vai retornar
        // um novo CompletableFuture, digamos que você está fazendo um cálculo pesado e você precisa saber quando todas
        // essas chamadas terminaram, então esse CompletableFuture.allOf faz exatamente isso você passa todos os
        // CompletableFuture para ele e quando todos eles terminarem independente de ter exceção ou não, se você tiver
        // exceção ele fala que vai terminar de forma excepcional e você vai ter tipo uma flag olha todos aqui já
        // terminaram e aí você provavelmente poderia dar continuidade a próxima tarefa

        // Agora que já temos o código de cima nós precisamos do seguinte o allOf aceita um varargs, ou seja, a gente
        // não pode passar uma lista a gente teria que passar um Array
        // Se você só executar esse cara você vai ver que absolutamente nada vai acontecer porque a gente não está
        // chamando o join, ou seja, o programa simplesmente finaliza
        // O que eu preciso fazer agora que eu tenho esse allOf? Esse allOf vai dar origem a um novo CompletableFuture
        // um CompletableFuture que vai ter finalizado quando todos os CompletableFuture que estavam aqui dentro tiverem
        // sido finalizados

        // Esse é o allOf quando você precisar saber se todas as tarefas que você passou no CompletableFuture foram
        // finalizadas e você tem também o anyOf, qual a diferença? O anyOf vai ser considerado terminado um
        // CompletableFuture completado quando uma das tarefas, quando um dos CompletableFuture finalizar, então por
        // exemplo, estou executando aqui quatro, mas estou falando se um deles terminar está terminado
        // Quando você executa você vai ver que ele retornou 1 e acabou, o processamento aqui parou, quando isso é útil?
        // Imagine que você tem que fazer uma cotação de preço, quer saber, por exemplo, a cotação do dólar você pode
        // chamar tecnicamente pra cinco lugares e se você sempre tiver o mesmo resultado, por exemplo, o dólar é o
        // mesmo preço para cada uma das chamadas que a gente vai fazer, você só se importa com um resultado você dá um
        // trigger pra cinco chamadas em cinco diferentes empresas pra fazer a cotação quando uma delas responde é o que
        // você precisa aí você pode utilizar o anyOf

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures);

        // Então, a gente pode fazer o seguinte agora
        voidCompletableFuture.join();
        System.out.printf("Finished? %b%n", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }
}
