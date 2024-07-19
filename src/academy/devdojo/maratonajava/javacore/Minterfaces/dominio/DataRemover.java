package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

// Recapitulando interfaces é como se fosse um contrato onde todos os métodos por padrão eles serão públicos e
// abstratos, se você não criar ele abstrato você precisa criá-lo default que foi introduzido no Java 8 e você precisa
// prover uma implementação quando ele é default, mas que por padrão ele ainda vai ser public
public interface DataRemover {
    void remove();
}
