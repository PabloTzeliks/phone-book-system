package pablo.tzeliks.view.menu;

import pablo.tzeliks.exception.ContactNotFoundException;
import pablo.tzeliks.model.Contact;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;

import java.util.Scanner;

public class DeleteContactView {

    public static void execute(Scanner sc, ContactService service) {

        MenuHelper.menuRemoveContact();

        System.out.println("Digite o ID do Contato que deseja remover: ");
        int id = sc.nextInt();

        sc.nextLine();

        try {

            Contact contact = service.findById(id);

            boolean acceptContact = InputHelper.acceptChange(sc, contact);

            if (acceptContact) {

                service.deleteContact(contact);
            }

        } catch (ContactNotFoundException e) {
            MessageHelper.erro("An error occurred while trying to delete the contact, info: " + e.getMessage());
        }
    }
}