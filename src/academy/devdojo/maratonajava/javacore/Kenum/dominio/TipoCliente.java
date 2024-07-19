package academy.devdojo.maratonajava.javacore.Kenum.dominio;

// Enumeração -> tipo especial de classe aonde todos os atributos que nós vamos criar é constante
// Você utiliza enumeração quando você tem uma escolha dentro de uma quantidade limitada de opções e você precisa forçar
// o tipo a ser utilizado
// Nós podemos também criar atributos dentro de uma enumeração
// Quando você está criando uma enumeração você basicamente está chamando um construtor
public enum TipoCliente {
    // Atributos
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    // Uma vez que você associa o VALOR não precisa mais alterar
    public final int VALOR;
    private String nomeRelatorio;

    // O construtor é privado, apenas a enumeração que chama o construtor
    TipoCliente(int valor, String nomeRelatorio) {
        this.VALOR = valor;
        this.nomeRelatorio = nomeRelatorio;
    }

    // Retornando um TipoCliente através do atributo nomeRelatorio
    public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio) {
        for (TipoCliente tipoCliente : values()) {
            if (tipoCliente.getNomeRelatorio().equals(nomeRelatorio)) {
                return tipoCliente;
            }
        }
        return null;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }
}
