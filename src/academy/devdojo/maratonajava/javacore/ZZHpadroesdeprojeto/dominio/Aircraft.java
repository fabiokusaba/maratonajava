package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

// Qual o problema que o singleton tenta resolver? Em determinados momentos da sua vida de desenvolvedor você vai
// precisar criar uma classe aonde ela só pode ter um objeto e esse objeto tem que ser compartilhado por qualquer
// pessoa, qualquer thread, qualquer parte do seu código que tente utilizá-lo, por exemplo, geralmente drivers de
// conexão com banco de dados são um claro exemplo de singleton
// Vamos imaginar que a gente tem uma classe de domínio chamada Aircraft essa classe vai ter um Set que vai representar
// os assentos disponíveis, os assentos em um avião sempre são únicos, e aí vamos criar um método para comprar um
// assento, podemos deixá-la como sendo uma classe final para não ser extendida
// Então, qual o problema quando você tem esse tipo de caso? O problema é que você precisa garantir que os dados que
// estão dentro do seu objeto sejam o mesmo independente de quem estiver criando, independente de quem estiver chamando
// o objeto, ou seja, você tem que garantir uma forma de que todas as classes que forem utilizar o objeto do tipo
// Aircraft sempre utilizem o mesmo espaço em memória com os mesmos dados, então isso vai evitar você ter esse tipo de
// problema
public final class Aircraft {
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public Aircraft(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    public String getName() {
        return name;
    }
}
