package academy.devdojo.maratonajava.javacore.Npolimorfismo.servico;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

// Lembra da nossa aula de atributos e métodos estáticos que fala que se você não estiver acessando nenhum atributo
// de classe você pode transformar os seus métodos em estáticos
// Em seguida criamos uma classe de serviço para conter a regra de negócio relacionado ao relatório do cálculo dos
// impostos
public class CalculadoraImposto {
    // Perceba que estamos repetindo o mesmo método e o que estamos chamando nesse método são coisas relacionadas ao
    // próprio Produto e como sabemos podemos usar uma variável de referência da super classe para receber um objeto da
    // subclasse, então podemos refatorar esse método
    // Como você pode ver o nosso método ficou mais genérico significa dizer que ele está desacoplado
    public static void calcularImposto(Produto produto) {
        System.out.println("Relatório de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Preço: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);

        // Essa variável de referência Tomate vai fazer referência para o mesmo objeto que o Produto está fazendo
        // Fazendo de forma direta você vai ter um erro de compilação porque você não pode fazer esse cast sem ter
        // certeza absoluta de que esse cast vai funcionar porque você esta fazendo um cast de Produto, para o Java
        // é um Produto, mas ele não sabe exatamente qual é o Produto, então quando você faz esse cast que é você pegar
        // do mais genérico para o mais específico o que está acontecendo é que você pode estar passando aqui um objeto
        // que não seja um Tomate, um objeto que seja um Computador e não tem como você fazer referência de um
        // Computador para um Tomate, então aqui precisamos utilizar o cast explícito
        // Precisamos verificar se a instância da variável de referência é um Tomate e o Java tem um modificador para
        // isso, uma palavra reservada que vai fazer essa verificação pra gente
        // Aqui estou dizendo que se produto for uma instância de Tomate execute o seguinte trecho de código
        // Tome cuidado quando você for fazer o cast, verifique sempre que o tipo da variável que vocês estão fazendo
        // o cast é uma instância daquilo que vocês estão esperando para fazer o cast
        if (produto instanceof Tomate) {
            Tomate tomate = (Tomate) produto;
            System.out.println(tomate.getDataValidade());
        }
    }

    public static void calcularImpostoComputador(Computador computador) {
        System.out.println("Relatório de imposto do computador");
        double imposto = computador.calcularImposto();
        System.out.println("Computador " + computador.getNome());
        System.out.println("Valor " + computador.getValor());
        System.out.println("Imposto a ser pago " + imposto);
    }

    public static void calcularImpostoTomate(Tomate tomate) {
        System.out.println("Relatório de imposto do tomate");
        double imposto = tomate.calcularImposto();
        System.out.println("Computador " + tomate.getNome());
        System.out.println("Valor " + tomate.getValor());
        System.out.println("Imposto a ser pago " + imposto);
    }
}
