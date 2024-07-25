package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("22222", "Pixel");
        Smartphone s3 = new Smartphone("33333", "Samsung");

        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(s1);
        smartphones.add(s2);

        // A lista sempre mantém a ordem do índice
        smartphones.add(0, s3);

        // Digamos que você quer limpar esse array, mas não quer perder a variável de referência você pode chamar o
        // clear que ele deleta todos que estão dentro desse ArrayList, praticamente limpa
        //smartphones.clear();

        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }

        // Uso do equals -> digamos que a gente tenha aqui um quarto smartphone, você tem esses três valores s1, s2, s3
        // guardados em um banco de dados e uma pessoa vai lá e digita, por exemplo o s4, e você quer saber se aquele
        // smartphone existe na lista, como podemos fazer isso?
        // As listas tem um método chamado contains aonde ele retorna true ou false pra saber se aquele objeto existe
        // dentro da lista
        Smartphone s4 = new Smartphone("22222", "Pixel");
        System.out.println(smartphones.contains(s4));

        // Tem outro método que é o indexOf, ou seja, o indexOf ele vai trazer o índice daquele objeto que você está
        // passando e -1 caso ele não exista
        int indexSmartphone4 = smartphones.indexOf(s4);
        System.out.println(indexSmartphone4);
        System.out.println(smartphones.get(indexSmartphone4));

        // Quando você tenta chamar Collections.sort passando a lista de smartphones você tem um erro de compilação
        // porque se você for na classe Smartphone você tem serialNumber e marca e como não sabemos por onde ordenar
        // o Java vai dar um erro de compilação
        //Collections.sort(smartphones);
    }
}
