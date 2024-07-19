package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

// Modificador estático -> nós precisamos de uma propriedade que seja independente do objeto, nós queremos algo que
// afete a instância em si do Carro e os objetos que serão criados, o que precisamos é criar um modificador estático e
// para isso usamos a palavra reservada static logo após o modificador de acesso
// Pelo fato do modificador de acesso estático ser usado nessa variável velocidadeLimite você está falando que essa
// variável não pertence mais ao objeto em si, ele pertence agora a Carro, ou seja, todos os objetos que você criar
// daqui pra frente agora tem essa velocidadeLimite como padrão de 250, qualquer coisa que você fizer em qualquer um
// dos objetos você está afetando todos os objetos porque não pertence mais a uma única instância
// Modificador de acesso estático vai fazer o atributo agora pertencer a classe e todos os objetos vão compartilhar do
// mesmo valor, então se você alterar através de uma instância na verdade você não está alterando de uma instância você
// está alterando para todos os objetos em existência dessa classe
public class Carro {
    private String nome;
    private double velocidadeMaxima;
    private static double velocidadeLimite = 250;

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void imprime() {
        System.out.println("-----------------");
        System.out.println("Nome " + this.nome);
        System.out.println("Velocidade máxima " + this.velocidadeMaxima);
        System.out.println("Velocidade limite " + Carro.velocidadeLimite);
    }

    // Método estático -> não podem acessar variáveis de instância, atributos de instância porque quando você utiliza
    // static significa que existe a possibilidade de não existir um objeto em memória, então como você vai pegar uma
    // variável que só pode existir em memória, um atributo de instância, nesse caso você não vai poder utilizar dentro
    // de métodos estáticos variáveis que não são estáticas, porém o contrário é possível um objeto sempre será criado
    // depois dos valores estáticos serem inicializados, ou seja, sempre vai existir os estáticos depois de você criar
    // um atributo por isso conseguimos acessar a velocidadeLimite dentro do método não estático imprime
    // As boas práticas dizem que você pode criar um método estático quando os métodos não acessam um atributo da
    // instância
    public static void setVelocidadeLimite(double velocidadeLimite) {
        Carro.velocidadeLimite = velocidadeLimite;
    }

    public static double getVelocidadeLimite() {
        return Carro.velocidadeLimite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
