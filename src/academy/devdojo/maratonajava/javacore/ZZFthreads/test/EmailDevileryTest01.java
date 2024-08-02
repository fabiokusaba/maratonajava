package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Members;
import academy.devdojo.maratonajava.javacore.ZZFthreads.service.EmailDeliveryService;

import javax.swing.*;

// Lembrando que você precisa ter esses caras wait, notify e notifyAll dentro de um synchronized porque eles precisam
// ter o lock na mão
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
