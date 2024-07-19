package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais01 {
    public static void main(String[] args) {
        // Estruturas condicionais -> tudo na vida é um if, quando você vai atravessar a rua se não vier carro você
        // atravessa, se tiver dinheiro você vai comprar comida, se tiver dinheiro você vai comprar um Playstation 5
        // Obrigatoriamente o resultado que você vai colocar na condicional precisa ser um booleano
        // O if somente será executado se a condição que estiver dentro dele for verdadeira
        // O else sempre será executado caso o if não seja executado e um else só existe ao lado de um if
        int idade = 20;
        boolean isAutorizadoComprarBebida = idade >= 18;
        if (isAutorizadoComprarBebida) {
            System.out.println("Autorizado a comprar bebida alcóolica");
        } else {
            System.out.println("Não autorizado a comprar bebida");
        }

        // Operador de negação ! (NOT)
        if (!isAutorizadoComprarBebida) {
            System.out.println("Não autorizado a comprar bebida");
        }
        System.out.println("Fora do if");
    }
}
