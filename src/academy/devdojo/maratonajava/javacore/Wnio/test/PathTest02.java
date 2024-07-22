package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        // Digamos que a gente quer pegar o diretório que nós estamos maratonajava para isso utilizamos Paths.get e se
        // você não passar nada você está trabalhando no diretório aonde esse programa está sendo executado, então vou
        // colocar aqui que quero pegar esse diretório pasta e isso seria equivalente a new File(pasta)
        Path pastaPath = Paths.get("pasta");

        // Para criar esse diretório você precisa chamar o Files e você tem duas opções: createDirectory e
        // createDirectories, isso vai lançar uma exceção do tipo checked que precisa ser tratada
        // Ele não retorna mais um boolean ele retorna um Path, a maior diferença é que se você executar novamente ele
        // lança uma exceção no caso o arquivo já existe
        // Para contornar esse problema você tem dentro de Files o exists ou notExists, isso funciona quando você tem
        // um diretório
        if (Files.notExists(pastaPath)) {
            Path pastaDirectory = Files.createDirectory(pastaPath);
        }

        // Existem algumas vezes onde você tem múltiplos diretórios
        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");

        // Nesses casos com createDirectories é possível, uma das vantagens é que caso os parents não existam ele vai
        // criar e se você executar novamente ele não vai lançar uma exceção caso o diretório já exista
        Path subPastaDirectory = Files.createDirectories(subPastaPath);

        // Para criar um arquivo em si você vai ter que chamar Files.createFile, mas esse createFile também está
        // pedindo um atributo do tipo Path
        Path filePath = Paths.get(subPastaPath.toString(), "file.txt");

        if (Files.notExists(filePath)) {
            Path filePathCreated = Files.createFile(filePath);
        }

        // Digamos que eu quero copiar renomeando esse file.txt para file_renamed.txt dentro de subsubpasta
        // Nosso arquivo está dentro desse filePath, o arquivo original, você pode fazer o seguinte:
        // O getParent vai retornar o pai daonde esse arquivo se encontra
        Path source = filePath;
        Path target = Paths.get(filePath.getParent().toString(), "file_renamed.txt");

        // Se você escrever alguma coisa dentro do arquivo e executar novamente você vai ter uma exceção falando que
        // esse arquivo já existe, mas tem uma opção dentro do copy para contornar isso
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
