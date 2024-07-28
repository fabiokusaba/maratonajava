package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        // Temos o mesmo comportamento da aula anterior, mas qual a diferença? A diferença que nós temos uma interface
        // CarPredicate que define um método test que não tem um comportamento, qual é o comportamento? O comportamento
        // é da subclasse que nós criamos, a subclasse que nós criamos fala que o método test ele fala que vai ser a cor
        // do carro igual a verde
        List<Car> greenCars = filter(cars, new CarPredicate() {
            // Definindo qual vai ser o comportamento do test
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        // Sintaxe lambda
        List<Car> greenCarsLambda = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCarsLambda = filter(cars, car -> car.getColor().equals("red"));
        List<Car> yearBeforeCarsLambda = filter(cars, car -> car.getYear() < 2015);

        System.out.println(greenCars);
        System.out.println(greenCarsLambda);
        System.out.println(redCarsLambda);
        System.out.println(yearBeforeCarsLambda);
    }

    // Eu quero poder filtrar baseado no que estou passando
    // Por que filter? Porque agora a responsabilidade não vai ser mais do método aqui que nós definimos no if
    // A responsabilidade da regra de negócio vai ser enviada via CarPredicate através do polimorfismo
    // Através desse método nós definimos uma lógica que vai mudar de acordo com a chamada, ou seja, o comportamento
    // está vindo por parâmetro
    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            // O que vai ser o test? O test vai ser definido através de uma classe anônima
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
