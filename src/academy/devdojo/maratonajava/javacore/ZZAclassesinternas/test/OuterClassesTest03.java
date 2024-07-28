package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// Classes estáticas aninhadas basicamente é muito parecido com nested classes que nós vimos, mas a diferença é que você
// vai ter o static aqui e quando você utiliza esse static aqui dentro é como se você tivesse uma classe, digamos que
// essa classe OuterClassesTest03 ela é uma classe que nós chamamos de top level, classe no nível mais alto, o static
// class você colocando dentro dessa classe OuterClassesTest03 é como se fosse uma outra classe de alto nível, como se
// essa classe estivesse fora, e você só está fazendo dessa forma essa classe estática dentro dessa OuterClassesTest03
// por mais uma questão de empacotamento
public class OuterClassesTest03 {
    // Então, por exemplo você através da static class não vai conseguir acessar nenhum atributo que não seja estático
    // da classe mais externa
    // Se você tiver aqui
    private String name = "William";

    // O intuito dessa classe é justamente esse é como se você tivesse uma classe mais externa que vai comunicar com
    // a classe estática, sendo ela uma classe top level, ou vice-versa, mas devido a forma como o código é desenvolvido
    // essa classe Nested não tem motivo para estar fora da classe mais externa, não tem motivo para as duas classes
    // estarem no mesmo nível porque a classe Nested só vai se comunicar com a classe OuterClassesTest03
    static class Nested {
        private String lastName = "Suane";

        void print() {
            // Não posso acessar o name porque o name ele não é estático e eu estou dentro da minha classe estática
//            System.out.println(name);

            // Para acessar o name você precisaria criar new OuterClassesTest03 e chamar o atributo name
            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        // Você pode acessar esse cara através da criação desse objeto Nested, apesar de ser estático você tem que criar
        // mas você não precisa mais desse objeto externo, por exemplo
        Nested nested = new Nested();
        nested.print();
    }
}
