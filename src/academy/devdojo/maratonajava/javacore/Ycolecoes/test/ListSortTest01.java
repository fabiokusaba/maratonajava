package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Hellsing Ultimate");
        mangas.add("Berserk");
        mangas.add("Pokemon");
        mangas.add("Attack on titan");
        mangas.add("Dragon ball Z");

        // Digamos que você queira fazer a ordenação dessa lista uma das formas é utilizar a Collections.sort
        // Esse método vai reorganizar a lista na ordem, se você estiver trabalhando com Strings em ordem alfabética,
        // se você estiver trabalhando com números na ordem do menor para o maior

        // Essa lista só foi possível ordenar porque a String já toma conta disso, então se você abrir a classe String
        // como é que o Java sabe que essa String pode ser organizada por ordem alfabética por causa que a String está
        // implementando essa interface Comparable, e essa interface tem o método compareTo que você provém a
        // implementação dele e ele vai saber como sortir o seu objeto dentro de coleções
        Collections.sort(mangas);

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(23.98);
        dinheiros.add(21.21);
        dinheiros.add(98.10);

        Collections.sort(dinheiros);

        for (String manga : mangas) {
            System.out.println(manga);
        }

        System.out.println(dinheiros);
    }
}
