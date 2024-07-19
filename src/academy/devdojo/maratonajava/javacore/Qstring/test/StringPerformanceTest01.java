package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformanceTest01 {
    public static void main(String[] args) {
        // A performance das Strings conforme você vai aumentando o tamanho da quantidade de Strings no seu sistema,
        // digamos Strings únicas, a performance vai diminuindo você precisa de cada vez mais tempo para você executar
        // as ações
        // Quando você está trabalhando com um sistema você está fazendo um mapeamento das regras de negócio que você
        // tem no mundo real, essa regra de negócio do mundo real é o que vai dizer se realmente você precisa utilizar
        // StringBuffer ou StringBuilder em vez de String, a maioria das vezes você sempre vai trabalhar com String, o
        // mapeamento do mundo real para o mundo computacional sempre vai requerer Strings
        long inicio = System.currentTimeMillis();
        concatString(30_000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatStringBuilder(100_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatStringBuffer(100_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuffer " + (fim - inicio) + " ms");
    }

    private static void concatString(int tamanho) {
        String texto = "";
        for (int i = 0; i < tamanho; i++) {
            // As Strings elas são imutáveis então cada uma das iterações desse for vai criar uma nova String no pool
            // de Strings
            texto += i;
        }
    }

    private static void concatStringBuilder(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }

    // Para quando você trabalha em ambientes com a acesso a múltiplas threads ao mesmo recurso e quando você faz isso
    // existe a possibilidade de você ter dados inconsistentes
    private static void concatStringBuffer(int tamanho) {
        StringBuffer sb = new StringBuffer(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
}
