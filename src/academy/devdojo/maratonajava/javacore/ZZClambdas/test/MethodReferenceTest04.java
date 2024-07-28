package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

// Referência para um construtor
// Nós podemos utilizar lambdas para criar objetos
public class MethodReferenceTest04 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList(List.of(new Anime("Berserk", 43), new Anime("One Piece", 900), new Anime("Naruto", 500)));
        AnimeComparators animeComparators = new AnimeComparators();
        animeList.sort(animeComparators::compareByEpisodesNonStatic);

        // Existe uma interface funcional muito interessante chamada de Supplier que não recebe nenhum argumento e
        // retorna um tipo T
        // Isso é importante porque poderíamos criar um Anime da seguinte forma
        // Temos uma interface funcional que não tem nenhum argumento, mas ela retorna um Anime, ou seja, isso aqui pode
        // virar um method reference através de AnimeComparators::new
        // É muito importante você lembrar ou entender que não é nessa linha aqui que o objeto está sendo criado
        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;

        // Para criar um objeto eu chamo esse Supplier newAnimeComparators.get porque aí sim ele vai retornar um novo
        // objeto
        AnimeComparators anime = newAnimeComparators.get();

        animeList.sort(anime::compareByEpisodesNonStatic);
        System.out.println(animeList);

        // Como é que a gente faria para criar um objeto do tipo Anime? Porque aqui no nosso Anime nós temos um
        // construtor que recebe um title e episodes
        // Você pode ver que não rola porque você não tem o construtor sem parâmetros
//        Supplier<Anime> animeSupplier = Anime::new;

        // O que a gente pode fazer? A gente primeiro precisa definir algo que vai receber dois argumentos diferentes e
        // vai retornar um terceiro argumento, nós temos basicamente um Function que recebe um T e retorna um R, mas eu
        // quero receber um T, um U e retornar um R, e nós temos o BiFunction

        // Fazendo via lambda
        BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title, episodes);

        // Method reference
        // O Java já sabe que você tem dois atributos e vai colocar diretamente no construtor tipo 1, tipo 2 e vai
        // retornar pra você um Anime
        // Lembrando que o objeto não está sendo criado nessa linha
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;

        // O apply sim que vai se encarregar de criar esse novo Anime
        System.out.println(animeBiFunction2.apply("Super Campeões", 36));
    }
}
