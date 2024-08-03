package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import javax.swing.*;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Members;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.EmailDeliveryService;

public class EmailDevileryTest01 {
    public static void main(String[] args) {
        Members members = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");

        jiraya.start();
        kakashi.start();

        while (true) {
            String email = JOptionPane.showInputDialog("Entre com o seu email");
            if (email == null || email.isEmpty()) {
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
