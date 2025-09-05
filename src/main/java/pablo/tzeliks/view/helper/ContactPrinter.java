package pablo.tzeliks.view.helper;

import pablo.tzeliks.model.Contact;

import java.util.List;
import java.util.Locale;

public class ContatcPrinter {

    public static void printList(List<Contact> list) {

        System.out.println();
        System.out.println("---- Contatos ----");
        for (Contact dto : list) {
            imprimirEquipamento(dto);
            System.out.println("----------------------");
        }
    }

    public static void imprimirEquipamento(Contact contact) {

        if (contact == null) {
            MessageHelper.erro("Contact null");
            return;
        }

        System.out.println("ID: " + contact.getId());
        System.out.println("Nome: " + contact.getName());
        System.out.println("Número de Telefone: " + contact.getPhoneNumber());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Observation: " + contact.getObservation());
    }

}
