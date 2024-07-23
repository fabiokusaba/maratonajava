package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    // Ele é invocado quando basicamente entra em um diretório, aqui não temos garantia do seu comportamento
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("pre visit " + dir.getFileName());

        // Nós colocamos continue, se você colocar skip subtree ele basicamente vai dar um skip em tudo o que tem dentro
        // de pasta e o skip siblings tem o mesmo comportamento do skip subtree quando você está trabalhando com
        // diretórios
        return FileVisitResult.CONTINUE;
    }

    // Basicamente como o nome já diz se ele tentar ler um arquivo, por exemplo o arquivo não tiver permissão de leitura
    // ou se tiver qualquer tipo de problema para pegar aquele arquivo ele vai lançar essa exceção aí você pode usar
    // esse visitFileFailed pra, por exemplo para exibir, colocar um log falando que tentou ler o arquivo no diretótio
    // tal e falhou
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    // Basicamente o contrário do preVisitDirectory, o preVisit é para quando você está entrando e esse é para quando
    // você está saindo
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post visit " + dir.getFileName());

        // O skip subtree e o skip siblings não funcionam aqui porque uma vez que você entrou você precisa sair
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("pasta");
        Files.walkFileTree(root, new ListAllFiles());
    }
}
