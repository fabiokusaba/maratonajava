package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio;

public class Carro {
    private String nome;

    // Quando você cria um método como final você está falando que esse método nunca poderá ser sobrescrito
    // Então, quando você cria um método final em uma super classe você está querendo dizer que é esse o comportamento
    // que esse método precisa ter para todos
    // Em casos específicos aonde você não quer que esse método seja sobrecarregado, ou seja, que o comportamento dele
    // seja alterado da forma que deveria ser na subclasse você coloca o método como final
    public final void imprime() {
        System.out.println(this.nome);
    }

    // Existem valores que queremos associar as variáveis que não queremos que ele mude nunca, esses atributos são o que
    // chamamos de constantes que uma vez criados eles vão permanecer daquele jeito até você parar o código e alterar
    // esse valor novamente
    // No Java a constante é definida através da palavra final, se você tem uma constante você obrigatoriamente precisa
    // falar qual é o valor que você quer que essa variável tenha, ele não aceita valores de inicialização padrão
    // Constante não pode ter o valor alterado uma vez que esse valor foi associado e geralmente ele vai vir acompanhado
    // do static
    // O modificador final é uma palavra reservada que a gente pode aplicar tanto para variável quanto para as classes
    public static final double VELOCIDADE_LIMITE = 250;

    // Quando você faz isso significa que você está falando que a referência que essa variável COMPRADOR tem para esse
    // objeto nunca poderá ser alterada
    public final Comprador COMPRADOR = new Comprador();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
