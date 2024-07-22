package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        // Para pegarmos um Path a gente utiliza Paths.get, se você for dentro da Paths você vai ver que ela foi
        // introduzida no Java 1.7 e se você for em Files você vai ver que é uma classe final é como se fosse uma
        // classe utilitária porque os métodos que nós temos nela são praticamente todos estáticos, uma classe
        // utilitária que foi criada para você trabalhar com arquivos
        // A Path como é uma interface a sua implementação vai ser baseada no sistema operacional que você está
        // trabalhando
        // Formas de você pegar o Path:
        Path p1 = Paths.get("/home/fabiokusaba/Documentos/Projetos/maratonajava/file.txt");
        Path p2 = Paths.get("/home/fabiokusaba/Documentos/Projetos/maratonajava", "file.txt");
        Path p3 = Paths.get("/home", "/fabiokusaba/Documentos/Projetos/maratonajava", "file.txt");
        Path p4 = Paths.get("/home", "/fabiokusaba/", "Documentos/", "Projetos/", "maratonajava", "file.txt");
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());
    }
}
