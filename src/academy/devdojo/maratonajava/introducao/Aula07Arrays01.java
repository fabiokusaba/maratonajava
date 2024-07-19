package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays01 {
    public static void main(String[] args) {
        // Arrays -> lembre-se arrays a variável que você usa para declarar é sempre um tipo reference
        // Somente tipos de referência podem ser inicializados com nulo porque eles estão falando que não fazem
        // referência para nenhum objeto em memória
        // No Java todas as vezes que você declara um array você obrigatoriamente precisa dizer quanto de espaço em
        // memória você está alocando
        // Todas as vezes que você cria um array você tem posições, então posição 0, 1, 2, lembre-se o índice sempre
        // começa de 0
        // Todas as vezes que você cria um array tem uns tipos de inicialização padrão na memória alocada pelo array
        // então todos os tipos primitivos vão inicializar com um valor, por exemplo 0 se for do tipo numérico, 0.0
        // se for do tipo numérico flutuante, se for String vai ser nulo
        // Se você tentar pegar uma posição que não existe nós vamos ter um erro em tempo de execução dizendo que o
        // índice está fora do limite, a mesma exceção irá acontecer caso você tente atribuir um valor para um índice
        // que não existe
        // Arrays são considerados objetos na memória, então essa nossa variável idades faz referência a um objeto que
        // é um array do tipo inteiro de 3 posições
        int[] idades = new int[3];
        idades[0] = 21;
        idades[1] = 15;
        idades[2] = 11;
        System.out.println(idades[0]);
        System.out.println(idades[1]);
        System.out.println(idades[2]);
    }
}
