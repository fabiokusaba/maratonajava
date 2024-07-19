package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "       Luffy       ";
        String numeros = "012345";

        // O método charAt vai retornar o char baseado no índice, o índice começa em zero
        System.out.println(nome.charAt(0));

        // Existe um método chamado length para você saber o tamanho das Strings, a diferença do length de um array e o
        // length de uma String é que o length de um array é um atributo e o length de uma String é um método, mas ambos
        // vão retornar o tamanho
        System.out.println(nome.length());

        // Outro método interessante é o replace, o replace é um método que vai trocar todos os caracteres da primeira
        // posição por um outro caracter
        System.out.println(nome.replace("f", "l"));

        // Outro método que vimos é o toLowerCase e o toUpperCase, o toLowerCase vai transformar tudo em minúscula e o
        // toUpperCase tudo em maiúscula
        System.out.println(nome.toLowerCase());
        System.out.println(nome.toUpperCase());

        System.out.println(numeros.length());

        // Existe um método chamado substring e o método substring recebe dois valores o índice daonde você quer começar
        // e o índice daonde você quer terminar, mas com um pequeno porém o índice que está terminando ele é sempre um
        // a menos do que você está passando
        // O índice final não é inclusivo ele é exclusivo, ou seja, ele vai retornar 01
        System.out.println(numeros.substring(0, 2));

        // O trim é um método que vai remover os valores que você tem em branco no começo e no fim da String
        System.out.println(nome.trim());
    }
}
