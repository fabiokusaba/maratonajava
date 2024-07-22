package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // O caracter de range é representado pelos colchetes [], ou seja, e o que você tem aqui dentro é representado
        // como um range de caracteres
        //String regex = "[a-zA-C]";
        String regex = "0[xX][0-9a-fA-F]";

        // Digamos que a gente tenha o seguinte texto e eu quero dentro desse texto achar as letras a, b ou c
        String texto2 = "cafeBABE";

        // Digamos que a gente tenha um texto e queremos encontrar os números hexadecimais, sabemos que no Java os
        // números hexadecimais começam com 0x e só podem ir até F
        String texto3 = "12 0x 0X 0xFFABC 0x109 0x1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto3);
        System.out.println("texto:  " + texto3);
        System.out.println("índice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas: ");

        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }

        // Números hexadecimais -> no Java para ele reconhecer números hexadecimais é preciso começar com 0x ou 0X
        int numeroHex = 0x59F86A;
        int numeroHex2 = 0X59F86A;
        System.out.println(numeroHex);
    }
}
