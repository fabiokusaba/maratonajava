package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Estávamos trabalhando com threads da forma mais baixa possível nós vimos uma forma de você trabalhar
// mais alto nível fazendo o lock das threads sem utilizar o synchronized, mas no final das contas tudo
// o que estávamos fazendo com threads era bem baixo nível e tem um pequeno problema imagina assim você
// está criando uma thread pra trabalhar numa requisição de usuário todas as vezes que entra o nome dele
// você quer iniciar essa thread para trabalhar de forma concorrente, mas o que acontece se, por exmeplo,
// você tiver 1000 usuários? Você vai estar criando 1000 threads e no final das contas você pode ter um
// sério problema no seu sistema operacional porque quando você cria thread você cria um objeto e você
// precisa de memória, você precisa de processamento, você precisa levar em consideração tudo aquilo que
// envolve a criação de um objeto
// Então, pensando nesse problema o pessoal do Java criou tipo um frameworkzinho esse Executors ele tem
// um único objetivo que é você desacoplar a submissão de tarefas da execução, por exemplo, digamos que
// você quer trabalhar com número fixo de threads quer trabalhar com 8 threads independente do que você
// tem no seu código a quantidade de tarefas você quer sempre trabalhar com 8, com 4 ou você quer, por
// exemplo, que cresça exponencialmente ilimitadamente, então esse framework ele vai tomar conta pra você

// Uma classe bem simples uma classe Printer que vai imprimir um número onde a gente tem o início e quando
// a thread finalizou
class Printer implements Runnable {
    private final int num;
    
    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s iniciou: %d%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finalizou%n", Thread.currentThread().getName());
    }

}

public class ExecutorsTest01 {
    public static void main(String[] args) {
        // Eu quero definir uma certa quantidade de threads com Executors nós temos vários métodos que vão
        // criar um pool de threads
        // Bom, o FixedThreadPool como o nome já diz vai criar um pool de threads fixo, geralmente quando você
        // está trabalhando o processador ele tem o número de núcleos, dependendo do processdor que você está
        // utilizando o número de threads é o dobro do número de núcleos, tecnicamente eu tenho a possibilidade
        // de trabalhar com 16 threads como se fosse assim eu tenho 16 cabeças pensando em paralelo, se eu colocar
        // 32 eu tenho 16 meio que real e o resto vão ser virtuais, mas não é bem assim que funciona por causa que
        // ainda tem o sistema operacional que está usando uma caralhada de threads, não é uma matemática muito precisa
        // System.out.println(Runtime.getRuntime().availableProcessors());

        // Mas, vou falar que eu quero começar com 4 threads e esse cara retorna um ExecutorService pra gente, então eu
        // falei que ele desacopla a submissão das tarefas com a execução e como é que isso funciona? Funciona da seguinte
        // forma agora antes a gente criava o Runnable e dava o start, mas digamos que você não queira fazer desse jeito que
        // você queira ter um pouco mais de flexibilidade quando deveria iniciar porque quando dá start já era não tem mais o
        // que fazer agora a gente está delegando essa responsabilidade para essa API Executors
        // ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Se você não quiser criar um número fixo de threads quais são as outras opções?
        // As outras opções são: você utilizar uma thread
        // ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Ou a outra opção: seria você utilizar CachedThreadPool basicamente ele vai criar threads as needed, ou seja, conforme
        // você vai precisando, mas ele vai reutilizar as threads quando elas estão disponíveis e depois de 60s as threads vão
        // ser removidas do cache
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Vou falar executa e o que eu preciso executar? Preciso executar um Runnable no nosso caso o Printer
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));

        // Como você pode ver temos um pool de threads thread 1, 2, 3 e 4, você pode ver que as threads começaram e as threads
        // finalizaram e o programa não para enquanto não desligarmos ele, mas como você pode ver temos 4 threads
        // O que acontece se eu iniciar 6? Então estou iniciando 6 Runnables, mas meu FixedThreadPool tem apenas 4 threads
        executorService.execute(new Printer(5));
        executorService.execute(new Printer(6));

        // Você pode ver que nós temos as 4 executando, as 4 entraram no modo sleep aí quando uma finalizou você já pode ver que a
        // thread 1 tinha pegado o valor 1 agora a thread 1 pegou o valor 5 e assim por diante, então como você pode ver o número
        // não troca estou trabalhando com 4 threads poderia estar colocando 500 Printers aqui que o número de threads ia continuar
        // com 4, isso é ótimo porque você não precisa se preocupar se você está trabalhando com algo escalável digamos a quantidade
        // de usuários que pode acessar o seu sistema você está com um número fixo de threads ali que não vai mudar
        // E como você faz para parar o ExecutorService? Você tem esse shutdown, mas o shutdown não significa que no momento em que ele
        // executar ele simplesmente vai desligar então, por exemplo, você poderia imprimir alguma coisa falando o programa foi finalizado
        // Mas, o que que vai acontecer? Você tem a thread main que vai executar linha a linha, quando a main falar ExecutorService agora
        // você pode desligar o problema é que essas threads ainda vão estar em execução, então você vai ver o println primeiro antes de
        // finalizar
        // E quando realmente ele parar todas as threads você pode ver que o programa ele é finalizado
        executorService.shutdown();
        System.out.println("Programa finalizado");
    }

}
