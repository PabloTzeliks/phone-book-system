package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.valueobjects.Email;
import pablo.tzeliks.model.valueobjects.PhoneNumber;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateContactView {

    public static void execute(Scanner sc, ContactService service) {

        MenuHelper.menuCreateContact();

        System.out.println("Digite o nome do contato: ");
        String name = sc.nextLine();

        System.out.println("Digite o telefone do contato: ");
        String phonenumber = sc.nextLine();

        System.out.println("Digite o email do contato: ");
        String email = sc.nextLine();

        System.out.println("Digite o observação do contato: ");
        String observation = sc.nextLine();

        try {

            service.createContact(name, new PhoneNumber(phonenumber), new Email(email), observation);

        } catch (Exception e) {
            MessageHelper.erro("An error occurred while trying to create the contact, info: " + e.getMessage());
        }
    }

}
