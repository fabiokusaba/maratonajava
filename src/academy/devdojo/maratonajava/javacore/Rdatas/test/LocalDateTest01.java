package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest01 {
    public static void main(String[] args) {
        // Criando datas
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());

        // LocalDate trabalhamos apenas com a data em si, não tem a hora
        // Criando uma data específica utilizando of passando ano, mês e dia
        LocalDate date = LocalDate.of(2022, Month.JANUARY, 27);

        // Pegando a data de agora
        LocalDate agora = LocalDate.now();

        // LocalDate é uma classe imutável por isso você não pode criar instâncias utilizando new, significa que todas
        // as vezes que você fizer alguma alteração, por exemplo você está adicionando um número x de semanas, quando
        // fazemos isso não vemos nenhuma alteração por causa da imutabilidade o resultado é ignorado, então tudo o que
        // você faz nas classes LocalDate, LocalTime vai ser criado um novo objeto por isso você precisaria associar
        // novamente a uma variável de referência
        // Isso é muito interessante para quando você está trabalhando em sistemas onde você tem várias threads tentando
        // acessar o mesmo recurso e isso garante que você não vai ter nenhum problema de incompatibilidade e
        // inconsistência nos dados
        // No geral sempre trabalhe com a LocalDate
        agora = agora.plusWeeks(4);

        // Métodos utilitários que facilitam a sua vida quando você está trabalhando com datas
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.lengthOfMonth());

        // Verificando se o ano é bissexto
        System.out.println(date.isLeapYear());

        // Digamos que você não quer utilizar os métodos utilitários que a classe provê e gostaria de algo mais
        // específico, nesse caso você tem o get que pede um TemporalField que é uma interface do pacote java.time
        // e você tem algumas classes que você pode utilizar, por exemplo ChronoField
        System.out.println(date.get(ChronoField.YEAR_OF_ERA));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        // Uma das coisas interessantes que eles mudaram foi a formatação, a data agora está sendo impressa exatamente
        // como geralmente é salvo no banco de dados
        System.out.println(date);
        System.out.println(agora);

        // Uma outra mudança interessante é que nós tínhamos uma limitação na Calendar e na Date em que você só podia
        // pegar até 01 de janeiro de 1970, mas agora temos a possibilidade de uma data bem longa
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
    }
}
