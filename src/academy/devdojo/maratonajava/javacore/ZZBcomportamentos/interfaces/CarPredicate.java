package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.dominio.Car;

// Uma interface funcional é uma interface onde você tem apenas um método abstrato
@FunctionalInterface
public interface CarPredicate {
    // Esse método na interface funcional diz tudo o que a gente precisa saber sobre como aquela lambda ela vai se
    // comportar
    // A lambda tem o parâmetro e tem o corpo que pode ou não retornar alguma coisa
    // (parâmetro) -> <expressão>
    // Como nós temos aqui uma descrição de como a lambda deve se comportar toda a informação que nós precisamos está
    // aqui, então por exemplo, (Car car) -> car.getColor.equals("green"); isso aqui está retornando pra você um
    // booleano caso esse parâmetro seja da cor verde
    // As lambdas basicamente são anônimas, a gente chama as lambdas de funções porque elas não estão atreladas a
    // nenhuma classe, você tem a lambda sendo executada diretamente dentro de um método, mas ela tecnicamente não está
    // ligada a uma classe, então a forma mais correta de chamar ela é de função e o objetivo é fazer o código ser mais
    // conciso o fato da lambda reduzir a quantidade de código por si só já diz o quanto ela é concisa
    // O que precisamos lembrar dessa aula é que qualquer interface funcional nós podemos utilizar lambdas
    // Interface funcional é uma interface onde você tem apenas um método abstrato sem corpo, você pode ter outros
    // métodos mas eles obrigatoriamente precisam ter o default e o próprio método da sua interface funcional diz como
    // a lambda vai se comportar, então isso daqui é o contrato da sua lambda que diz que tem que retornar um boolean
    // e que você está recebendo como parâmetro um Car
    boolean test(Car car);
}
