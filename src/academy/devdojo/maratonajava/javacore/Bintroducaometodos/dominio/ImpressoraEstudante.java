package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class ImpressoraEstudante {
    // Temos aqui dentro desse método uma variável de referência do tipo Estudante
    public void imprime(Estudante estudante) {
        System.out.println("---------------");

        // Quando chamamos dentro do método estudante e como estamos passando a cópia da referência, ou seja, o local
        // onde aquele objeto está na memória a nossa variável estudante quando for acessar os atributos nome, idade e
        // sexo vai acessar exatamente os mesmos valores
        System.out.println(estudante.nome);
        System.out.println(estudante.sexo);
        System.out.println(estudante.idade);

        // A passagem de parâmetros via referência se torna perigoso porque lembre-se quando nós estamos utilizando
        // tipos primitivos nós estamos passando uma cópia então não importa o que você fizer com essa cópia que nunca
        // vai ser alterado o original, mas quando você está passando passagens de parâmetros via referência tudo o que
        // você fizer no objeto você vai afetar o objeto independente de você estar fazendo dentro de uma outra classe
        // ou dentro da classe originária onde você criou o objeto
        // Nessa linha o objeto em memória que tenha referência para o nome vai receber um novo valor Gohan, antes dele
        // finalizar o método ele vai fazer essa alteração
        estudante.nome = "Gohan";
    }
}
