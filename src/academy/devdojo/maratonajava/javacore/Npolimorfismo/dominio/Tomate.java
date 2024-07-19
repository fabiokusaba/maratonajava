package academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio;

public class Tomate extends Produto {
    public static final double IMPOSTO_POR_CENTO = 0.06;

    // Esse atributo dataValidade não posso executar através de Produto, nunca vai ser disponível pra mim dataValidade
    // porque Produto não tem como saber, então a garantia que a herança me dá é de que todos os atributos que eu tenho
    // na minha super classe podem ser chamados na subclasse porque eu sei que eles vão ser herdados
    // Como dataValidade é algo específico de Tomate eu nunca vou conseguir acessar de Produto
    private String dataValidade;

    public Tomate(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        System.out.println("Calculando imposto do Tomate");
        return this.valor * IMPOSTO_POR_CENTO;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}
