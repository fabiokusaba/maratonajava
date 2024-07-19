package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais02 {
    public static void main(String[] args) {
        // idade < 15 -> categoria infantil
        // idade >= 15 && idade < 18 -> categoria juvenil
        // idade >= 18 -> categoria adulto
        // Todas as variáveis que estão dentro de métodos elas tem o que chamamos de escopo local, todas as variáveis
        // de escopo local tem que obrigatoriamente serem inicializadas antes que você tente executá-las, se você não
        // completar essa condição você tem um erro de compilação
        int idade = 17;
        String categoria;

        if (idade < 15) {
            categoria = "Categoria Infantil";
        } else if (idade >= 15 && idade < 18) {
            categoria = "Categoria Juvenil";
        } else {
            categoria = "Categoria Adulto";
        }
        System.out.println(categoria);
    }
}
