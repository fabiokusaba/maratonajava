package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Televisao;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.servico.CalculadoraImposto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 11000);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);
        Televisao tv = new Televisao("Samsung 50\" ", 5000);

        // Quando transformamos os nossos métodos em estáticos nós não precisamos mais criar um new CalculadoraImposto
        // nós podemos chamar CalculadoraImposto.calcularImpostoComputador ou CalculadoraImposto.calcularImpostoTomate
        CalculadoraImposto.calcularImpostoComputador(computador);
        System.out.println("--------------------------");
        CalculadoraImposto.calcularImpostoTomate(tomate);

        CalculadoraImposto.calcularImposto(computador);
        System.out.println("------------------------");
        CalculadoraImposto.calcularImposto(tomate);
        System.out.println("--------------------");
        CalculadoraImposto.calcularImposto(tv);
    }
}
