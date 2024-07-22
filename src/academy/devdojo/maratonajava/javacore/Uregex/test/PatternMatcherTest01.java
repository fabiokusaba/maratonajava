package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Expressões regulares nada mais é do que uma linguagem que foi desenvolvida que utiliza metacaracteres, utiliza uns
// símbolos e ele vai encontrar padrões no texto, também utilizado para validações
public class PatternMatcherTest01 {
    public static void main(String[] args) {
        // Expressão regular para demonstrar o que procuramos
        String regex = "aba";

        // Texto para servir de base
        //String texto = "abaaba";
        String texto2 = "abababa";

        // São duas classes que precisamos para trabalhar com regex no Java que é a Pattern que é o padrão e a Matcher
        // que encontra aquele padrão
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("texto:  " + texto2);
        System.out.println("índice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas: ");

        // O Matcher ele vai ficar procurando durante o texto, então enquanto ele encontrar
        // Por que o start? Porque enquanto estamos pesquisando ab ele vai encontrar no texto ab, existe a posição 0 e 1
        // mas, aonde começou esse match, ou seja, aonde que começou o ab, então nesse caso é na posição 0, o próximo
        // começa na posição 3 e assim por diante
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
    }
}
