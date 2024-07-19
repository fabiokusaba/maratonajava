package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

// Quando você está criando um método privado as chances é que você vai acabar utilizando um try-catch porque o método
// privado ninguém fora dessa classe vai poder chamar esse método, então não faz sentido você dar um throws
// Agora se você estiver criando esse método como público nesse momento você não faz ideia de quem pode chamar esse
// criarNovoArquivo, qualquer pessoa em qualquer parte do seu projeto pode chamar esse método, então nesse caso talvez
// seria interessante você manter o throws
public class ExceptionTest02 {
    public static void main(String[] args) throws IOException {
        // Quem é que está chamando esse criarNovoArquivo é obrigado a tratar a exceção colocando um try-catch ou
        // jogando a batata quente para outra pessoa
        // Nesse caso aqui a vantagem é que o método main pode estar fazendo o tratamento da exceção e assim ele decide
        // como vai trabalhar caso tenha uma exceção
        criarNovoArquivo();
    }

    // Uma outra opção é a gente não fazer o tratamento desse método criarNovoArquivo e lançamos a responsabilidade
    // para quem está chamando
    // Se você está lançando uma exceção do tipo checked você é obrigado a dizer para os outros métodos que estão
    // chamando que eles tem que tratar essa exceção
    private static void criarNovoArquivo() throws IOException {
        File file = new File("arquivo/teste.txt");
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado " + isCriado);
        } catch (IOException e) {
            e.printStackTrace();

            // Lançando uma exceção do tipo checked
            throw e;
        }
    }
}
