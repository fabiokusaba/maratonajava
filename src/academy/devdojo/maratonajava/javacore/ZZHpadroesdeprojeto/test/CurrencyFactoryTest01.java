package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;


import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;

// Como você pode ver ele está criando uma nova moeda e eu não faço ideia que moeda é essa no sentido de como essa moeda
// está sendo criada, não importa pra mim o que importa pra mim é que essa moeda vai ser criada
// Então, você está desacoplando e qual a vantagem disso? A vantagem é que, se por exemplo, você mudar a regra de
// negócio você não afeta, então quando você está trabalhando com construtor e você precisa adicionar alguma coisa nele
// você está na verdade tendo que alterar ou sobrecarregar, mas por exemplo, você tem uma regra de negócio aqui que você
// precisa fazer aqui dentro que geralmente não é bom fazer no construtor pra quem está chamando não importa porque no
// fim das contas ele vai pegar um Currency
// É um padrão de projeto que é muito utilizado ele ajuda bastante a você manter um baixo acoplamento no seu código
// facilitando a manutenção
public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
