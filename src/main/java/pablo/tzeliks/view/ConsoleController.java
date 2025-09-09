package pablo.tzeliks.view;

import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.helper.MessageHelper;
import pablo.tzeliks.view.menu.*;

import java.util.Scanner;

public class ConsoleController {

    private final ContactService service;
    private final Scanner scanner;

    public ConsoleController(ContactService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int option;
        do {
            MenuHelper.menuMain();
            option = InputHelper.lerInteiro(scanner, "Insert an option: ");

            try {
                switch (option) {
                    case 1:
                        CreateContactView.execute(scanner, service);
                        break;
                    case 2:
                        UpdateContactView.execute(scanner, service);
                        break;
                    case 3:
                        DeleteContactView.execute(scanner, service);
                        break;
                    case 4:
                        SearchContactView.execute(scanner, service);
                        break;
                    case 5:
                        ListAllContactsView.execute(scanner, service);
                        break;
                    case 0:
                        System.out.println("Bye bye!");
                        break;
                    default:
                        MessageHelper.erro("Invalid Option!");
                }
            } catch (Exception e) {
                MessageHelper.erro("Error: " + e.getMessage());
            }

        } while (option != 0);

        scanner.close();
    }
}