package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Discount;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Quote;

public class StoreServiceWithDiscount {
    public String getPriceSync(String storeName) {
        double price = priceGenerator();
        Discount.Code discountCode = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", storeName, price, discountCode);
    }

    public String applyDiscount(Quote quote) {
        delay();
        double discountValue = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage()) / 100;
        return String.format("'%s' original price: '%.2f'. Applying discount code '%s'. Final price: '%.2f'", 
            quote.getStore(), 
            quote.getPrice(), 
            quote.getDiscountCode(), 
            discountValue);
    }

    private double priceGenerator() {
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    private void delay() {
        try {
            // Primeiro vamos simular um caso mais real, qual é o caso mais real? O serviço com desconto está tendo o
            // delay de 1s para todos e isso não é o que acontece no mundo real, no mundo real vocẽ iria ter um delay
            // digamos dinâmico você pode ter uma loja responsendo em 100ms, uma loja respondendo em 1s, 2s, outra loja
            // lançando uma exceção, então vamos fazer o seguinte
            int milli = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
