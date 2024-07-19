package academy.devdojo.maratonajava.javacore.Pwrapper.test;

// Wrappers nada mais é do que tipos objetos que vão encapsular os tipos primitivos
// Java é uma linguagem orientada a objetos, tudo no Java é objeto como nós sabemos todas as classes são filhas de
// Object e os tipos primitivos são apenas tipos primitivos não temos nada na memória além do valor representando os
// bytes
// Vimos sobre passagem de parâmetro por valor e passagem de parâmetro por referência, então quando você está passando
// uma referência do objeto você faz alguma alteração alterando o valor original, mas se você passa uma variável de
// tipo primitivo que é uma passagem por valor você não está alterando o valor original
// As classes wrappers vão encapsular os tipos primitivos e transformar em objetos
// Um dos motivos do Java ter criado as classes wrappers é para você passar os valores numéricos por referência e não
// mais por valor para caso você queira fazer alguma alteração dentro do método, o segundo motivo é que quando nós
// trabalharmos com estruturas de dados do pacote de Collections eles não trabalham com tipos primitivos porque dentro
// das coleções você guarda referência e esse é um dos principais motivos que a gente precisa aprender a trabalhar com
// as classes wrappers
// Além disso, quando trabalharmos com threads principalmente no ambiente de concorrência você precisa de objetos para
// trabalhar com a parte de sincronização
// As boas práticas dizem que se você conseguir criar tipos primitivos vai de tipos primitivos utilize wrappers quando
// for preciso em uma dessas situações
public class WrapperTest01 {
    public static void main(String[] args) {
        // Tipos primitivos
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10L;
        float floatP = 10F;
        double doubleP = 10D;
        char charP = 'W';
        boolean booleanP = false;

        // Classes wrappers
        // Autoboxing é quando você tem um tipo primitivo e você simplesmente faz o Java transformar esse tipo primitivo
        // em um tipo wrapper
        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1;
        Long longW = 1L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'W';
        Boolean booleanW = false;

        // Unboxing é o contrário, então temos aqui uma variável primitiva e você quer pegar o wrapper o Java está se
        // encarregando de transformar esse tipo wrapper em tipo primitivo
        int i = intW;

        // Transformando uma String em um valor wrapper
        Integer intW2 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("TruE");
        System.out.println(verdadeiro);

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));
    }
}
