package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.dominio;

// Como você pode ver a inicialização dos objetos acontece antes mesmo da execução do construtor
public class Anime {
    private String nome;
    private int[] episodios;

    // Blocos de inicialização -> são bem simples, basicamente em qualquer lugar da classe, mas geralmente você coloca
    // no começo antes dos construtores e depois dos atributos, você abre e fecha {}, a partir de agora você tem um
    // bloco de inicialização de instância porque esse cara é executado todas as vezes que esse objeto é criado, a regra
    // é que ele é executado antes do construtor
    // Praticamente a diferença entre ele e um construtor é que por exemplo, quando você tem códigos iguais do episodio
    // ele pode ser jogado para dentro desse bloco de inicialização e você não vai precisar ficar replicando, agora
    // independente do construtor que eu chamar os episodios vão estar inicializados
    // Quando você está criando objetos primeiro é alocado espaço em memória, em seguida cada atributo de classe é
    // criado e inicializado com valores padrão(default) ou o que for passado, o terceiro passo é que o bloco de
    // inicialização é executado, em seguida o construtor é executado
    {
        System.out.println("Dentro do bloco de inicialização");
        this.episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime() {
        for (int episodio : this.episodios) {
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
