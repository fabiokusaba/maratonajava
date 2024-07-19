package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        // Lembre-se a variável de referência é como se fosse um controle remoto então ele pode ter alguns botões
        // imagina que tem o botão chamado nome, idade e sexo e esses são os botões que essa variável consegue chamar
        // Quando eu chamar estudante01.nome quem executa vai ser sempre o objeto nunca é a variável de referência que
        // executa
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();

        estudante01.nome = "Midoriya";
        estudante01.idade = 15;
        estudante01.sexo = 'M';

        estudante02.nome = "Sakura";
        estudante02.idade = 16;
        estudante02.sexo = 'F';

        // Quando eu mandar estudante01.imprime estou mandando um sinal para o meu objeto, o imprime irá executar e
        // dentro dele estou falando que eu quero o contexto desse objeto representado por this
        estudante01.imprime();
        estudante02.imprime();
    }
}
