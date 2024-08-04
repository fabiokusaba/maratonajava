package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Aircraft;

public class AircraftTest01 {
    public static void main(String[] args) {
        // Digamos que você vem aqui e você chama o método passando o assento 1A, mas tem um outro usuário que também
        // chama o mesmo método com o assento 1A, você está tentando fazer 1A duas vezes, ou seja, uma delas tinha que
        // retornar false porque você pega um assento do avião ele obrigatoriamente tem que te retornar false dizendo
        // que esse assento já foi agendado
        // Se você executar você vai ver que ele vai retornar true true e por que ele vai retornar true true? Porque
        // aqui no nosso Aircraft quando nós criamos o objeto nós inicializamos, ou seja, nós criamos um avião, nós
        // colocamos assentos no avião e aí quando vimos aqui na nossa classe de teste quando nós estamos criando um
        // objeto nós estamos duplicando todos os dados, então o motivo é que a gente está criando dois objetos quando
        // na verdade a gente só pode ter um objeto porque só existe uma aeronave, só existe essa aeronave 787-900
        bookSeat("1A");
        bookSeat("1A");
    }

    // Imagina que a gente tem um método aqui
    private static void bookSeat(String seat) {
        Aircraft aircraft = new Aircraft("787-900");
        System.out.println(aircraft.bookSeat(seat));
    }
}
