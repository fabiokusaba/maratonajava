package academy.devdojo.maratonajava.javacore.Lclassesabstratas.dominio;

// A regra é se você tiver uma classe abstrata e uma outra classe abstrata extender ela, no caso Funcionario extendendo
// uma Pessoa que é abstrata você não é obrigado a implementar os métodos abstratos, mas a primeira classe concreta que
// extender a funcionalidade dessa classe Funcionario vai precisar obrigatoriamente prover a implementação do método
// imprime
// Essa é a regra se você tem uma classe abstrata extendendo de outra classe abstrata ela não é obrigada a implementar
// os métodos, mas caso você resolva implementar você só precisa implementar uma vez
// Lembre-se dessa regrinha você não pode ter múltipla herança de classes com Java, porém você pode ter uma hierarquia
// maior, você pode ter avô, tataravô e assim por diante, no nosso caso nós temos a classe Gerente que é um Funcionario
// que por sua vez é uma Pessoa que é um Object
public abstract class Pessoa {
    public abstract void imprime();
}
