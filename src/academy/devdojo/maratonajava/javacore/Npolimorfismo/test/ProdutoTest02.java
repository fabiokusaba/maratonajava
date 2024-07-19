package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class ProdutoTest02 {
    public static void main(String[] args) {
        // Aqui temos uma variável de referência do tipo Produto e o objeto do tipo Computador
        Produto produto = new Computador("Ryzen 9", 3000);

        // Quando falamos produto.getNome quem está executando não é a variável de referência produto, quem está
        // executando é o objeto Computador, na verdade estamos pegando o nome do Computador que é o objeto em si
        // Quem executa é sempre o objeto
        System.out.println(produto.getNome());
        System.out.println(produto.getValor());
        System.out.println(produto.calcularImposto());
        System.out.println("-----------------------");

        // Aqui estamos falando que um tipo mais específico está fazendo referência para um tipo mais genérico ou o tipo
        // mais genérico está fazendo referência para o tipo mais específico
        Produto produto2 = new Tomate("Americano", 20);
        System.out.println(produto2.getNome());
        System.out.println(produto2.getValor());
        System.out.println(produto2.calcularImposto());
    }
}
