package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays03 {
    public static void main(String[] args) {
        // Declarando e inicializando arrays diretamente com os valores
        int[] numeros = new int[3];
        int[] numeros2 = {1, 2, 3, 4, 5};
        int[] numeros3 = new int[]{5,4,3,2,1};

        // Formas de você imprimir um array
        for (int i = 0; i < numeros3.length; i++) {
            System.out.println(numeros3[i]);
        }

        // Esse for, denominado de foreach, não te dá o índice específico, ou seja, não tem como você acessar o índice
        // caso você precise acessar o índice é mais aconselhável você utilizar o for indexado
        // A variável de referência declarada vai fazer referência para cada uma das posições, por isso o tipo dessa
        // variável deve ser o mesmo tipo do array
        for (int num : numeros2) {
            System.out.println(num);
        }
    }
}
