package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// Da mesma forma que a gente fez no List o Set é uma interface, essa interface ela é uma Collection e a vantagem do
// Set é que ele não permite elementos duplicados dentro da coleção
// Existem algumas opções de objetos que podemos criar, vamos começar com HashSet, como você já viu aqui o HashSet tem
// Hash no nome significa que essa é uma coleção aonde permite apenas elementos únicos e esses elementos eles serão
// organizados pelo Hash, ou seja, não tem como garantir como esses caras vão estar dentro da nossa lista porque ele
// pode se reajustar baseado no que nós inserirmos
public class SetTest01 {
    public static void main(String[] args) {
        // Então, assim como nós temos o HashSet que não mantém a ordem de inserção, se você quiser manter a ordem de
        // inserção ainda utilizando um Hash você pode utilizar um LinkedHashSet que vai manter a ordem de inserção
        Set<Manga> mangas = new LinkedHashSet<>();
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));

        // Ao tentarmos inserir novamente o Dragon ball Z tecnicamente nós deveríamos ter dois elementos, mas você vai
        // ver que nós temos apenas um Dragon ball Z porque antes de inserir o Java vai checar através do método equals
        // por isso é importante você ter o método equals sobrescrito na sua classe, porque ele vai garantir que você
        // não adicione elementos duplicados
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));

        // E você vai ver que não existe índice porque o Set não é indexado, não tem como você pegar get na posição 1,
        // você precisa navegar sobre a coleção e você pode utilizar o foreach
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
