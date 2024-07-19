package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        // Criando os objetos -> variável de referência e a instância
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        // Inicializando os valores do objeto
        carro1.nome = "Fusca Bala";
        carro1.modelo = "Sport";
        carro1.ano = 1969;

        carro2.nome = "Mustang";
        carro2.modelo = "GT 500";
        carro2.ano = 1968;

        // Referência de objetos -> nesse trecho de código estou falando que o carro1 faz referência para o mesmo
        // objeto que carro2 está fazendo, você só pode fazer isso quando você tem objetos do mesmo tipo, da mesma
        // linha de herança
        carro1 = carro2;

        // Imprimindo os valores
        System.out.println("Carro 1");
        System.out.println(carro1.nome);
        System.out.println(carro1.modelo);
        System.out.println(carro1.ano);

        System.out.println("\nCarro 2");
        System.out.println(carro2.nome);
        System.out.println(carro2.modelo);
        System.out.println(carro2.ano);
    }
}
