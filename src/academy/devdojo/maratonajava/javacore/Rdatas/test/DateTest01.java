package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

// Date é uma classe que está desde os primórdios do Java
// A primeira coisa que você precisa saber é que o Date trabalha em milisegundos, então o valor que ele tem dentro é
// um long representando os milisegundos desde 01/01/1970
public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        // Adicionando mais uma hora na data de hoje
        date.setTime(date.getTime() + 3_600_000);

        // Long que representa a data de hoje
        System.out.println(date.getTime());

        System.out.println(date);
    }
}
