package pablo.tzeliks.view.helper;

public class MenuHelper {

    public static void menuMain() {

        System.out.println("""
                \n---------- MENU PRINCIPAL ----------
                1- Cadastrar contato
                2- Listar todos os contatos cadastrados
                3- Buscar contato por nome
                4- Atualizar dados de um contato.
                5- Remover contato
                
                0- Sair do sistema.
                """);

    }

    public static void menuCreateContact() {
        System.out.println("---------- MENU CADASTRAR CONTATO ----------");
    }

    public static void menuListAllContatct() {
        System.out.println("---------- MENU LISTAGEM CONTATOS ----------");
    }

    public static void menuUpdateContact() {
        System.out.println("---------- MENU EDITAR CONTATO ----------");
    }

    public static void menuConfirmContact() {
        System.out.println("---------- CONFIRMAR CONTATO ----------");
    }

}
