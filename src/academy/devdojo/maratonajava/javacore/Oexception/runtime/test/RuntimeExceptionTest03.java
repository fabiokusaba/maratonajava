package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        // Em alguns casos quando você está trabalhando com recursos externos, por exemplo leitura de um arquivo ou
        // você está trabalhando com um banco de dados em situações como essas você está fazendo requisição ao
        // sistema operacional para um outro tipo de sistema para que você possa acessar esse recurso, se você está
        // abrindo um arquivo você está pedindo ao sistema operacional um processo pra você abrir aquele arquivo, se
        // você está conectando no banco de dados você está pedindo ao sistema gerenciador de banco de dados pra te dar
        // uma conexão e toda vez que você faz uma requisição para esse tipo de recurso você tem que fechar
        // Existem momentos que você precisa gerenciar esses recursos, ou seja, depois que você utilizar eles
        // corretamente você precisa fechá-los, muitos deles que você abre e fecha você precisa trabalhar com exceções
        // O finally é um bloco de código que sempre será executado independente se você executou normalmente,
        // independente se você tem uma exceção, independente se você está retornando alguma coisa
        // O bloco finally é extremamente utilizado quando você precisa trabalhar com recursos sendo liberados por
        // outras aplicações que precisam ser fechadas após o seu uso
        abreConexao();
    }

    private static String abreConexao() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            return "conexão aberta";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fechando recurso liberado pelo Sistema Operacional");
        }
        return null;
    }

    // A sintaxe do Java permite a utilização do try-finally
    // Durante a criação do try você nunca pode criar um try sozinho ou você cria um try-catch ou try-finally
    private static void abreConexao2() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
        } finally {
            System.out.println("Fechando recurso liberado pelo Sistema Operacional");
        }
    }
}
