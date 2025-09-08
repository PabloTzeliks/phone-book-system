package pablo.tzeliks.view.menu;

import pablo.tzeliks.exception.ContactNotFoundException;
import pablo.tzeliks.model.Contact;
import pablo.tzeliks.model.valueobjects.Email;
import pablo.tzeliks.model.valueobjects.PhoneNumber;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;

import java.util.Scanner;

public class UpdateContactView {

    public static void execute(Scanner sc, ContactService service) {

        MenuHelper.menuUpdateContact();

        System.out.println("Digite o ID do Contato que deseja editar: ");
        int id = sc.nextInt();

        try {

            Contact contact = service.findById(id);

            boolean acceptContact = InputHelper.acceptChange(sc, contact);

            if (acceptContact) {

                System.out.println("Digite o novo Nome: ");
                String newName = sc.nextLine();
                contact.setName(newName);

                System.out.println("Digite o novo Número de Telefone: ");
                String newPhoneNumber = sc.nextLine();
                PhoneNumber phoneNumber = new PhoneNumber(newPhoneNumber);
                contact.setPhoneNumber(phoneNumber);

                System.out.println("Digite o novo Email: ");
                String newEmail = sc.nextLine();
                Email email = new Email(newEmail);
                contact.setEmail(email);

                System.out.println("Digite a novo Observação: ");
                String newObservation = sc.nextLine();
                contact.setObservation(newObservation);

                service.updateContact(contact);

                // Lógica Provisória
            }

        } catch (ContactNotFoundException e) {
            MessageHelper.erro("An error occurred while trying to update the contact, info: " + e.getMessage());
        }

    }

}
