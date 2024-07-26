package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

// Como nós estamos trabalhando com Map precisamos passar dois valores, relembrando algumas aulas anteriores sobre
// NavigableSet lembre-se que pra você colocar um valor no NavigableSet você obrigatoriamente precisa que aquela
// interface ou classe precisa ter a implementação do Comparable ou você precisa passar um Comparator
// Nesse caso o NavigableMap é a mesma coisa só que pra chave
public class NavigableMapTest01 {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");

        // Você vai ver que ele ordena, basicamente da mesma forma que o TreeSet vai ordenar o TreeMap também vai
        // ordenar só que ele vai ordenar pela chave, então por exemplo o valor não precisa implementar o Comparable
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        // O headMap tem duas opções aqui: o toKey e boolean inclusive
        // Aqui ele vai retornar todos que vem antes do C, importante salientar que o headMap está linkado com o map
        // original, então como você pode ver ao removermos a letra A do headMap também removemos do Map original
//        System.out.println(map.headMap("C").remove("A"));
//        System.out.println(map);

        // Se você quiser incluir a chave que você está passando você pode passar o boolean como true
        System.out.println(map.headMap("C", true));

        // lower <
        // floor <=
        // higher >
        // ceiling >=
        System.out.println(map.ceilingKey("C"));
        System.out.println(map.higherKey("C"));
        System.out.println(map.lowerKey("C"));
        System.out.println(map.floorKey("C"));
    }
}
