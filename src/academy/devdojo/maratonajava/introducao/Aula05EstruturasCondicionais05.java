package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais05 {
    public static void main(String[] args) {
        // Switch
        // Restrições -> os valores que você pode colocar são: char, int, byte, short, enum, String
        // Por padrão, quando o case bate com o valor que você tem dentro do switch ele irá executar o trecho de código
        // ali contido, se você não falar para ele continuará executando as linhas seguintes, por isso é comum em todos
        // os casos o uso da palavra break que vai permitir com que ele saia e não continue executando
        // Quando você utiliza o switch é comum a utilização de uma opção padrão denominada default, portanto em case de
        // nenhum case ser executado a opção padrão será executada
        byte dia = 5;
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

        char sexo = 'M';
        switch (sexo) {
            case 'M':
                System.out.println("Masculino");
                break;
            case 'F':
                System.out.println("Feminino");
                break;
            default:
                System.out.println("Inválido");
                break;
        }
    }
}
