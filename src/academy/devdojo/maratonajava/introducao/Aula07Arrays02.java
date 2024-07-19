package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays02 {
    public static void main(String[] args) {
        // Valores padrões -> todas as vezes que você declarar uma variável do tipo primitiva array ou uma variável de
        // classe, os tipos primitivos tem os seus valores padrões que não são aplicados quando você está dentro de um
        // escopo local, ou seja, dentro de um método se você criar só uma variável tipo "int idade" ela não tem uma
        // inicialização padrão, então para arrays ou para quando você declara uma variável fora do método elas tem um
        // padrão de inicialização
        // byte, short, int, long, float e double -> 0
        // char -> '\u0000' -> ' '
        // boolean -> false
        // String -> todos os tipos reference vão ter, por exemplo String ou qualquer outro, o padrão é -> null

//        String[] valoresPadrao = new String[3];
//        System.out.println(valoresPadrao[0]);
//        System.out.println(valoresPadrao[1]);
//        System.out.println(valoresPadrao[2]);

        // Iterando sobre arrays
        // O tamanho do array não pode aumentar dinamicamente, então toda vez que a gente quiser alterar o tamanho do
        // array nós precisamos compilar o programa novamente, você não pode simplesmente alterar o tamanho de um array
        // em tempo de execução
        // Quando você está trabalhando com tipo reference significa que você tem algumas coisas a mais, por exemplo a
        // nossa variável nomes, quando a acessamos, por ser do tipo array basicamente ela tem uma propriedade que diz
        // o seu tamanho chamada de length
        String[] nomes = new String[4];
        nomes[0] = "Goku";
        nomes[1] = "Kurosaki";
        nomes[2] = "Luffy";
        nomes[3] = "Hinata";

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }
    }
}
