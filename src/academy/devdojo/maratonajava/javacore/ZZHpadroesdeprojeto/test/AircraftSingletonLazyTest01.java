package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Mas, aí temos um outro problema o Java tem um conceito chamado reflection que é muito utilizado por frameworks que
// basicamente utiliza as propriedades, metadados da sua classe pra fazer as coisas sem saber exatamente o que existe lá
// dentro, então você pode, por exemplo, fazer os atributos privados virarem públicos ou você pode pegar todos os
// atributos que estão listados na sua classe, mas que afeta a performance de forma absurda do seu programa e uma das
// coisas que você pode fazer com reflection é fazer o seu construtor ficar público
public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");

        System.out.println(AircraftSingletonLazy.getInstance());
        System.out.println(AircraftSingletonLazy.getInstance());

        // Dando continuidade a última parte do nosso Singleton Pattern nós vamos ver como podemos resolver esse
        // problema que nós temos aqui no SingletonLazy e SingletonEager que é você poder alterar via reflection a
        // acessibilidade do construtor
        // Só lembrando que quando eu falo que é thread safe nesse caso do SingletonLazy é a ação do objeto
        // AircraftSingletonLazy, lembrando que se você realmente está trabalhando num ambiente multi-thread você
        // precisa ter certeza absoluta que o bookSeat também é thread-safe porque se não você pode ter duas threads
        // removendo o mesmo assento
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");
        System.out.println(aircraftSingletonLazy);
    }

    private static void bookSeat(String seat) {
        AircraftSingletonLazy aircraftSingletonLazy = AircraftSingletonLazy.getInstance();
        System.out.println(aircraftSingletonLazy.bookSeat(seat));
    }
}
