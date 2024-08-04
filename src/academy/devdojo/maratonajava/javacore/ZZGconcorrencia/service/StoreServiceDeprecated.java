package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// Imagine que esse StoreServiceDeprecated você só tem uma opção que é você utilizar o getPricesSync, basicamente
// você não tem a opção de fazer ele de forma assíncrona
public class StoreServiceDeprecated {
    public double getPriceSync(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return priceGenerator();
    }

    private double priceGenerator() {
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
