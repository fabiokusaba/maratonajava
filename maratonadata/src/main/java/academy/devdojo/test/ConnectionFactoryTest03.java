package academy.devdojo.test;

import java.util.List;

import academy.devdojo.dominio.Producer;
import academy.devdojo.service.ProducerService;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Toei Animation").build();
        Producer producer2 = Producer.builder().name("White Fox").build();
        Producer producer3 = Producer.builder().name("Studio Ghibli").build();

        ProducerService.saveTransaction(List.of(producer1, producer2, producer3));
    }
}
