package academy.devdojo.maratonajava.javacore.Isobrescrita.dominio;

public class Anime {
    private String nome;

    public Anime(String nome) {
        this.nome = nome;
    }

    // Lembre-se que todos os objetos que trabalhamos eles são objetos porque as classes elas extendem, elas são um
    // Object, então independente de você ter criado métodos em Anime você vai ter sempre métodos que pertencem a classe
    // Object
    // Toda vez que você imprime uma variável de referência esse método toString que é da classe Object é executado, é
    // por isso que você vê aquela saída no terminal, por ser um método da classe Object, como vimos anteriormente em
    // sobrescrita de métodos e herança, é possível nós sobrescrevermos esse método
    // Existem duas regras que você precisa seguir quando você está sobrescrevendo: a primeira o nome precisa ser
    // exatamente o mesmo, a quantidade de parâmetros precisa ser exatamente a mesma independente se você tem ou não tem
    // o tipo de retorno tem que ser exatamente a classe ou alguma subclasse isso se chama covariança de retorno e o
    // modificador de acesso nunca pode ser mais restritivo, ou seja, público é o modificador de acesso mais aberto que
    // nós temos, ou seja, se nós tentarmos trocar para protected ele vai dar um erro falando que você não pode colocar
    // um modificador de acessos com menos privilégios, você não pode tirar os privilégios
    @Override
    public String toString() {
        return "Anime: " + this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
