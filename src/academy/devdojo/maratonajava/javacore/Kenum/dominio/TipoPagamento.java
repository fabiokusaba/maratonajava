package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoPagamento {
    DEBITO {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.1;
        }
    }, CREDITO {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.05;
        }
    };

    // Temos que definir um desconto atrelado a essas enumerações
    // O certo quando você quer criar um método e o método em si não vai ter comportamento, o comportamento vai ser
    // decidido pelas classes, pelas enumerações que vão sobrescrever, nesse caso o corpo do método é inútil, então
    // você precisa tirar o corpo colocar ponto e vírgula e falar que esse método é abstrato, ele em si não existe o
    // que existe é a implementação do método calcularDesconto dentro das enumerações DEBITO e CREDITO
    public abstract double calcularDesconto(double valor);
}
