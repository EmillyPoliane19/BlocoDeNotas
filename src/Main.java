import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BlocoDeNotas anotacao = new BlocoDeNotas();

        final int ADICIONAR = 1;
        final int BUSCAR = 2;
        final int EDITAR = 3;
        final int LISTAR = 4;
        final int REMOVER = 5;
        final int EXCLUIR = 6;
        final int SAIR = 7;

        int escolha = 0;

        System.out.print("Bloco de Notas");
        while (escolha != SAIR) {
            opcoes();
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case ADICIONAR:
                    System.out.println("Informe a anotação:");
                    try {
                        anotacao.adicionarAnotacao(recebeAnotacao(sc)); // Possivel Exceção valor nulo
                    }
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Informe a anotação:");
                        anotacao.adicionarAnotacao(recebeAnotacao(sc));
                    }
                    break;

                case BUSCAR:
                    System.out.println("Informe o texto que deseja pesquisar:");
                    try {
                        anotacao.buscarAnotacao(recebeTexto(sc)); // Possivel Exceção valor nulo
                    }
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Informe o texto que deseja pesquisar:");
                        anotacao.buscarAnotacao(recebeTexto(sc));
                    }
                    break;

                case EDITAR:
                    System.out.println("Informe o Id da anotação que deseja editar:");
                    int id = recebeId(sc);
                    try {
                        anotacao.editarAnotacao(id); // Possivel Exceção valor negativo
                    }
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Informe o Id da anotação que deseja editar:");
                        anotacao.editarAnotacao(recebeId(sc));
                    }
                    break;

                case LISTAR:
                    anotacao.listarPorOrdem();
                    break;

                case REMOVER:
                    System.out.println("Informe o Id da anotação que deseja excluir da lista de busca:");
                    id = recebeId(sc);
                    try {
                        anotacao.deletarDaBusca(id); // Possivel Exceção valor negativo
                    }
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Informe o Id da anotação que deseja excluir da lista de busca:");
                        anotacao.deletarDaBusca(recebeId(sc));
                    }
                    break;

                case EXCLUIR:
                    System.out.println("Informe o ID da anotação que deseja excluir do bloco de notas:");
                    id = recebeId(sc);
                    try {
                        anotacao.deletarAnotacao(id); // Possivel Exceção valor negativo
                    }
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Informe o ID da anotação que deseja excluir do bloco de notas:");
                        anotacao.deletarAnotacao(recebeId(sc));
                    }
                    break;

                case SAIR:
                    break;
            }
        }
        sc.close();
    }
    private static void opcoes () { //Menu
        System.out.println("\nDigite uma das opções:\n" + "1 - Adiciona Anotação");
        System.out.println("2 - Buscar Anotações\n" + "3 - Editar Anotação");
        System.out.println("4 - Exibir Anotações\n" + "5 - Remover Anotação da lista de busca");
        System.out.println("6 - Remover Anotação\n" + "7 - Sair do bloco de notas");
    }

    private static Anotacao recebeAnotacao(Scanner sc) throws Exception { //Método para receber uma anotação
        String texto = sc.nextLine();
        Anotacao adicionar = new Anotacao(texto);
        return adicionar;
    }
    private static String recebeTexto(Scanner sc) { //Método para receber um texto
        String texto = sc.nextLine();
        return texto;
    }
    private static int recebeId(Scanner sc) throws Exception {//Método para receber um Id
        if (!sc.hasNextInt()) {
            throw new Exception("Não pode usar letras.");
        }
        int id = sc.nextInt();
        return id;
    }
}
