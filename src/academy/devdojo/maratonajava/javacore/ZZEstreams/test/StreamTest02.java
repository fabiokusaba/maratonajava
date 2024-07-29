package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Relembrando Streams na verdade é uma sequência de elementos, quando a gente fala sobre coleções a gente está
// falando sobre elementos em um espaço onde você está guardando os seus dados, as suas coleções, você está falando de
// memória, quando a gente trabalha com Streams a gente está falando sequência de elementos esses elementos eles estão
// digamos que no tempo, podemos falar que coleções trabalham com dados no espaço e Streams trabalham com dados no
// tempo porque você está trabalhando com a sequência você não está guardando absolutamente nada
public class StreamTest02 {
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
        // A maioria das coleções tem um método chamado stream e você pode ver que o retorno desse cara é um Stream do
        // tipo da nossa coleção significa que agora eu vou trabalhar com essa sequência de elementos
        // E o que eu vou fazer nessa sequência de elementos? Nós temos o que chamamos de operações, as operações em uma
        // stream tem duas opções: ou elas são intermediárias ou elas são finais, uma ação intermediária significa uma
        // ação que retorna o próprio Stream, ou seja, você pode encadear ações
        // O stream tem o método chamado sorted que significa que vai fazer a ordenação e retorna um outro Stream, ou
        // seja, essa é uma operação intermediária
        // Aqui eu tenho o método chamado filter que pede um Predicate significa que a gente pode usar uma programação
        // funcional aqui, utilizar lambda, o tipo de retorno do filter é um Stream também o que significa que é uma
        // operação intermediária também, ou seja, podemos dar continuidade
        // Após filtrarmos queremos limitar e para isso temos o limit que também é uma operação intermediária
        // Agora vem a parte que nós precisamos pegar os títulos existe um método que geralmente quando você vai fazer
        // o mapeamento de um atributo específico de uma classe você tem o nome map, nas nossas Streams nós temos
        // também o map que ele aceita uma Function, ou seja, ele recebe um T e retorna um R, então se ele recebe um
        // light novel ele pode retornar o título daquele light novel, podemos utilizar aqui method reference, aqui
        // temos também uma operação intermediária que vai retornar um outro Stream
        // O que precisamos agora é de uma operação final, uma operação que vai fechar o Stream e vai retornar uma
        // coleção, uma das operações finais que nós temos é o coletar, ou seja, você fez a ordenação, você filtrou,
        // você limitou, você pegou somente os títulos e agora o que você precisa fazer com essa Stream? Lembrando que
        // uma Stream é uma sequência de dados você precisa pegar e agrupar, ou seja, tire do tempo e mova para o espaço
        // Perceba que o collect retorna R e não mais um Stream, então aqui dentro desse collect você fala como é que
        // você quer retornar, temos um método que é o toList para retornar uma lista
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());

        System.out.println(titles);
    }
}
