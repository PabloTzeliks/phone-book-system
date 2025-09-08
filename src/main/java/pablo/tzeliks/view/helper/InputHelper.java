package pablo.tzeliks.view.helper;

import pablo.tzeliks.model.Contact;

import java.util.Scanner;

public class InputHelper {

    public static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                MessageHelper.erro("Valor inválido, tente novamente.");
            }
        }
    }

    public static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                MessageHelper.erro("Valor inválido, tente novamente.");
            }
        }
    }

    public static String lerString(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public static boolean acceptChange(Scanner scanner, Contact contact) {

        MenuHelper.menuConfirmContact();

        ContactPrinter.printContact(contact);

        System.out.println("\n1- Confirmar" +
                "\n0- Cancelar");

        String input = scanner.nextLine();

        try {
            if (input.equals("1")) {
                return true;
            } else if (input.equals("0")) {
                return false;
            }
        } catch (NumberFormatException e) {
            MessageHelper.erro("Valor inválido, tente novamente.");
        }
        return false;
    }

}
