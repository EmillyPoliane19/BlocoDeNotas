import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlocoDeNotasTest {
    private Anotacao anotacao;
    private BlocoDeNotas blocoDeNotas;

    @BeforeEach
    void criarObjeto() throws Exception {
        blocoDeNotas = new BlocoDeNotas();
        anotacao = new Anotacao("Anotação Teste");
    }
    @AfterEach
    void limpaALista () {
        blocoDeNotas.getLista().clear();
    }

    /* Esse teste adiciona uma anotação e verifica se ela realmente foi adicionada na lista. */
    @Test
     void adicionarAnotacaoTesteDandoCerto() throws Exception {
        blocoDeNotas.adicionarAnotacao(anotacao);

        Assertions.assertEquals(1,blocoDeNotas.getLista().size());
    }

    /* Esse teste adiciona anotação fazia e verifica se a excessão está funcionando */
    @Test
    void adicionarAnotacaoTesteDandoFail() {
        Anotacao anotacaoVazia = null;

        try {
            blocoDeNotas.adicionarAnotacao(anotacaoVazia);
            fail("Adicionou uma anotação vazia");

        } catch (Exception e) {

            Assertions.assertEquals(e.getMessage(),"Você não pode adionar uma anotação vazia.");
        }
    }

    /*
    Esse teste adiciona uma anotação e depois verifica se a anotação
    está sendo passada na lista de busca
    */
   @Test
   void buscarAnotacaoTesteDandoCerto() throws Exception {
       String textoDeBusca = "Teste";

       blocoDeNotas.getLista().add(anotacao);
       List<Anotacao> lista = blocoDeNotas.buscarAnotacao(textoDeBusca);

       Assertions.assertTrue(lista.contains(anotacao));
   }

    /* Esse teste adiciona um texto vazio e verifica se a excessão está funcionando */
   @Test
   void buscarAnotacaoTesteDandoFail() throws Exception {
       String textoVazio = null;

       blocoDeNotas.getLista().add(anotacao);

       try {
           blocoDeNotas.buscarAnotacao(textoVazio);

           fail("Adicionou um texto vazio");

       } catch (Exception e) {

           Assertions.assertEquals(e.getMessage(),"Você precisa fornecer um texto");
       }
   }

   /* Esse teste verifica se uma anotação foi editada */
   @Test
   void editarAnotacaoTesteDandoCerto() throws Exception {

        String novoTexto = "Texto Editado";

        blocoDeNotas.getLista().add(anotacao);
        blocoDeNotas.editarAnotacao(anotacao.getId(), novoTexto);

        Assertions.assertEquals(novoTexto, anotacao.getTexto());
   }

    /* Esse teste pesquisa um id negativo e verifica se a excessão está funcionando */
    @Test
   void editarAnotacaoTesteDandoFail() throws Exception {
       String novoTexto = "Texto Editado";
       int idNegativo = -1;
       try {
           blocoDeNotas.editarAnotacao(idNegativo,novoTexto);

           fail("Buscou um id negativo.");

       } catch (Exception e) {

           Assertions.assertEquals(e.getMessage(), "Não é possível pesquisar um id negativo");
       }
   }


    /* Esse teste verifica se a anotação está sendo excluida da lista de busca */
   @Test
   void deletarDaBuscaTesteDandoCerto() throws Exception {

        blocoDeNotas.getLista().add(anotacao);
        blocoDeNotas.ocultarAnotacao(anotacao.getId());

        Assertions.assertTrue(anotacao.isOculta());
   }

    /* Esse teste pesquisa um id negativo e verifica se a excessão está funcionando */
   @Test
   void deletarDaBuscaTesteDandoFail() throws Exception {
       int idNegativo = -1;

       try {
           blocoDeNotas.ocultarAnotacao(idNegativo);
           fail("Buscou um id negativo");
       } catch (Exception e) {
           Assertions.assertEquals(e.getMessage(), "Não é possível pesquisar um id negativo");
       }

   }

   /* Esse teste verifica se a anotação está sendo excluida da liste */
   @Test
   void deletarAnotacaoTesteDandoCerto() throws Exception {

       blocoDeNotas.getLista().add(anotacao);
       boolean removerDaLista = blocoDeNotas.deletarAnotacao(anotacao.getId());

       Assertions.assertTrue(removerDaLista);
   }

    /* Esse teste pesquisa um id negativo e verifica se a excessão está funcionando */
    @Test
    void deletarAnotacaoTesteDandoFail () throws Exception {
       int idNegativo = -1;
       try {
           blocoDeNotas.deletarAnotacao(idNegativo);

           fail("Buscou um id negativo");

       } catch (Exception e) {
           Assertions.assertEquals(e.getMessage(), "Não é possível pesquisar um id negativo");
       }
   }
}