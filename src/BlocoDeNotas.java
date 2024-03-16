import java.util.*;
// Adicionar novas anotações, editar anotações existentes, realizar a deleção lógica de anotações
// Buscar anotações a partir de um texto de busca e listar todas as anotações pela ordem.
public class BlocoDeNotas {
    List<Anotacao> listaDeAnotacoes; // Lista
    public BlocoDeNotas() { //Construtor
        this.listaDeAnotacoes = new ArrayList<>();
    }

    public void adicionarAnotacao (Anotacao texto) throws Exception{ //Adiciona anotação
        listaDeAnotacoes.add(texto);
        System.out.println("Anotação salva.");
    }

    public void editarAnotacao (int id) throws Exception{ //Edita anotação
        Scanner sc = new Scanner(System.in);
        boolean idEncontrado = false;
        if (id < 0) {
            throw new Exception("Não é possível pesquisar um id negativo"); //Exceção para valor nulo
        }
        for (Anotacao texto : listaDeAnotacoes) {
            if (id == texto.getId()) {
                idEncontrado = true;
                System.out.println("Id encontrado! Informe o novo texto:");
                String textoEditar = sc.nextLine();
                texto.setTexto(textoEditar);
                System.out.println("O texto da anotação " + id + " foi editado com sucesso!");
                sc.nextLine();
            }
        }
        if (!idEncontrado) {
            System.out.println("O ID " + id + " não foi encontrado!");
        }
        sc.close();
    }
    public void buscarAnotacao(String texto) throws Exception { //Busca anotação por texto
        List <Anotacao> listaOrdenada = new ArrayList<>();
        if (texto == null || texto.isEmpty()) {
            throw new Exception ("Você precisa fornecer um texto"); //Exceção para nulo
        }
        boolean encontrada = false;
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (anotacao.getTexto().toLowerCase().contains(texto.toLowerCase()) && anotacao.isOculta() == false) {
                encontrada = true;
                if (encontrada) {
                    listaOrdenada.add(anotacao);
                }
            }
        }
        if (!encontrada) {
            System.out.println("Nenhum resultado encontrado!");
        } else {
            listarBuscaOrdenada(listaOrdenada); //Chama o método
        }
    }
    public void deletarDaBusca (int id) throws Exception { //Deleta anotação da lista de busca
        boolean excluida = false;
        if (id < 0) {
            throw new Exception("Não é possível pesquisar um id negativo"); //Exceção para valor negativo
        }
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (anotacao.getId() == id) {
                excluida = true;
                anotacao.setOculta(true);
                System.out.println("Anotação deletada da lista de busca.");
            }
        }
        if (!excluida) {
            System.out.println("Anotação não encontrada.");
        }
    }
    public void deletarAnotacao(int id) throws Exception { //Deleta anotação do bloco de notas
        if (id < 0) {
            throw new Exception("Não é possível pesquisar um id negativo"); //Exceção para valor negativo
        }
        boolean excluida = false;
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (anotacao.getId() == id) {
                excluida = true;
                listaDeAnotacoes.remove(anotacao);
                System.out.println("Anotação excluida.");
            }
        }
        if (!excluida) {
            System.out.println("Anotação não encontrada.");
        }
    }
    public void listarBuscaOrdenada(List<Anotacao> lista) { // Imprime as anotacões ao chamar o método
        Collections.sort(lista, Comparator.comparing(Anotacao::getData)); //Ordena a lista com base na data
        for (Anotacao anotacao : lista) {
            if (!lista.isEmpty() && anotacao != null) {
                System.out.println(anotacao);
            }
        }
    }
    public void listarPorOrdem() {  // Imprime as anotacões ao chamar o método
        Collections.sort(listaDeAnotacoes, Comparator.comparing(Anotacao::getData)); //Ordena a lista com base na data
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (!listaDeAnotacoes.isEmpty() && anotacao != null) {
                System.out.println(anotacao);
            }
        }
    }
}
