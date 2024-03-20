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

    @Test
     void adicionarAnotacaoTeste() throws Exception {
        blocoDeNotas.adicionarAnotacao(anotacao);
        Assertions.assertEquals(1,blocoDeNotas.getLista().get(0).getId());
        blocoDeNotas.getLista().remove(anotacao);
    }

    @Test
    void adicionarAnotacaoTesteFail() {
        Anotacao a2 = null;
        try {
            blocoDeNotas.adicionarAnotacao(a2);
            fail("é para ir para o catch");

        } catch (Exception e) {

        }
    }

   @Test
   void buscarAnotacaoTeste() throws Exception {
       String textoDeBusca = "Teste";

       blocoDeNotas.getLista().add(anotacao);
       List<Anotacao> lista = blocoDeNotas.buscarAnotacao(textoDeBusca);

       Assertions.assertTrue(lista.contains(anotacao));
   }

   @Test
   void editarAnotacaoTeste() throws Exception {

        String novoTexto = "Texto Editado";

        blocoDeNotas.getLista().add(anotacao);
        blocoDeNotas.editarAnotacao(anotacao.getId(), novoTexto);

        Assertions.assertEquals(novoTexto, anotacao.getTexto());
    }

   @Test
   void deletarDaBuscaTeste () throws Exception {

        blocoDeNotas.getLista().add(anotacao);
        blocoDeNotas.deletarDaBusca(anotacao.getId());

        Assertions.assertTrue(anotacao.isOculta());
   }

    /*
    asadasd
    */
   @Test
   void deletarAnotacaoTeste () throws Exception {

       blocoDeNotas.getLista().add(anotacao);
       boolean removerDaLista = blocoDeNotas.deletarAnotacao(anotacao.getId());

       Assertions.assertTrue(removerDaLista);
   }



}