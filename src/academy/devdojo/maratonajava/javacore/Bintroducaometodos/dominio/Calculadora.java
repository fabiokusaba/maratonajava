package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

// Métodos -> comportamento das classes
// São muito parecidos com os atributos, porém a funcionalidade é muito diferente, você ainda precisa de modificar de
// acesso que vai ser sempre a sua primeira parte, a segunda parte é o retorno o método geralmente ou retorna alguma
// coisa pra você ou não retorna nada
// Não confunda retorno com saída, por exemplo imagine uma maçã e que eu peça para que você corte em dois pedaços, se
// você, como método, cortar essa maçã e devolver os dois pedaços significa que você, método, está retornando a maçã
// em dois pedaços, agora se eu falo corta a maçã e você fica com a maçã você cortou a maçã, o método foi executado,
// porém você não devolveu a maçã, você não retornou absolutamente nada
// Em seguida temos o nome do método seguindo as convenções do Java para nomenclatura
// Lembre-se os métodos assim como as variáveis/atributos ele é executado no objeto

public class Calculadora {
    // Método sem retorno -> void
    public void somaDoisNumeros() {
        System.out.println(10 + 10);
    }

    public void subtraiDoisNumeros() {
        System.out.println(21 - 2);
    }

    // Métodos sem retorno com parâmetros
    // Parâmetros -> nada mais é que variáveis locais, variáveis que vão estar vivas durante o contexto desse método
    // Essas variáveis seguem os mesmos padrões que você tem para variáveis quando você declara nas classes
    // Sintaxe -> identificador que pode ser qualquer um dos tipos primitivos, qualquer um das variáveis dos tipos de
    // referência até mesmo arrays, e o identificador a mesma regra que o identificador não pode ser uma palavra
    // reservada, as convenções de código funcionam da mesma forma aqui(camelCase)
    // Para receber mais de um parâmetro basta separá-los por vírgula
    public void multiplicaDoisNumeros(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    // Métodos com retorno
    // Obrigatoriamente você precisa dar um retorno para isso usamos a palavra reservada return
    public double divideDoisNumeros(double num1, double num2) {
        if (num2 == 0) {
            return 0;
        }
        return num1 / num2;
    }

    public double divideDoisNumeros02(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        }
        return 0;
    }

    public void imprimeDivisaoDeDoisNumeros(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero");

            // Retorna para quem chamou o método
            return;
        }
        System.out.println(num1 / num2);
    }

    // Parâmetros tipo primitivo
    // Nesse nosso método nós temos duas variáveis de escopo local, ou seja, elas são válidas dentro do escopo desse
    // método
    public void alteraDoisNumeros(int num1, int num2) {
        num1 = 99;
        num2 = 33;
        System.out.println("Dentro do alteraDoisNumeros");
        System.out.println("Num1 " + num1);
        System.out.println("Num2 " + num2);
    }

    // Somando um array de números inteiros
    public void somaArray(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }

    // Varargs
    // Se você tiver mais de um atributo o varargs precisa ser o último
    public void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }
}
