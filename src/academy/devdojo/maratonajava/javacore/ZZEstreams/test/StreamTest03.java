package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
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
        // Uma operação final que você pode fazer é o forEach que não tem retorno, mas ele tem o Consumer que
        // basicamente pode fazer uma ação
        // Uma coisa que preciso falar pra vocês é que a própria lista tem um método forEach que também recebe o mesmo
        // Consumer, porém você tem que lembrar que do stream para o forEach você tem uma operação terminal, mas da
        // coleção para o forEach não é uma operação terminal que tecnicamente você não está dentro de um stream isso
        // daqui é só um método dentro da interface Iterable que vai receber um Consumer
        // Então, basicamente eles tem o mesmo nome mas é uma má prática você fazer stream().forEach() porque você está
        // criando uma Stream que basicamente transforma os seus dados do espaço para o tempo e você está imprimindo
        // todos eles, ou seja, você está desperdiçando processamento quando você poderia fazer diretamente aqui
        // lightNovels.forEach()
        Stream<LightNovel> stream = lightNovels.stream();
        lightNovels.forEach(System.out::println);

        // Outra operação terminal que você poderia fazer também é contar, digamos que você quer contar quantos
        // elementos tem aqui dentro, então você poderia usar o size, mas digamos que você quer contar quantos light
        // novels tem o preço menor do que 4
        long count = stream.filter(ln -> ln.getPrice() <= 4).count();

        // Digamos agora que você queira os elementos distintos, então você pode usar o distinct que é uma operação
        // intermediária, ou seja, ele vai retornar um outro Stream que eu posso encadear

        // Quando você está trabalhando com Stream você está trabalhando no espaço de tempo, então quando você está com
        // as coleções você está no espaço, mas quando você está nas Streams você está no tempo e quando você fecha um
        // Stream você não pode mais trabalhar com aquele Stream porque você já fechou o fluxo daqueles elementos que
        // você estava trabalhando, como você faz para pegar novamente um Stream? Você tem que ir lá na fonte de dados
        // e chamar lightNovels.stream
        long count2 = lightNovels.stream()
                .distinct()
                .filter(ln -> ln.getPrice() <= 4)
                .count();

        System.out.println(count);
        System.out.println(count2);
    }
}
