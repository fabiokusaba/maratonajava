package academy.devdojo.maratonajava.javacore.ZZFthreads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

// Essa classe vai ser a responsável por ter a lista de emails
public class Members {
    // Como vamos sempre mandar um email na ordem vamos utilizar Queue, podemos usar a versão thread-safe que é o
    // ArrayBlockingQueue, porém você tem que passar a capacidade
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);

    // Chave para abrir e fechar a classe para receber ou não emails
    private boolean open = true;

    // Método para verificar se está aberto
    public boolean isOpen() {
        return open;
    }

    // Vai retornar o size se nós temos algum email ainda esperando para ser enviado, porém lembre-se apesar da lista
    // ser sincronizada nós precisamos sincronizar a camada que está acima nesse caso aqui vou sincronizar o objeto
    // emails significa que duas Threads não podem acessar ao mesmo tempo esse objeto
    public int pendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    // Método para adicionar emails
    // Sempre sincronizando o objeto
    public void addMemberEmail(String email) {
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);

            // Nós estamos adicionando, lembra que eu falei pra vocês que nós vamos ter outras Threads esperando então
            // a gente precisa notificar essas Threads
            // Ou seja, se você adicionou você precisa falar para aquela galera que estava esperando acordar e como você
            // faz isso? Utilizando o notifyAll para avisar todas as Threads
            this.emails.notifyAll();
        }
    }

    // Método que vai pegar os emails
    // Basicamente quem chamar esse método vai checar se está tendo email
    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");

        // Novamente sincronizando o objeto
        synchronized (this.emails) {
            // Aí é que vem a lógica de negócio porque se não tiver emails eu não quero que esse método pare, ou seja,
            // se o tamanho for igual a zero eu quero que as Threads fiquem esperando
            while (this.emails.size() == 0) {
                // Se não estiver aberto eu quero que você saia desse while
                if (!open) return null;

                // Mas, se for igual a zero
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");

                // Tem duas coisas que você precisa tomar cuidado: primeiro que quando você chama o wait você precisa
                // tratar a exceção InterruptedException, segundo você só pode chamar o wait se você tiver o lock do
                // objeto porque você não pode esperar se você não tiver o lock, ou seja, nesse caso aqui todas as vezes
                // que você for chamar wait você tem que estar obrigatoriamente dentro de um bloco sincronizado
                // E aí o que estou falando é que essa Thread agora vai ficar esperando até ela ser notificada
                this.emails.wait();
            }

            // Caso não seja zero a gente tem que retornar o email, eu quero retornar sempre o primeiro poll
            // ele retorna e retira
            return this.emails.poll();
        }
    }

    // Nós precisamos agora fechar a lista caso você queira
    // Na verdade pra você utilizar o notifyAll você também precisa estar no contexto sincronizado
    public void close() {
        open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando emails");
        }
    }
}
