package academy.devdojo.maratonajava.javacore.Oexception.exception.dominio;

import java.io.FileNotFoundException;

// A primeira regra é que quando você está sobrescrevendo um método você não é obrigado a declarar as mesmas exceções
// que aquele método está declarando porque a funcionalidade da sobrescrita que você está colocando pode ser
// complemtamente diferente, pode ser que ela não lance exceção por isso você não é obrigado
// Você pode, por exemplo colocar apenas uma exceção
// Uma outra opção ainda é você não declarar uma exceção do tipo Runtime, exceções do tipo Runtime elas não forçam você
// a fazer o tratamento na hora da chamada
// Então, a primeira regra é quando você está sobrescrevendo você pode lançar nenhuma exceção, você pode lançar uma ou
// todas as exceções, você pode adicionar qualquer exceção do tipo unchecked filhas de Runtime ou uma outra regrinha
// é que você não pode adicionar exceções mais genéricas ou do tipo checked aqui no throws e por fim você não pode
// adicionar nenhuma exceção do tipo checked que não foi declarada no método original
public class Funcionario extends Pessoa{
    public void salvar() throws LoginInvalidoException, FileNotFoundException {
        System.out.println("Salvando funcionário");
    }
}
