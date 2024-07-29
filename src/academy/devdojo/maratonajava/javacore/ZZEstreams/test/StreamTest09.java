package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        // Digamos que eu queira um Stream de inteiros a gente pode utilizar o IntStream que é um daqueles Streams que
        // vão manter os valores primitivos se você tiver trabalhando com alta performance é uma boa ideia você utilizar
        // E nós temos dois caras aqui: range e rangeClosed, todos eles tem o startInclusive significa que se você
        // colocar de 0 ele vai considerar o valor 0, mas o range ele tem o final endExclusive significa que se você
        // colocar um range de 1 a 50 ele vai de 1 a 49, se você utilizar rangeClosed ele é endInclusive tanto para o
        // início quanto para o fim significa que ele vai contar de 1 a 50 se você colocar de 1 a 50

        // Por exemplo, digamos que a gente tem um Stream de 1 a 50 e nós queremos apenas os números pares e imprimir no
        // console
        IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Digamos que você quer um Stream de palavras
        // O of ele aceita um varargs de T, ou seja, ele aceita qualquer coisa
        Stream.of("Eleve ", "O ", "Cosmo ", "no seu coração")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Arrays
        int[] num = {1, 2, 3, 4, 5};

        // Para você ter um Stream desse nosso Array de números você pode chamar Arrays.stream e o interessante desse
        // método aqui é que ele retorna no caso um IntStream, quando ele já retorna esse Stream tipado ele tem alguns
        // métodos já úteis pra gente, por exemplo se você quiser a soma sum, se você quiser o valor mínimo min, se você
        // quiser o valor máximo max ou se você quiser, por exemplo, a média average
        // E todos eles estão linkados ao fato de nós estarmos trabalhando diretamente com IntStream
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        // E para finalizar essa aula nós podemos trabalhar também com Stream e arquivos
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            lines
                    .filter(l -> l.contains("Java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
