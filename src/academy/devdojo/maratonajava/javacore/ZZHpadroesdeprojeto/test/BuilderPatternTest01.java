package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;

// O problema é o seguinte a gente cria uma nova Pessoa passa o firstName, não sei qual é o próximo então preciso
// apertar CTRL+P para saber que o próximo é o lastName, depois username e por fim email, qual o problema que nós temos
// aqui? O intelliJ está sendo camarada e está dando aqui uma dica do que cada um desses argumentos significa, nem todos
// usam intelliJ, nem todos tem essa facilidade de ver essas coisas aqui até porque isso aqui é um negócio que você pode
// remover
// O problema de você ter um construtor com muitos argumentos é que você não sabe depois o que cada um dos argumentos
// significa e o padrão de projeto builder veio justamente para resolver esse problema que basicamente é uma forma que
// você tem de organizar a criação desse objeto de uma forma que qualquer um consiga entender consiga ver de forma fácil
public class BuilderPatternTest01 {
    public static void main(String[] args) {
        // Perceba que agora o new Person está dando problema porque o nosso construtor é privado e como eu faço agora
        // para montar esse cara?
        // new Person("William", "Suane", "viradonojiraya", "william.suane@devdojo.academy");

        // Simples, eu chamo Person.PersonBuilder
        // Temos um problema a gente tem um PersonBuilder e PersonBuilder não é um Person, então geralmente nesses
        // métodos que você vê nos builders você vai ver um método no final chamado build
        // Aí agora todas as vezes que você quiser o objeto Person no finalzinho como todos estão retornando this é só
        // você chamar o build, então você pode chamar o build em qualquer lugar
        Person person = new Person.PersonBuilder()
                .firstName("William")
                .lastName("Suane")
                .username("ViradoNoJiraya")
                .email("william.suane@devdojo.academy")
                .build();

        System.out.println(person);
    }
}
