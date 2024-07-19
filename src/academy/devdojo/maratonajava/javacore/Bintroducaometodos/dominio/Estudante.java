package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Estudante {
    public String nome;
    public int idade;
    public char sexo;

    // O nosso método imprime está dentro do objeto então ele tem acesso a todos os atributos que temos aqui dentro
    public void imprime() {
        // Existe uma palavra reservada para quando você está querendo referir a algo que está dentro do seu objeto
        // chamada this que em inglês quer dizer "esse"
        System.out.println("--------");
        System.out.println(this.nome);
        System.out.println(this.idade);
        System.out.println(this.sexo);
    }
}
