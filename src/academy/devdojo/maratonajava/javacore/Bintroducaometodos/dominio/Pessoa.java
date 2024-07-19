package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

// Acoplamento -> quando falamos que o nosso código é altamente coeso estamos falando que a quantidade de coisas que
// aquele código está fazendo é mínima, ou seja, nosso código é específico para um determinado problema
// E o acoplamento é o quanto uma classe conhece da outra, quão uma classe está conectada com outra
// Um modificador de acesso privado(private) significa que esses atributos só vão poder ser acessados pelo objeto
public class Pessoa {
    private String nome;
    private int idade;

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.idade);
    }

    // Quando você cria atributos privados é comum você dar um método para acessá-los, o atributo em si fica privado
    // mas, o método fica público, você cria uma camada que vai receber esse atributo
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        if (idade < 0) {
            System.out.println("Idade inválida");
            return;
        }
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return idade;
    }
}
