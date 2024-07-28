package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// Classes locais é quando você tem uma classe dentro de um método ou dentro de um bloco de inicialização estático
public class OuterClassesTest02 {
    private String name = "Midoriya";

    // Por exemplo, estamos dentro de um método normal chamado print e esse método faz parte da classe, porém a gente
    // pode criar classes locais dentro do método
    // Lembre-se o método tem o tempo de vida muito menor do que o tempo de vida da classe, ou seja, enquanto essa
    // classe OuterClassesTest02 está vivo significa que o atributo nome está vivo e você só vai poder executar o método
    // print quando tiver essa classe/objeto OuterClassesTest02 vivo, então por isso que você pode fazer alterações nos
    // atributos de classe da classe externa, mas o problema é o seguinte quando você tem uma classe interna e você tem
    // um método pode ser que em algum lugar lá na memória que talvez essa LocalClass esteja vivo depois desse método
    // print terminar por isso que essa variável local lastName quando acaba esse método significa que essa variável
    // local deixa de existir, mas pode ser que esse objeto LocalClass ainda esteja vivo por isso tem que ser
    // efetivamente final
    // A mesma coisa se aplica se tiver um parâmetro
    // Para ser bem explícito você pode adicionar final
    void print(final String param) {
        // Relacionado a atributos temos algo bem interessante, digamos que você tem um atributo dentro do método
        // Quando você tem um atributo aqui você também pode utilizar esse atributo diretamente na sua classe, porém
        // tem um pequeno detalhe que esse atributo que você está utilizando ele tem que ser ou final ou efetivamente
        // final, porém se você fizer alguma modificação nesse cara vai dar um problema porque quando você cria uma
        // variável dentro do método você não altera o Java considera ela efetivamente final
        final String lastName = "Izuku";

        // A gente ainda tem acesso aos atributos das classes externas, por exemplo, digamos que eu queira imprimir o
        // nome
        // Dentro do nosso LocalClass podemos ter construtores, métodos
        // Agora aqui vem algumas regrinhas quanto aos modificadores de acesso como você está dentro do método as regras
        // se aplicam, então você tem duas opções: ou abstract ou final
        class LocalClass {
            public void printLocal() {
                // Você pode utilizar o parâmetro contanto que o parâmetro seja efetivamente final
                System.out.println(param);
                System.out.println(name + " " + lastName);
            }
        }

        // Uma vez que você tem uma classe Local você não tem acesso a essa classe uma vez que esse método termina,
        // então sempre que você criar uma classe Local você precisa inicializar essa classe diretamente no método se
        // não você não vai ter mais acesso a essa classe a partir do momento que esse método termina, a forma correta
        // seria
        LocalClass localClass = new LocalClass();

        // Essa seria a única forma que você tem de utilizar as classes locais, você precisa instanciar essa classe
        // diretamente no método
        localClass.printLocal();
    }

    public static void main(String[] args) {
        OuterClassesTest02 outer = new OuterClassesTest02();

        // Daí você usa da mesma forma que você usaria o método print e o método print vai se encarregar de executar
        // printLocal, como você pode ver nós temos acesso ao nome
        outer.print("Boku no Hero");
    }
}
