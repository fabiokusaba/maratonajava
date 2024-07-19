package academy.devdojo.maratonajava.javacore.Lclassesabstratas.dominio;

// Classes abstratas -> foram criadas para resolver um problema de design
// Imagine que você tem uma empresa e na sua empresa tem funcionários e eles sempre vão ter um cargo, você tem
// desenvolvedor, gerente, supervisor e assim por diante
// O funcionário em si no caso da nossa empresa é algo abstrato, é como se fosse o template, ele em si não existe, o que
// existe é uma das implementações do funcionário que são os cargos das pessoas
// Quando você coloca uma classe com abstract você está falando que essa classe agora é como se fosse um template, ou
// seja, você não pode mais criar algo concreto
// Como você pode ver uma classe abstrata foi criada basicamente para ser extendida, é uma classe que foi criada para
// ser uma super classe e como ela foi criada para ser uma super classe você não pode misturar final com abstract
// porque abstract significa dizer que você criou uma classe que tem que ser extendida e final está falando que não pode
// ser extendida
public abstract class Funcionario extends Pessoa {
    protected String nome;
    protected double salario;

    // Aqui temos um construtor porque estamos trabalhando com herança e a herança funciona da mesma forma para classe
    // concreta ou abstrata, então se você precisa de um nome e salario para criar um Funcionario você vai precisar de
    // um nome e salario para criar um Gerente e é por isso que nós temos o nosso construtor
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        calcularBonus();
    }

    // Imagine um cenário onde nós temos que calcular um bônus, todos os funcionários eles tem que ter um cálculo de
    // bônus
    // Nesse ponto onde você precisa obrigar todas as subclasses a prover a implementação de um método é que o método
    // abstrato passa a ser útil
    public abstract void calcularBonus();

    // Como Funcionario que é uma classe abstrata implementou o método imprime todas as outras classes filhas de
    // Funcionario vão consequentemente pegar essa implementação
    @Override
    public void imprime() {
        System.out.println("Imprimindo...");
    }

    // Em uma classe abstrata você pode ter ambos, métodos abstratos e métodos não abstratos, porém você nunca vai poder
    // ter um método abstrato em uma classe concreta porque métodos abstratos só podem existir dentro de classes
    // abstratas, mas classes abstratas podem ter métodos tanto concretos quanto abstratos, isso é útil em pontos onde
    // você, por exemplo digamos que você queira fazer uma funcionalidade para deletar um funcionário, a funcionalidade
    // que você fizer não depende do tipo do funcionário se é gerente, desenvolvedor ou qualquer um outro, nesse caso
    // faria sentido você ter um método concreto dentro da classe Funcionario e se caso alguma subclasse específica
    // precise trocar a funcionalidade era só sobrescrever, mas o resto usaria a opção concreta implementada dentro
    // da classe Funcionario
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }
}
