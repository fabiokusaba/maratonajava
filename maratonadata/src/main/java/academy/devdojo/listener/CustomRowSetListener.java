package academy.devdojo.listener;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

import lombok.extern.log4j.Log4j2;

// Mas, aí tem um pequeno ponto que nós temos uma vantagem que não tínhamos com o ResultSet lembra quando a gente
// estava trabalhando com ResultSet e o ResultSet do Type Scrollable o que a gente tinha que se preocupar quando
// estávamos utilizando esse Type Scrollable? A gente tinha que se preocupar caso a gente precisasse voltar a gente
// teria que tomar cuidado porque ele não é atualizado automaticamente, então basicamente ele não reflete as mudanças
// que você faz no banco de dados você teria que voltar pra primeira linha ou pra linha que você alterou e assim continuar
// alterando os dados com o JdbcRowSet a gente pode criar um listener e o que é um listener? Listener é uma classe que
// fica escutando por mudanças 

// RowSetListener é uma interface que vai obrigar a gente a implementar alguns métodos aqui, mas o que isso significa?
// Significa que cada vez que tiver uma determinada ação esses métodos vão ser acionados por causa do polimorfismo que
// ele tem que passar esse objeto para o nosso JdbcRowSet

// A gente tem agora o nosso listener, o listener é um RowSetListener tem que ser por causa do polimorfismo aí tem três
// métodos que vão ser chamados automaticamente quando o RowSet fizer alguma coisa
@Log4j2
public class CustomRowSetListener implements RowSetListener {

    @Override
    public void rowSetChanged(RowSetEvent event) {
        log.info("Command execute triggered");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        log.info("Row inserted, updated or deleted");

        // A gente pode dar um trigger na query novamente para isso:
        if (event.getSource() instanceof RowSet) {
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        log.info("Cursor moved");
    }

}
