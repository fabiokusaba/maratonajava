package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    public static void main(String[] args) {
        // Operadores no Java são elementos que vão fazer com que você possa fazer operações, por exemplo nós temos os
        // famosos operadores aritméticos
        // Operadores aritméticos são operadores que você consegue realizar contas matemáticas com os números
        // Operadores matemáticos básicos -> + - / *
        // O resultado da operação de dois números inteiros é sempre um número inteiro
        int numero1 = 10;
        int numero2 = 20;
        int resultado = numero1 + numero2;
        System.out.println(resultado);

        // O operador de resto é o sinal de %, como você sabe o operador de resto da divisão pode ser usado para você
        // identificar se um número é par ou ímpar
        int resto = 20 % 2;
        System.out.println(resto);

        // Operadores lógicos sempre vão retornar um valor booleano
        // < > <= >= == !=
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualVinte = 10 == 20;
        boolean isDezIgualDez = 10 == 10;
        boolean isDezDiferenteDez = 10 != 10;
        System.out.println("isDezMaiorQueVinte " + isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte " + isDezMenorQueVinte);
        System.out.println("isDezIgualVinte " + isDezIgualVinte);
        System.out.println("isDezIgualDez " + isDezIgualDez);
        System.out.println("isDezDiferenteDez " + isDezDiferenteDez);

        // Operador lógico && (AND) || (OR) ! (NOT)
        int idade = 35;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;
        System.out.println("isDentroDaLeiMaiorQueTrinta " + isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta " + isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPlaystation = 5000F;
        boolean isPlaystationCincoCompravel = valorTotalContaCorrente > valorPlaystation || valorTotalContaPoupanca > valorPlaystation;
        System.out.println("isPlaystationCincoCompravel " + isPlaystationCincoCompravel);

        // Operadores de atribuição vão atribuir a sua variável
        // = += -= *= /= %=
        double bonus = 1800; // 1800
//        bonus = bonus + 1000;
        bonus += 1000; // 2800
        bonus -= 1000; // 1800
        bonus *= 2; // 3600
        bonus /= 2; // 1800
        bonus %= 2; // 0
        System.out.println(bonus);

        // Operadores unários
        // ++ --
        int contador = 0;
        contador += 1; // contador = contador + 1
        contador++;
        contador--;
        ++contador;
        --contador;
        System.out.println(contador);

        // A diferença entre você adicionar antes ou depois vai depender do momento em que você quer que ele seja
        // executado, quando você coloca depois você está falando que é para primeiro fazer o que for preciso com
        // a variável, no caso do contador2 primeiro exiba o valor em tela e depois você incrementa +1, agora você
        // colocando antes ele primeiro vai incrementar e depois executar
        int contador2 = 0;
        System.out.println(++contador2); // 1
        System.out.println(contador2++); // 1
        System.out.println(contador2); // 2
    }
}
