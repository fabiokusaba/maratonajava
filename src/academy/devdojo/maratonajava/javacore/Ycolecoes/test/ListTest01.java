package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

// A lista é uma coleção ordenada, ou seja, tem uma sequência
// Como falamos anteriormente o pacote Collection ele é altamente coeso, significa que a gente geralmente trabalha
// orientado a interface e você precisa de um tipo para esse objeto, existem vários tipos que podemos criar e um dos
// mais simples e mais famosos é o ArrayList
// E o ArrayList que nós temos aqui é basicamente um array que pode ser dinâmicamente incrementado, ou seja, conforme
// você for adicionando elementos você não precisa recriar o array ele faz isso por debaixo dos panos
public class ListTest01 {
    public static void main(String[] args) {
        List nomes = new ArrayList(); // Versão 1.4 do Java
        nomes.add("William");
        nomes.add("DevDojo");

        // Como você pode ver ele está aceitando qualquer coisa dentro dessa lista e isso é um problema porque as vezes
        // quero pegar um valor para trabalhar com replace e como vou saber se esse cara é uma String
        nomes.add(121);

        // Para navegarmos nessa lista podemos utilizar tanto o foreach quanto o for iterando com um índice
        // Vamos utilizar o foreach e para isso precisamos de um tipo, esse nomes quando estou adicionando está pedindo
        // um objeto, então qual o objeto que nós temos aqui? Na verdade, não sabemos, estamos adicionando um objeto e
        // o que temos de variável de referência aqui é um Object
        for (Object nome : nomes) {
            System.out.println(nome);
        }

        // Com a introdução dos generics eles forçaram em tempo de compilação a definição do tipo, então por exemplo
        // essa sintaxe diamond <> para você colocar o tipo que você quer
        // Então, você está forçando agora em tempo de compilação essa lista ser uma lista de Strings
        // Na verdade foi feito desse jeito pra manter compatibilidade retroativa com as outras versões do Java
        // Você precisa definir o tipo na variável de referência não é obrigatório definir o tipo aqui no objeto
        // Você tem uma opção também que você pode definir o tamanho da capacidade, a capacidade é 16 se você tentar
        // inserir 17 ele vai dobrar o tamanho para 32, se chegar em 33 ele vai dobrar denovo e vai para 64 e assim
        // por diante, então por exemplo se você sabe que você vai colocar uma lista com 300 nomes você já pode criar
        // uma capacidade inicial de 300 e isso vai evitar que ele precise ficar dando um redimensionamento do próprio
        // array

        // Uma coisa que você precisa tomar cuidado é que no momento da criação de qualquer tipo de coleção o valor que
        // você tem aqui <> tem que obrigatoriamente ser um Object, ou seja, você não pode criar uma lista de nenhum
        // tipo primitivo, por exemplo int, float, double, você precisa utilizar os wrappers, então se você quer criar
        // uma lista de inteiros você precisa utilizar o wrapper do Integer
        // Por que ele não pode criar coleções de tipos primitivos? Porque as coleções elas chamam o equals e hashCode
        // internamente como os tipos primitivos são tipos primitivos não tem como existir um equals e hashCode para os
        // tipos primitivos
        List<Integer> numeros = new ArrayList<>();

        // Você consegue adicionar o número 1 aqui porque o número 1 é um tipo primitivo, mas lembre-se que o Java tem o
        // conceito de autoboxing e unboxing, ou seja, na hora de adicionar ele vai transformar esse 1 em um wrapper
        numeros.add(1);

        List<String> nomes2 = new ArrayList<>(16); // A partir da versão 1.5 do Java
        nomes2.add("Suane");
        nomes2.add("Academy");

        // O remove tem duas opções: uma passando o índice e você também tem a opção de passar um Object, no nosso caso
        // o objeto é uma String então podemos passar William e ele vai remover através do equals
        // Ele retorna true ou false caso ele consiga ou não remover
        nomes.remove("William");

        // Imagine que temos duas listas e queremos adicionar todos os elementos de uma na outra nós podemos fazer isso
        // através do for ou você pode fazer nomes.addAll() e como você pode ver ele recebe aqui uma coleção de qualquer
        // coisa que passe no teste é uma String
        nomes.addAll(nomes2);

        for (String nome2 : nomes2) {
            System.out.println(nome2);

            // Se colocarmos o add dentro do for teremos uma exceção ConcurrentModificationException e isso acontece
            // por causa da forma como o for funciona, o for já tem um tamanho meio que fixado na hora que você começa
            // a iterar sobre ele, então você não pode simplesmente alterar o tamanho dinâmicamente enquanto você está
            // executando esse for
            // Se você for precisar fazer uma modificação dessas o aconselhável é você utilizar o iterator ou o for
            // indexado
            nomes2.add("Suane");
        }

        nomes2.add("Suane");

        System.out.println("-------");

        int size = nomes2.size();

        // Agora que estamos trabalhando com listas não é mais o length, você pega o nome da lista e utiliza .size()
        // esse cara vai retornar o tamanho da lista pra você, no nosso caso o tamanho é 2 e o índice vai de 0 a 1
        for (int i = 0; i < size; i++) {
            System.out.println(nomes2.get(i));

            // Se você adicionar aqui o nomes2.add("Suane") você colocou nomes.size() nesse caso ele vai imprimir o nome
            // e quando chegar nessa linha ele vai adicionar Suane e daí o nomes.size() de 2 vai para 3 e a iteração
            // vai continuar de 0 até nomes.size(), na próxima iteração o size vai para 4 e assim por diante, ou seja,
            // esse cara nunca vai parar de executar
            // O que você poderia fazer para solucionar é o seguinte: criar uma variável auxiliar size e pegar esse
            // valor primitivo, independente se o nomes.size() mudar ele vai continuar sempre o mesmo
            nomes2.add("Suane");
        }

        System.out.println(nomes2);
    }
}
