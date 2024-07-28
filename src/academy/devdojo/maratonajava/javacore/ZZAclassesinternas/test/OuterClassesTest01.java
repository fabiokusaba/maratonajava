package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// Classes internas basicamente é uma classe dentro da outra e quando que é útil? Bom, sem trabalhar com interfaces
// gráficas é um pouquinho difícil de ver a utilidade de classes internas, então imagina, por exemplo, que você tem um
// chat geralmente você tem a telinha e você tem os botões, ou seja, você tem a interface gráfica e você tem as ações
// que podem ser feitas dentro daquele chat do ponto de vista da coesão você tem que ter uma classe que toma conta da
// parte de interface gráfica e você tem que ter uma classe que toma conta das ações que estão acontecendo, ou seja,
// esses objetos são dois objetos diferentes, mas que eles estão tecnicamente fortemente acoplados, ou seja, não faz
// sentido o botão enviar a ação estar fora da interface gráfica, então para esses casos bem específicos foi criado o
// uso de interfaces gráficas
public class OuterClassesTest01 {
    // name é um atributo que pertence a essa classe OuterClassesTest01
    private String name = "Monkey D. Luffy";

    // Basicamente para você ter uma classe interna você cria uma outra classe
    // É como se fosse um método só que bem mais poderoso porque você pode declarar atributos e esse método também vai
    // ter acesso a todos os objetos da classe mais externa
    // Classes internas são como atributos, então você poderia colocar aqui os modificadores de acesso public, private
    // protected e até mesmo static
    class Inner {
        // Método da classe interna que vai imprimir o atributo da classe externa
        public void printOuterClassAttribute() {
            System.out.println(name);

            // Uma coisinha que precisamos nos preocupar é com o this, o this sempre vai se referir ao contexto da
            // classe o qual ele se encontra, ou seja, o this está fazendo referência ao objeto interno
            System.out.println(this);

            // Agora, para referenciar o this para a classe mais externa fazemos da seguinte forma
            System.out.println(OuterClassesTest01.this);
        }
    }

    public static void main(String[] args) {
        // Para criar um objeto da classe interna você precisa de um objeto da classe externa, então ele está fortemente
        // linkado a classe externa
        // Existem alguns momentos da sua vida que você vai desenvolver duas classes onde, por exemplo, só a classe B
        // vai acessar os atributos da classe A, então não tem outro motivo para B existir fora da classe A
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        Inner inner2 = new OuterClassesTest01().new Inner();
        inner.printOuterClassAttribute();
        inner2.printOuterClassAttribute();
    }
}
