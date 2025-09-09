package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Contact;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.ContactPrinter;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ListAllContactsView {

    public static void execute(Scanner sc, ContactService service) {

        MenuHelper.menuListAllContatct();

        try {
            List<Contact> contacts = service.getAllContacts();

            ContactPrinter.printList(contacts);

        } catch (SQLException e) {
            MessageHelper.erro("An error occurred while trying to list all contacts, info: " + e.getMessage());
        }
    }
}