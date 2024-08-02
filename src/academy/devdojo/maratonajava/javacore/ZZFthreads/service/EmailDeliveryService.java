package academy.devdojo.maratonajava.javacore.ZZFthreads.service;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Members;

// Esse cara vai ser responsável por enviar os emails
public class EmailDeliveryService implements Runnable {
    // Se ele vai trabalhar com emails a gente precisa aqui de Members
    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting to deliver emails...");

        // Aí vem a lógica vou verificar ele só pode enviar emails se tiver aberto ou a lista for maior do que zero
        while (members.isOpen() || members.pendingEmails() > 0) {
            try {
                // A gente precisa pegar o email
                // Quando a gente executar esse código, imagine que vai ser a primeira vez, ele vai entrar dentro do
                // retrieveEmail e vai checar se tem algum email, entra no sincronizado o email vai ser zero o size vai
                // ser zero ele vai ver que ainda está aberto e vai esperar, esse é o caso aonde ela esperaria
                String email = members.retrieveEmail();

                // Mas, se ela não esperar? A gente tem que verificar, se esse cara for nulo vou dar um continue e a
                // única razão de eu criar esse continue é porque eu quero que ele volte no while e quando ele entrar
                // nesse retrieveEmail ele vai continuar esperando lá porque não vai ter nada
                if (email == null) continue;

                System.out.println(threadName + " enviando email para " + email);

                Thread.sleep(2000);

                System.out.println(threadName + " enviou email com sucesso para " + email);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Todos os emails foram enviados com sucesso!");
    }
}
