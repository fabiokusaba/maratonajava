package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

// Podemos criar uma classe e chamá-la de CurrencyFactory aqui dentro nós vamos ter um método e esse método nós vamos
// chamar de newCurrency que vai criar um Currency, vai ser um método estático, queremos criar a moeda baseada no país
// então, para criar a moeda nós vamos precisar de um Country
// Qual é a regra? Para quem está chamando o que vou fazer aqui dentro não importa o que importa é que ele vai ter uma
// moeda baseado no país que ele passar
public class CurrencyFactory {
    public static Currency newCurrency(Country country) {
        switch (country) {
            case BRAZIL:
                return new Real();
            case USA:
                return new UsDollar();
            default: throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
