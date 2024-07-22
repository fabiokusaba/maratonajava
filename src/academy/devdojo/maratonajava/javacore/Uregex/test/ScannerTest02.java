package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        String texto = "Levi,Eren,Mikasa,true,200";

        // Por padrão a classe Scanner já recebe várias opções no construtor
        Scanner scanner = new Scanner(texto);

        // Ela possui um delimitador padrão que é o espaço em branco, como nós queremos utilizar um outro delimitador
        // nós precisamos utilizar aqui useDelimiter e passamos aqui o valor que queremos como delimitador
        scanner.useDelimiter(",");

        // Para pegar os valores da scanner é um pouco diferente da String porque é como se ele tivesse dois ponteiros
        // na scanner o primeiro ponteiro vai verificar se existe um próximo valor para então se caso existir um segundo
        // ponteiro vai realmente pegar aquele valor, ou seja, um vai verificar e o outro vai andar
        // Para isso nós temos que utilizar o while, ou seja, enquanto existir um próximo eu quero que você pegue o next
        //while (scanner.hasNext()) {
            //System.out.println(scanner.next());
        //}

        // Porém, imagine que você quer pegar esses valores de acordo com o tipo dele, então você pode utilizar aqui
        while (scanner.hasNext()) {
            // Verificando se tem um inteiro
            if (scanner.hasNextInt()) {
                // Pegando o valor inteiro lido
                int i = scanner.nextInt();

                // Imprimindo o valor lido
                System.out.println("Int " + i);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("Boolean " + b);
            } else {
                System.out.println(scanner.next());
            }
        }
    }
}
