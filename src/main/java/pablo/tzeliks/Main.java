package pablo.tzeliks;

import pablo.tzeliks.dao.ContactDAOImpl;
import pablo.tzeliks.service.ContactService;
import pablo.tzeliks.view.ConsoleController;

public class Main {

    public static void main(String[] args) {

        ContactService service = new ContactService(new ContactDAOImpl());
        ConsoleController controller = new ConsoleController(service);

        controller.iniciar();

    }

}