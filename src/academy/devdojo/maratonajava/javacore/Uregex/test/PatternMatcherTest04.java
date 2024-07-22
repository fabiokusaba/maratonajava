package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
    public static void main(String[] args) {
        // Quantificadores são caracteres que vão te dar poder em pegar determinada expressão baseada na quantidade que
        // o meta caracter representa, por exemplo
        // Você tem a ? que é zero ou uma ocorrência
        // Você tem o * que é zero ou mais
        // Você tem o sinal de + que representa uma ou mais ocorrências
        // E se você quer ter um valor mais específico você pode utilizar as chaves {n,m} que é um valor n ou m que é
        // de n até m, então digamos que você quer pegar de 5 a 10 ocorrências
        // Outros meta caracteres que vão ajudar nós temos o de agrupamento que são os parênteses ()
        // Nós temos o meta caracter que é o pipe | que é para ou
        // Digamos que você quer achar uma palavra que seja o(v|c)o, desta forma estou falando que ele vai dar um match
        // nas ocorrências de ovo ou nas ocorrências de oco, por exemplo
        // Por último nós temos o cifrão $ que ele representa o fim da linha
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";

        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  " + texto);
        System.out.println("índice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas: ");

        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
