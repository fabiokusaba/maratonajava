package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

// Queue é mais uma coleção que temos disponível que tem por padrão a característica FIFO (first in first out), ou seja,
// o primeiro a entrar é o primeiro a sair
// Parecida com o Sorted que nós vimos porque ele precisa quando você está adicionando a classe que você definiu aqui
// precisa obrigatoriamente ser um Comparable
public class QueueTest01 {
    public static void main(String[] args) {
        // A PriorityQueue tem o construtor sobrecarregado onde você pode passar a capacidade inicial, e como ela
        // necessita que você tenha as classes utilizadas aqui como é um Comparable ela também oferece a possibilidade
        // de você passar um Comparator caso você não tenha a possibilidade de alterar aquela classe
        // Essa classe foi criada justamente para isso, para você trabalhar com prioridades customizadas
        Queue<String> fila = new PriorityQueue<>();

        // Basicamente ela vai ser ordenada de forma natural
        // Você adiciona os valores não significa que os valores eles vão estar ordenados dentro da memória, dentro do
        // Heap, mas quando você tirar os valores você vai ter de volta a forma ordenada, a forma que você definiu no
        // Comparable ou Comparator
        fila.add("C");
        fila.add("A");
        fila.add("B");

        // A coisa interessante aqui que a PriorityQueue ela vai manter a ordem, mas não necessariamente quando você
        // tiver esses objetos dentro em memória
//        for (String s : fila) {
//            System.out.println(s);
//        }
//        System.out.println(fila);

        // O certo quando você está trabalhando com a PriorityQueue é você trabalhar com um dos métodos disponíveis, por
        // exemplo: peek, poll, offer e remove
        // add -> vai adicionar um elemento a fila
        // A diferença entre o peek e o poll é que o peek ele vai te mostrar o primeiro elemento, quer dizer ele sempre
        // vai te mostrar o primeiro elemento, se você estiver dentro de um while ele vai mostrar o elemento sem remover
        // da fila
        // O poll ele pega o primeiro elemento daquela fila e vai remover
        // O offer é parecido com add a diferença é que o add retorna uma exceção se você tiver, por exemplo com um
        // tamanho definido, o offer retorna um booleano caso não consiga inserir em uma Queue com capacidade restrita
        // e o add ele vai lançar uma exceção caso você atinja o limite

        // Enquanto a fila não estiver vazia, faça
        while (!fila.isEmpty()) {
            // Você vai ver que ele vai ficar imprimindo pra sempre porque você não está removendo e ele está sempre
            // retornando o primeiro elemento
//            System.out.println(fila.peek());

            // O poll ele sempre remove o elemento cabeça daquela fila e você vai ver agora que realmente nós temos
            // A B C, ou seja, quando nós inserimos até nós desinfileirarmos ele não estava ordenado, mas no momento em
            // que nós começamos a remover esses elementos nós temos a ordem correta, a ordem que o Comparable ou
            // Comparator está indicando
            System.out.println(fila.poll());
        }
   }
}
