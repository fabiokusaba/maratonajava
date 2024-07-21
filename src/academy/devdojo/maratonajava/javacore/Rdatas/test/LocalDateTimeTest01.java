package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// LocalDateTime é praticamente uma junção das duas classes LocalDate e LocalTime
public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        // Data e hora atual do Sistema Operacional
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // É uma classe bem flexível com vários métodos get sendo a junção das duas classes
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getHour());

        // Aqui estamos criando um LocalDate e um LocalTime e temos também um LocalDateTime, falando em LocalDate e
        // LocalTime é possível você pegar esses valores diretamente de uma String, por exemplo quando você viu parse
        // na DateFormat você viu que tínhamos uma exceção do tipo checked sendo lançada, mas por exemplo aqui se eu
        // quisesse trocar esse valor passado no of poderia utilizar o parse passando a sequência
        // O parse não lança exceção do tipo checked mais, mas se você passar um valor inválido ele ainda vai lançar uma
        // exceção a diferença é que a exceção não é mais do tipo checked
        LocalDate date = LocalDate.parse("2022-08-06");
        LocalTime time = LocalTime.parse("09:45:00");
        System.out.println(date);
        System.out.println(time);

        // Existe a possibilidade de você fazer uma junção entre essas classes
        LocalDateTime localDateTime1 = date.atTime(time);
        LocalDateTime localDateTime2 = time.atDate(date);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }
}
