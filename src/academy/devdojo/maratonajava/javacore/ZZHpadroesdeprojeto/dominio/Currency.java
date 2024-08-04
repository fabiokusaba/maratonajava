package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

// O padrão de projeto factory foi criado para você desacoplar a regra de negócio da criação do seu objeto da sua classe
// Por exemplo, digamos que a gente tenha aqui uma interface Currency e aqui dentro nós vamos ter apenas um método que
// vai ser o getSymbol
public interface Currency {
    String getSymbol();
}

// Para facilitar podemos criar aqui dentro algumas classes
// A gente tem duas classes implementando uma moeda e aí eu quero desacoplar, ou seja, eu quero criar uma moeda baseado
// por exemplo, no parâmetro e como a gente faz isso?
class Real implements Currency {
    @Override
    public String getSymbol() {
        return "R$";
    }
}

class UsDollar implements Currency {
    @Override
    public String getSymbol() {
        return "$";
    }
}