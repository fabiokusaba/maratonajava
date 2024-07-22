package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

// A BasicFileAttributes é uma interface que foi introduzida a partir do Java 1.7 e ela foi criada para dar
// possibilidade de você utilizar polimorfismo baseado no sistema operacional
public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        // BasicFileAttributes -> interface mais geral
        // DosFileAttributes -> que basicamente é uma implementação da BasicFileAttributes, mas como se sabe DOS é mais
        // voltado para o Windows e uma coisa interessante é que todos esses atributos que nós temos aqui, esses métodos
        // eles são apenas para leitura
        // PosixFileAttributes -> para sistemas operacionais do tipo Unix
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("pasta2/novo.txt");
        boolean isCreated = file.createNewFile();

        // Para modificar nós temos o setLastModified e esse método pede um long
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        // Podemos fazer o mesmo, mas agora utilizando o pacote NIO
        Path path = Paths.get("pasta2/novo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTime);

        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isExecutable(path));
    }
}
