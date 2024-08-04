package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Basicamente quando você está fazendo um sistema você precisa pensar em dois tipos de processamento: processamento
// síncrono e processamento assíncrono, processamento síncrono é bem direto você basicamente se olhar para os pacotes
// que estávamos utilizando até a parte de threads todos os processamentos são síncronos, ou seja, você tem uma thread
// executando as coisas do começo ao fim, mas aí existem problemas aonde você precisa executar coisas de forma assíncrona
// por exemplo, digamos que você tem uma telinha e nessa telinha você quer, por exemplo, checar a cotação do dólar o usuário
// clica lá checar cotação do dólar e se você estiver trabalhando de forma assíncrona significa que você tem uma thread pra
// gerenciar a tela, o botão, o clique, os eventos que estão acontecendo e a mesma thread vai ser usada pra você ir lá no
// servidor remoto e buscar aquela cotação do dólar, o problema é que quando você está utilizando programação síncrona você
// só tem essa thread você vai ter que bloquear a tela porque a thread responsável por fazer a requisição também é a thread
// responsável por gerenciar interface gráfica, então o que significa? Significa que essa thread está ocupada indo lá no
// servidor buscar esperando o resultado você não vai conseguir fazer nada na tela, então nesse tipo de caso você tem que
// utilizar a programação assíncrona, ou seja, você tem que criar uma thread pra ficar gerenciando, por exemplo, a interface
// do usuário e você também tem que criar uma outra thread pra você fazer outros tipos de coisas que não vão travar aquela
// tela
// Então, o Future é exatamente isso quando você fala, por exemplo, pro Callable olha executa essa tarefa aqui então a thread
// main que é a thread principal continua, mas aí o Future ele vai criar uma nova thread através do Executor e manda essa thread
// executar seja o Runnable ou o Callable e aí o main não fica bloqueado, mas aí nós vimos que temos que para o main se não o que
// acontece? Ele passa direto e chega uma hora que você precisa esperar o resultado, mas se nós estivéssemos em uma telinha a
// thread não ia acabar ela ia ficar sempre executando você não ia bloquear ela
public class FutureTest01 {
    public static void main(String[] args) {
        // Estou executando a nossa thread main que vai executar esse ExecutorService que vai criar um thread pool com uma thread
        // Em seguida nós temos o Future, ou seja, esse executorService vai submeter essa tarefa esse Callable vai ser executado
        // com a thread criada dentro do thread pool
        // Em seguida nós vamos falar para o nosso main fazer alguma coisa
        // Como estamos trabalhando com Executors temos que dar um shutdown

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Essa é a thread que vai fazer a execução, então eu tenho a thread main e essa thread main vai simular como se estivesse
        // indo no servidor remoto pegar a cotação do dólar e os 2s que nós vamos dormir é justamente para fazer essa simulação
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(15);
            return 4.35D;
        });

        System.out.println(doSomething());

        // Mas, aí nós temos um problema a gente não pegou a cotação do dólar, nós precisamos pegar a cotação do dólar e como a gente
        // pega? A gente já sabe que a gente precisa chamar o get
        // Mas, o que acontece, se por exemplo, a gente tiver aqui 15s? Aqui é um problema que você pode ver que é normal acontecer o
        // servidor meio que está fora do ar e o nosso programa está travado tem uma thread que vai ficar esperando por 15s nesse caso
        // poderia ser mais se o servidor estiver fora do ar e você não configurar um timeout e você vai ter a resposta
        // Então, quando você está trabalhando com requisição assíncrona geralmente você define um prazo você quer pegar, você quer
        // esperar, mas por quanto tempo? E é por isso que esse método é sobrecarregado você tenta 3s se não der em 3s o que vai acontecer?
        // Ele vai lançar uma exceção, então tem uma outra exceção nesse get sobrecarregado TimeoutException que caso ele não consiga pegar
        // simplesmente vai lançar essa exceção aí é de você tratar essa exceção
        // E é assim que funciona a programação assíncrona você tem uma thread geralmente a thread principal e você tem outras threads
        // executando outros tipos de tarefas tem que tomar muito cuidado pra você não bloquear o sistema todo quando você está utilizando
        // programação síncrona e você também tem que tomar cuidado pra você sempre colocar um timeout se não aquela thread pode ficar lá
        // esperando durante muito tempo
        // Só uma coisa programação assíncrona que estamos vendo aqui é diferente de ParallelStreams que a gente viu anteriormente, então
        // ParallelStreams é você está executando ao mesmo tempo se você tiver dois processadores é como se ele separasse a tarefa em duas
        // assíncrona, mas são dois núcleos executando paralelamente essa é a principal ideia do ParallelStreams, mas quando você está
        // utilizando programação assíncrona aqui com Callable você está utilizando na maior parte do tempo um núcleo e você está mantendo
        // aquele núcleo, digamos, em atividade porque quando você está trabalhando com processador você tem aqui a ociosidade e a atividade
        // do processador quando você está utilizando um núcleo, mas você está criando outras threads pra fazer outros tipos de trabalho você
        // está reaproveitando a potência daquele único núcleo pra você manter ele sempre ocupado, então ociosidade na verdade não é bom se
        // você conseguir manter ele o mais ocupado possível gerenciando os recursos melhor pra você
        Double dollarResponse = null;
        
        try {
            dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            // Nós colocamos esses 15s aí lançamos uma exceção, mas aí porque a gente não estava fazendo o tratamento da exceção esse shutdown ele
            // nunca é executado, a gente não está fazendo tratamento lançamos aqui no throws significa que esse cara nunca vai parar, qual o
            // código certo que você tem que fazer nesse caso? Você não lança o throws e utiliza o bloco try-catch
            executorService.shutdown();
        }

        System.out.println("Dollar: " + dollarResponse);
    }

    // Agora vamos simular como se a gente estivesse fazendo outra coisa
    private static long doSomething() {
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
