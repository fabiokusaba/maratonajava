package academy.devdojo.maratonajava.javacore.Dconstrutores.dominio;

public class Anime {
    private String nome;
    private String tipo;
    private int episodios;
    private String genero;
    private String estudio;

    // Construtores -> a primeira regra é que construtor não tem nenhum tipo de retorno, a sintaxe para sua criação é
    // um modificador de acesso seguido do nome da classe seguido de parênteses e chaves
    // O Java tem uma regra que se você não definir um construtor na classe o Java vai adicionar um pra você no meio da
    // compilação
    // Você precisa de um construtor para dar origem a um objeto então se você não adicionar um construtor o Java no
    // momento da compilação vai adicionar um pra você
    // A vantagem dos construtores é que eles te forçam a seguir algumas regras, por exemplo para a criação de um Anime
    // eu precise obrigatoriamente de um nome então podemos definir no momento da criação de um Anime que agora você
    // precise passar um nome
    // O construtor é executado antes de qualquer método que você tem na sua classe
    // Da mesma forma que você tem sobrecarga de métodos você tem sobrecarga de construtores que é você criar outro
    // construtor com o mesmo nome, obrigatoriamente o construtor tem que ter o nome da classe sem o retorno, mas com
    // diferentes parâmetros
    // O construtor é o inicializador dos objetos no momento em que você pede determinados parâmetros você é obrigado
    // a passar a não ser que você tenha um construtor sobrecarregado
    // O construtor possui uma sintaxe especial, o construtor é relacionado ao objeto e qual das variáveis refere-se ao
    // próprio objeto em memória this, então no construtor para você chamar outro construtor você só precisa escrever
    // this()
    // Duas regras que você precisa saber ao chamar outro construtor dentro de um construtor -> primeiro você não
    // consegue utilizar essa sintaxe fora de construtores, o this() só pode ser usado dessa forma dentro do corpo de
    // um construtor, e a segunda regra é que se você tiver que chamar outro construtor obrigatoriamente precisa ser a
    // primeira linha executável do corpo do construtor
    public Anime(String nome, String tipo, int episodios, String genero) {
        this();
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.genero = genero;
    }

    public Anime(String nome, String tipo, int episodios, String genero, String estudio) {
        this(nome, tipo, episodios, genero);
        this.estudio = estudio;
    }

    public Anime() {
        System.out.println("Dentro do construtor sem argumentos");
    }

    // Sobrecarda de métodos -> é você ter o método com o mesmo nome, porém o tipo ou a quantidade dos parâmetros são
    // diferentes
    public void init(String nome, String tipo, int episodios) {
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
    }

    public void init(String nome, String tipo, int episodios, String genero) {
        this.init(nome, tipo, episodios);
        this.genero = genero;
    }

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.genero);
        System.out.println(this.estudio);
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public int getEpisodios() {
        return episodios;
    }
}
