package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

// Quando nós estamos trabalhando com interfaces que criam métodos abstratos por padrão a gente não utiliza mais o
// extends, quando você tiver trabalhando com interface você utiliza implements e o nome da interface
// Uma das vantagens da interface é que você pode prover implementação para múltiplas interfaces de uma mesma classe
// Como você pode ver não existe limite para quantidade de interface que você pode implementar em uma classe, ao
// contrário de classes que quando você está trabalhando com a extensão você não pode extender mais de uma classe
// porém quando você está trabalhando com interfaces você pode fazer a implementação de múltiplas interfaces
// Como você pode ver uma das vantagens e uma das diferenças entre classes abstratas e interfaces é que as interfaces
// você pode ter uma mesma classe fazendo implementação de várias delas
// Bom, agora uma das outras diferenças e que foi introduzido no Java 8 é o fato de interfaces poder ter métodos com
// implementação
public class DatabaseLoader implements DataLoader, DataRemover {
    // Como o método load é um método abstrato você é obrigado a prover a implementação daquele método
    // Você precisa tomar cuidado quanto aos modificadores de acesso e as regras da sobrescrita, então nós falamos que
    // quando você está sobrescrevendo você não pode colocar o modificador de acesso mais restritivo, por padrão os
    // métodos em uma interface são públicos
    // As regras são -> você tem um modificador de acesso mais restritivo para o mais liberal:
    // private -> default ou modificador de acesso de pacote -> protected -> public que é o mais liberal de todos, ou
    // seja, o menos restritivo
    @Override
    public void load() {
        System.out.println("Carregando dados do Banco de Dados");
    }

    @Override
    public void remove() {
        System.out.println("Removendo do Banco de Dados");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões no Banco de Dados");
    }

    public static void retrieveMaxDataSize() {
        System.out.println("Dentro do retrieveMaxDataSize na classe DatabaseLoader");
    }
}
