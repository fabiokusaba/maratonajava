package academy.devdojo.maratonajava.javacore.ZZClambdas.service;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;

public class AnimeComparators {
    // Podemos aqui criar um método que faz a mesma coisa do compareTo, mas não vai passar no teste é um Comparator
    // Como você pode ver eu tenho agora um método que ele é estático dentro do meu AnimeComparators
    public static int compareByTitle(Anime a1, Anime a2) {
        return a1.getTitle().compareTo(a2.getTitle());
    }

    public static int compareByEpisodes(Anime a1, Anime a2) {
        return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
    }

    public int compareByEpisodesNonStatic(Anime a1, Anime a2) {
        return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
    }
}
