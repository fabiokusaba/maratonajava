package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// O Comparator também é uma interface que o nome já diz também vai fazer comparação, mas a única diferença entre essa
// e a Comparable é que essa interface você tem o método compare e você não utiliza implementando na sua classe
// diretamente, então você não faz implements Comparator porque o sort ele espera Comparable, ou seja, ele espera que
// tenha o método compareTo
// Digamos que eu queira que os mangas sejam ordenados por id em um específico ponto do meu software, bom para isso
// você precisa ter um objeto que passa no teste é um Comparator, daí você precisa prover a implementação do método
// compare
class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga manga1, Manga manga2) {
        // Exatamente a mesma regrinha que nós tínhamos no compareTo do -1, 0 e 1, porém como você pode ver nós não
        // estamos mais no objeto Manga, nós estamos num objeto completamente diferente que é o MangaByIdComparator
        // nesse caso aqui agora a gente tem acesso a 2 você tem acesso a manga1 e você tem acesso a manga2
        // Da mesma forma que eu fiz lá no compareTo eu estou passando aqui no compare
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9));
        mangas.add(new Manga(1L, "Berserk", 9.5));
        mangas.add(new Manga(4L, "Pokemon", 3.2));
        mangas.add(new Manga(3L, "Attack on titan", 11.20));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99));

        // Agora nós precisamos ordenar e para ordenar nós precisamos dizer ao Java como ele deve ordenar a lista
        // principalmente quando a gente está falando de objetos customizados que são objetos que nós criamos
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("-------");

        // O Collections.sort vai chamar internamente o nosso método compareTo da classe Manga
        Collections.sort(mangas);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("-------");

        // Eu quero que o meu sort ao invés de utilizar o comportamento padrão definido na classe Manga que é fazendo a
        // ordenação via nome eu quero que seja por id e é por isso que esse método é sobrecarregado e ele aceita um
        // objeto que ele passa no teste é um Comparator, ou seja, a gente tem um objeto aqui MangaByIdComparator, aqui
        // eu só crio o objeto porque quem é que vai se encarregar de chamar esse objeto é o próprio Java
        // A própria lista tem esse método sort, porém você precisa passar aqui um Comparator porque o sort ele não liga
        // se você tem um Comparable ou não, ele liga que você vai passar aqui um objeto que passa no teste é um
        // Comparator
        //Collections.sort(mangas, new MangaByIdComparator());
        mangas.sort(new MangaByIdComparator());

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
