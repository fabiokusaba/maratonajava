package academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio;

// No nosso caso não faz sentido ter um Produto em si, produto tem que ser uma das subclasses então podemos transformar
// esse cara em abstrato
// Independente do Produto que você tiver você vai ter que calcular o imposto sobre esse produto, então vamos falar que
// a classe abstrata Produto implementa a interface Taxavel
// Nós criamos uma classe abstrata Produto porque essa classe não deve existir, esse Produto em si não deve existir, nós
// não podemos instanciar porque precisa de uma regra aonde os produtos concretos que é Computador e Tomate ou qualquer
// outro que for criado é o que deve ter procedência
// Quando cheguei em Produto e falei que ele implementa Taxavel estou falando que o Produto agora é Taxavel, se o
// Produto é Taxavel ele precisa prover implementação para o método calcularImposto, como Produto é abstrato e o método
// calcularImposto é abstrato não há necessidade de prover implementação aqui dentro, então fica a critério da primeira
// classe concreta a prover implementação
public abstract class Produto implements Taxavel {
    protected String nome;
    protected double valor;

    // Todas as vezes que você criar um Produto você precisa passar um nome e valor, fazemos isso através do construtor
    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
