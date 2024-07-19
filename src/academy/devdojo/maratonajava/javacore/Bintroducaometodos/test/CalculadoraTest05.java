package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest05 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int[] numeros = {1, 2, 3, 4, 5};
        calculadora.somaArray(numeros);

        // Passando vários argumentos separados por vírgula que o Java por de baixo dos panos vai transformar em um
        // array, o que muda do varargs e do array é só uma questão de sintaxe
        calculadora.somaVarArgs(1, 2, 3, 4, 5, 6, 7);
    }
}
