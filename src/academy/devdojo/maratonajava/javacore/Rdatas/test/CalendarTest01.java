package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Calendar;
import java.util.Date;

// Calendar foi a segunda classe que a equipe do Java criou com o propósito de solucionar alguns problemas que a classe
// Date não estava conseguindo dar conta, praticamente relacionados a internacionalização
// A classe Calendar também vem do pacote java.util e ela é uma classe abstrata, ou seja, você não pode utilizar new
// para instanciar ela
// É uma classe que possui várias implementações baseados no tipo do calendário
public class CalendarTest01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        if (c.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("Domingão é o primeiro dia da semana");
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        // Adicionando dias
        c.add(Calendar.DAY_OF_MONTH, 2);

        // O método add sempre vai virar o dia, ou o mês, ou até mesmo o ano
        c.add(Calendar.HOUR, 2);

        // Caso você não queira virar, você deseja adicionar, mas não quer virar, caso passe você volte a contar do
        // mesmo dia, para isso utilizamos o método roll
        c.roll(Calendar.HOUR, 12);
        Date date = c.getTime();
        System.out.println(date);
    }
}
