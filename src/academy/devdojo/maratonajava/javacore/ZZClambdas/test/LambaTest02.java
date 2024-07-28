package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// A Function é uma interface funcional e ela tem uma pequena diferença que você vai ter um tipo T e um tipo R, ou seja,
// o T é o que você vai receber e o R é o que você vai retornar e pode ser absolutamente qualquer coisa
public class LambaTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("Natsu", "Allucard");

        // Method references é uma sintaxe que nós temos para utilizar com a parte das lambdas que simplifica ainda mais
        // o nosso código
        // A regrinha que você pode lembrar de uma forma fácil é que se na sua lambda você chamar apenas um método você
        // pode utilizar method reference
        // Então, aqui a nossa lambda está usando apenas o método length simplificando você pode ver que ele chama o
        // método length através da chamada da classe String e a sintaxe é ::
        List<Integer> integers = map(strings, String::length);
        System.out.println(integers);

        // O tipo pode ser o mesmo, estou passando uma String e recebendo uma String não necessariamente precisa ser
        // tipos diferentes para ficar claro que você tem o T e o R só para diferenciar que você está passando dois
        // tipos que podem ser o mesmo ou podem não ser os mesmos
        List<String> map = map(strings, s -> s.toUpperCase());
        System.out.println(map);
    }

    // A gente pode passar uma lista de Strings e retornar uma lista com o tamanho de cada uma das Strings que estão lá
    // dentro
    // Geralmente quando a gente precisa transformar alguma coisa e retornar alguma coisa totalmente diferente chamamos
    // de map
    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            R r = function.apply(e);
            result.add(r);
        }
        return result;
    }
}
