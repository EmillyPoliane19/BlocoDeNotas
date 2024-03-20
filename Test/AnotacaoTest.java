import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnotacaoTest {
    private Anotacao anotacao;
    @BeforeEach
    void ConstroiAnotacao() throws Exception {
        anotacao = new Anotacao("Anotação teste");
    }

    @Test
    void getTextoTeste () {
        Assertions.assertEquals("Anotação teste",anotacao.getTexto());
    }

    @Test
    void setTextoTeste () {
        String textoModificado = "Nova Anotação";

        anotacao.setTexto(textoModificado);

        Assertions.assertEquals(textoModificado, anotacao.getTexto());
    }

    @Test
    void getDataTeste () {

    }




}