package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

// Como vocês já sabem existem opções para gente criar coleções que elas são, digamos
// próprias para concorrência, por exemplo, você utilizando unmodifiable ou synchronizaed
// porém, existe uma outra forma também que é você utilizar a coleção CopyOnWriteArrayList
// Importante você entender como funciona o conceito de imutabilidade no Java geralmente
// quando você está trabalhando com classes que tem acesso por múltiplas threads você dê
// preferência tenta trabalhar com objetos imutáveis
// O que é objeto imutável? Se você tiver uma classe geralmente se você está trabalhando com
// imutabilidade a classe é final significa que ninguém pode extender ninguém pode alterar os
// atributos sem a permissão
// A primeira parte de criar uma classe imutável é fazer ela final, porém uma classe imutável
// você tem que remover toda e qualquer forma de acesso pra trocar os atributos

final class Anime {
    // Digamos que se você tiver aqui
    // Então, o certo é você criar esse atributo como final
    private final String name;

    // Você criar um construtor aonde você adiciona o nome
    public Anime(String name) {
        this.name = name;
    }

    // E caso você queira pegar o nome você só adiciona um getter
    public String getName() {
        return name;
    }

    // Então, dessa forma você tem uma classe que é final o atributo que nós temos é final e
    // você só dá acesso a leitura
    // A única forma de você trocar os valores desse objeto é você literalmente criando um novo
    // objeto, então isso é um objeto imutável
    // Se você tiver várias threads trabalhando as threads vão ter que criar o próprio objeto e
    // tecnicamente o seu objeto vai ficar se você tiver outras threads trabalhando ao mesmo tempo
    // vão ficar seguros

    // E você criar o get e o set essa classe já não é mais imutável porque uma vez criado o
    // objeto você pode vir aqui e setar o nome, ou seja, se você tem dez threads setando o
    // nome você vai alterar o mesmo objeto
    // Imutabilidade é você uma vez que o objeto foi criado você simplesmente não pode mais
    // alterar absolutamente nada daquele objeto
    // Se você tem um Anime e você tem um Anime que é imutável se você quer trocar o nome você
    // tem que criar um novo objeto com o novo nome

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }
}

public class CopyOnWriteTest01 {
    public static void main(String[] args) {
        // Mas, o nosso foco aqui é a CopyOnWrite que basicamente é uma lista "imutável"
        // A ideia desse cara é justamente você trabalhar com uma lista imutável, mas a
        // lista em si é imutável como? 
        // Se você trocar aqui por ArrayList o comportamento é o mesmo porque é como o Iterator
        // vai se comportar, então ele mantém meio que uma cópia no momento da criação mesmo ele
        // removendo os 500 uma outra thread nós temos aqui ainda os valores
        List<Integer> list = new CopyOnWriteArrayList<>();

        // Imagine que você tem a lista e você adicione 1, o que acontece se você adicionar 2?
        // Ele vai copiar o valor, ou seja, a lista original o valor está intacto e ele vai criar
        // uma nova lista com o valor [1, 2], se você quiser adicionar 3 ele vai criar um novo objeto
        // uma nova lista vai copiar os valores [1, 2] e adicionar o 3 [1, 2, 3]
        // Quer remover? Beleza, vai copiar esse [1, 2, 3], porém removendo o 3, então você vai ter uma
        // nova lista com o valor [1, 2], não é a mesma você está sempre criando uma nova lista
        // Bom, não preciso dizer que a performance desse cara se você precisar ficar inserindo toda hora
        // e tirando vai dar problema porque vai ter um certo impacto na memória
        // E ela não é totalmente thread-safe porque estou trabalhando com inteiros, mas se nós tivéssemos
        // um Anime e esse Anime não fosse imutável o que que ia acontecer? Você poderia trocar o valor de
        // memória, então o nome do Anime você poderia chegar lá e trocar o nome e várias threads acessando
        // já ferrou toda a sua aplicação
        // Então, a lista em si é imutável o tamanho, adiciona, remove, mas você tem que tomar cuidado quando
        // você está adicionando atributos que sejam objeto dentro dessa lista, tenha certeza que eles também
        // são imutáveis

        // Para simplificar vamos adicionar 2000 valores nessa lista
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }

        // Criando dois Runnable
        // E por que vou utilizar Iterator? Iterator é interessante porque ele mantém uma cópia pro valor original
        // no momento da criação daquele Iterator
        Runnable runnableIterator = () -> {
            Iterator<Integer> iterator = list.iterator();

            // Colocando para dormir por 2s de uma maneira diferente
            try {
                TimeUnit.SECONDS.sleep(2);

                // Depois que ela dormir eu quero imprimir esses valores, então vou imprimir de uma forma diferente
                // sem utilizar o while
                iterator.forEachRemaining(System.out::println);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnableRemover = () -> {
            // Esse remover vai ser simples vou criar um for até 500 e vou remover
            for (int i = 0; i < 500; i++) {
                System.out.printf("%s removed %d%n", Thread.currentThread().getName(), i);
            }
        };

        // Vou iniciar duas threads do runnableIterator, mas quando elas forem iniciadas elas vão dormir por 2s
        new Thread(runnableIterator).start();
        new Thread(runnableIterator).start();

        // Enquanto elas estão dormindo vou pegar o runnableRemover e vou iniciar também e ele vai remover 500
        // posições dessa lista de 2000
        // Então, estou criando uma lista com 2000 posições estou iniciando esses caras runnableIterator que é para
        // imprimir essas 2000 posições, mas eu vou antes delas acordarem vou remover 500 posições no momento em que
        // ele executar isso aqui list.iterator ele vai guardar o valor 2000, mas depois uma outra thread vai remover
        // os valores
        new Thread(runnableRemover).start();
    }
}
