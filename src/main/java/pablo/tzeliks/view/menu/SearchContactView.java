package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Contact;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.ContactPrinter;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;

import java.util.Scanner;

public class SearchContactView {

    public static void execute(Scanner sc, ContactService service) {

        MenuHelper.menuSearchContact();

        String input = sc.nextLine();

        while (true) {

            switch (input) {

                case "0":
                    return;
                case "1":
                    pesquisarPorNome(sc, service);
                    break;
                case "2":
                    pesquisarPorEmail(sc, service);
                    break;
                case "3":
                    pesquisarPorId(sc, service);
                    break;
                default:
                    MessageHelper.erro("Invalid input");

            }
        }
    }

    private static void pesquisarPorNome(Scanner sc, ContactService service) {

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

    private static void pesquisarPorEmail(Scanner sc, ContactService service) {

        System.out.println("Digite o Email do contato: ");
        String emailInput = sc.nextLine();

        try {

            Contact contact = service.findByEmail(emailInput);

            if (contact == null) {
                MessageHelper.erro("Not found contact, by email: " + emailInput);
            } else {
                ContactPrinter.printContact(contact);
            }

        } catch (Exception e) {
            MessageHelper.erro("An error occured when Searching Contact, by email. " + emailInput + "\n" + e.getMessage());
        }

    }

    private static void pesquisarPorId(Scanner sc, ContactService service) {

        System.out.println("Digite o ID do contato: ");
        long idInput = sc.nextLong();

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
