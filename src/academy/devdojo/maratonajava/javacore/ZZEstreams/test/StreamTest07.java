package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;
import java.util.Optional;

// Basicamente o Reduce é uma operação terminal dos Streams que vai possibilitar você obter um resultado único a partir
// de uma sequência de elementos, então ele vai repetidamente aplicar a operação aos elementos e ao final você vai ter
// um resultado
public class StreamTest07 {
    public static void main(String[] args) {
        // Vamos imaginar que você tenha uma lista de números
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        // A partir dessa lista de valores inteiros você quer obter a soma desses valores
        // Se eu quiser somar você vai somar dois elementos, certo? Você tem dois valores x e y e você quer retornar a
        // soma deles, ou seja, x + y
        // Esse cara aqui retorna um Optional porque ele não sabe e pode ser que essa lista esteja vazia, então caso
        // você queira
        integers.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);

        // Existe uma outra forma que você pode estar colocando um valor inicial, dessa forma ele não vai mais retornar
        // um Optional ele vai retornar um valor final inteiro
        System.out.println(integers.stream().reduce(0, (x, y) -> x + y));

        // Uma forma melhor de se fazer isso é utilizando method reference, dentro da classe Integer nós temos um método
        // sum e esse método sum se você for lá dentro dele ele recebe o valor a e b e como você pode ver aqui ele já é
        // um BinaryOperator
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, Integer::sum));

        // Multiplicação
        integers.stream().reduce((x, y) -> x * y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(1, (x, y) -> x * y));

        // E se você quisesse trazer o máximo, digamos que você tem uma lista de valores inteiros e você quer trazer o
        // maior deles
        integers.stream().reduce((x, y) -> x > y ? x : y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, Integer::max));
    }
}
