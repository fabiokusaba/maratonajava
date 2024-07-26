package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

// Tem alguns sistemas onde a prioridade é importante, digamos que nós temos aqui o nosso Manga, nosso Manga é um
// Comparable que está utilizando o nome, mas imagine o seguinte que você tem uma lista de Manga
public class QueueTest02 {
    public static void main(String[] args) {
        // Passando o modo de comparação como sendo o preço do Manga
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());

        // Estou adicionando todos esses objetos Manga na minha PriorityQueue, bom mas aí vem aquele negócio o que que
        // é o nome PriorityQueue? Ele quer dizer que você pode definir a prioridade, lembre-se como a gente sempre
        // remove o primeiro elemento da nossa fila a gente quer, por exemplo, definir qual é a importância, o foco é
        // a prioridade, então por exemplo, no nosso caso do Manga a gente sobrescreveu o Comparable com o nome, mas
        // digamos que você tem uma outra regra de negócio e você quer, por exemplo, dar importância para o preço, se
        // fosse um carrinho de compras você poderia dar prioridade para os elementos que, por exemplo, tem uma maior
        // quantidade de itens, maior preço pra você dar o checkout primeiro
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10L, "Aaragon", 2.99, 0));

        while (!mangas.isEmpty()) {
            System.out.println(mangas.poll());
        }
    }
}
