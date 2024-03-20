import java.util.*;
// Adicionar novas anotações, editar anotações existentes, realizar a deleção lógica de anotações
// Buscar anotações a partir de um texto de busca e listar todas as anotações pela ordem.
public class BlocoDeNotas {
    List<Anotacao> listaDeAnotacoes; // Lista
    public BlocoDeNotas() { //Construtor
        this.listaDeAnotacoes = new ArrayList<>();
    }

    public List<Anotacao> getLista() {
        return this.listaDeAnotacoes;
    }

    public void adicionarAnotacao (Anotacao texto) throws Exception{ //Adiciona anotação
        listaDeAnotacoes.add(texto);
    }
    public List<Anotacao> buscarAnotacao(String texto) throws Exception { //Busca anotação por texto
        List <Anotacao> listaOrdenada = new ArrayList<>();
        if (texto == null || texto.isEmpty()) {
            throw new Exception ("Você precisa fornecer um texto"); //Exceção para nulo
        } else if (this.listaDeAnotacoes.isEmpty()) {
            throw new Exception("Lista vazia!");
        }
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (anotacao.getTexto().toLowerCase().contains(texto.toLowerCase()) && !anotacao.isOculta()) {
                    listaOrdenada.add(anotacao);
            }
        }

        listarBuscaOrdenadaPelaData(listaOrdenada);
        return listaOrdenada;
    }
    public void editarAnotacao (int id, String textoInformado) throws Exception{ //Edita anotação
        if (id < 0) {
            throw new Exception("Não é possível pesquisar um id negativo"); //Exceção para valor nulo
        }
        for (Anotacao texto : listaDeAnotacoes) {
            if (id == texto.getId()) {
                texto.setTexto(textoInformado);
                return;
            }
        }
        throw new Exception("O ID " + id + " não foi encontrado!");
    }
    public boolean deletarDaBusca (int id) throws Exception { //Deleta anotação da lista de busca
        boolean excluida = false;
        if (id < 0) {
            throw new Exception("Não é possível pesquisar um id negativo"); //Exceção para valor negativo
        }
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (anotacao.getId() == id) {
                excluida = true;
                anotacao.setOculta(excluida);
            }
        }
        if (!excluida) {
            return false;
        }
        return true;
    }
    public boolean deletarAnotacao(int id) throws Exception { //Deleta anotação do bloco de notas
        if (id < 0) {
            throw new Exception("Não é possível pesquisar um id negativo"); //Exceção para valor negativo
        }
        for (Anotacao anotacao : listaDeAnotacoes) {
            if (anotacao.getId() == id) {
                listaDeAnotacoes.remove(anotacao);
                return true;
            }
        }
        return false;
    }
    public void listarBuscaOrdenadaPelaData(List<Anotacao> lista) { // Imprime as anotacões ao chamar o método
        Collections.sort(lista, Comparator.comparing(Anotacao::getData)); //Ordena a lista com base na data
    }

    public List<Anotacao> filtrarBuscarPorData() {  // Imprime as buscas ao chamar o método
        Collections.sort(listaDeAnotacoes, Comparator.comparing(Anotacao::getData)); //Ordena a lista com base na data
        return listaDeAnotacoes;
    }
}
