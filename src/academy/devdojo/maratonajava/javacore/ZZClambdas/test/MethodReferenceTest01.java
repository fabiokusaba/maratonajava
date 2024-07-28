package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList(List.of(new Anime("Berserk", 43), new Anime("One Piece", 900), new Anime("Naruto", 500)));

        // Digamos que você quer organizar esses animes por nome, como você faria utilizando lambdas?
        // Lambda basicamente só se importa com o target type e o functional descriptor, então o target type é o
        // contexto onde a lambda está inserido isso significa que podemos criar um método que é exatamente o que o
        // compareTo faz, basicamente o functional descriptor, o compareTo pede dois atributos do tipo T e retorna um
        // int
//        Collections.sort(animeList, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));

        // Você pode ver que a gente está chamando apenas um método, ou seja, nós podemos utilizar o method reference
//        Collections.sort(animeList, (a1, a2) -> AnimeComparators.compareByTitle(a1, a2));

        // O código acima pode ser escrito da seguinte forma
        // Nesse caso aqui a lambda está tomando conta porque você tem o mesmo functional descriptor está retornando
        // exatamente o que o compareTo está retornando, nesse caso retorna um int e está aceitando dois argumentos
        // por isso conseguimos fazer esse código funcionar
        Collections.sort(animeList, AnimeComparators::compareByTitle);
        animeList.sort(AnimeComparators::compareByEpisodes);

        System.out.println(animeList);
    }
}
