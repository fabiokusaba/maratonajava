package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

// A classe Duration é uma classe que foi criada para você trabalhar com a quantidade de tempo, ela geralmente é
// utilizada quando você quer pegar um intervalo entre duas datas, você quer saber quantas horas, quantos minutos,
// quantos segundos, quantos dias, quantos anos passaram e ela é baseada em segundos e nanossegundos, ou seja, se você
// tem uma classe que não oferece suporte a segundo e nanossegundo como LocalDate você não pode trabalhar com a Duration
// tem uma outra classe que trabalha com isso que é a Period focada em datas
public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinusSevenHours = LocalTime.now().minusHours(7);

        Duration duration1 = Duration.between(now, nowAfterTwoYears);
        Duration duration2 = Duration.between(timeNow, timeMinusSevenHours);
        Duration duration3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        Duration duration4 = Duration.ofDays(20);
        Duration duration5 = Duration.ofMinutes(3);
        Duration duration6 = Duration.of(3, ChronoUnit.HOURS);
        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
        System.out.println(duration4);
        System.out.println(duration5);
        System.out.println(duration6);
    }
}
