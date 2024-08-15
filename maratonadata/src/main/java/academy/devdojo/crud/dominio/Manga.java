package academy.devdojo.crud.dominio;

import java.util.Objects;

// Records são um tipo especial de classe que vai ser imutável é uma classe final que não pode ser extendida todos os
// atributos também não podem ser alterados você não tem um modificador de acesso pra trocar eles, você não tem
// permissão pra trocar ele porque não tem os accessors, por exemplo setters, você pode trabalhar com Record com
// modificador de acesso da mesma forma que uma classe public, private,
public record Manga(String name, int episodes) {
    // Não podemos criar atributos diretamente
    // Não podemos criar atributos de instância, mas podemos criar atributos estáticos
    // Tudo o que for relacionado a instância você não pode fazer tanto pra você criar atributos ou blocos de
    // inicialização, mas você pode colocar blocos de inicialização estáticos também
    // Você pode utilizar generics se quiser

    // O que você pode fazer caso você queira verificar se o nome não é nulo? Você pode criar um construtor dessa forma
    // compact constructor
    public Manga {
        // Esse construtor vai ser chamado na hora da criação do objeto e você pode verificar, por exemplo
        Objects.requireNonNull(name);

        // Dessa forma quando você estiver criando você pode verificar se o nome não é nulo como se fosse uma validação
        // de uma classe normal
    }
}
