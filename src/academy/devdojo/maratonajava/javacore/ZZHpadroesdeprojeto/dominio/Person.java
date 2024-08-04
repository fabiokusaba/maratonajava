package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

// Design Patterns ou padrões de projeto são padrões que geralmente tendem a resolver problemas comuns, problemas que
// os desenvolvedores encontram no dia a dia que milhares de vezes precisa ser resolvido e para tentar padronizar e
// achar a melhor forma de você resolver esse problema é utilizando esse padrão de projeto, então basicamente é uma
// forma de você escrever código que vai resolver um problema comum
// O primeiro padrão de projeto que vamos falar aqui é o builder e o que que o builder tenta resolver? Imagine que a
// gente tem a classe Pessoa você tem os atributos da classe, cria um construtor com todos eles, getters, setters, o
// padrão que nós já vimos, mas qual o problema de você fazer isso?
public class Person {
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    // Você pode deixar público, mas geralmente você vai ver que o acesso ao construtor é privado porque você quer
    // forçar a pessoa a usar o builder
    private Person(String firstName, String lastName, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Como você já sabe nesse nível do curso uma classe interna tem acesso aos atributos da classe externa
    // Aqui a gente vai copiar os mesmos atributos que a gente vai precisar, mas aí o segredo está na forma que você
    // vai criar os métodos pra você dar o nome
    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private String username;
        private String email;

        // Quando a gente cria os getters e os setters, o que a gente está fazendo? Principalmente o setter que é o que
        // a gente está tentando fazer quando você cria o setter você tem aqui o void você tem o objeto seta o valor e
        // não retorna nada, mas quando você está trabalhando com padrão builder você retorna a própria classe o próprio
        // builder e aí você coloca o nome nesse caso aqui o nome que você quer adicionar e o que você retorna? O
        // próprio objeto, por que estou fazendo isso? Porque todas as vezes que eu chamar eu vou retornar o mesmo
        // objeto vou trabalhar no mesmo espaço de memória
        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, username, email);
        }
    }

    public String getFirstName() {
        return firstName;
    }
}
