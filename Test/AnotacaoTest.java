import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AnotacaoTest {
    private Anotacao anotacao;
    @BeforeEach
    void ConstroiAnotacaoAntesDoTexte() throws Exception {
        anotacao = new Anotacao("Anotação teste");
    }

    /* Esse teste verifica se a anotação ta sendo criada */
    @Test
    void getTextoTesteDandoCerto () {
        Assertions.assertEquals("Anotação teste",anotacao.getTexto());
    }

    /* Esse teste verifica uma anotação dando fail*/
    @Test
    void getTextoTesteDandoFail () {
        String textoEsperado = "Teste falho";

        Assertions.assertNotEquals(textoEsperado,anotacao.getTexto());
    }


    /* Esse teste verifica se a anotação está sendo modificada */
    @Test
    void setTextoTesteDandoCerto () {
        String textoModificado = "Nova Anotação";

        anotacao.setTexto(textoModificado);

        Assertions.assertEquals(textoModificado, anotacao.getTexto());
    }

    /* Esse teste verifica se a anotação está sendo modificada dando fail */
    @Test
    void setTextoTesteDandoFail() {
        String textoModificado = "Nova Anotação";

        anotacao.setTexto(textoModificado);

        Assertions.assertNotEquals("Texto esperado", anotacao.getTexto());
    }

    /* Esse teste verifica se data está sendo criada */
    @Test
    void getDataTesteDandoCerto () {

        LocalDateTime horaPassada = anotacao.getData().withSecond(0).withNano(0);
        LocalDateTime horaEsperada = LocalDateTime.now().withSecond(0).withNano(0);

        assertEquals(horaPassada,horaEsperada);
    }

    /* Esse teste verifica se data está sendo criada dando fail */
    @Test
    void getDataTesteDandoFail () {

        LocalDateTime horaEsperada = LocalDateTime.now().minusHours(1);
        LocalDateTime horaPassada = anotacao.getData().withSecond(0).withNano(0);

        assertNotEquals(horaEsperada, horaPassada);
    }
}