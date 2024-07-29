package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        // Vamos imaginar o seguinte exemplo: você tem uma lista e essa lista é uma lista de palavras, então por exemplo
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");

        // E eu quero que você retorne cada uma dessas letras em uma nova lista, ou seja, eu quero uma lista onde a
        // posição 0 seja 'G', a posição 1 seja 'o' e assim por diante até o final
        // Como é que você faria isso para uma palavra?
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));

        // Como podemos fazer isso utilizando Streams?
        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());

        // Digamos que eu tenha um Array e eu quero transformar ele em um Stream
        Stream<String> stream = Arrays.stream(letters);

        // Como você pode ver o uso do flatMap é bem específico é só você ver quando você tem algo aninhado você muito
        // provavelmente tem que utilizar o flatMap
        List<String> letters2 = words.stream()
                .map(w -> w.split("")) // Stream<String[]>
                .flatMap(Arrays::stream) // Stream<String>
                .collect(Collectors.toList());

        System.out.println(letters2);
    }
}
