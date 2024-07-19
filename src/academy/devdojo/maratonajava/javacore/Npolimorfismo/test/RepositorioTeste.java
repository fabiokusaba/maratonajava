package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.repositorio.Repositorio;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.servico.RepositorioMemoria;

public class RepositorioTeste {
    public static void main(String[] args) {
        // Na programação orientada a interface ao invés de você colocar o tipo mais específico você coloca o tipo mais
        // genérico que no caso é o Repositorio
        // Como Repositorio é uma interface e tem o método salvar nós podemos colocar aqui qualquer um dos objetos que
        // fazem implementação do método salvar
        // Como você pode perceber estou trocando a implementação só trocando o objeto não precisei alterar
        // absolutamente mais nada
        // Você programar orientado a interfaces você está aumentando a manutenabilidade do seu código porque fica mais
        // fácil de você expandir, você não precisa ficar trocando a implementação específica
        Repositorio repositorio = new RepositorioMemoria();
        repositorio.salvar();
    }
}
