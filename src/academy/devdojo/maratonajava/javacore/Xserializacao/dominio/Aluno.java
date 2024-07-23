package academy.devdojo.maratonajava.javacore.Xserializacao.dominio;

import java.io.*;

// Deixando Aluno serializável
// A interface Serializable é uma interface flag que não tem métodos, ela só serve pra você passar naquele teste é um
public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 739959230178355186L;

    private Long id;
    private String nome;

    // Como você sabe você está serializando, ou seja, você está gravando algo em digamos texto aonde você tem dados
    // sensitivos, ou seja, você não quer gravar a senha porque se alguém tem acesso a esses valores serializados ele
    // tem acesso a senha também
    // Quando você tem uma situação dessas aonde você quer que um campo seja completamente ignorado durante a
    // serialização você tem que colocar a palavra transient, significa que esse atributo não deve ser serializado
    // Todas as vezes que você serializa o Java ele precisa manter como se fosse um id pra saber se você pode
    // deserializar, nesse caso como nós não definimos um id o Java gerou um pra gente baseado num hash e esse hash
    // tem a garantia que nada foi alterado
    private transient String password;

    // Outra coisa que você precisa tomar cuidado também na hora da serialização é com atributos estáticos
    // Atributos estáticos não pertencem ao objeto pertencem a classe, ou seja, eles não são serializados
    private static final String NOME_ESCOLA = "DevDojo Viradão no Jiraya";

    // Falando para o Java não serializar um atributo através do transient
    // Recapitulando para você serializar um objeto que não pode ser serializado você tem que praticamente escrever
    // todos os atributos daquele objeto nos métodos writeObject e readObject, primeiro você escreve todos os atributos
    // e na hora de você ler novamente você lê na mesma ordem que você escreveu assim você monta o objeto e quando você
    // termina de fazer a leitura do objeto serializado você tem meio que o mesmo estado que você tinha quando você
    // salvou
    private transient Turma turma;

    public Aluno(Long id, String nome, String password) {
        System.out.println("Dentro do construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    // Como para escrever, serializar esse objeto
    // O Java vai encarregar de chamar esse writeObject, mas você não tem um Override porque Serializable não tem
    // nenhum método, mas ele tem que ser escrito dessa forma
    @Serial
    private void writeObject(ObjectOutputStream oos) {
        try {
            // Primeiramente você salva da forma padrão
            oos.defaultWriteObject();

            // Em seguida você precisa salvar tudo aquilo que não faz parte do seu defaultWriteObject, ou seja, no nosso
            // caso a Turma que é algo transient, no caso da Turma eu só tenho um atributo então eu preciso falar olha
            // agora você escreve, você não pode salvar o objeto porque o objeto não é serializável, mas os atributos
            // a gente pode pegar e escrever aqui dentro, como quero escrever uma String writeUTF
            // A ordem é importante porque a ordem que você está escrevendo é a ordem que você tem que ler
            oos.writeUTF(turma.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Como ler esse objeto
    @Serial
    private void readObject(ObjectInputStream ois) {
        try {
            // Primeiramente você lê o defaultReadObject
            ois.defaultReadObject();

            // Agora que você tem o objeto você lê o extra que é
            String nomeTurma = ois.readUTF();

            // Criando a turma
            turma = new Turma(nomeTurma);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", Turma='" + turma + '\'' +
                '}';
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
