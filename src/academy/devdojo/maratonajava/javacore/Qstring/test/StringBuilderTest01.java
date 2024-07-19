package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        // Nós vimos que temos as Strings e elas são imutáveis
        String nome = "William Suane";
        nome.concat(" DevDojo");

        // Perceba que aqui não houve alteração porque nós não alteramos a String nós criamos uma outra String em
        // memória pegando somente da posição zero até a posição dois
        nome.substring(0, 3);
        System.out.println(nome);

        // A primeira coisa que você precisa aprender da StringBuilder é que você não tem mais aquele conceito de
        // String imutável quando você trabalha com esse objeto StringBuilder porque StringBuilder não é uma String
        // A StringBuilder como já vimos é uma classe que vai no final das contas trabalhar com as Strings e a
        // principal diferença é que a importabilidade dela não é até o momento em que você transforma numa String não
        // existe
        // Por padrão a capacidade da StringBuilder é de 16 e as Strings e StringBuilder como eles não são a mesma coisa
        // você não pode falar que essa StringBuilder vai receber uma String, isso não existe porque são objetos
        // completamente diferentes
        // Na StringBuilder você adiciona através do método append que é um método sobrecarregado, você pode passar
        // qualquer tipo que ele vai transformar em uma String e ele retorna não uma String, mas um StringBuilder
        // Você tem o método toString dentro do StringBuilder que vai transformar esse valor que você tem dentro do
        // StringBuilder em uma String
        // Uma das razões que a performance da StringBuilder é bem maior do que da String é justamente por essa
        // capacidade que a StringBuilder oferece pra fazer a mudança da String sem precisar ficar alocando um novo
        // espaço lá no pool de Strings
        StringBuilder sb = new StringBuilder("William Suane");
        sb.append(" DevDojo").append(" Academy");

        // Aqui você precisa tomar um pouco de cuidado, para você saber se a StringBuilder está manipulando a String
        // dentro do objeto você tem que saber qual é o tipo de retorno que ela está te oferecendo, então quando você
        // vê o append o tipo de retorno que ele tem é um StringBuilder, mas o substring ele retorna uma String então
        // se ele retorna uma String ele não está alterando o valor que você tem dentro da StringBuilder, então aqui
        // você teria que criar uma String para receber essa substring
        String substring = sb.substring(0, 3);

        // Mas, nós temos outros métodos que retornam um StringBuilder, por exemplo o reverse que vai reverter a ordem
        // da String
        sb.reverse();
        sb.reverse();

        // Você pode usar também o delete que deleta os caracteres, da mesma forma começando da posição zero e a última
        // posição é exclusiva, ou seja, é o final menos um, e nos dá como retorno um StringBuilder
        sb.delete(0, 3);
        System.out.println(sb);
    }
}
