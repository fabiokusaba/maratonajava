package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais03 {
    public static void main(String[] args) {
        // Operador ternário -> é dividido em três partes, a primeira parte é a condição, a segunda parte é caso a
        // condição seja verdadeira e a terceira parte caso a condição seja falsa
        // Sintaxe -> (condição) ? verdadeiro : falso
        // No operador ternário nós sempre estamos associando um valor
        // Condição -> doar se salário for maior que 5000
        double salario = 6000;
        String mensagemDoar = "Eu vou doar 500 pro DevDojo";
        String mensagemNaoDoar = "Ainda não tenho condições, mas vou ter!";
        String resultado = salario > 5000 ? mensagemDoar : mensagemNaoDoar;

        System.out.println(resultado);
    }
}
