package academy.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando doguinho");
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando Gato");
    }
}

public class WildcardTest01 {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};

        // Como você pode ver esse código funciona normalmente porque o Java sabe, principalmente para os Arrays, em
        // tempo de execução qual é o tipo de objeto que você está trabalhando
        printConsulta(cachorros);
        printConsulta(gatos);

        // Aqui você está fazendo o uso do polimorfismo, é como se você tivesse fazendo assim Animal animal = new Gato()
        Animal[] animals = {new Cachorro(), new Gato()};
        printConsulta(animals);
    }

    // Vamos imaginar que nós temos um método aonde você vai receber todos os tipos de Animais, mas esse método se
    // comporta de forma diferente baseado se você está trabalhando com Arrays ou com Lists
    // Como você pode ver nós temos um método printConsulta que recebe um Array de Animais e nós estamos chamando aqui o
    // nosso for
    private static void printConsulta(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }

        // Como você pode ver o código não tem nenhum erro de compilação, o código compila normalmente mas se tentarmos
        // executar você tem um erro chamado ArrayStoreException porque o Java sabe que esse Array que você passou na
        // primeira iteração é um Array de Cachorro e você está tentando colocar um Gato num Array de Cachorro daí você
        // vai ter essa Exception, porém se fosse um Array mesmo de Animais você conseguiria colocar um Gato lá dentro
//        animals[1] = new Gato();
    }
}
