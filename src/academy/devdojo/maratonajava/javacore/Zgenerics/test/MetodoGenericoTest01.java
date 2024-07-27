package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
//        criarArrayComUmObjeto(new Barco("Canoa Marota"));
        List<Barco> barcoList = criarArrayComUmObjetoRetornandoUmaLista(new Barco("Canoa Marota"));
        System.out.println(barcoList);
    }

    // Vamos imaginar o seguinte problema eu tenho aqui a nossa classe MetodoGenerico e eu quero criar um método
    // genérico que, por exemplo, ele cria um Array pra mim, vou passar um objeto e ele vai retornar um Array desse
    // objeto, então podemos fazer
    // Primeiramente precisamos declarar o modificador de acesso, a palavra static porque vou acessar do método estático
    // e agora vem a sintaxe a primeira coisa que você precisa fazer quando está definindo um método genérico é definir
    // o tipo que você vai receber por parâmetro, esse <T> ele vem depois do seu modificador de acesso e antes do tipo
    // de retorno, por exemplo, se eu não tiver nenhum tipo de retorno eu tenho void e vou colocar um nome para esse
    // método
    // Qual é o tipo do objeto que eu vou receber para criar esse Array? O tipo é o T
    private static <T> void criarArrayComUmObjeto(T t) {
        // Para criar uma lista
//        List<T> list = new ArrayList<>();

        // Adicionando a lista
//        list.add(t);

        // Ou podemos fazer
        List<T> list = List.of(t);

        // Imprimindo a lista
        System.out.println(list);
    }

    private static <T> List<T> criarArrayComUmObjetoRetornandoUmaLista(T t) {
        return List.of(t);
    }

    // Para recebermos apenas objetos que sejam do tipo Comparable podemos fazer da seguinte forma
    private static <T extends Comparable<T>> List<T> criarArrayComUmObjetoComparableRetornandoUmaLista(T t) {
        return List.of(t);
    }
}
