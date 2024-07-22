package academy.devdojo.maratonajava.javacore.Uregex.test;

// Tokens e delimitadores tem um pouco a ver com expressões regulares, mas não necessariamente é uma expressão regular
// quando falamos de tokens não é tokens relacionados a parte de criptografia, token delimitador é tipo assim digamos
// que você tenha essa String aqui "luffy@hotmail.com, 123jotaro@gmail.com" os tokens seriam os emails e os
// delimitadores são as vírgulas, então o token é o resultado que você tem da utilização dos delimitadores
public class ScannerTest01 {
    public static void main(String[] args) {
        // Imagine que você tem true e 200, ao invés de você pegar esses valores como String você quer pegar esses
        // valores como booleano e inteiro, para isso nós temos uma outra classe que é chamada de Scanner
        String texto = "Levi, Eren, Mikasa, true, 200";

        // Para pegarmos esses valores podemos utilizar o split passando como delimitador a vírgula
        String[] nomes = texto.split(",");

        // Iterando sobre o nosso array de nomes
        for (String nome : nomes) {
            // Utilizamos o trim para remover o espaço
            System.out.println(nome.trim());
        }

    }
}
