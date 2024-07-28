package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

// Esse terceiro é parecido com os anteriores, no primeiro vimos o nome da classe, no segundo o nome do objeto e nesse
// terceiro é você utilizar ao invés do objeto a classe mais o método não estático
public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList(List.of("Rimuru", "Veldora", "Hikimaru"));

        // Digamos o seguinte eu quero fazer a comparação dessa lista, você já sabe que a String implementa Comparable
        // significa que você vai ter o método compareTo
        // O método compareTo é um método não estático que a gente pode chamar através da classe, então por exemplo
        list.sort(String::compareTo);

        // Como você pode ver o compareTo não é estático e nós estamos chamando através do nome da classe
        System.out.println(list);

        // Imagine que você quer criar uma função que vai pegar um número em String e transformar em um Integer, você
        // sabe que você tem Integer.parseInt, então se você quiser criar uma função você sabe que você vai receber uma
        // String e vai ter que retornar um int, ou seja, se você precisar de uma interface funcional você através da
        // Function consegue atingir esse objetivo
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("10");
        System.out.println(num);

        // Digamos que você quer fazer algo um pouquinho diferente, você quer verificar se você tem um elemento dentro
        // de uma lista, qual a interface funcional que nós sabemos que já faz isso? A Predicate, mas a Predicate só
        // aceita um argumento e no nosso caso precisamos passar dois que seria a nossa lista e o que queremos verificar
        // o valor, para isso o Java criou BiPredicate que é a mesma coisa que o Predicate com a diferença que ele
        // recebe dois argumentos
        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(list, "Rimuru"));
    }
}
