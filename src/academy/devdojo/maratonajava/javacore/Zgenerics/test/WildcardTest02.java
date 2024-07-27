package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        // Vamos agora trabalhar com listas
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());

        // Esse erro de compilação ele existe justamente porque uma vez que o código é compilado o Java não sabe que
        // tipo de lista você está passando, lembrando que o nome desse termo é o Type erasure
        // Por causa do Type erasure o Java não sabe, por exemplo, depois que você compila que o que você está passando
        // é uma lista de Cachorros e uma lista de Cachorros pode ser referenciada por uma lista de Animais, o mesmo se
        // aplicaria a Gato
//        printConsulta(cachorros);
//        printConsulta(gatos);

        printConsulta(cachorros);
        printConsulta(gatos);

        List<Animal> animals = new ArrayList<>();
        printConsultaAnimal(animals);
//        printConsultaAnimal(cachorros);
    }

    // Mas, quando você está trabalhando com listas o tipo dessa lista aqui que você tenta passar através de parâmetros
    // ou o objeto você precisa passar exatamente o que foi definido nessa sintaxe e é por isso que nós temos o Wildcard

    // O Wildcard é bem simples, ele é o ? e eu quero aceitar dentro desse método qualquer tipo de lista que seja um
    // Animal
    // Quando você faz isso List<? extends Animal> animals você está assinando um contrato, o contrato diz que você não
    //vai poder adicionar elementos nessa lista porque imagine o seguinte você está passando aqui qualquer coisa que
    // seja um Animal, digamos que você passa um Animal você pode adicionar Cachorro, você pode adicionar Gato
    // Por causa do problema que você pode aceitar qualquer coisa que seja filho de Animal e você pode passar coleções
    // que são irmãs que nunca vão passar no teste de polimorfismo você não pode adicionar, ou seja, você perdeu a
    // possibilidade de adicionar elementos nessa lista, tudo o que você passar aqui vai ser somente para leitura
    // Segundo ponto importante é que independente se aqui é uma interface, uma classe abstrata a palavra vai ser
    // sempre extends
    private static void printConsulta(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }

        // Mas, você ainda consegue, por exemplo, adicionar dentro dessa lista de Animais objetos independentes, então
        // por exemplo, que sejam filho de Animal
        // É a mesma coisa que se você tivesse um Animal criando referência para um objeto do tipo Cachorro
        Animal a = new Cachorro();
//        animals.add(new Cachorro());
    }

    // Se eu quiser adicionar? A gente pode fazer da seguinte forma
    // Eu quero receber nessa lista qualquer tipo de objeto que seja um Animal ou um super de Animal
    // Qual a diferença? No primeiro caso estamos falando que podemos receber Animal ou qualquer um que seja filho e
    // agora estamos falando que podemos receber Animal ou qualquer um que seja pai
//    private static void printConsultaAnimal(List<? super Cachorro> animals) {
//        // Aqui precisamos subir na hierarquia até bater lá no topo e quem é o topo? Object
//        // Você não consegue utilizar nada a não ser que seja Object aqui
//        for (Object o : animals) {
//            // E como você faria para pegar um Cachorro ou um Animal? Teria que utilizar o instanceof
//            if (o instanceof Cachorro) {}
//        }
//    }

    // Então, estou falando que obrigatoriamente tudo o que eu passar aqui vai ter que ser um Animal ou um super de
    // Animal
    // Veja que aqui não posso mais passar cachorros e nem gatos porque elas são subclasses e eu só aceito superclasses
    // E com isso eu tenho algumas garantias, a garantia é que os objetos que eu vou passar dentro dessa lista sempre
    // vão ser do tipo Animal, então como você tem um tipo Animal você pode passar tudo o que passa no teste é um
    // Animal, você pode passar aqui um Cachorro, um Gato, como você pode fazer isso você também pode colocar dentro
    // dessa lista um Cachorro e um Gato e por que a gente pode colocar nesse aqui e noutro não pode?
    // Porque se eu passar uma lista de Cachorros eu não posso adicionar Gato, se eu passar uma lista de Gatos eu não
    // posso adicionar Cachorro, mas aqui eu posso adicionar qualquer uma das subclasses porque tenho garantia do
    // polimorfismo, eles passam no teste é um e como noutro eu não sei o que vai vir os filhos eu posso ter problema
    // com os irmãos e o Java não gosta de coisas que ele não tem garantia
    private static void printConsultaAnimal(List<? super Animal> animals) {
//        Animal animal = new Cachorro();
//        Animal animal2 = new Gato();
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}
