package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

// No Comparable precisamos definir o tipo <>, no nosso caso Manga
public class Manga implements Comparable<Manga> {
    // Como nós estamos trabalhando com classes que geralmente agora vão representar algo no mundo real a gente vai
    // precisar sempre de um identificador único que geralmente é um id
    private Long id;
    private String nome;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nome, double preco) {
        // Não podem ser nulos se não vai lançar uma exceção de NullPointerException logo de cara
        Objects.requireNonNull(id, "Id não pode ser null");
        Objects.requireNonNull(nome, "Nome não pode ser null");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Manga(Long id, String nome, double preco, int quantidade) {
        this(id, nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(@NotNull Manga outroManga) {
        // A regrinha é o seguinte, esse método retorna um inteiro, você tem acesso a dois objetos o objeto this que é o
        // objeto que está executando esse compareTo e você tem o outro objeto que é o que está sendo passado como
        // variável de referência, como argumento aqui
        // A regra é que você tem que retornar negativo se o this for menor que outroManga
        // Se this for igual a outroManga você retorna 0
        // Você retorna positivo se o this for maior que outroManga
//        if (this.id < outroManga.getId()) {
//            return -1;
//        } else if (this.id.equals(outroManga.getId())) {
//            return 0;
//        } else {
//            return 1;
//        }

        // Existe uma forma de simplificarmos isso, se você reparar o nosso id é um wrapper, wrapper eles possuem
        // métodos que a gente pode utilizar, ou seja, o wrapper do Long já implementou o compareTo, ele já é um
        // Comparable
        // Ou seja, só preciso retornar porque estou delegando a responsabilidade do meu compareTo para o compareTo do
        // Long
        // Você não poderia utilzar um compareTo de um wrapper quando você está trabalhando com tipo primitivo, por
        // exemplo não posso utilizar o compareTo com o preco porque ele é um tipo primitivo (double), para isso
        // poderíamos fazer um wrapper Double.valueOf(preco).compareTo()
        return this.nome.compareTo(outroManga.getNome());
        //return Double.compare(preco, outroManga.getPreco());
        //return Double.valueOf(preco).compareTo(outroManga.getPreco());
        //return this.id.compareTo(outroManga.getId());
    }
}
