package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Classe responsável pelas formatações no Java, você precisa lembrar quando está trabalhando com formatação é que todas
// as vezes que você vê a palavra Format significa que você está transformando do seu objeto para uma String, todas as
// vezes que você vê a palavra parse você está transformando de uma String para o seu objeto
public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // Imagine agora que você tenha a String e que você quer transformar essa String em um objeto, quando você tem
        // essa String você precisa tomar cuidado e utilizar o mesmo padrão que você utilizou para formatar em String
        // ou caso você esteja pegando de uma API de terceiros ou banco de dados você precisa escolher um padrão que
        // vai dar um match, vai bater exatamente com o que você tem
        LocalDate parse1 = LocalDate.parse("20240720", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse("2024-07-20", DateTimeFormatter.ISO_DATE);
        LocalDate parse3 = LocalDate.parse("2024-07-20", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse1);
        System.out.println(parse2);
        System.out.println(parse3);

        LocalDateTime now = LocalDateTime.now();
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s4);
        LocalDateTime parse4 = LocalDateTime.parse("2024-07-20T21:38:47.440082726", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(parse4);

        // Nem sempre vamos ter um padrão que atenda as nossas necessidades, por exemplo no Brasil é dd/MM/yyyy, nos EUA
        // é MM/dd/yyyy, no Japão yyyy/MM/dd e baseado nisso nós precisamos formatar uma data, para isso podemos fazer
        // o seguinte
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);
        LocalDate parseBR = LocalDate.parse("20/07/2024", formatterBR);
        System.out.println(parseBR);

        DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatGR = LocalDate.now().format(formatterGR);
        System.out.println(formatGR);
        LocalDate parseGR = LocalDate.parse("20.Juli.2024", formatterGR);
        System.out.println(parseGR);
    }
}
