package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

// Bom, como a gente resolve essa situação? Tem várias formas uma delas é a Eager Initialization que basicamente é a
// forma gulosa de você inicializar
// O que é um objeto que tem inicialização gulosa/eager? Lembre-se quando um atributo é estático no momento em que o
// class loader passar por essa classe aqui esse objeto vai ser criado
public final class AircraftSingletonEager {
    private static final AircraftSingletonEager INSTANCE = new AircraftSingletonEager("787-900");
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonEager(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    // Todas as vezes que eu chamar essa INSTANCE você pode adicionar um getter para ficar bem explícito que você está
    // realmente pegando a instância, todas as vezes que eu executar esse getInstance ele sempre vai me retornar esse
    // valor new AircraftSingletonEager("787-900") e por que eu sei? Porque ele é final e ele é estático
    public static AircraftSingletonEager getInstance() {
        return INSTANCE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
