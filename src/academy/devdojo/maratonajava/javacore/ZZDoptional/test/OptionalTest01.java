package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

// Optional é uma classe que foi introduzida na versão 8 do Java e o intuito dessa classe em termos simples é tentar
// evitar null pointer exception, é ser fácil de você identificar que o retorno de um método pode ser opcional, pode
// não vir
// O Optional não é indicado para passagem de parâmetro e também não é uma boa ideia utilizar como variável de
// classe porque o Optional não é uma classe serializável, então tem alguns frameworks como Hibernate e JPA que eles
// esperam que você tenha os atributos da sua classe serializáveis se não eles não vão conseguir fazer o mapeamento
// relacional
// Geralmente é indicado a utilização no retorno dos métodos
public class OptionalTest01 {
    public static void main(String[] args) {
        // Criamos um Optional dessa forma, então basicamente essas são as três formas que você pode criar um
        // Optional através da classe Optional
        Optional<String> o1 = Optional.of("Aha uhu o DevDojo é foda.");

        // Digamos que esse seja o retorno de um método e caso você não passe um valor, você tem aqui algo nulo, o que
        // vai acontecer se você executar? Você vai ter um NullPointerException porque o of quer que você retorne um
        // objeto não nulo
//        Optional<String> o2 = Optional.of(null);

        // Caso você não saiba se vai ser nulo ou não você tem uma opção chamada ofNullable e dessa forma ele vai
        // executar e ele vai imprimir um Optional.empty
        Optional<String> o2 = Optional.ofNullable(null);

        // E caso você queira criar um vazio nós temos a opção Optional.empty
        Optional<String> o3 = Optional.empty();

        // Imprimindo nós podemos ver um objeto Optional encapsulando esse valor
        System.out.println(o1);

        System.out.println(o2);
        System.out.println(o3);

        // Qual o problema? O problema é que muita das vezes você faz um negócio assim
//        String name = findName("william");

        // Em algum momento você faz lá que esse nome vai ser em letra maiúscula, você executa e você tem um
        // NullPointerException porque ele não conseguiu encontrar, então para facilitar esse tipo de caso a galera do
        // Java criou o Optional
        // O Optional é um objeto que vai encapsular outros objetos
//        System.out.println(name.toUpperCase());

        // Dessas três formas de Optional que vimos a que deveríamos utilizar seria ofNullable
        Optional<String> nameOptional = Optional.ofNullable(findName("William"));

        // Ao executar nós temos aqui um Optional.empty, ou seja, vazio, não temos um NullPointerException
        System.out.println(nameOptional);

        // Mas, vamos dizer que eu queira executar se tem alguma coisa, então aí que vem a mágica do Optional porque
        // caso você tenha o nome você pode retornar, caso você não tenha você pode retornar alguma coisa
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(empty);

        // Outro método interessante que você tem para utilizar é o ifPresent que pede um Consumer
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
    }

    // Verificando se um nome contém na lista, caso ele exista nós retornamos o nome e caso ele não exista nós
    // retornamos null
    private static String findName(String name) {
        List<String> list = List.of("William", "DevDojo");
        int i = list.indexOf(name);
        if (i != -1) {
            return list.get(i);
        }
        return null;
    }

    // O ideal nesse método era nós utilizarmos Optional
    private static Optional<String> findNameOptional(String name) {
        List<String> list = List.of("William", "DevDojo");
        int i = list.indexOf(name);
        if (i != -1) {
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}
