package pablo.tzeliks.view.helper;

import pablo.tzeliks.model.Contact;

import java.util.List;

public class ContactPrinter {

    public static void printList(List<Contact> list) {

        System.out.println();
        System.out.println("---- Contatos ----");
        for (Contact contact : list) {
            printContact(contact);
            System.out.println("----------------------");
        }
    }

    public static void printContact(Contact contact) {

        if (contact == null) {
            MessageHelper.erro("Contact null");
            return;
        }

        System.out.println("ID: " + contact.getId());
        System.out.println("Nome: " + contact.getName());
        System.out.println("Número de Telefone: " + contact.getPhoneNumber().getPhoneNumber());
        System.out.println("Email: " + contact.getEmail().getValue());
        System.out.println("Observação: " + contact.getObservation());
    }

}
