package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        // Temos duas variáveis do tipo reference que estão fazendo referência a um objeto diferente em memória
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();

        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante01.nome = "Midoriya";
        estudante01.idade = 15;
        estudante01.sexo = 'M';

        estudante02.nome = "Sakura";
        estudante02.idade = 16;
        estudante02.sexo = 'F';

        // O que essa linha está falando é que estudante(método) vai fazer referência ao mesmo objeto que estudante01
        // (argumento) está fazendo
        // Neste caso, temos duas variáveis de referência fazendo referência para o mesmo objeto
        // O que precisamos lembrar é que quando passamos objetos como argumento você na verdade está passando a
        // referência, ou seja, aonde aquele objeto está guardado
        impressora.imprime(estudante01);
        impressora.imprime(estudante02);

        System.out.println("#########");

        // Lembre-se como você não perdeu os objetos em memória o que acontece é que o estudante(método) está alterando
        // os estados do objeto e o estado desse objeto vai ficar alterado
        // O que precisamos saber é que quando você altera algo dentro do objeto você está mantendo essa alteração para
        // as outras referências que ainda tem a ligação com aquele objeto
        impressora.imprime(estudante01);
        impressora.imprime(estudante02);
    }
}
