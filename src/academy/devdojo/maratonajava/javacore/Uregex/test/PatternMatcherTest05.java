package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// regexr.com
// Caracter de acento circunflexo ^ Anchor é um caracter que pode ser utilizado pra dar um match, para encontrar
// exatamente aquilo que você quer no começo da linha, a segunda forma de utilizar é como negação e para isso ele
// precisa estar dentro dos colchetes [] e ele é case sensitive por isso tem diferenciação entre maiúsculas e minúsculas
public class PatternMatcherTest05 {
    public static void main(String[] args) {
        // Tem mais um caracter que chamamos de caracter coringa que é o ., então se por exemplo você falar que está
        // procurando uma expressão 1.3 ele vai achar, por exemplo 123, 133, 1@3, 1A3, ou seja, tudo o que poder ter
        // entre o 1 e o 3 ele é considerado, por isso que ele é o caracter coringa
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";

        // Imagine que nós temos o seguinte texto e com base nele traga todos os emails válidos
        String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, test@gmail.com.br, sakura@mail";

        // Digamos, por exemplo que você quer validar se esse #@!zoro@mail.br é válido, essa String em si, o que você
        // pode fazer é utilizar o método matches da classe String que justamente é para fazer essa validação através
        // de uma expressão regular
        System.out.println("Email válido");
        System.out.println("#@!zoro@mail.br".matches(regex));

        System.out.println(Arrays.toString(texto.split(",")));
        System.out.println(texto.split(",")[1].trim());

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
