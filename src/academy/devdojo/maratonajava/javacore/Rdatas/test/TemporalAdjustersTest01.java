package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

// Todos os métodos dessa classe são estáticos, ou seja, ela é uma classe utilitária que foi criada para você fazer
// ajustes no tempo
public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        //now = now.plusDays(20);

        // As vezes quando você adicionar dias você não quer que ele vire o mês, quando estamos diante desse tipo de
        // situação de querer pegar exatamente o dia que queremos independente do mês que você está, para isso nós
        // temos o método with, a diferença do with para o plus é que with vai meio que só dar um replace trocar
        // exatamente o valor que você está passando sem virar o resto dos campos
        //now = now.withDayOfMonth(20);

        // Você também pode estar utilizando esse método with passando um TemporalField
        //now = now.with(ChronoField.DAY_OF_MONTH, 20);

        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Imagine agora que queremos o dia que represente a próxima quinta-feira
        // Nós temos um método na TemporalAdjusters que ele pega o dia da semana, quando utilizamos o nextOrSame se
        // estivermos na quinta-feira ele vai retornar a mesma data
        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Mas, se trocarmos e eu falar que quero o próximo independente se hoje for quinta-feira ou não só utilizar o
        // next, nós vamos ter agora a próxima quinta-feira
        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Além, do nextOrSame e next nós temos também o previous para quando foi a última quinta-feira e o
        // previousOrSame mesmo funcionamento do nextOrSame
        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Temos outros métodos interessantes também como, por exemplo caso você queira saber o primeiro dia do mês
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Caso você queira saber o último dia do mês
        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Caso você queira saber o primeiro dia do próximo ano
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Caso você queira saber o primeiro dia do próximo mês
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
    }
}
