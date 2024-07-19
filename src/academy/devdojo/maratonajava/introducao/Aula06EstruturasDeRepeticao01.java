package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao01 {
    public static void main(String[] args) {
        // Laços de repetição -> while, do while, for
        // while -> o que você coloca aqui dentro precisa obrigatoriamente resultar em um valor booleano
        // Quando você estiver usando um while você precisa trocar o estado da variável dentro do seu corpo
        // do while -> a diferença com o while é que aqui ele vai executar pelo menos uma vez independente da condição
        // for -> é dividido em três partes: a primeira parte é a variável que vai ser incrementada(índice), a segunda
        // parte você faz a comparação até onde você quer que esse laço de repetição seja executado e na última parte
        // como essa variável vai alterar o status
        int count = 0;
        while (count < 10) {
            System.out.println(++count);
//            System.out.println(count);
//            count = count + 1;
//            count += 1;
            count++;
        }

        do {
            System.out.println("dentro do do-while " + count);
        } while (count < 10);

        for (int i = 0; i < 10; i++) {
            System.out.println("For " + i);
        }
    }
}
