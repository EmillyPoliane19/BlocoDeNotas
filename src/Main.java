import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("Bloco de Notas");
        while (escolha != SAIR) {
            System.out.println(opcoes());
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case ADICIONAR:
                    System.out.println("Informe a anotação:");
                    String novaAnotacao = sc.nextLine();
                    Anotacao adicionar = new Anotacao(novaAnotacao);
                    anotacao.adicionarAnotacao(adicionar);
                    break;

                case BUSCAR:
                    System.out.println("Informe o texto que deseja pesquisar:");
                    String texto = sc.nextLine();
                    anotacao.buscarAnotacao(texto);
                    break;

                case EDITAR:
                    System.out.println("Informe o Id da anotação que deseja editar:");
                    int idEditar = sc.nextInt();
                    anotacao.editarAnotacao(idEditar);
                    break;

                case LISTAR:
                    anotacao.listarPorOrdem();
                    break;

                case REMOVER:
                    System.out.println("Informe o Id da anotação que deseja excluir da lista de busca:");
                    int idRemover = sc.nextInt();
                    anotacao.deletarDaBusca(idRemover);
                    break;

                case EXCLUIR:
                    System.out.println("Informe o ID da anotação que deseja excluir do bloco de notas:");
                    int idExcluir = sc.nextInt();
                    anotacao.deletarAnotacao(idExcluir);
                    break;
                case SAIR:
                    break;
            }
        }
    }
    private static String opcoes () {
        return "\nDigite uma das opções:\n" + "1 - Adiciona Anotação\n" +
                "2 - Buscar Anotações\n" + "3 - Editar Anotação\n" +
                "4 - Exibir Anotações\n" + "5 - Remover Anotação da lista de busca\n" +
                "6 - Remover Anotação\n" + "7 - Sair do bloco de notas";
    }
}
