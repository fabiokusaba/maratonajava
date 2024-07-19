package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        // Aqui a gente começa a ter problema com acoplamento, acoplamento é o quão uma classe está conectada com
        // outra e no nosso caso a nossa Pessoa e PessoaTest01 elas estão extremamente conectadas porque estou acessando
        // os meus objetos de forma pública
        // Uma das formas de você garantir um baixo acoplamento é você utilizar modificadores de acesso privado
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jiraya");
        pessoa.setIdade(70);
//        pessoa.imprime();
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
    }
}
