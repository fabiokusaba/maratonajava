package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        // Criar um objeto do tipo Pessoa
        // Você tem uma variável de referência do tipo Estudante e para você criar objetos você sempre vai precisar
        // utilizar a palavra new em seguida o nome do objeto que você quer criar
        Estudante estudante = new Estudante();

        // Colocando valores dentro dos atributos
        // Imagine a variável de referência como um controle remoto quando falamos estudante.nome significa dizer que
        // vou estar acessando o espaço em memória que contém esse atributo nome
        // Então aqui estou falando que o espaço em memória que a variável estudante está fazendo referência, ou seja,
        // esse espaço maior em memória Estudante, .nome que é o espaço menor que está dentro recebe um determinado
        // valor, o mesmo equivale para os demais atributos
        // A nossa variável de referência estudante sabe da existência do nosso objeto Estudante e dentro desse objeto
        // estou utilizando os espaços menores para criar variáveis, associar os valores aos atributos que são as
        // características do meu Estudante
        estudante.nome = "Luffy";
        estudante.idade = 21;
        estudante.sexo = 'M';

        // Imprimindo
        // Quando você for imprimir primeiramente vá na variável de referência estudante que está fazendo referência
        // para um objeto e pega o que estiver dentro de estudante.nome e vai repetir o mesmo processo para os demais
        // Se você imprimir somente a variável de referência estudante você vai ter apenas o endereço de memória porque
        // elá é uma variável do tipo reference
        System.out.println(estudante.nome);
        System.out.println(estudante.idade);
        System.out.println(estudante.sexo);
        System.out.println(estudante);
    }
}
