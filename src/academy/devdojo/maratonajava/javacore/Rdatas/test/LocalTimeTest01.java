package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

// Como LocalDate trabalha com datas LocalTime trabalha com horas
public class LocalTimeTest01 {
    public static void main(String[] args) {
        // Os desenvolvedores do Java manteram um padrão que basicamente é a mesma coisa do LocalDate
        // Criando uma hora a partir de uma hora específica, aqui precisamos tomar bastante cuidado a hora só vai até
        // 23 horas, então se você colocar 24 teremos uma exceção falando que o valor é inválido, as horas válidas são
        // de 0 até 23
        LocalTime time = LocalTime.of(23, 32, 12);
        System.out.println(time);

        // Pegando a hora atual
        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        // Alguns métodos interessantes que temos na LocalTime parecidos com a LocalDate
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        // Utilizando algo mais específico com TemporalField
        System.out.println(time.get(ChronoField.HOUR_OF_DAY));

        // Se você precisar pegar a hora meia noite você pode utilizar
        System.out.println(LocalTime.MIN);

        // E o máximo do dia
        System.out.println(LocalTime.MAX);
    }
}
