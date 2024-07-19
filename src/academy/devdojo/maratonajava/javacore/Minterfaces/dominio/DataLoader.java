package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

// Interfaces é bem parecido com classes abstratas, mas a principal diferença é que interface é interface e classe
// é classe independente de ser abstrata ou não
// Interfaces quando o Java foi criado tinha o intuito de servir como contrato porque classes abstratas se você for
// parar pra pensar nos métodos abstratos eles são contratos que as classes concretas que extenderem essa classe
// precisam implementar, até o Java 7 as interfaces obrigatoriamente tinham que criar os métodos abstratos, a partir
// do Java 8 isso mudou você pode criar métodos concretos dentro de uma interface, mas até o Java 7 todos os métodos
// em uma interface eram abstratos
// Se interface é meio como se fosse um contrato você não pode colocar a palavra final porque o contrato foi criado
// para ser implementado
// O que você precisa lembrar é que quando você está criando uma interface você não utiliza mais a public class você
// utiliza public interface, a interface por padrão tem todos os métodos que você declarar como public abstract, mesma
// regra métodos abstratos precisam ter ponto e vírgula e quando você implementa na classe e não extende você precisa
// usar a palavra reservada implements e o nome da interface
public interface DataLoader {
    // É possível declarar atributos em uma interface, por padrão todos os atributos em uma interface são constantes
    // portanto, se torna redundante colocar public static final
    public static final int MAX_DATA_SIZE = 10;

    // Quando você cria uma interface você pode criar métodos, por padrão os métodos são públicos e abstratos
    // E as interfaces foram criadas com esse intuito de prover um contrato para implementação
    void load();

    // O problema é que quando você adiciona um método abstrato você é obrigado a prover implementação desse método
    // abstrato em todas as classes que estão fazendo a implementação
    // Os métodos default são métodos que tem implementação
    // Em nosso caso para não quebrarmos o nosso código podemos prover a implementação, mas quando você provê a
    // implementação você está fazendo a mesma coisa que em uma classe abstrata você está falando que você está
    // definindo a interface o comportamento para aquele método
    default void checkPermission() {
        System.out.println("Fazendo checagem de permissões");
    }

    // E a partir do Java 8 nós também temos a possibilidade de adicionar métodos estáticos, métodos estáticos nunca
    // vão ser sobrescritos porque eles pertencem a classe, no nosso caso pertencem a interface
    public static void retrieveMaxDataSize() {
        System.out.println("Dentro do retrieveMaxDataSize na interface");
    }
}
