package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        // Lembre-se esse é um caminho relativo porque quando você não coloca a primeira / inicial você está falando que
        // antes disso quem quer que seja, nesse caso o sistema operacional, o seu programa Java tem que considerar
        // como se o caminho anterior fosse a localização aonde esse cara se encontra
        // Se eu colocar /home o que estou falando é que ele tem que ir do root da raiz do sistema operacional, no caso
        // seria o caminho absoluto
        // Perceba que ambos são caminhos relativos dir e arquivo, o primeiro (dir) o Java vai encontrar, mas o segundo
        // (arquivo) dev não existe no root do nosso projeto, então precisamos resolver esse Path
        Path dir = Paths.get("home/william");
        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);

        // As coisas não são tão simples assim, precisamos tomar cuidado porque o resolve vai juntar os Paths, mas
        // quando começamos a misturar caminho absoluto com caminho relativo
        // Quando você tenta fazer uma resolução com um arquivo Paths que já é absoluto ele simplesmente retorna o
        // absoluto
        // No segundo caso ele funcionou ele adicionou o file.txt para o caminho relativo, mas no terceiro ele não
        // funcionou porque quando você usa absoluto ele não tem o que resolver, o caminho absoluto é o caminho
        // absoluto, mas se você começar do absoluto e tentar resolver o relativo aí sim ele vai adicionar, mas o
        // contrário não pode, você não pode adicionar de um relativo para um absoluto
        Path absoluto = Paths.get("/home/william");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");
        System.out.println("1 " + absoluto.resolve(relativo));
        System.out.println("2 " + absoluto.resolve(file));
        System.out.println("3 " + relativo.resolve(absoluto));
        System.out.println("4 " + relativo.resolve(file));
        System.out.println("5 " + file.resolve(absoluto));
        System.out.println("6 " + file.resolve(relativo));
    }
}
