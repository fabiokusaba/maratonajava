package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

// Existe um modificador de acesso que é o seguinte que a gente fala que qualquer subclasse em qualquer pacote vai ter
// acesso direto aos atributos como se você tivesse o atributo na sua própria classe e o nome desse modificador de
// acesso é protected
// Lembre-se disso protected vai dar acesso direto a variável a todas as subclasses independente daonde elas tiverem
// porém, todas as classes que estão no mesmo pacote também vão ter acesso
public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;

    static {
        System.out.println("Dentro do bloco de inicialização estático de pessoa");
    }

    {
        System.out.println("Dentro do bloco de inicialização de pessoa 1");
    }

    {
        System.out.println("Dentro do bloco de inicialização de pessoa 2");
    }


    // Todas as vezes que você adiciona um construtor na sua classe mãe e esse construtor agora tem argumentos
    // obrigatoriamente você precisa alterar em todas as classes filhas
    public Pessoa(String nome) {
        System.out.println("Dentro do construtor de pessoa");
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf) {
        this(nome);
        this.cpf = cpf;
    }

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.endereco.getRua() + " " + this.endereco.getCep());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
