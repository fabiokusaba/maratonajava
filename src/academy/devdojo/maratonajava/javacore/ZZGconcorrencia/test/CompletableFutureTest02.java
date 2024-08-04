package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();

        // E você vai ter o mesmo problema que tínhamos antes você está executando de forma síncrona, por que isso
        // acontece? As operações intermediárias do stream são operações que nós chamamos de operações lazy, são
        // operações que elas acontecem de forma uma por uma não é como se executasse tudo e depois você fosse
        // fazendo em cima do resultado, o que a gente precisa fazer aqui para resolver esse problema? A gente precisa
        // quebrar esse stream em duas partes diferentes porque se não a gente vai continuar com o mesmo problema como
        // se a gente tivesse executando código sincronicamente
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();

        // Imagine que você tem uma lista com o nome dessas lojas e você gostaria de executar esses caras via stream, você
        // tem que executar todas essas chamadas basicamente de uma vez só
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        // Como podemos fazer para executar esse cara via stream? A forma mais simples é você chamar diretamente
        // Esse cara retorna pra gente um List<CompletableFuture>, mas aí a gente não está querendo List<CompletableFuture>
        // a gente quer a List<Double>, então o que você precisa fazer? Depois que você tem esse CompletableFuture você tem
        // que fazer o map novamente para o que vai trazer o valor do objeto no caso aqui é o join e aí sim o retorno dele
        // é List<Double>

        // Quando a gente faz isso a gente está fazendo exatamente o que fizemos na aula anterior a gente está separando a
        // chamada do nosso CompletableFuture do join, então quando ele chegar aqui ele vai ter passado por todos os
        // getPricesAsyncCompletableFuture da mesma forma que na aula anterior a thread main passou por todos eles antes de
        // chegar aqui no join como se fosse dando um trigger para todos eles serem executados o stream agora vai ter passado
        // por todos eles, eles vão executar por de trás do processamento background e daí a gente vai agora coletar aqui os
        // valores
        List<CompletableFuture<Double>> completableFutures = stores.stream()
            .map(storeService::getPricesAsyncCompletableFuture)
            .collect(Collectors.toList());
        
        List<Double> prices = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        
        System.out.println(prices);

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }
}
