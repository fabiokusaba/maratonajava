package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest01 {
    public static void main(String[] args) {
        // Checked e Unchecked
        // Exceções do tipo checked, ou seja, exceções que são checadas são exceções que são filhas da classe
        // Exception diretamente, se não forem tratadas elas vão lançar um erro em tempo de compilação, ou seja,
        // você nem consegue compilar o seu código, por exemplo quando você está trabalhando com arquivos e você
        // fizer alguma coisa provavelmente eles vão lançar esse IOException, possíveis exceções de entrada e
        // saída, se você não fizer uma tratativa o seu código não vai compilar
        // E nós temos as exceções que são unchecked, ou seja, exceções não checadas, que são exceções que são filhas
        // ou incluindo a classe RuntimeException, são exceções que quando lançadas pelo programa quase 100% das vezes
        // o problema é você que desenvolveu algo que está errado ou não fez uma tratativa que deveria ter feito, por
        // exemplo você tentar formatar um número e o número é um caractere literal você vai ter NumberFormatException
        // O que você precisa lembrar em relação as RuntimeExceptions é que elas são do tipo unchecked você não precisa
        // fazer um tratamento, não é obrigatório tratar elas, e quando você tem as checked exceptions obrigatoriamente
        // você precisa fazer um tratamento, se você não fizer um tratamento o código não compila

        //RuntimeException
        Object object = null;
        System.out.println(object.toString());

        int[] nums = {1, 2};
        System.out.println(nums[2]);
    }
}
