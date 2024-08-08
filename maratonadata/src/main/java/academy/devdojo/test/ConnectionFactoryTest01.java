package academy.devdojo.test;

import academy.devdojo.dominio.Producer;
import academy.devdojo.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        Producer producer = Producer.builder().name("Studio Deen").build();
//        ProducerRepository.save(producer);

        // Cada log contém um tipo diferente de informações, então por exemplo log.debug
        // Lembre-se quando você coloca a sua aplicação em produção você geralmente não tem muito acesso você só tem
        // acesso aos dados que estão aparecendo no log
        // log.debug você geralmente não coloca em produção porque às vezes contém dados sensitivos
        // log.info você pode colocar geralmente são informações, por exemplo ah entrou no metodo, executando ação tal
        // Cada um dos tipos de log warn, error e trace tem o seu uso
        log.info("INFO");
        log.debug("DEBUG");
        log.warn("WARNING");
        log.error("ERROR");
        log.trace("TRACE");
    }
}
