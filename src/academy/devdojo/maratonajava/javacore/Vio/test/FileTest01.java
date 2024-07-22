package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

// A classe mais básica que temos para arquivos
public class FileTest01 {
    public static void main(String[] args) {
        // Quando você está criando um objeto do tipo File você precisar passar o argumento que está pedindo que é um
        // pathname, você tem duas opções: se você quer criar aonde esse programa está sendo executado você só passa o
        // nome, por exemplo file.txt, mas se você quiser salvar ele em um lugar específico você precisa passar o
        // caminho absoluto, por exemplo /home/fabiokusaba/Documentos/Projetos/maratonajava/arquivo/file.txt
        // Se você executar essa classe você vai ver que nenhum arquivo foi criado porque você só está criando um objeto
        // da File
        File file = new File("file.txt");

        // Você precisa para criar o arquivo chamar o método createNewFile, você sabe que esse cara lança uma exceção do
        // tipo checked, então você tem duas opções: ou usar o bloco try-catch ou adicionar a exceção na assinatura do
        // método
        // Por padrão, esse createNewFile retorna um booleano
        // Se você executar novamente esse file.txt não vai ser sobrescrito, ele não vai criar novamente
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created " + isCreated);

            // Outra coisa interessante que podemos fazer com o uso da File é pegar o path e o path é bem interessante
            // porque tem dois tipos de path: o pathname que você pega chamando getPath, porém se você quer saber o
            // caminho absoluto você tem o getAbsolutePath
            System.out.println("path " + file.getPath());
            System.out.println("path absolute " + file.getAbsolutePath());

            // Outro é saber se ele é um diretório ou se ele é um arquivo
            System.out.println("is directory " + file.isDirectory());
            System.out.println("is file " + file.isFile());

            // Você pode verificar se esse arquivo é oculto
            System.out.println("is hidden " + file.isHidden());

            // Existem outros que você pode verificar se você pode ler, escrever e assim por diante

            // Podemos verificar a última vez que ele foi modificado, como você pode ver ele retorna um long
            // em milissegundos desde 1970, porém já sabemos trabalhar com datas e podemos utilizar um new Date
            System.out.println("last modified " + new Date(file.lastModified()));

            // Antes de você deletar um arquivo é uma boa prática você verificar se ele existe, para isso temos um
            // método chamado exists
            boolean exists = file.exists();
            if (exists) {
                // Se o arquivo existir você pode chamar o método para deletar, você tem duas opções: introduzir em uma
                // variável local ou você coloca ele dentro de um sout também
                System.out.println("Deleted " + file.delete());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
