package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Nós vimos que o map basicamente extrai aquilo que você passar aqui
// Basicamente o FlatMap vai fazer a mesma coisa que o map faz, mas a diferença é que o FlatMap é utilizado quando você
// tem propriedades aninhadas uma dentro da outra
public class StreamTest04 {
    public static void main(String[] args) {
        // Digamos que eu tenho uma lista de uma lista de Strings, se estivéssemos falando de Arrays isso daqui seria
        // um Array multi dimensional
        // Vamos chamar essa lista maior de devdojo
        List<List<String>> devdojo = new ArrayList<>();

        // E dentro do devdojo vou adicionar outras listas
        List<String> graphicDesigners = List.of("Wildnei Suane", "Catarina Santos", "Sandy Carolina");
        List<String> developers = List.of("William", "David", "Harisson");
        List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        // Como a gente faria agora para imprimir os elementos dessa lista sem utilizar os Streams, então digamos que
        // eu quero pegar essa lista e colocar tudo numa lista só, pegar todos os nomes de todas as pessoas estão dentro
        // do devdojo
        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }
        }

        // Então, o FlatMap é utilizado para esses casos aonde você tem que tirar um atributo que está aninhando, ou
        // seja, que está dentro de outro atributo e na verdade você está falando de uma coleção de atributos e como
        // ficaria o código utilizando FlatMap
        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
