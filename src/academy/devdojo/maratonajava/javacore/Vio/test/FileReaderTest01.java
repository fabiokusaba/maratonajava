package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// A FileReader assim como a FileWriter nós precisamos trabalhar com um File
public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        // Você já sabe que ler e escrever de um arquivo requer o sistema operacional liberar recursos para o nosso
        // sistema e se ele libera recursos para o nosso sistema nós precisamos fechar e para fechar podemos utilizar o
        // try com recursos que vai se encarregar de fechar normalmente
        try (FileReader fr = new FileReader(file)) {
            // Array de caracteres que representa a entrada de dados
            //char[] in = new char[1000];

            // O read vai chamar esse array e colocar o valor que ele ler dentro dele
            // O read ele retorna a quantidade de caracteres lidos para dentro desse array e quando você não usa o
            // array aqui ele vai retornar o valor decimal daquele caracter
            //int size = fr.read(in);
            //System.out.println(size);

            // Você pode fazer um foreach para fazer a leitura dos caracteres, é como se fosse um buffer em memória, mas
            // como você pode ver ele não está pegando o arquivo inteiro
            //for (char c : in) {
                //System.out.print(c);
            //}

            // Sabemos que o read retorna -1 indicando que ele chegou ao fim, para isso criamos uma variável auxiliar i
            // porque queremos iterar sobre esse arquivo
            int i;

            // O nosso i vai receber o read, ou seja, todas as vezes que ele ler ele vai retornar um valor, o final do
            // arquivo ele é -1, então vamos fazer a leitura enquanto o i for diferente de -1
            while ((i = fr.read()) != -1) {
                // Podemos imprimir diretamente o i, mas o que queremos é o caracter, então para isso precisamos fazer
                // um cast para o char e você tem exatamente o conteúdo do arquivo no console
                System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
