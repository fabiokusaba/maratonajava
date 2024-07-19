package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;

// Quando você tem herança a super classe daquela herança sempre precisa ser inicializada primeira, então o que for para
// ser inicializado da classe pai sempre vai ter a precedência a classe filha porque você precisa das coisas da classe
// pai primeiro
// O primeiro bloco de inicialização estático que é executado apenas uma vez é o da Pessoa, a JVM vai estar falando que
// vai carregar a classe Funcionario, mas Funcionario depende de Pessoa então a JVM vai carregar primeiro a Pessoa em
// seguida ele vai inicializar o bloco estático de Funcionario, finalizada a parte estática, nós precisamos do objeto em
// si por isso que vem dentro do bloco de incicialização de Pessoa 1 e 2 significa que depois que ele inicializou o
// estático do filho ele vai voltar lá pro pai e executar o que precisa ser executado que depende do objeto, nesse caso
// o bloco de inicialização ele depende do objeto por isso que ele é inicializado na ordem em que ele aparece no código
// depois que ele termina os blocos de inicialização ele vem para o construtor de Pessoa, só depois dele ter terminado
// de construir a Pessoa que ele desce para o bloco de inicialização do Funcionario e termina dentro do construtor de
// Funcionario, então o construtor de Funcionario que chamamos aqui na nossa classe de Test foi a última coisa a ser
// chamada
public class HerancaTest02 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Jiraya");
    }
}
