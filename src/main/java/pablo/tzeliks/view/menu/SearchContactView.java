package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Contact;
import pablo.tzeliks.model.valueobjects.Email;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.ContactPrinter;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;

import java.util.Scanner;

public class SearchContactView {

    public static void execute(Scanner sc, ContactService service) {

        while (true) {

            MenuHelper.menuSearchContact();
            String input = sc.nextLine();

            switch (input) {

                case "0":
                    return;
                case "1":
                    searchName(sc, service);
                    break;
                case "2":
                    searchEmail(sc, service);
                    break;
                case "3":
                    searchId(sc, service);
                    break;
                default:
                    MessageHelper.erro("Invalid input");
            }
        }
    }

    private static void searchName(Scanner sc, ContactService service) {

        System.out.println("Digite o Nome do contato: ");
        String nameInput = sc.nextLine();

        try {

            Contact contact = service.findByName(nameInput);

            if (contact == null) {
                MessageHelper.erro("Not found contact, by name: " + nameInput);
            } else {
                ContactPrinter.printContact(contact);
            }

        } catch (Exception e) {
            MessageHelper.erro("An error occured when Searching Contact, by name. " + nameInput + "\n" + e.getMessage());
        }
    }

    private static void searchEmail(Scanner sc, ContactService service) {

        System.out.println("Digite o Email do contato: ");
        String emailInput = sc.nextLine();

        try {

            Email email = new Email(emailInput);

            Contact contact = service.findByEmail(email);

            if (contact == null) {
                MessageHelper.erro("Not found contact, by email: " + email.getValue());
            } else {
                ContactPrinter.printContact(contact);
            }

        } catch (Exception e) {
            MessageHelper.erro("An error occured when Searching Contact, by email. " + emailInput + "\n" + e.getMessage());
        }
    }

    private static void searchId(Scanner sc, ContactService service) {

        System.out.println("Digite o ID do contato: ");
        long idInput = Long.parseLong(sc.nextLine().trim());

        try {

            Contact contact = service.findById(idInput);

            if (contact == null) {
                MessageHelper.erro("Not found contact, by ID: " + idInput);
            } else {
                ContactPrinter.printContact(contact);
            }

        } catch (Exception e) {
            MessageHelper.erro("An error occured when Searching Contact, by ID. " + idInput + "\n" + e.getMessage());
        }
    }
}