package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

// Variáveis do tipo primitivo -> variáveis que guardam valores simples
// Orientação a objeto -> a sua função é mapear o mundo real para o mundo computacional, então começamos a partir do
// princípio que as coisas podem ser agrupadas
// Esse agrupamento de dados que temos aqui é um objeto onde nós temos diferentes dados sendo guardados dentro de um
// único espaço em memória, dentro dele está organizado em diferentes espacinhos, mas todos eles estão relacionados ao
// mesmo objeto
// Essa é a principal diferença entre variáveis do tipo primitivo e variáveis do tipo reference(objeto)
// Classe -> é o que nós temos em Java para representar algo do mundo real com funcionalidades em comum, agrupamento de
// coisas do mundo real que vão dar origem a objetos
// Classes de domínio -> representam o mapeamento do mundo real

public class Estudante {
    // Atributos, características dessa classe
    // Quando colocamos dentro da classe a inicialização todos os objetos que estou criando já estou dando um valor
    public String nome = "Zoro";
    public int idade;
    public char sexo;
}
