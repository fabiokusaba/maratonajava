package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// DirectoryStream é uma das formas mais fáceis que nós temos de pegar todos os arquivos de um diretório, ele funciona
// mais ou menos como o dir
// O dir lista apenas o primeiro level que você tem de pastas e arquivos e o DirectoryStream funciona mais ou menos
// dessa forma
// Como o próprio nome diz DirectoryStream é uma classe que foi criada para trabalhar com diretórios
public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        // Pega tudo o que você tem no diretório atual e para isso podemos referenciar com o ponto .
        Path dir = Paths.get(".");

        // Quando você tem <T> significa que você está trabalhando com generics, generics significa que o Java vai
        // decidir em tempo de compilação qual é o tipo da classe que ele precisa criar
        // Geralmente quando você trabalha com IO e Stream você vai precisar fechar, ou seja, quando você vê que tem
        // essa Closeable aqui significa que de alguma forma nós vamos ter que chamar o método close para fechar o
        // recurso que nós estamos pegando do sistema operacional
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            // Stream é como se fosse um fluxo, quando você falar sobre fluxo você está falando sobre uma quantidade
            // maior do que um, isso significa que nós vamos ter que iterar sobre esse cara
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
