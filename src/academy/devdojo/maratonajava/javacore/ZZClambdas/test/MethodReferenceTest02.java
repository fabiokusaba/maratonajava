package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Referência a métodos não estáticos
// Da mesma forma que temos na nossa classe AnimeComparators os métodos compareByTitle e compareByEpisodes estáticos
// você poderia ter um outro método que não é estático aí você iria precisar de um objeto
public class MethodReferenceTest02 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList(List.of(new Anime("Berserk", 43), new Anime("One Piece", 900), new Anime("Naruto", 500)));

        // Através desse método não estático nós precisaríamos de um objeto, então
        AnimeComparators animeComparators = new AnimeComparators();

        // É um lambda normal, mas estamos chamando através de um objeto ao invés de chamar diretamente no nome da
        // classe
        animeList.sort(animeComparators::compareByEpisodesNonStatic);

        // Se fosse através de um lambda
        animeList.sort((a1, a2) -> animeComparators.compareByEpisodesNonStatic(a1, a2));
        System.out.println(animeList);
    }
}
