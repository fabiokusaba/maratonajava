package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

// Herança -> você utiliza herança quando você quer extender a funcionalidade de uma classe e manter um relacionamento
// entre elas, na herança você está acoplando fortemente o seu código
// Geralmente você utiliza a herança em dois casos: quando você quer extender funcionalidades de uma classe ou quando
// você quer utilizar o polimorfismo
// Herança múltipla não existe no Java, você não pode extender mais de uma classe
public class Funcionario extends Pessoa {
    private double salario;

    static {
        System.out.println("Dentro do bloco de inicialização estático de funcionário");
    }

    {
        System.out.println("Dentro do bloco de inicialização de funcionário 1");
    }

    {
        System.out.println("Dentro do bloco de inicialização de funcionário 2");
    }

    // A regra da herança com construtores é: se você tem um construtor na super classe e não existe nenhum outro
    // construtor na subclasse que automaticamente pode chamar esse cara você precisa criar um construtor que vá atender
    // os requisitos para criar o objeto da super classe
    public Funcionario(String nome) {
        super(nome);
        System.out.println("Dentro do construtor de funcionário");
    }

    // Sobrescrita -> é você escrever o método com a mesma assinatura da super classe e mudar o seu comportamento
    // Todas as vezes que você usa a palavra super você está se referindo ao objeto mais genérico, a super classe
    // que essa nossa classe extende
    public void imprime() {
        super.imprime();
        System.out.println(this.salario);
    }

    public void relatorioPagamento() {
        System.out.println("Eu " + this.nome + " recebi um salário de " + this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
