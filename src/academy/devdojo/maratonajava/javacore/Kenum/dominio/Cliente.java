package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public class Cliente {
    // É possível criar uma enumeração dentro de uma classe
//    public enum TipoPagamento {
//        DEBITO, CREDITO
//    }

    private String nome;

    // É uma relação tem um -> o meu cliente tem um TipoCliente
    // Agora, aqui eu tenho total segurança que o TipoCliente vai ser PESSOA_FISICA ou PESSOA_JURIDICA por causa do
    // atributo que nós temos disponível dentro da enumeração
    private TipoCliente tipoCliente;

    // Relacionamento em que Cliente tem um TipoPagamento
    private TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipoCliente=" + tipoCliente.getNomeRelatorio() +
                ", tipoClienteInt=" + tipoCliente.VALOR +
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }
}
