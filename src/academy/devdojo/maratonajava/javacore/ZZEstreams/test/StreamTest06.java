package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// Quando a gente está trabalhando com coleções a gente tem que de alguma forma manipular essas coleções
public class StreamTest06 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // Digamos que eu queira encontrar, por exemplo existe algum light novel que tem preço maior que 8
        // A gente tem um método dentro das Streams que é o anyMatch, o anyMatch vai fazer uma busca, como você pode ver
        // ele aceita um Predicate e vai retornar um booleano, então por exemplo
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));

        // Outro método interessante que nós temos é o allMatch, digamos assim que você quer ter certeza que todos os
        // light novels tem o preço maior que 0
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));

        // Você também tem o inverso noneMatch que vai retornar true se nenhum light novel tiver preço maior que 0
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() > 0));

        // E além disso, nós temos outros que podem ser utilizados juntamente com filtro, por exemplo nós temos o
        // findAny e o findFirst que você vai trabalhar com Predicate utilizando filter e o findAny e findFirst ele
        // retorna um Optional
        // O findAny se você ler a documentação ela vai falar que ele é não determinístico, então ele pode selecionar
        // qualquer elemento de dentro desse Stream, utilize esse findAny quando você não se importa com o resultado e
        // se você ver o que ele retorna é um Optional, como existe a possibilidade dele não retornar nada ele já te
        // obriga a tratar, então nesse caso aqui você pode encadear com algum dos outros métodos que nós temos dentro
        // do Optional, por exemplo ifPresent, ifPresentOrElse ou até mesmo orElseThrow você escolhe a lógica de negócio
        // que você quer
        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);

        // E nós também podemos utilizar o findFirst, então ele vai encontrar o primeiro elemento dessa lista aonde o
        // preço é maior que 3 e a mesma coisa do exemplo anterior se ele estiver presente imprimo no console
        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);
    }
}
