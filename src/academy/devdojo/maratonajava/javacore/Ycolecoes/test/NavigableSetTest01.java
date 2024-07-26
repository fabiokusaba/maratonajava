package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

// NavigableSet é uma interface que extends o SortedSet e o SortedSet extends o Set, ou seja, tudo é parte de um Set que
// segue as mesmas regras significa que você precisa obrigatoriamente tomar cuidado para não inserir elementos
// duplicados, ou seja, ele não vai deixar através da utilização do equals para saber se aquele elemento já existe
// dentro daquele seu Set
// Basicamente ele adiciona alguns métodos que você pode trabalhar pra você pegar elementos baseados em posições já
// existentes
// Você utiliza o TreeSet quando a classe que você está criando a coleção implementa Comparable ou caso você não tenha
// Comparable você tem que ter certeza absoluta que você está criando um Comparator e você tem que lembrar que todas as
// vezes que você inserir um elemento o próprio TreeSet vai reordenar a coleção baseado no valor ou do compareTo que
// você tem quando tiver implementando Comparable ou no compare que você passou aqui no Comparator
// Lembrando também que ele não aceita valores duplicados
// O TreeSet ele falha ao obedecer o contrato do Set, ele não utiliza o equals para verificar se dois elementos são
// iguais, então ele fala aqui na documentação que ele se baseia no método compareTo ou no Comparator que você está
// passando quando você está criando o TreeSet, isso significa que mesmo você tendo o equals você pode ter elementos
// duplicados
public class NavigableSetTest01 {
    public static void main(String[] args) {
        // Então, ele tem algumas regrinhas
        // Uma das classes que implementa essa interface é a TreeSet, essas classes que vocês veêm com nome Tree vão
        // trabalhar geralmente diretamente linkado a parte de você ter o sort, ou seja, elas precisam que as classes
        // que você está adicionando dentro dessa coleção Tree você precisa ter certeza que elas tem Comparable
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");

        // Se você tentar colocar esse smartphone dentro desse Set e você executar você vai ver que você tem um
        // ClassCastException porque ele tenta comparar, verificar se o Smartphone é um Comparable, como não é ele tem
        // essa exceção
        // E caso você queira adicionar mesmo assim, digamos que você não tem acesso a classe Smartphone, você pode vir
        // aqui e criar uma classe Comparator e passarmos no nosso TreeSet e agora ele executa normalmente
        // Então, nesse caso temos duas opções: uma quando a nossa classe implementa Comparable e a segunda é você
        // passando um Comparator diretamente na criação do seu TreeSet
        set.add(smartphone);

        NavigableSet<Manga> mangas = new TreeSet<>( new MangaPrecoComparator());
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10L, "Aaragon", 2.99, 0));

        // Perceba que aqui ele está imprimindo em ordem alfabética do nome porque se você voltar na nossa classe
        // Manga no método compareTo nós estamos comparando com o nome
        // O que você precisa saber é que o TreeSet ele automaticamente vai fazer a organização da sua coleção baseado
        // no seu compareTo, por causa desse comportamento se você ver na lista do TreeSet ele é um O(log n)

        // Se você chamar o descendingSet ele vai ordenar de forma inversa
        for (Manga manga : mangas.descendingSet()) {
            System.out.println(manga);
        }
        System.out.println("-------");

        // Esses métodos são métodos para comparação baseado no objeto que você passar
        // lower -> traz dentro de uma coleção o imediatamente menor
        // floor -> traz o mesmo valor que você está passando ou se caso não exista o imediato abaixo dele
        // higher -> traz dentro de uma coleção o imediatamente maior
        // ceiling -> leva em consideração o valor que você está passando
        Manga yuyu = new Manga(21L, "Yuyu Hakusho", 3.2, 5);
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));
        System.out.println("------------------");

        //
        System.out.println(mangas.size());

        // Retorna e remove o primeiro elemento da lista
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.size());
        System.out.println("-----------");

        // Para o pollLast é a mesma coisa, mas ao contrário, ele vai remover o último elemento da lista
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());
    }
}
