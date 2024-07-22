package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta2/new.txt");

        // Quando essa classe Files executar esse método readAttributes o objeto que tem que ser retornado é um objeto
        // que passa no teste é um BasicFileAttributes
        // Não importa o que ele vai retornar porque vou trabalhar orientado a interface, então o BasicFileAttributes é
        // uma interface e a gente vai executar os métodos através da interface, o objeto em si pra gente não importa o
        // Java vai tomar conta disso
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        // Esses caras sempre retornam o horário no time zone UTC
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println("creationTime " + creationTime);
        System.out.println("lastModifiedTime " + lastModifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);
        System.out.println("--------------------------------");

        // Basicamente as classes que vão alterar ou podem te dar a possibilidade de alterar alguns atributos elas
        // terminam com View no nome
        // BasicFileAttributesView, DosFileAttributesView, PosixFileAttributesView
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newLastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
        fileAttributeView.setTimes(lastModifiedTime, newLastAccessTime, creationTime);

        creationTime = fileAttributeView.readAttributes().creationTime();
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();

        System.out.println("creationTime " + creationTime);
        System.out.println("lastModifiedTime " + lastModifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);
    }
}
