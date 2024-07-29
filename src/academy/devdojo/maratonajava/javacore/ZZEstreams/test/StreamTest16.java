package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

// Streams paralelos -> basicamente funciona assim você tem no computador o que nós chamamos de processador
// o processador geralmente tem os núcleos e dentro dos núcleos nós temos o que chamamos de threads, as threads são como
// se fossem trabalhadores, então imagine que você tem uma pessoinha lá que fica sempre trabalhando fazendo cálculos
// fazendo todos os processamentos das informações que você tem, então quanto mais threads você tem maior a capacidade
// de processamento paralelo que você tem dentro do seu computador
// Stream paralelo é basicamente uma forma que o Java fez de abstrair a complexidade de ficar desenvolvendo porque
// quando você desenvolve código para ser utilizado paralelamente é um código complicado, é um código que você precisa
// pensar em muitas coisas e o Java meio que abstraiu isso através da utilização de Parallel Streams

// A melhor forma de você decidir de você deve ou não usar Parallel Stream é você fazer Benchmarks
// Outra coisa que você precisa tomar cuidado é a parte de unboxing e boxing que é você trabalhar com tipo primitivo e
// wrapper independente se você está usando múltiplas threads ou não ainda tem um custo na performance
// Tem algumas operações que são muito ruins de fazer de forma paralela que são: limit, findFirst, que são operações que
// não foram feitas para se trabalhar paralelamente, o findAny é bom para se utilizar de forma paralela porque a partir
// do momento que você achou um já era
// Levar em consideração o custo total da computação geralmente quando você está trabalhando com Streams você vai ter
// uma quantidade de elementos e uma quantidade de processamento quanto maior a quantidade de processamento que você
// precisar fazer geralmente você vai se beneficiar se você conseguir fazer esse processamento de forma paralela
// Quantidade de dados se a quantidade de dados for muito pequena não vale a pena você utilizar Parallel Streams porque
// o custo pra você paralelizar é mais alto do que o custo pra você simplesmente utilizar uma thread e você trabalhar no
// processamento dela
// Tipos de coleções algumas coleções são muito boas para você trabalhar de forma paralela ArrayList é excelente,
// LinkedList é uma bosta porque você precisa percorrer a lista inteira, o Iterate do Stream é ruim, rangeClosed já é
// melhor, Set já tem uma performance melhorzinha
// Tamanho do Stream geralmente os Streams que já tem um tamanho definido são melhores pra você paralelizar, por exemplo
// você tem um Stream que vai ser criado dinâmicamente talvez você tenha problemas para paralelizar porque para
// paralelizar a tarefa precisa ser dividida e se você não sabe o tanto de tarefas que você tem como é que você vai
// dividir a quantidade de tarefas, então a performance acaba diminuindo bastante
// Processamento do merge 
public class StreamTest16 {
    public static void main(String[] args) {
        // Primeiramente precisamos ver quantos processadores o nosso Stream pode utilizar, mas não é assim que o Java
        // enxerga você tem os processadores físicos e você tem os processadores virtuais, núcleos
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Vamos imaginar que a gente tem um número bem grande e a gente quer somar esses números
        long num = 10_000_000L;

        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumParallelLongStreamIterate(num);
    }

    private static void sumFor(long num) {
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();

        // O for para esse tipo de coisa tem uma das melhores performances em relação a todos os outros tipos de
        // iterações que você pode fazer porque o for foi desenvolvido para trabalhar dessa forma, basicamente ele meio
        // que trabalha no baixo nível da máquina
        for (long i = 1; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumStreamIterate(long num) {
        System.out.println("Sum StreamIterate");
        long init = System.currentTimeMillis();

        // Como você pode ver o Stream para esse caso não é uma boa saída porque o Stream ele precisa fazer a iteração
        // de um por um e para cada uma dessas iterações ele está fazendo aquele boxing e autoboxing que a gente já viu
        // que tem um probleminha na performance
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumParallelStreamIterate(long num) {
        System.out.println("Sum ParallelStreamIterate");
        long init = System.currentTimeMillis();

        // Adicionando o parallel estamos falando que agora ele vai executar em múltiplas threads
        // Levou mais tempo para fazer esse cara de forma paralela porque da forma que estamos utilizando não é a ideal
        // para trabalhar de forma paralela porque você está iterando de um por um e quando você itera dessa forma fica
        // difícil para as threads saberem a partir daqui você faz essa conta, a partir daqui você faz essa conta, não
        // tem como saber como essas threads vão trabalhar justamente porque eles não sabem o tamanho
        long result = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumLongStreamIterate(long num) {
        System.out.println("Sum LongStreamIterate");
        long init = System.currentTimeMillis();

        // Para usar Parallel Streams precisamos trabalhar de forma certa, precisamos ter algo pré definido e já sabemos
        // como utilizar isso através do LongStream
        // E aqui tem o fato também de você não ter o boxing e unboxing
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumParallelLongStreamIterate(long num) {
        System.out.println("Sum ParallelLongStreamIterate");
        long init = System.currentTimeMillis();

        // Para usar Parallel Streams precisamos trabalhar de forma certa, precisamos ter algo pré definido e já sabemos
        // como utilizar isso através do LongStream
        // E aqui tem o fato também de você não ter o boxing e unboxing
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
}
