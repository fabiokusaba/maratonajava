package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {
        // Existem casos onde um método vai lançar mais de uma exceção
        // Para tratar esse cara é muito simples, basta você colocar múltiplos catch
        // Se eu lançar uma exceção o Java vai tentar dar um match, procurar qual dessas exceções ele consegue fazer
        // a associação com a variável de referência, então aqui entra de novo o polimorfismo
        // Aqui nós temos algumas regrinhas a primeira regra que nós temos é que nós não podemos colocar um tipo mais
        // genérico a frente dos outros catch porque quando você tem a RuntimeException você tem o tipo mais genérico
        // todas as demais são filhas diretas de RuntimeException significa que qualquer uma dessas exceções podem ser
        // referenciadas por um objeto da classe RuntimeException pela regra do polimorfismo, ou seja, se eu colocar
        // a RuntimeException aqui em cima o que vai acontecer é que nenhuma das exceções vão ser executadas, essas
        // exceções se tornaram unreachable porque independente da exceção que eu lançar aqui que é do tipo Runtime
        // esse código nunca vai ser executado porque ela vai ser capturada pelo primeiro catch que é o mais genérico
        // por isso, você precisa tomar cuidado, exceções mais genéricas sempre precisam vir no final
        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Dentro do IndexOutOfBoundsException");
        } catch (IllegalArgumentException e) {
            System.out.println("Dentro do IllegalArgumentException");
        } catch (ArithmeticException e) {
            System.out.println("Dentro do ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println("Dentro do RuntimeException");
        }

//        try {
//            talvezLanceException();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // Você pode colocar exceções que não estão na mesma linha de herança dentro de um mesmo catch separados via
        // pipe
        // Cuidado que você não pode fazer isso quando você tem classes na mesma linha de herança
        // Na verdade tudo se resume ao tipo de tratamento que você quer dar para aquela exceção, então quando você tem
        // um multi catch existe a possibilidade de você ter diferentes tipos de tratamento para as exceções que estão
        // acontecendo
        try {
            talvezLanceException();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
