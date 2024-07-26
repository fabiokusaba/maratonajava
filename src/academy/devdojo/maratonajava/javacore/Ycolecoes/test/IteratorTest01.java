package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        // A vantagem de você trabalhar orientado a interface é que estávamos utilizando o ArrayList, mas existe uma
        // outra opção que podemos trocar a implementação aqui que é o LinkedList, ele não aceita o tamanho no
        // construtor, e ao trocar e executar o nosso código teremos o mesmo resultado
        // O LinkedList nada mais é que um Array em que cada uma das posições sabe sobre a posição anterior e a próxima
        // então a vantagem de você utilizar um LinkedList se você for na comparação do Big O você vai ver que o
        // ArrayList para remover é O(n) que tem uma performance inferior a constante O(1), significa que o LinkedList
        // ele é melhor para remover, ou seja, se você vai ficar fazendo bastante remoção em uma lista seria mais
        // vantagem você utilizar o nosso LinkedList ao invés de utilizar o ArrayList e como você está programando
        // orientado a interface você só precisa trocar aqui a criação do objeto
        List<Manga> mangas = new LinkedList<>();
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));

        // Se tentarmos executar o código abaixo para tentar remover os mangas cuja quantidade seja zero teremos uma
        // ConcurrentModificationException, então é uma péssima ideia você fazer a remoção utilizando um foreach
//        for (Manga manga : mangas) {
//            if (manga.getQuantidade() == 0) {
//                mangas.remove(manga);
//            }
//        }

        // Uma outra forma que nós temos de remover é utilizando o Iterator
        // O Iterator é uma classe que meio que checa antes de fazer alguma ação, então por exemplo imagina que você
        // está no banco e você está olhando a fila do banco, você é o Iterator, a fila do banco é os mangas, você
        // antes de chamar alguém da fila você vai olhar tem alguém na fila? Tem, aí você vai falar olha você vem cá
        // aí a pessoa veio e você vai olhar para a fila denovo se tiver mais uma outra pessoa, você vê se tem para
        // depois apontar o dedo e falar você vem cá também, ou seja, o Iterator ele vai fazer isso
        Iterator<Manga> mangaIterator = mangas.iterator();

        // Enquanto o mangaIterator tiver próximo, ou seja, enquanto existir
//        while (mangaIterator.hasNext()) {
//            // Caso exista eu quero que você pega o manga, esse next é pegando o objeto tanto que você pode ver que
//            // esse next retorna um Manga e o hasNext retorna um booleano
//            Manga manga = mangaIterator.next();
//
//            // Agora que você tem um manga você pode verificar se a quantidade dele é zero para remover
//            if (manga.getQuantidade() == 0) {
//                // Dessa forma, você consegue remover de uma forma segura por causa do hasNext
//                mangaIterator.remove();
//            }
//        }

        // Era assim que precisávamos fazer para remover os valores da nossa lista, mas aí veio o nosso querido Java 8
        // com programação funcional e adicionou o método chamado removeIf
        // A sintaxe é bem simples você precisa primeiro de uma variável de referência da mesma forma que quando você
        // cria um foreach você precisa de uma variável de referência
        // O nome da variável de referência é você quem dá, quem vai fazer a navegação dos elementos vai ser o próprio
        // removeIf
        // A lógica de negócio vai vir depois da seta ->
        // Dessa forma, a gente está falando navega por todos os mangas e remove se você achar que manga.getQuantidade
        // é igual a zero
        mangas.removeIf(manga -> manga.getQuantidade() == 0);

        System.out.println(mangas);
    }
}
