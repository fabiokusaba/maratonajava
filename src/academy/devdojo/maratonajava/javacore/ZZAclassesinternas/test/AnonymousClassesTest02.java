package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Não temos um Comparable no Barco e eu não quero criar uma classe Comparator, por exemplo
class BarcoNameComparator implements Comparator<Barco> {
    @Override
    public int compare(Barco o1, Barco o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        // Imagine que nós temos uma lista de Barco
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

        // Lembra que caso você queira dar um sort nessa lista, por exemplo, barcoList.sort você precisa de um
        // Comparator
        // Na hora de dar o sort passamos new BarcoNameComparator
//        barcoList.sort(new BarcoNameComparator());

        // Classes anônimas também podem ser úteis para essas situações
        // Você não pode dar new numa interface, mas como estamos trabalhando com classes anônimas isso é possível
        // Então, isso são classes anônimas como você pode ver você pode dar um new numa interface dentro da chamada de
        // um método e você está criando uma classe sem nome que passa no teste é um Comparator e você pode utilizar
        // nesse ponto específico do tempo
        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        // Ou se você quiser passar Collections.sort e a lista o objeto precisa ser um Comparable
//        Collections.sort(barcoList);

        System.out.println(barcoList);
    }
}
