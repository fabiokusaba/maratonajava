package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        // Digamos que você tenha essa lista de numeros e você precise agora de um Array
        // O toArray vai nos retornar um array de Object o que geralmente não é muito bom
        //Object[] array = numeros.toArray();

        // Ou nós temos a segunda opção que é sobrecarregada e ele pede um array de Object e você pode utilizar dessa
        // forma
        // Aqui utilizamos zero porque o Java vai utilizar reflection para descobrir o tamanho do Array que ele precisa
        // criar, mas você tem a opção também de passar numeros.size
        Integer[] listToArray = numeros.toArray(new Integer[0]);

        // Imprimindo os valores através do Arrays.toString, como você pode ver nós agora temos um Array com as mesmas
        // posições que nós temos dentro do nosso ArrayList
        System.out.println(Arrays.toString(listToArray));
        System.out.println("--------------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        // Imagine agora que temos um Array e gostaríamos de transformá-lo em uma List, para isso temos algumas opções
        // A primeira opção é utilizando o método Arrays.asList que vai nos retornar uma lista de inteiros, porém é
        // preciso tomar muito cuidado ao utilizá-lo porque ele cria um link com o Array que nós temos aqui
        List<Integer> arrayToList = Arrays.asList(numerosArray);

        // Aqui estou dizendo que a posição 0 agora terá o valor 12
        arrayToList.set(0, 12);

        // Você vai verificar que ambos os valores são os mesmos
        // Note que ao utilizar o set ambos os valores foram mudados tanto do meu Array quanto do meu ArrayList porque
        // o Arrays.asList cria um link com o Array original, isso fica mais complicado se você tentar adicionar um
        // valor
        // Caso você tente adicionar um valor você vai ter um UnsupportedOperationException, você não pode fazer
        // alterações quando você cria um Array através do asList
        //arrayToList.add(19);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);
        System.out.println("---------------------------");

        // Para criarmos um cara desse que permita a gente fazer alterações podemos fazer da seguinte forma
        // O ArrayList construtor é sobrecarregado você pode passar um valor sendo a capacidade inicial ou você pode
        // passar uma outra coleção, no nosso caso poderia ser esse Arrays.asList(numerosArray)
        // Dessa forma ele vai criar um novo ArrayList com os valores de numerosArray e a gente vai poder alterar
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));

        // Perceba que aqui ele não vai dar exceção ao tentarmos adicionar um novo número, nós temos os mesmos valores
        // mas temos o número 15, dessa forma você está quebrando o vínculo que você teria somente utilizando o asList
        numerosList.add(15);
        System.out.println(numerosList);

        // Existem duas formas de você criar um ArrayList diretamente na mesma linha que é você utilizar esse
        // Arrays.asList
        // Esse Arrays.asList pede nada mais que um varargs, ou seja, a gente pode passar os valores dessa forma
        //Arrays.asList(1, 2, 3, 4, 5); // Vai criar uma lista de inteiros
        List<String> strings = Arrays.asList("1", "2");// Vai criar uma lista de Strings

        // Existe uma opção a partir do Java 9 que é a mesma coisa que o asList está fazendo, mas
        List.of(1, 2, 3, 4, 5);

        // Tome cuidado com o asList porque ele é imutável, então se você estiver criando através de um Arrays.asList
        // ele vai manter um link com o Array original
    }
}
