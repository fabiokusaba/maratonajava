package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try (FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            // Da mesma forma que tínhamos no nosso FileReader ao invés de você ler caracter por caracter dentro de um
            // arquivo o BufferedReader ele vai ler a linha inteira
            // Em questões de performance é bem melhor você ler uma linha inteira do que caracter por caracter
            // O readLine, quando você está lendo linha por linha ele retorna nulo ao final do arquivo, então precisamos
            // verificar se o valor retornado não é nulo
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
