package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        // Criando um objeto
        // Variável de referência cria um link para o nosso objeto e a partir de agora conseguimos acessar esse espaço
        // em memória
        // Quando você tem uma variável do tipo reference os objetos que essa variável está fazendo referência se tiver
        // um atributo dentro não precisam ser necessariamente inicializados, você pode inicializar também
        Estudante estudante = new Estudante();
        Estudante estudante2 = new Estudante();

        // Imprimindo
        // Quando você cria um atributo diretamente numa classe como estamos fazendo em Estudante nós temos os valores
        // de inicialização padrão aplicados a ele então você pode utilizar mesmo que não tenha sido inicializado,
        // porém é claro que se você tentar utilizar o nome, tentar fazer alguma coisa com ele, você vai ter uma exceção
        // porque não tem nenhum objeto sendo referenciado aqui na variável de referência nome que é do tipo String
        estudante.nome = "Sanji";
        System.out.println(estudante.idade);
        System.out.println(estudante.sexo);
        System.out.println(estudante.nome);
        System.out.println("--------------");
        System.out.println(estudante2.idade);
        System.out.println(estudante2.sexo);
        System.out.println(estudante2.nome);
    }
}
