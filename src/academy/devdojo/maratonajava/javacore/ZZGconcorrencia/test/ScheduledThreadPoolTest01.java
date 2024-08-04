package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Por que a gente tem esse ScheduledThreadPool? Você provavelmente já deve ter pensando como é que eu faço pra executar
// uma determinada tarefa a cada 5s, ou como é que eu faço para executar uma tarefa para daqui a um dia, como é que eu
// faço para executar uma tarefa uma vez por dia, então se você já se perguntou esse tipo de coisa esse é o seu melhor
// amigo
public class ScheduledThreadPoolTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Esse método vai imprimir beep a cada determinado tempo que eu passar
    private static void beeper() {
        // Primeiramente nós precisamos de um run, run é uma tarefa que vai imprimir o beep
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");

            // Colocando o Runnable para dormir por 5s
            // Quando você está utilizando o scheduledFixedDelay quando você colocou para dormir por 3s logo depois que
            // a thread acorda ela vai ver opa passou 3s eu preciso já executar essa minha tarefa, então basicamente é
            // contínuo ele sempre vai contar 5s
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Mas, aí vem aquele negócio quando que eu quero executar essa tarefa? E aí que entra o Scheduled
        // Chamo meu executor e falo que quero executar o Runnable e eu quero que execute depois de 5 segundos
        // executor.schedule(r, 5, TimeUnit.SECONDS);

        // Por que o programa não parou? Lembre-se nós temos que dar o shutdown ainda continua sendo um Executor se você
        // não der o shutdown ele simplesmente não vai parar

        // Você tem o scheduledWithFixedDelay basicamente você fala o que você quer executar o comando o Runnable r, o início
        // então, por exemplo, eu quero que comece logo agora passou 1s você comece a contar e a cada 5s depois você continua
        // executando
        // E como você faria para parar esse cara aqui que vai ficar executando de 5 em 5 segundos para sempre? Bom, você pode
        // chamar um Scheduled pra parar ele, digamos assim eu quero parar esse Scheduled então você vai criar um Scheduled para
        // parar um Scheduled
        // Você precisa de um objeto de referência desse cara, então você pode adicionar uma variável aqui
        // ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);

        // Você tem um outro cara que é um pouquinho diferente que é o scheduleAtFixedRate que vai executar a cada 5s, então se
        // você colocou pra dormir por 3s quando ele acordar mais 2s depois ele vai ver opa eu preciso imprimir porque passou 5s
        // se você colocar para dormir por 5s ele vai continuar fazendo exatamente o que falei, por exemplo, se ele dormiu por 5s
        // quando ele acordar opa já passou 5s preciso imprimir, então ele sempre vai contar esse tempo continuamente, está fixo
        // Agora o que a gente estava falando scheduleWithFixedDelay esse aqui é o contrário do momento que a thread acorda ele
        // começa a contar, então por exemplo, se a thread dormiu em 49s ela vai acordar em 54s e a partir daqui ele vai contar
        // mais 5s e dar o resultado de 59s
        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);

        // É possível você criar um Runnable diretamente aqui através de um lambda
        // Esse construtor tem o delay, então digamos que eu quero executar esse cara o shutdown depois de 10s
        // O schedule precisa de um Runnable e de um delay
        executor.schedule(() -> {
            // O que eu quero fazer? Eu quero parar quando esse Scheduled iniciar ele vai dar um trigger nesse Runnable
            System.out.println("Cancelando o scheduledWithFixedDelay");

            // Criei essa variável porque preciso chamar ela e falar cancela, aqui você tem um construtor deve interromper se
            // estiver rodando? Nesse caso não, eu quero que pelo menos termine dos beep antes de interromper
            scheduleWithFixedDelay.cancel(false);

            executor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
