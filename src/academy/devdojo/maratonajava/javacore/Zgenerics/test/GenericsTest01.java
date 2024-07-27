package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

// Generics foi algo que foi adicionado em tempo de compilação, mas você tem que tomar bastante cuidado porque dessa
// forma que estamos fazendo aqui é em tempo de compilação porque quando o Java ele manda o bytecode para a JVM o
// bytecode da JVM vai assim List lista = new ArrayList(), então lá dentro da JVM você não sabe o que tem dentro dessa
// lista por isso é feito esse checking em tempo de compilação porque dessa forma você consegue manter a compatibilidade
// com todos os sistemas existentes e continua atualizando a linguagem, esse conceito é chamado de Type erasure porque
// ele realmente está apagando o tipo depois que o código é compilado
public class GenericsTest01 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Midoriya");
        lista.add("Midoriya");

        for (String s : lista) {
            System.out.println(s);
        }

        // Esse código executou normalmente
        add(lista, new Consumidor("Midoriya"));

        // Mas, se você tentar executar novamente o forearch você vai ter uma exceção de ClassCastException
        // Se essa cara fosse um Object você simplesmente imprime tudo, ou seja, você não tem garantia que se você fizer
        // um código sem Generics que você não pode colocar que vai falhar quando você colocar um objeto que não
        // pertence
        for (Object s : lista) {
            System.out.println(s);
        }
    }

    // Por isso, o uso de Generics é importante porque ele vai fazer essa validação em tempo de compilação, ou seja, ele
    // não deixa seu código passar pra JVM se você não tomar cuidado e colocar o tipo corretamente
    private static void add(List lista, Consumidor consumidor) {
        lista.add(consumidor);
    }
}
