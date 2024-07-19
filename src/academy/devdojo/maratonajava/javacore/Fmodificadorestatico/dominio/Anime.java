package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

// Como você pode ver a inicialização dos objetos acontece antes mesmo da execução do construtor
public class Anime {
    private String nome;
    private static int[] episodios;

    // Bloco de inicialização estático -> vai fazer com que o bloco de inicialização seja executado apenas uma vez, ou
    // seja, o bloco de inicialização estático é executado apenas uma vez quando a classe é carregada pela JVM antes
    // mesmo de você ter espaço em memória, na verdade isso acontece para todos os atributose métodos estáticos
    // Quando você tem mais de um bloco de inicialização estático eles vão ser executados na ordem em que aparecem
    // Vocês precisam lembrar que bloco de inicialização estático é executado apenas uma vez quando a classe é carregada
    // pela JVM, isso acontece antes de qualquer coisa, antes mesmo do espaço ser alocado em memória para o objeto, se
    // tiver mais de um vão ser executados na ordem em que aparecem no código e que você não pode acessar atributos de
    // instância dentro de um método estático justamente por causa dessa ordem pelo fato de não existir um objeto em
    // memória ainda quando ele é executado, e que você pode ter blocos de inicialização juntamente com blocos de
    // inicialização estáticos
    static {
        System.out.println("Dentro do bloco de inicialização estático 1");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }

    static {
        System.out.println("Dentro do bloco de inicialização estático 2");
    }

    static {
        System.out.println("Dentro do bloco de inicialização estático 3");
    }

    {
        System.out.println("Dentro do bloco de inicialização não estático");
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime() {
        for (int episodio : Anime.episodios) {
            System.out.print(episodio + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}
