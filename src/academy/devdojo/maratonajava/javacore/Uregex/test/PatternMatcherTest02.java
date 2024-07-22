package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Como você já sabe as expressões regulares foram criadas para você pegar determinados padrões dentro de um texto e as
// vezes os padrões não são tão simples quanto só colocar uma palavra
public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // É assim que funciona os meta caracteres eles vão servir como se fosse um atalho para você conseguir pegar
        // determinados caracteres
        // O primeiro meta caracter que nós temos é o \d e ele vai retornar todos os dígitos daquele texto
        // Nós temos também o \D que é o contrário, ou seja, vai retornar tudo o que não for dígito
        // Outro interessante que nós temos também é o \s que vai trazer todos os espaços em branco, no Java os espaços
        // em branco podem ser \t, \n, \f, \r
        // Além do \s nós temos o \S vão trazer todos os caracteres excluindo os brancos
        // E nós temos também o \w que vai trazer tudo o que for de a-z ou de A-Z, todos os dígitos (valores numéricos),
        // e _, basicamente ele excluiu todos os caracteres especiais
        // E o \W que basicamente é o contrário do que nós temos no \w, ele vai trazer tudo o que não for incluso no \w
        String regex = "\\w";

        // Digamos que nós temos o seguinte valor e dentro desse texto eu quero, por exemplo retirar só os números
        String texto2 = "@#hh_j2 12gvh21";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("texto:  " + texto2);
        System.out.println("índice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas: ");

        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
