package academy.devdojo.maratonajava.javacore.Qstring.test;

// A primeira coisa que vocês precisam saber é que as Strings no Java são imutáveis
// Heap é o lugar aonde todos os objetos moram, aqui dentro o Java cria um espaço especialmente para as Strings que é o
// pool de Strings, existe um conceito na área da ciência da computação chamado String interning que basicamente é
// quando você utiliza as Strings de forma imutável, ou seja, no Java toda String que você está criando se você criar
// ela pela primeira vez ela vai ser alocada no pool de Strings, mas se você cria uma segunda vez o Java não vai
// duplicar
public class StringTest01 {
    public static void main(String[] args) {
        String nome = "William"; // String constant pool -> piscina constante de Strings
        String nome2 = "William";

        // É importante você perceber que como String é imutável não é possível alterar esse valor William, quando você
        // altera o valor, por exemplo concatena o nome com Suane
        // Por causa da imutabilidade das Strings a não ser que você faça uma nova associação você não pode trocar o
        // valor que existe
        // O que aconteceu aqui é o seguinte nós temos William, o Suane sendo criado e existe ainda a String que é
        // concatenada William Suane, mas o problema é que não existe uma variável de referência pra elas
        // O que podemos fazer é:
        nome = nome.concat(" Suane"); // nome += " Suane"

        // A partir de agora nome vai estar fazendo referencia para William Suane no pool de Strings e nome2 está
        // fazendo referência para William no pool de Strings, então você nunca consegue alterar um valor no pool de
        // Strings se você criar uma outra String e o Java verificar que já existe no pool de Strings ele só vai te
        // devolver a referência daquele valor
        System.out.println(nome);

        // Quando estamos comparando Strings nós devemos usar o equals porque o equals vai comparar se o valor delas é
        // igual, mas o que queremos validar agora é a referência que se nome e nome2 estão fazendo referência ao mesmo
        // objeto que nesse caso é William que está dentro do pool de Strings e para fazer isso quando você quer
        // comparar a referência você utiliza o sinal de ==
        System.out.println(nome == nome2);

        // Nesse exemplo o resultado é falso porque nós temos uma variável de referência nome3 que está fazendo
        // referência para um objeto e quando você faz new String() você está criando em um outro lugar, você está
        // criando uma String dentro do heap de memória e não no pool de Strings e essa variável está fazendo referência
        // para ela
        // Quando estamos trabalhando com Strings de forma literal nome2 nós estamos pegando do pool de Strings, mas
        // quando você cria um objeto a sua variável de referência está fazendo a referência para o objeto, ou seja,
        // nome3 faz referência a esse objeto William que encapsula William que está dentro do pool de Strings
        // Quando fazemos dessa forma nome3 estamos criando uma variável de referência, um objeto do tipo String e uma
        // String no pool de Strings
        String nome3 = new String("William");
        System.out.println(nome2 == nome3);

        // Se eu quisesse pegar o valor que tem do William lá dentro eu utilizo o intern que retorna uma representação
        // canônica desse objeto e se executarmos novamente vamos obter o valor true, ou seja, o nome2 está sendo
        // comparado com o valor que nós temos dentro do pool de Strings que é William
        System.out.println(nome2 == nome3.intern());
    }
}
