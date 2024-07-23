package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Se você for dentro da Files você tem um método chamado walkFileTree, basicamente esse método está dizendo que ele
// precisa de um Path para startar, ou seja, onde você quer começar a procurar, e o FileVisitor que basicamente define
// o comportamento do que você quer fazer quando você está navegando por esses diretórios
// A gente precisa de um objeto que passe no teste é um FileVisitor e a melhor forma de fazer isso é criando uma nova
// classe
// Novamente aqui temos os generics e precisamos falar para que tipo nós vamos querer substituir esse <T>, basicamente
// quando eu falo que eu quero, por exemplo Path, estou dizendo que todos os métodos que você tem esse <T> nós vamos ter
// o Path
class ListJavaFiles extends SimpleFileVisitor<Path> {
    // Como é uma classe não sou obrigado a sobrescrever todos os métodos, vamos sobrescrever apenas um método
    // Quem vai chamar esse método é o Java através do polimorfismo a gente só precisa definir o que a gente quer fazer
    // O retorno que nós temos é um FileVisitResult basicamente nós temos algumas enumerações, então o que o Java vai
    // fazer? O Java vai navegar e encontrar o primeiro que é maratonajava ao encontrar uma pasta ele vai perguntar se
    // você quer continuar, quer terminar, pular subpastas ou pular quem está no mesmo nível
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        // Um desafio pra você, como você faria para você imprimir, por exemplo todos os arquivos .java e ignorar o
        // resto
        // Já temos o nome do arquivo, tudo o que precisamos fazer é:
        if (file.getFileName().toString().endsWith(".java")) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Files.walkFileTree(root, new ListJavaFiles());
    }
}
