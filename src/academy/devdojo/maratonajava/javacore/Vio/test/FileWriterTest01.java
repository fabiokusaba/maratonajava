package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Para você escrever e ler de um arquivo você precisa utilizar das classes específicas, o Java principalmente nesse
// pacote io eles fizeram altamente coesos, significa que cada classe tem um propósito específico
// File -> trabalhar com arquivos em si
// FileWriter -> escrever em um arquivo, mas bem low level (baixo nível), não otimizada
// FileReader -> somente leitura
// BufferedWriter -> escrita num arquivo, mas de forma otimizada, com uma performance trabalhando com dados em memória
// BufferedReader -> leitura em memória, tem uma performance melhor do que a FileReader
public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        // Se você criar uma FileWriter você vai ver que ela tem um construtor sobrecarregado onde você pode passar
        // o nome do arquivo ou você pode passar um File, aqui precisamos tratar essa exceção
        // Quando você trbalha com leitura e escrita de arquivos você está pegando recursos do sistema operacional e
        // quase sempre quando você está trabalhando com recursos do sistema operacional você precisa fechar, então
        // por exemplo dentro do FileWriter temos o close, quando você abre você tem que fechar
        // Já trabalhamos com o try with resources (try com recursos) então podemos fazer com que ele se encarregue de
        // fechar, mas lembre-se que precisa ser Closeable
        // Quando executamos novamente ele substitui o antigo pelo novo, ele simplesmente pega todos os dados que tem
        // no arquivo deleta tudo e adiciona o novo conteúdo, caso você queira adicionar o conteúdo novamente você
        // precisa passar no construtor do FileWriter um booleano que você deve adicionar ao final do arquivo append
        try (FileWriter fw = new FileWriter(file, true)){
            fw.write("O DevDojo é lindo, é o melhor curso do brasilllll\nContinuando a cantoria na próxima linha\n");

            // Para escrever num arquivo usamos o write
            // Quando estamos escrevendo num arquivo precisamos nos preocupar com algo que não é tão claro, quando você
            // está escrevendo num arquivo você está pegando recursos do sistema operacional, mas imagine que esse
            // recurso é como se fosse um túnel se você abre um vídeo no YouTube aquela barrinha que está carregando que
            // nós chamamos de buffer é como se fosse um túnel aonde os dados estão sendo recebidos, então por exemplo
            // você abre um vídeo no YouTube você vai recebendo os dados dentro desse buffer e quando você aperta o play
            // o browser vai lendo os dados desse buffer, desse túnel e vai mostrando pra você
            // Quando você está trabalhando com arquivos é praticamente a mesma coisa, você está escrevendo mas o
            // sistema operacional ele meio que deu um buffer, então existe a chance de você fechar o arquivo e o
            // sistema operacional não ter mandado todos os dados desse túnel, desse buffer pro arquivo, então antes de
            // você fechar um arquivo você chama o flush que basicamente é cospe tudo o que você tem no seu buffer e aí
            // depois quando o método acabar o próprio Java vai chamar o close do FileWriter
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
