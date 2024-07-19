package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest04 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int num1 = 1;
        int num2 = 2;
        // Quando passamos valores do tipo primitivo para um método você não está passando a referência daquele objeto
        // em memória, mas sim você está fazendo uma cópia e enviando ela
        // Dentro das suas classes quando você está passando variáveis do tipo primitivo a variável original do tipo
        // primitivo nunca vai ser alterada não importa o que aconteça dentro do método a variável original nunca será
        // alterada porque você está passando uma cópia daqueles valores
        calculadora.alteraDoisNumeros(num1, num2);
        System.out.println("Dentro CalculadoraTest04");
        System.out.println("Num1 " + num1);
        System.out.println("Num2 " + num2);
    }
}
