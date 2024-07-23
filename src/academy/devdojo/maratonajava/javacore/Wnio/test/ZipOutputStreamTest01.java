package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Como o nome já diz, quando você vê output significa que você está mandando para um lugar, quando você tem input
// significa que você está lendo
public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");
        zip(arquivoZip, arquivosParaZipar);
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar) {
        // ZipOutputStream como o nome já diz é um output stream e geralmente um output stream eles tem implementação
        // do Closeable significa que nós precisamos fechar o recurso, então vamos criar um try with resources
        // Nós precisamos passar um OutputStream para isso nós temos dentro da classe Files um método newOutputStream
        // que basicamente pega um Path e vai transformar em OutputStream
        // Precisamos agora navegar para dentro da subsubpasta1 e pegar cada um dos arquivos, para isso podemos utilizar
        // a DirectoryStream passando o Path aonde estão os nossos arquivos que queremos zipar
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
            // Precisamos pegar os arquivos e jogar para dentro do nosso zip, para isso vamos pegar arquivo por arquivo
            for (Path file : directoryStream) {
                // Zipar é um processo que ele acontece em etapas você primeiro prepara falando olha eu vou criar uma
                // entrada, em seguida você pega essa entrada e você coloca no zip e depois que você copia
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipStream.putNextEntry(zipEntry);
                Files.copy(file, zipStream);
                zipStream.closeEntry();
            }
            System.out.println("Arquivo criado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
