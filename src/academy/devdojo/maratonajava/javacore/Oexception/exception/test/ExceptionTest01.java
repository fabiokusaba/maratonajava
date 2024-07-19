package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
    public static void main(String[] args) {
        criarNovoArquivo();
    }

    // Existem os prós e contras de você fazer o tratamento de exceção com try-catch, o primeiro deles é que você está
    // fazendo um tratamento de exceção o seu código não vai parar de funcionar, mas um caso negativo é de que a
    // pessoa que está chamando o seu método, por exemplo o método public static void main ele não tecnicamente não tem
    // opção de fazer tratamento do jeito dele, por exemplo no nosso método criarNovoArquivo nós temos a criação do
    // arquivo, mas dentro da criação do arquivo nós estamos chamando o createNewFile do Java e se os desenvolvedores
    // da linguagem resolver fazer o tratamento da exceção dentro desse método não teríamos o que fazer se a gente
    // quisesse mudar algo
    private static void criarNovoArquivo() {
        File file = new File("arquivo/teste.txt");

        // Aqui estamos diante de uma exceção do tipo checked que não foi tratada e por isso dá esse erro de
        // compilação, você precisa oferecer um tratamento para a exceção ou o seu código não vai compilar
        // Para fazer esse tratamento no Java podemos utilizar o bloco try-catch, onde no try vamos tentar fazer algo
        // e no catch vamos capturar as exceções caso elas surgirem
        // Todas as vezes que você estiver trabalhando com alguma das subclasses de Exception que não é Runtime você
        // precisa obrigatoriamente de um código que existe a possibilidade de lançar
        // As boas práticas dizem que você tem que tentar capturar as exceções mais específicas porque você pode
        // oferecer um tratamento melhor
        // Evite deixar o bloco catch em branco porque você deixando esse bloco em branco você está simplesmente
        // ignorando completamente a exceção e não está avisando para ninguém que tem uma exceção acontecendo
        // Evite colocar lógica de negócio no catch, lógica de negócio não deve ser executada dentro do catch, o catch
        // simplesmente é pra você lidar com exceções
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado " + isCriado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
