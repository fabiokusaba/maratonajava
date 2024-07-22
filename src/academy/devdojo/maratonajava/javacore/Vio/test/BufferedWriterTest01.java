package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Lembre-se a FileWriter e a FileReader são classes bem low level, são classes que elas não foram criadas com
// pensamento de performance em mente, então quando você está trabalhando com arquivos muito grandes é melhor você
// utilizar pra escrita a BufferedWriter e pra leitura BufferedReader
public class BufferedWriterTest01 {
    public static void main(String[] args) {
        // Encadeamento -> nós temos a File e temos a FileWriter, a FileWriter recebe um arquivo File dentro do
        // construtor e a BufferedWriter recebe uma FileWriter dentro do construtor
        // O que fizemos aqui foi que temos um File que está fazendo uma referência ao nosso arquivo, dessa referência
        // desse arquivo nós estamos passando para um FileWriter que é responsável pela escrito do conteúdo no arquivo
        // mas ele não é otimizado, o BufferedWriter sim é otimizado, então a gente está encapsulando a FileWriter
        // dentro do BufferedWriter que vai utilizar um buffer, ou seja, os dados vão ser guardados dentro de um buffer
        // é mais rápido do que você escrever diretamente no disco
        // Então, quando você está trabalhando com a BufferedWriter a estrutura é praticamente a mesma da FileWriter a
        // performance por de baixo dos panos é que vai ser melhor, mas tem mais uma coisa que o \n não é uma boa ideia
        // porque ele é dependente do sistema operacional e nem todos os sistemas operacionais entendem o \n como uma
        // quebra de linha e a BufferedWriter que é uma classe mais nova sabe disso, então você tem aqui o newLine
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("O DevDojo é lindo, é o melhor curso do brasilllll");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
