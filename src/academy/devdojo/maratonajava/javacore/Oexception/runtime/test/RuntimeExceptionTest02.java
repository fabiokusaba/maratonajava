package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

// Você utiliza throw new quando você quer lançar uma exceção e geralmente na maioria das vezes vai ser uma exceção do
// tipo Runtime, mas ele também pode ser uma exceção filha direta de Exception(exceção do tipo checked), quando você
// está trabalhando com throw new e é do tipo Runtime não existe necessidade de você colocar na assinatura do método
// um aviso pra quem está chamando falando que esse método está lançando uma exceção, mas é obrigatório quando as
// exceções são do tipo checked, ou seja, as exceções são filhas de Exception, e você faz isso para proteger o seu
// código é uma programação defensiva que você deve sempre praticar
public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        System.out.println(divisao(1, 0));
    }

    private static int divisao(int a, int b) {
        // Eu sei que não pode ter divisão por zero, então se uma pessoa mandar uma divisão por zero a gente tem que
        // mandar uma exceção
        // Quando fazemos isso o código abaixo do if não vai ser executado a não ser que esse cara seja falso, desta
        // forma não precisamos mais do uso do try-catch e apenas retornarmos a divisão de a por b
        if (b == 0) {
            // Lançando uma nova exceção, aqui sempre é bom usar as exceções mais específicas possíveis porque quando
            // uma outra pessoa estiver utilizando o seu código ela vai facilmente entender o que está acontecendo
            // Sempre que você fizer alguma validação você pode lançar alguma exceção
            throw new IllegalArgumentException("Argumento ilegal, não pode ser zero");
        }
        return a / b;

//        try {
//            return a / b;
//        } catch (RuntimeException e) {
//            // Nesse nosso exemplo nós podemos usar ArithmeticException ou fazer uso do polimorfismo e colocar aqui
//            // RuntimeException e como RuntimeException é uma super classe de ArithmeticException a regra de
//            // polimorfismo vai ser aplicada aqui, então e vai fazer referência a um objeto do tipo ArithmeticException
//            e.printStackTrace();
//        }
//        return 0;
    }
}
