package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    // Java toda vez que você quiser comparar dois objetos do tipo Smartphone você precisa levar em consideração o
    // serial number dele e não a referência
    // Para isso como nós sabemos todos os objetos eles obrigatoriamente são um Object significa que nós temos acesso a
    // sobrescrita do método equals

    // Existe algumas regrinhas que você precisa seguir no método equals
    // Reflexivo: o método equals tem que ser reflexivo significa que x.equals(x) tem que ser true para tudo que for
    // diferente de null
    // Simétrico: significa que para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true
    // Transitividade: para x, y, z diferentes de null, se x.equals(y) == true, e x.equals(z) == true logo, y.equals(z)
    // também tem que ser igual a true
    // Consistente: independente de quantas vezes você chamar x.equals(x) ele sempre tem que retornar true se x for
    // diferente de null
    // Para x diferente de null, x.equals(null) tem que retornar false
    @Override
    public boolean equals(Object obj) {
        // Basicamente a primeira coisa que você precisa fazer é verificar se o objeto é null, se o objeto que você está
        // passando é null, que você recebe como argumento é null obviamente nós temos que retornar falso
        // Lembre-se o equals sempre vai ser executado a partir de um objeto, ou seja, o this sempre vai existir, então
        // o this e o Object são dos dois valores que você tem que comparar
        if (obj == null) return false;

        // Em seguida nós temos que verificar se temos dois objetos iguais porque se tem dois objetos e está trabalhando
        // com o mesmo objeto em memória é claro que vai ser true
        if (this == obj) return true;

        // Nós temos como parâmetro um Object, mas nós precisamos verificar se esse objeto faz parte do Smartphone, ou
        // seja, é um Smartphone, se não for impossível serem iguais, não estamos trabalhando com os mesmos objetos
        if (this.getClass() != obj.getClass()) return false;

        // Quando chegamos nessa linha temos a certeza que o objeto é um Smartphone, então podemos criar um cast para
        // pegar esse objeto
        Smartphone smartphone = (Smartphone) obj;

        // E agora vem o que nós queremos comparar, agora sim é a comparação que vai falar que esse objeto que nós
        // temos aqui this e esse objeto que nós estamos recebendo como argumento são iguais, no nosso caso queremos
        // que o serial number seja o valor atribuído para essa comparação
        // Primeiramente nós temos que verificar se o serialNumber é diferente de null, e o serialNumber.equals, ou seja
        // estou chamando o equals de uma String, o equals da String compara dois valores literais
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    // hashCode assim como equals foi definido na classe Object
    // native significa que isso daqui é um código que foi escrito em uma outra linguagem que não é Java
    // O que precisamos lembrar dessa aula é que o hashCode é um número que será gerado, de preferência, esse número
    // tem que ser único para os objetos, mas se tiver um ou dois repetidos não tem muito problema, mas quanto mais
    // específico for para cada um dos objetos que você tem é melhor porque a performance vai ser mais alta e quando
    // você está implementando hashCode ele tem que dar um match no equals, no equals se você está usando serialNumber
    // para verificar se dois objetos são iguais no hashCode você também tem que utilizar o serialNumber para gerar o
    // número hash

    // Porém, tem algumas regrinhas pra gente implementar nesse hashCode
    // Se você tiver x.equals(y) == true, y.hashCode() tem que ser igual a x.hashCode(), então basicamente se você fala
    // que o hashCode se x for igual a y significa que y.hashCode e x.hashCode tem que ser a mesma coisa
    // A segunda regra é y.hashCode() == x.hashCode() não necessariamente o equals de y.equals(x) tem que ser true,
    // significa que se você tem y.hashCode igual a x.hashCode não significa que y.equals(x) tem que retornar a mesma
    // coisa
    // x.equals(y) == false o hashCode tem que ser diferente
    // y.hashCode() != x.hashCode(), x.equals(y) deverá ser false
    @Override
    public int hashCode() {
        // Se a gente está utilizando o nosso serialNumber pra representar o nosso equals para dizer se dois objetos são
        // iguais, eu posso fazer a mesma coisa aqui
        // Uma última coisa que você precisa tomar cuidado que é você verificar se o serialNumber é null, caso ele seja
        // null nós vamos ter um NullPointerException nessa linha, nesse caso podemos usar um operador ternário
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
