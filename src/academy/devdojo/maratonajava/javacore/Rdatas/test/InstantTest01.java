package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Instant;
import java.time.LocalDateTime;

// A classe Instant é parecida com a Date, a diferença é que a Date trabalha com milissegundos a partir de 1 de janeiro
// de 1970, mas a Instant ela trabalha com nanossegundos, ela representa um ponto instantâneo dentro de uma time-line
// Quando você cria um objeto Instant esse objeto como faz parte também do pacote java.time ele é imutável todas as
// alterações que você fizer nesse objeto vai gerar uma nova instância e esse objeto guarda os nanossegundos de 1970
// até agora
// Comparando com LocalDateTime percebemos que ela retorna quase a mesma coisa com a diferença do Z, e esse Z representa
// o Zulu time que representa o horário neutro do mundo, ou seja, qualquer pessoa em qualquer lugar do mundo pode
// pesquisar o horário em Zulu time e eles vão ver a mesma coisa
// O Zulu time é bastante utilizado em aplicações onde você precisa de data específica e você precisa salvar essa data
// no banco de dados por se tratar de uma data neutro
public class InstantTest01 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(LocalDateTime.now());

        // Um caso curioso é que os nanossegundos a partir de 1970 resultam num long muito grande e esses números não
        // cabem dentro de um long, então os desenvolvedores do Java dividiram em duas variáveis: você tem o nano e
        // você tem o epoch second
        System.out.println(now.getEpochSecond());

        // O nano ele representa o nanossegundo do segundo, ou seja, ele vai ter no máximo esse valor 999.999.999
        System.out.println(now.getNano());

        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3, 0));
        System.out.println(Instant.ofEpochSecond(3, 1_000_000_000));
        System.out.println(Instant.ofEpochSecond(3, - 1_000_000_000));
    }
}
