package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// A SimpleDateFormat oferece um pouco mais de flexibilidade do que a classe DateFormat
// Tudo que está relacionado a formatação está no pacote java.text
// O objetivo dessa classe é trabalhar com a formatação de datas de forma mais flexível utilizando os padrões que são
// definidos nas letras
public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        // Se você reparar o at está com aspas simples para que dessa forma o SimpleDateFormat ignore na hora de fazer
        // a conversão, assim tudo que quisermos que seja ignorado pelo SimpleDateFormat colocamos entre aspas simples
        String pattern = "yyyy.MM.dd G 'at' HH:mm:ss z";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.format(new Date()));

        // Quando você for fazer o parse é preciso prestar muita atenção porque ele segue a mesma regra, quando você
        // vai fazer o parse de uma String você tem que fazer o parse da String baseado no padrão que você passou
        // Ele também lança uma exceção do tipo checked, ou seja, você coloca entre try-catch, mas quando ele faz o
        // parse ele retorna um Date
        try {
            System.out.println(sdf.parse("2024.07.20 d.C. at 17:54:53 BRT"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
