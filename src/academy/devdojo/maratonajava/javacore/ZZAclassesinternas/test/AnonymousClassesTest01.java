package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// Classes anônimas são classes que vão existir brevemente por um determinado período de tempo no código e que não
// pode ser reutilizada em nenhum outro lugar

// Vamos criar uma classe chamada Animal
class Animal {
    // Digamos que você tem o método walk
    public void walk() {
        // Esse animal anda, então
        System.out.println("Animal walking");
    }
}

// Agora imagine o seguinte que você queira trocar o comportamento do método walk, digamos que você queira um
// outro comportamente que não seja o padrão do método, a forma como você faria isso seria você criar uma
// subclasse de Animal, então por exemplo, você poderia ter uma classe Dog, beleza você já sabe como funciona o
// polimorfismo
class Dog extends Animal {
    @Override
    public void walk() {
        System.out.println("Dog walking");
    }
}

// Mas, digamos que você queira fazer a troca desse método walk, a troca do comportamento desse método, mas só por um
// determinado momento do código, você não precisa criar uma outra classe, poluir o código, sendo que você não vai
// utilizar mais, é para casos como esses que as classes anônimas servem
public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        // Imagina o seguinte nós temos um Animal e queremos agora trocar o comportamento do Animal mas só aqui nesse
        // trecho de código, como a gente faz isso? Aí a gente faz através da criação de uma classe anônima adicionando
        // as chaves, nesse exato momento você tem uma classe anônima, parece que você está criando um objeto do tipo
        // Animal, mas você está criando uma subclasse de Animal porque se eu apertar CTRL+O eu tenho acesso ao walk
        Animal animal = new Animal(){
            @Override
            public void walk() {
                System.out.println("Walking in the shadows");

                // Você poderia chamar dentro do método walk porque você tem acesso a ele, mas fora não tem como porque
                // essa variável de referência é do tipo Animal e a minha subclasse é anônima não contém um tipo
                // específico eu só sei que ela é uma filha de Animal
                jump();
            }

            // Lembrando que isso daqui como é uma superclasse e uma subclasse você está atrelado as mesmas regras, por
            // exemplo se na minha classe Animal com a variável de referência só tenho o método walk eu não posso, por
            // exemplo se eu criar um outro método aqui jump eu nunca vou conseguir chamar esse método jump porque na
            // minha variável de referência animal não existe jump
            public void jump() {}
        };
        animal.walk();
    }
}
