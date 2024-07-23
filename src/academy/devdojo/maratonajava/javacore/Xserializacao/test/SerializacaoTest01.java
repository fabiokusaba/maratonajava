package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Basicamente serialização é você pegar um objeto que você tem em memória e persistir ele, aonde você vai persistir
// depende daonde você coloca o seu destino
// Serialização é você pegar um objeto e através dos arrays de bytes você persistir ele em algum lugar
// Quando você está lendo um objeto serializado o Java não vai utilizar o construtor
// Na hora de deserializar não existe uma chamada para dentro do construtor, ou seja, o construtor ele não é executado
// no momento da deserialização, o que isso significa? Significa que se você estiver trabalhando com herança as coisas
// ficam um pouco mais complicadas, por exemplo se você tiver uma herança aqui lembre-se que na herança o objetivo do
// construtor é sempre chamar o super, então como ele vai chamar o super se o construtor não é executado
public class SerializacaoTest01 {
    public static void main(String[] args) {
        // Agora que nós temos o nosso objeto digamos que você queira salvar esse objeto em um arquivo e depois você ler
        Aluno aluno = new Aluno(1L, "William Suane", "123412121");

        // Quando você tenta serializar algo que não é serializável você tem uma exceção
        // Nesses casos específicos aonde você não tem acesso ao código fonte e você não pode alterar você vai ter que
        // dar as instruções para o Java em como serializar e deserializar esse objeto
        Turma turma = new Turma("Maratona Java Virado no Jiraya em Breve Ricos");
        aluno.setTurma(turma);

        // Chamando o método para serializar
        serializar(aluno);

        // Chamando o método para deserializar
        deserializar();
    }

    // Método para salvar
    // Para serializar você precisa trabalhar com uma das classes do pacote io, pacote nio
    // Quando você está serializando você está transformando um objeto em um array de bytes, então você está trabalhando
    // em baixo nível, geralmente quando você trabalha em baixo nível você está trabalhando com uma das classes Stream
    private static void serializar(Aluno aluno) {
        // A primeira coisa que a gente vai precisar é um ObjectOutputStream como OutputStream é algo que muito
        // provavelmente vai pedir recursos do sistema operacional já vamos criar dentro de um try with resources
        Path path = Paths.get("pasta/aluno.ser"); // Aonde eu quero salvar
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            // Quando você está serializando um objeto você precisa falar para o Java que aquele objeto ele é
            // serializável e para falar que um objeto é serializável a única coisa que você precisa fazer é falar que
            // esse objeto é serializável, ou seja, que ele implementa Serializable
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserializando um objeto
    // Quando você está deserializando você não precisa de uma variável de referência, o objeto já se encontra no
    // arquivo e você não está trabalhando com Output porque você quer ler, então ObjectInputStream
    private static void deserializar() {
        Path path = Paths.get("pasta/aluno.ser");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            // Para ler o arquivo é basicamente utilizar o método readObject, esse método retorna um objeto porque ele
            // não sabe o que está lendo, como eu mesmo que estou lendo sei que esse cara é um Aluno então posso fazer
            // um casting
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
