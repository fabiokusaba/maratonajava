package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        // Tem duas formas de você gerar Streams "infinitos": um através do Stream.iterate e outro Stream.generate a
        // diferença é que o generate aceita um Supplier e o iterate ele aceita esse seed e esse UnaryOperator
        // O iterate você precisa dar um seed inicial e o UnaryOperator ele basicamente é um método que retorna o que
        // você passou como argumento
        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // Digamos que a gente tem a série de Fibonacci, a série de Fibonacci são valores numéricos aonde o número é
        // sempre somado com o anterior -> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
        // E dentro da sequência de Fibonacci se a gente fosse utilizar o iterate para fazer esse cálculo
        // (0, 1) (1, 1) (1, 2) (2, 3) (3, 5) (5, 8)
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        // Pegando somente os números da sequência de Fibonacci
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        // Nós temos também o generate a diferença é que ele não aceita o UnaryOperator e a gente pode criar ele através
        // do Stream.generate
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1, 500))
                .limit(90)
                .forEach(System.out::println);
    }
}
