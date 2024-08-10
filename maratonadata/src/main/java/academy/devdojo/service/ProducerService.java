package academy.devdojo.service;

import academy.devdojo.dominio.Producer;
import academy.devdojo.repository.ProducerRepository;

import java.util.List;

// Essa nossa classe vai ter os metodos que a gente tem no repository, tipo uma camada, você está meio que utilizando
// MVC (Model, View, Controller) o nosso model é o Producer a nossa view seria o nosso ConnectionFactoryTest01 e
// podemos dizer que o nosso controller é o nosso service que vamos criar
// É uma camada a mais que você está dando como se fosse pra dividir a responsabilidade do sistema, então caso você faça
// alguma alteração aqui no nosso repositório você não precisa ir lá e alterar no caso na sua view porque você tem o
// service entre eles
public class ProducerService {
    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void delete(int id) {
        requireValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer) {
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static List<Producer> findAll() {
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName(String name) {
        return ProducerRepository.findByName(name);
    }

    public static void showProducerMetaData() {
        ProducerRepository.showProducerMetaData();
    }

    public static void showDriverMetaData() {
        ProducerRepository.showDriverMetaData();
    }

    public static void showTypeScrollWorking() {
        ProducerRepository.showTypeScrollWorking();
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        return ProducerRepository.findByNameAndInsertWhenNotFound(name);
    }

    public static void findByNameAndDelete(String name) {
        ProducerRepository.findByNameAndDelete(name);
    }

    private static void requireValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
    }
}
