package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

// A primeira coisa que devemos falar quando estamos trabalhando com coleções é o equals
public class EqualsTest01 {
    public static void main(String[] args) {
        String nome = "William Suane";
        String nome2 = "William Suane";
        String nome3 = new String("William Suane");

        // O resultado aqui vai ser true porque ele está fazendo referência para o mesmo objeto em memória, no caso a
        // String está no pool de Strings e está utilizando a mesma referência
        System.out.println(nome == nome2);

        // Isso daqui vai retornar falso porque você tem William Suane dentro do pool de Strings, mas esse new String
        // está no heap, esse sinal de == não vai comparar o valor em si do objeto, mas sim a referência que aquela
        // variável está apontando
        System.out.println(nome == nome3);

        // Esse equals sim vai trabalhar no que foi definido porque ele é um método que vem lá da classe object, ou seja
        // todos os objetos tem o equals independente de você sobrescrever ou não
        // O equals da String vai comparar o valor, então se os dois valores são iguais ele retorna true
        // No Object o equals basicamente vai estar comparando se o objeto em memória é igual ao objeto sendo passado
        // como argumento
        System.out.println(nome.equals(nome3));

        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");

        // Quando comparamos esses dois valores temos como retorno falso, nesse nosso exemplo todos dois objetos
        // "iguais" com a diferença que nós temos duas variáveis de referência para cada objeto, quando utilizamos o
        // equals que vem do Object basicamente você está comparando this com o que está passando como argumento, por
        // exemplo quando você chama s1.equals(s2) você está perguntando dentro do equals esse valor que nós temos aqui
        // em memória s1 tem exatamente o mesmo valor que esse objeto aqui s2, a variável de referência s1 está fazendo
        // referência para o mesmo objeto que s2? Como eles estão fazendo referência para dois objetos distintos o
        // resultado é falso, para retornar true utilizando equals esse s2 tem que fazer referência para o mesmo valor
        // que s1 está fazendo e fazemos isso da seguinte forma s2 = s1
        System.out.println(s1.equals(s2));
    }
}
