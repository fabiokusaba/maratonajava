package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// Trabalhando com a formatação de moedas
// Ela segue o mesmo formato da formatação de números até porque valores monetários são representados por valores
// numéricos
public class NumberFormatTest02 {
    public static void main(String[] args) {
        Locale localeBR = new Locale("pt","BR");
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getCurrencyInstance();
        nfa[1] = NumberFormat.getCurrencyInstance(localeJP);
        nfa[2] = NumberFormat.getCurrencyInstance(localeBR);
        nfa[3] = NumberFormat.getCurrencyInstance(localeIT);
        double valor = 1000.2130;
        for (NumberFormat numberFormat : nfa) {
            // Verificando qual é a configuração máxima de digitos fracionados
            System.out.println(numberFormat.getMaximumFractionDigits());
            System.out.println(numberFormat.format(valor));
        }

        // Quando estamos trabalhando com valores monetários para fazermos o parse precisamos passar conforme a moeda
        // que estamos trabalhando, caso contrário vamos receber um erro de Unparseable number
        String valorString = "￥1,000";
        try {
            System.out.println(nfa[1].parse(valorString));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}