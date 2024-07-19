package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest02 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Argumentos -> na hora que você está chamando o método os parâmetros são chamados de argumentos
        calculadora.multiplicaDoisNumeros(10, 20);
    }
}
