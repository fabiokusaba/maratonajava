package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // Eu quero que você some todos os preços acima de 3 e retorne a soma daqueles preços
        // Como você viu aqui no reduce nós estamos trabalhando com wrappers quando na verdade o nosso LightNovel tem
        // o tipo primitivo double a performance não vai ser tão afetada assim se você ficar deixando o Java trabalhar
        // fazendo boxing e unboxing desses valores de primitivo para wrapper, de wrapper para primitivo, porém caso
        // você esteja trabalhando em uma aplicação de alta performance é melhor você tomar cuidado com esse cara, ao
        // invés de utilizar o reduce você pode trabalhar diretamente com os tipos primitivos usando os Streams de
        // primitivos DoubleStream, LongStream, IntStream
        lightNovels.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        // Para trabalhar dessa forma podemos fazer
        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();
        System.out.println(sum);
    }
}
