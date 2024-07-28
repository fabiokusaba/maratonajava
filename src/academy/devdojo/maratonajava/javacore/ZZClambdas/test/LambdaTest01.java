package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

// Consumer é uma interface funcional parecida com Predicate a diferença é que ele executa uma operação e não retorna
// nada, o tipo de retorno é void
public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> strings = List.of("William", "Suane", "Luffy", "Zoro");
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        forEach(strings, (String s) -> System.out.println(s));
        forEach(integers, i -> System.out.println(i));
    }

    // Método genérico para imprimir qualquer lista que a gente passar
    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            // O comportamento desse accept vai ser definido através da lambda
            consumer.accept(e);
        }

    }
}
