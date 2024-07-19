package academy.devdojo.maratonajava.javacore.Oexception.exception.dominio;

// Existem casos que o Java não vai te proporcionar a exceção que você quer e você quer fazer um tratamento específico
// por exemplo, digamos que você quer lançar uma exceção caso o login e a senha estejam incorretos que é uma exceção
// que geralmente varia de sistema para sistema
// Para criar uma exceção customizada basta você criar uma classe e dar um nome para essa classe, geralmente elas
// terminam com o nome Exception, e aí a gente escolhe qual é a exceção que a gente quer extender, você quer extender
// uma exceção do tipo checked ou uma exceção do tipo unchecked, é uma exceção que você vai forçar as pessoas a fazerem
// tratamento ou é uma exceção que você não vai forçar
// Nesse caso vou forçar as pessoas a fazerem o tratamento, portanto vou extender de Exception e quando você extende de
// Exception só isso já significa que você tem a sua própria exceção customizada, mas podemos sobrecarregar
public class LoginInvalidoException extends Exception {
    public LoginInvalidoException() {
        super("Login invalido");
    }

    public LoginInvalidoException(String message) {
        super(message);
    }
}
