package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.test;

import academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
//        Carro c1 = new Carro("BMW", 280);
//        Carro c2 = new Carro("Mercedes", 275);
//        Carro c3 = new Carro("Audi", 290);

        // Desta forma, você está falando que todas as instâncias de Carro vão ter agora o valor associado ao limite de
        // como 180, não estou acessando mais através de uma variável de referência, estou acessando agora através do
        // nome da classe então fica claro que você está alterando algo que vai afetar todos os objetos em existência
        // daquela classe
        // E uma coisa interessante é que como velocidadeLimite pertence agora a classe e não mais a uma instância eu
        // posso remover, não existe a necessidade de você ter nenhum objeto, independente de você ter ou não uma
        // instância esse código vai funcionar porque ele pertence a classe
        System.out.println(Carro.getVelocidadeLimite());
        Carro.setVelocidadeLimite(180);
        System.out.println(Carro.getVelocidadeLimite());

//        c1.imprime();
//        c2.imprime();
//        c3.imprime();
    }
}
