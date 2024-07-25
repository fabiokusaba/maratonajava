package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// É uma outra forma que nós temos de fazer busca em uma coleção ou na verdade arrays ele também funciona para arrays
// E a diferença basicamente do BinarySearch do, por exemplo indexOf, que nós já vimos é que o BinarySearch ele retorna
// pra você, por exemplo a posição que você deveria inserir esse elemento caso ele não exista
public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        // O BinarySearch vai fazer uma busca na lista que nós passarmos e ele vai retornar pra gente o índice caso
        // ele encontre o que estamos procurando ou caso ele não encontre ele vai retornar algo seguindo essa regra
        // aqui (-(ponto de inserção) -1)
        // Como ele vai te dar a posição que você deve inserir o elemento caso o elemento não exista, existe uma regra
        // que o Collections.binarySearch fala em sua documentação você precisa que a sua lista seja ordenada, pode ter
        // a ordem definida pelas classes wrappers por exemplo, ou caso você tenha definido um Comparator você precisa
        // passar esse Comparator também, então obrigatoriamente você tem que passar uma lista ordenada se não o
        // resultado não pode ser confiado (undefined)

        // Como a nossa lista não está ordenada nós precisamos antes de usar o binarySearch usar Collections.sort
        Collections.sort(numeros);

        // index 0, 1, 2, 3
        // value 0, 2, 3, 4

        // Agora vou fazer o nosso binarySearch
        // Digamos que eu queira encontrar o valor 2, o binarySearch precisa da nossa lista
        System.out.println(Collections.binarySearch(numeros, 2));
    }
}
