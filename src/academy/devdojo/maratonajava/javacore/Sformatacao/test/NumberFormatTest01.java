package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// A classe NumberFormat da mesma forma que nós temos a DateFormat é uma classe abstrata, ou seja, você não pode
// utilizar new, você não pode instânciar, você pega um objeto do NumberFormat através do getInstance ou
// getNumberInstance
public class NumberFormatTest01 {
    public static void main(String[] args) {
        Locale localeBR = new Locale("pt","BR");
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(localeJP);
        nfa[2] = NumberFormat.getInstance(localeBR);
        nfa[3] = NumberFormat.getInstance(localeIT);
        double valor = 1_000.2130;
        for (NumberFormat numberFormat : nfa) {
            // Verificando qual é a configuração máxima de digitos fracionados
            //System.out.println(numberFormat.getMaximumFractionDigits());

            // Você pode setar valores diferentes através do
            numberFormat.setMaximumFractionDigits(2);
            System.out.println(numberFormat.format(valor));
        }

        // Outra configuração interessante que podemos fazer é o parse onde podemos pegar um valor numérico e
        // transformar em uma String ou pegar uma String com esse mesmo valor e transformar em um valor numérico
        // Perceba que esse método lança uma exceção do tipo checked, ou seja, nós temos que usar o bloco try-catch ou
        // adicionar na assinatura do método
        // Você vai ver que o retorno foi 1 porque se você ver dentro do parse ele fala que faz o parse do texto from
        // the beginning, ou seja, talvez ele não vá utilizar o texto inteiro, então se você tem um caracter que é
        // inválido no começo, por exemplo _, ele vai ignorar o resto e vai parar de fazer o parse
        String valorString = "1000,2130";
        try {
            System.out.println(nfa[0].parse(valorString));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
