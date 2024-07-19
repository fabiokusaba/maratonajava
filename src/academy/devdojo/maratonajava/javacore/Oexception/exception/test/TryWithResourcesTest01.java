package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.Leitor1;
import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo();
    }
    public static void lerArquivo() {
        // try with resources ou try com recursos
        // Ele está se encarregando de tomar conta de fechar a conexão dessa variável de referência e para isso
        // precisamos seguir uma regra, você só pode colocar objetos, variáveis de referência dentro do try with
        // resources que implementem a interface Closeable ou AutoCloseable temos essa regra porque lembra do
        // polimorfismo nós temos certeza absoluta de que o Java vai conseguir chamar o close porque o Reader ele
        // implementa a Closeable e a Closeable tem apenas um método que é a close, então o Java vai se encarregar de
        // fazer essa chamada
        // Quando você está trabalhando com o try with resources você pode remover o catch, mas você é obrigado a
        // utilizar o throws e a exceção que está sendo lançada
        // Então, é possível com try with resources você criar sem o finally ou o catch
        // Como você pode ver eu posso declarar quantas variáveis eu quiser, a diferença é que eu preciso que essas
        // variáveis implementem a interface Closeable ou AutoCloseable
        try(Leitor1 leitor1 = new Leitor1(); Leitor2 leitor2 = new Leitor2()) {

        } catch (IOException e) {

        }
    }

    public static void lerArquivo2() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
