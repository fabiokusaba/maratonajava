package academy.devdojo.crud.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {
    @Test
    void instanceOf_ExecutesChildClassMethod_WhenObjectIsOfChildType() {
        Employee employeeDeveloper = new Developer("1", "Java");

        // Se eu quiser executar getMainLanguage que pertence ao Developer eu tenho que verificar se o objeto é um
        // Developer

        // Forma antiga de verificação
        if (employeeDeveloper instanceof Developer) {
            Developer developer = (Developer) employeeDeveloper;
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }

        // Forma nova de verificação - Pattern Matching for instanceof
        // Basicamente é isso você dá uma variável aqui no if e caso esse cara retorne true ele vai retornar diretamente
        // para a nossa variável o objeto
        if (employeeDeveloper instanceof Developer developer) {
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }

}