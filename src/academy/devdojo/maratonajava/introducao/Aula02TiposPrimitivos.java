package academy.devdojo.maratonajava.introducao;

public class Aula02TiposPrimitivos {
    public static void main(String[] args) {
        // Tipos primitivos são os tipos que vão guardar em memória um valor simples
        // int, double, float, char, byte, short, long, boolean
        // Os tipos primitivos com exceção do boolean são todos numéricos e a diferença entre eles é a quantidade de
        // valor que você pode colocar dentro da variável, dentro do espaço em memória
        // Casting é você forçar através dos parênteses a entrada de um valor, você pode fazer o casting de um número
        // maior, de uma variável primitiva maior para uma variável primitiva menor
        // String não é um tipo primitivo, é o que chamamos de tipos de referência ou reference types
        int idade = (int) 10000000000L;
        long numeroGrande = 100000L;
        double salarioDouble = 2000.0;
        float salarioFloat = (float) 2500.0D;
        byte idadeByte = 127;
        short idadeShort = 32000;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = '\u0041';
        String nome = "Goku";

        System.out.println("A idade é " + idade + " anos");
        System.out.println(falso);
        System.out.println("char " + caractere);
        System.out.println(salarioFloat);
        System.out.println("Oi meu nome é " + nome);
    }
}
