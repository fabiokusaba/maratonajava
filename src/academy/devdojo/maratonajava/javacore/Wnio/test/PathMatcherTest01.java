package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

// É uma classe que foi criada para facilitar um pouco a busca de Paths
// A PathMatcher trabalha com esse glob que é muito parecido com as expressões regulares, mas de forma simplificada
public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        matches(path1, "glob:*.bkp"); // Desconsidera os diretórios
        matches(path1, "glob:**/*.bkp"); // Considerando os diretórios, ignorando tudo a esquerda de .bkp
        matches(path1, "glob:**/*.{bkp,txt,java}"); // Considerando uma das seguintes extensões de arquivo
        matches(path2, "glob:**/*.{bkp,txt,java}");
        matches(path3, "glob:**/*.{bkp,txt,java}");
        matches(path1, "glob:**/*.???"); // Considerando arquivo com somente três letras na extensão
        matches(path2, "glob:**/*.???");
        matches(path3, "glob:**/*.???");
        matches(path3, "glob:**/file.????"); // Considerando arquivo com nome file e quatro letras na extensão
    }

    private static void matches(Path path, String glob) {
        // Como a gente consegue um objeto que é um PathMatcher? Como nós estamos trabalhando com Path e o Path é
        // baseado no sistema operacional que você está trabalhando nós pegamos através da classe FileSystems
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
