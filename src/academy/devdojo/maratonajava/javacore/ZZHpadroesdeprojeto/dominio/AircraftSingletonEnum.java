package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

// A vantagem de você utilizar uma enumeração nesse caso é porque o código ficou bem mais limpo do que o código anterior
// a criação de enumerações por padrão é thread-safe, mas lembrando de novo que bookSeat você teria que tomar cuidado
// para ter ele sincronizado se não você iria ter o mesmo problema de duas threads acessando a instância dessa
// enumeração a exatamente o mesmo tempo e por padrão você não tem a opção de utilizar reflection pra alterar o acesso
// do construtor da enumeração
public enum AircraftSingletonEnum {
    INSTANCE;
    private final Set<String> availableSeats;

    AircraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return this.availableSeats.remove(seat);
    }
}
