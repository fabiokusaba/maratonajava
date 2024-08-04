package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Aircraft;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        // Aqui eu pego o objeto através do getInstance, então eu não posso mais dar new nosso construtor da classe tem
        // que ser privado obrigatoriamente porque agora eu não tenho mais opção de fazer new AircraftSingletonEager()
        // ou seja, você cortou a possibilidade de qualquer classe de criar um objeto significa que a única forma de
        // você obter um objeto que é do tipo Aircraft seria você chamar o getInstance e todas as vezes que você chamar
        // o getInstance você vai ter exatamente esse mesmo objeto, esse mesmo espaço em memória
        AircraftSingletonEager aircraftSingletonEager = AircraftSingletonEager.getInstance();
        System.out.println(aircraftSingletonEager.bookSeat(seat));
    }
}
