package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

// Como nós vimos existem algumas classes que chamamos de Thread Safe, por exemplo, nós temos uma classe que é a
// StringBuffer e a diferença que falamos entre StringBuffer e StringBuilder é que essa classe StringBuffer é Thread
// Safe
// E o que significa uma classe ser Thread Safe? Os métodos que nós temos para acesso dessa classe são métodos
// sincronizados

import java.util.ArrayList;
import java.util.List;

// O que a gente está vendo que está acontecendo aqui? A nossa coleção ela é thread-safe, mas quando você está
// trabalhando com classes que são thread-safe você precisa olhar o nível acima, então no nosso caso aqui nós criamos
// uma classe que está trabalhando com essa coleção que é thread-safe, mas os métodos que estão acima não são
// thread-safe, então por exemplo, names.remove é thread-safe, mas aqui esse método que vai fazer essa checagem
// removeFirst não é thread-safe, então eu posso e vou ter mais de uma Thread acessando esse código mais de uma vez
// Então, quando você fala que uma classe é thread-safe a classe em si é os métodos são, mas se você tiver algum método
// acima que está fazendo algum tipo de operação você precisa sincronizar aquele método também, para ser completamente
// thread-safe você poderia fazer isso aqui: colocar synchronized nos métodos, dessa forma o nosso names não precisamos
// mais colocar Collections.synchronizedList porque agora sim o nosso names vai ser thread-safe porque quando você
// for adicionar é thread-safe e quando você for remover o primeiro também é thread-safe como não tenho nem o get e nem
// o set eu não posso acessar diretamente esse names, ele não existe então tudo o que tenho para acessar essa variável
// names está sincronizado
// Como você pode ver agora a nossa classe é thread-safe porque todos os métodos que vão acessar o objeto que pertence
// a essa classe são sincronizados
class ThreadSafeNames {
    // Esse é um método que vai retornar uma lista thread-safe
    private final List<String> names = new ArrayList<>();

    // Ao invés de eu acessar diretamente names.add eu estou fazendo uma camada de abstração em cima
    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void removeFirst() {
        // Estou verificando se o tamanho é maior que zero o que significa que sempre eu vou ter pelo menos uma posição
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

public class ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Junkrat");

        // Utilizando programação funcional com lambdas
        Runnable r = threadSafeNames::removeFirst;

        // Agora que temos o Runnable precisamos passar ele para uma Thread porque o Runnable não tem o start
        // Ao executarmos nós temos uma exceção diretamente no nosso método como você pode ver, as duas Threads
        // entraram dentro do código, ou seja, uma verificou e a outra entrou aqui imprimiu e parou, a outra verificou
        // imprimiu também aí deu continuidade na Thread que removeu e a outra quando foi tentar remover deu uma exceção
        // IndexOutOfBoundsException, mas nem sempre isso pode acontecer pode ser que em algum momento ele passe
        new Thread(r).start();
        new Thread(r).start();
    }
}
