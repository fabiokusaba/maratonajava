package academy.devdojo.dominio;

import lombok.Builder;
import lombok.Value;

// Queremos inserir algo no banco de dados vamos criar um pacote (package) e esse pacote vai se chamar dominio porque
// lembra que a gente estava falando que geralmente nós temos as classes dominio que elas representam os dados do banco
// de dados
// Producer é uma tabela que tem id e name e precisamos fazer a mesma coisa aqui no nosso dominio
// Agora que nós temos o nosso Producer que é o dominio nós precisamos trabalhar com o banco de dados precisamos criar
// um metodo que vai, por exemplo salvar um Producer

// Lombok ajuda a gente na criação de código boilerplate, por exemplo: builder, equals, hashCode, getters, setters
// Outra coisa interessante do Lombok é a possibilidade de utilização de log, até o momento estávamos utilizando
// System.out.println mas na verdade você nunca vai utilizar o System.out.println em ambientes corporativos você sempre
// vai utilizar uma biblioteca que trabalha exclusivamente com logs pra você ver as coisas no terminal porque a
// performance do System.out.println é péssima, horrível, impossível você ficar utilizando System.out.println sem dizer
// que você não tem muita informação você só tem a informação que está lá dentro você não sabe se aquilo foi um erro
// se aquilo foi uma mensagem de informação, se aquilo foi um warning então você não tem status das mensagens com o
// Lombok você precisa adicionar uma biblioteca de log

// A anotação @Value do Lombok transforma tudo em imutável
// A anotação @Builder do Lombok adiciona um builder

@Value
@Builder
public final class Producer {
    // Aqui vamos utilizar a classe wrapper Integer porque se precisarmos usar o equals e essas coisas fica mais fácil
    private final Integer id;
    private final String name;

}
