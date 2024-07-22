package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("pasta");

        // Existe um método dentro de File chamado mkdir que vai criar um diretório
        // Se você executar novamente da mesma forma como os arquivos ele não vai criar, mas vai fazer uma referência
        // para o objeto que tem a pasta
        boolean isDiretorioCriado = fileDiretorio.mkdir();
        System.out.println("Pasta criada? " + isDiretorioCriado);

        // Para criar um arquivo dentro desse diretório você tem duas opções: a primeira é você copiar o caminho
        // absoluto desse diretório e falar que você quer colocar um arquivo.txt lá dentro
        //File fileArquivoDiretorio = new File("/home/fabiokusaba/Documentos/Projetos/maratonajava/pasta/arquivo.txt");

        // Uma outra forma é que nós já temos uma referência para o diretório que é o objeto fileDiretorio, então
        // podemos criar da seguinte forma
        // Dessa forma, ao invés de você pegar o caminho absoluto você está pegando um File que já tem a referência para
        // a localização daquela pasta e passando aqui como argumento no construtor do File
        File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");

        // E vou chamar agora o createNewFile, você sabe que você pode utilizar o try-catch, mas também podemos
        // adicionar na assinatura do método
        boolean isArquivoCriado = fileArquivoDiretorio.createNewFile();
        System.out.println("arquivo.txt criado? " + isArquivoCriado);

        // Estou criando um novo objeto, esse objeto vai ser o meu objeto destino
        // Se eu quiser manter esse arquivo dentro do mesmo diretório preciso estar passando para qual diretório esse
        // arquivo que eu quero renomear vai
        File arquivoRenomeado = new File(fileDiretorio, "arquivo_renomeado.txt");

        // Estou falando para renomear esse meu fileArquivoDiretorio, ou seja, o arquivo.txt dentro do fileDiretorio
        // para esse arquivo_renomeado.txt
        boolean isRenomeado = fileArquivoDiretorio.renameTo(arquivoRenomeado);
        System.out.println("arquivo.txt renomeado para arquivo_renomeado.txt? " + isRenomeado);

        // Pra você renomear um diretório é praticamente a mesma coisa
        File diretorioRenomeado = new File("pasta2");
        boolean isDiretorioRenomeado = fileDiretorio.renameTo(diretorioRenomeado);
        System.out.println("Diretório pasta renomeado? " + isDiretorioRenomeado);
    }
}
