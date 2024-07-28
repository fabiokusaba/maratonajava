package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        List<Car> greenCarsLambda = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCarsLambda = filter(cars, car -> car.getColor().equals("red"));
        List<Car> yearBeforeCarsLambda = filter(cars, car -> car.getYear() < 2015);

        System.out.println(greenCarsLambda);
        System.out.println(redCarsLambda);
        System.out.println(yearBeforeCarsLambda);

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filter(nums, num -> num % 2 == 0));
    }

    // Método genérico para filtrar qualquer coisa
    // O que precisamos lembrar dessa aula é que o Predicate nada mais é do que uma interface você precisa passar uma
    // classe concreta que dá o comportamento do test como estamos passando lambda, lambda nada mais é do que uma
    // sintaxe mais enxuta para aquelas classes anônimas que vimos em aulas anteriores
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                filteredList.add(e);
            }
        }
        return filteredList;
    }
}
