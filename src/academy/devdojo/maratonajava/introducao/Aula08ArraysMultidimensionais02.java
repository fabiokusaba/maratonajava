package academy.devdojo.maratonajava.introducao;

public class Aula08ArraysMultidimensionais02 {
    public static void main(String[] args) {
        // A variável de referência o padrão de inicialização é nulo e como um array é sempre uma variável de referência
        // assim como objeto quando tentamos executar temos um NullPointerException porque não existe nada
        int[] array = {1, 2};
        int[][] arrayInt = new int[3][];

        arrayInt[0] = array;
        arrayInt[1] = new int[]{1, 2, 3};
        arrayInt[2] = new int[]{1, 2, 3, 4, 5, 6};

        int[][] arrayInt2 = {{0, 0}, {1, 2, 3}, {1, 2, 3, 4, 5, 6}};

        for (int[] arrBase : arrayInt2) {
            System.out.println("\n-------");
            for (int num : arrBase) {
                System.out.print(num + " ");
            }
        }
    }
}
