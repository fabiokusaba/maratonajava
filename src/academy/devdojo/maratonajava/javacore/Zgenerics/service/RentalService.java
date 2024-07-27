package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;

import java.util.List;

// Você poẽ o <T> e esse T quer dizer tipo (type), quando você tiver trabalhando com coleções normalmente você vai ver
// <E> que quer dizer os elementos que você coloca dentro daquela coleção
public class RentalService<T> {
    // Para deixar genérico o que eu tenho que fazer é trocar o tipo do objeto que estou trabalhando, ou seja, eu só
    // vou saber quem vai ser esse cara quando eu compilar o meu código e é aí que vem a parte genérica
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel() {
        System.out.println("Buscando objeto disponível...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponíveis para alugar:");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t) {
        System.out.println("Devolvendo objeto " + t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponíveis para alugar:");
        System.out.println(objetosDisponiveis);
    }
}
