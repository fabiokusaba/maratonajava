package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.text.DateFormat;
import java.util.Calendar;

// A classe DateFormat basicamente oferece pra você alguns métodos pré definidos para formatação
// O DateFormat é uma classe do pacote java.text e ela é uma classe abstrata, ou seja, você não pode usar o new, porém
// como vamos estar trabalhando com arrays podemos utilizar new DateFormat e tem basicamente seis tipos que podemos
// utilizar
public class DateFormatTest01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] df = new DateFormat[7];

        // Formas que você tem de automaticamente formatar baseado na configuração que o DateFormat te propõe
        // lembrando que é baseado na localização do seu computador
        df[0] = DateFormat.getInstance();
        df[1] = DateFormat.getDateInstance();
        df[2] = DateFormat.getDateTimeInstance();
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df[5] = DateFormat.getDateInstance(DateFormat.LONG);
        df[6] = DateFormat.getDateInstance(DateFormat.FULL);

        for (DateFormat dateFormat : df) {
            System.out.println(dateFormat.format(calendar.getTime()));
        }
    }
}
