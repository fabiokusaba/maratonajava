package academy.devdojo.maratonajava.javacore.Oexception.error.test;

// Exceções são condições anormais do seu programa, existem diversos tipos de exceções algumas estão dentro do seu
// controle e outras estão fora do seu controle, então por exemplo se a gente cria um atributo e esse atributo não pode
// receber um número negativo digamos uma data a gente não pode colocar uma data de aniversário negativa, não podemos
// fazer divisão por zero são fluxos aonde a gente tem como esperar e tem como fazer um tratamento caso isso realmente
// aconteça, ou seja, está dentro do nosso controle
// Mas, existem outros que estão fora do nosso controle, por exemplo imagine que você está tentando ler um arquivo e
// esse arquivo não tem permissão para leitura ou imagina que você está lendo um arquivo hoje e em algum momento alguém
// trocou a permissão ou trocou o arquivo de lugar e ele não existe mais, outro exemplo seria conexão com o banco de
// dados você espera que a conexão funcione mas a internet pode cair ou o banco de dados pode estar fora do ar, então
// são condições que estão além do seu controle
// O Java oferece pra gente uma quantidade imensa de classes e formas pra você trabalhar com esses fluxos anormais que
// vão com certeza acontecer no seu sistema
// Como você sabe as exceções no Java como tudo é um Objeto, então todas as exceções no Java são da classe Throwable
// e nós temos aqui dois tipos: Error e Exception
// Erros são situações aonde não tem como você se recuperar, por exemplo imagine que o seu sistema está rodando e
// simplesmente acaba a memória, você vai ter então um OutOfMemoryError, se você tem um erro de memória o que você pode
// fazer que a JVM não tentou? Então, erros quando você tem no seu programa geralmente eles são impossíveis de você se
// recuperar em tempo de execução você precisa parar o programa resolver o problema e em seguida você inicia novamente
// então quando você tem um erro geralmente a JVM para de executar
// Um outro erro é o stack overflow que é quando você estoura a memória da stack de chamadas do método
// O que você precisa lembrar é que Error é algo que acontece na JVM que provavelmente você não vai poder recuperar em
// tempo de execução
public class StackOverflowTest01 {
    public static void main(String[] args) {
        recursividade();
    }

    public static void recursividade() {
        recursividade();
    }
}
