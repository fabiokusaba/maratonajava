package academy.devdojo.maratonajava.javacore.Gassociacao.dominio;

// Associação -> é o relacionamento entre dois objetos
public class Jogador {
    private String nome;

    // Associação unidirecional -> o Jogador pode fazer parte de um Time, significa que o Time não tem conhecimento do
    // Jogador, ou seja, sem banco de dados você não conseguiria retornar a partir do Time quem são os jogadores, seria
    // preciso fazer uma lógica para pegar todos os jogadores do Time através do Jogador
    private Time time;

    public void imprime() {
        System.out.println(this.nome);
        if (time != null) {
            System.out.println(time.getNome());
        }
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
