package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.util.Locale;


public class LocaleTest02 {
    public static void main(String[] args) {
        // Se você quer saber como o seu Sistema Operacional está configurado existe um método na classe Locale que você
        // pode chamar getDefault
        System.out.println(Locale.getDefault());

        // Se você quer saber todas as ISOS que são suportadas tanto de língua quanto de país você tem algumas opções
        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();
        for (String isoLanguage : isoLanguages) {
            System.out.print(isoLanguage + " ");
        }
        System.out.println();
        for (String isoCountry : isoCountries) {
            System.out.print(isoCountry + " ");
        }
        System.out.println();
    }
}
