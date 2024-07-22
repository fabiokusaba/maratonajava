package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

// Nós vimos na última aula Resolve que basicamente vai resolver e colocar dois caras juntos, o Relativize dados dois
// Paths, digamos que você tenha o path1 e o path2 como você faz pra chegar no path2 a partir do path1, basicamente é
// assim que funciona
public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/william");
        Path classe = Paths.get("/home/william/devdojofoda/OlaMundo.java");
        Path pathToClasse = dir.relativize(classe);
        System.out.println(pathToClasse);

        Path absoluto1 = Paths.get("/home/william");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/william/devdojofoda/OlaMundo.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/temp.2021921");

        System.out.println("1 " + absoluto1.relativize(absoluto3));
        System.out.println("2 " + absoluto3.relativize(absoluto1));
        System.out.println("3 " + absoluto1.relativize(absoluto2));
        System.out.println("4 " + relativo1.relativize(relativo2));

        // Um problema que você tem que tomar cuidado é quando você trabalha com relativo e absoluto, o Java não faz
        // ideia naonde esse temp está localizado, como você coloca relativo o Java não consegue encontrar, nesse caso
        // o Java vai lançar uma exceção porque ele não sabe como chegar nesse temp porque ele é um caminho relativo
        // daonde esse programa está sendo executado
        System.out.println("5 " + absoluto1.relativize(relativo1));
    }
}
