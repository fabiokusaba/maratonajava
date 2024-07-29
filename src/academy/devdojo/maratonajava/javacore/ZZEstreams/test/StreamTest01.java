package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

// Basicamente Streams é uma forma que você tem de processamento de dados que ajuda você a fazer as funcionalidades
// que você precisa em uma coleção de uma forma mais funcional, uma forma mais declarativa
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1. Order LightNovel by title
// 2. Retrieve the first 3 titles light novels with price less than 4
public class StreamTest01 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // Ordenando por título
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));

        // Pegando os três primeiros títulos com preço menor que 4
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if (lightNovel.getPrice() <= 4) {
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >= 3) {
                break;
            }
        }

        System.out.println(lightNovels);
        System.out.println(titles);
    }
}
