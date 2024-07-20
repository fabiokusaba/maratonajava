package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

// A classe Locale é uma classe que foi criado para trabalhar com internacionalização, utilizada para formatação tanto
// de datas quanto moedas e números baseado na preferência do usuário ou na localização da JVM dele
// Ela está dentro do pacote java.util, é uma classe que podemos criar, não é uma classe abstrata e ela tem a
// possibilidade de trabalhar com diversos tipos de formatação
public class LocalTest01 {
    public static void main(String[] args) {
        // Ela segue o padrão de duas ISOS, um para definir a língua que você está falando, por exemplo o português é
        // representado pelo pt e o país Brasil é representado por BR, pt-BR
        Locale localeItaly = new Locale("it", "IT");
        Locale localeSuica = new Locale("it", "CH");
        Locale localeIndia = new Locale("hi", "IN");
        Locale localeJapao = new Locale("ja", "JP");
        Locale localeHolanda = new Locale("nl", "NL");

        // Podemos atribuir para diversos tipos de classes como estamos trabalhando com datas vamos utilizar a
        // DateFormat
        Calendar calendar = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeSuica);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeJapao);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localeHolanda);
        System.out.println("Italia " + df1.format(calendar.getTime()));
        System.out.println("Suíça " + df2.format(calendar.getTime()));
        System.out.println("Índia " + df3.format(calendar.getTime()));
        System.out.println("Japão " + df4.format(calendar.getTime()));
        System.out.println("Holanda " + df5.format(calendar.getTime()));

        // Alguns labels são traduzidos de acordo com o que temos no Sistema Operacional por padrão, então quando nosso
        // Sistema Operacional está em português ele vai estar exibindo em português
        System.out.println(localeItaly.getDisplayCountry());

        // Mas, por exemplo se passarmos um local ele vai traduzir para este local que passarmos
        System.out.println(localeSuica.getDisplayCountry(localeJapao));

        // Você pode usar também o language para saber como é falado em um local determinado
        System.out.println(localeItaly.getDisplayLanguage(localeJapao));
    }
}
