package pablo.tzeliks.view.helper;

public class MenuHelper {

    public static void menuMain() {

        System.out.println("""
                \n---------- MENU PRINCIPAL ----------
                1- Cadastrar Contato
                2- Atualizar dados de um Contato
                3- Remover Contato
                4- Busca de Contatos
                5- Listar Contatos
                
                0- Sair do sistema.
                """);

    }

    public static void menuCreateContact() {
        System.out.println("---------- MENU CADASTRAR CONTATO ----------");
    }

    public static void menuUpdateContact() {
        System.out.println("---------- MENU EDITAR CONTATO ----------");
    }

    public static void menuRemoveContact() {
        System.out.println("---------- MENU REMOVER CONTATO ----------");
    }

    public static void menuSearchContact() {
        System.out.println("---------- MENU PESQUISAR CONTATOS ----------\n");
        System.out.println("\n- Pesquisar por Nome");
        System.out.println("\n2- Pesquisar por Email");
        System.out.println("\n3- Pesquisar por ID\n");
        System.out.println("\n0- Voltar");
    }

    public static void menuListAllContatct() {
        System.out.println("---------- MENU LISTAGEM CONTATOS ----------");
    }

    public static void menuConfirmContact() {
        System.out.println("---------- CONFIRMAR CONTATO ----------");
    }

}
