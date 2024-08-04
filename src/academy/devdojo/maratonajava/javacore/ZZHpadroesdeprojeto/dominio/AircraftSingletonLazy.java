package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

// Então, como é que funciona o Lazy Initialization? No getInstance você adiciona um if, então se a instância for nula
// você faz a INSTANCE receber esse objeto, se não for nula ele já vai retornar a mesma INSTANCE, mas aí nós temos um
// pequeno probleminha nesse código qual o problema que nós temos? Quando você está trabalhando em ambientes multi
// thread você pode ter um problema que nem já vimos você pode ter duas threads acessando isso aqui uma verifica e ao
// invés de dar continuidade ela para e a outra verifica e ao invés de dar continuidade ela para também, mas as duas tem
// o resultado falando que a INSTANCE é nula e aí as duas vão entrar nesse if e se você tiver duas threads trabalhando
// dessa forma você possivelmente vai conseguir fazer com que dois usuários peguem o mesmo assento
// Bom, geralmente como isso é resolvido? Você pode dar um synchronized no método e tudo está resolvido, mas o problema
// é que quando você faz dessa forma você está afetando um pouco a performance, então geralmente como funciona? Você faz
// um double lock
public final class AircraftSingletonLazy {
    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    // Double lock -> primeiro você verifica se é nulo, se for nulo você dá um synchronized na classe e aqui dentro
    // você tem o mesmo if verificando se a INSTANCE é nula e como você pode ver dessa forma nós temos um código que
    // tem boas garantias que a possibilidade de você ter duas instâncias diferentes é bem reduzida
    public static AircraftSingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
