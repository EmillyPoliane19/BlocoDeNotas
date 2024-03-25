import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//Toda anotação deve ser identificada por um número de forma única
//E deve-se associar a cada anotação a data de criação da anotação.

public class Anotacao {
    private static int nextId = 1; //Instancia para o id
    private int id; //Id único
    private String texto; //Texto da anotação
    private LocalDateTime data; //Data de criação
    private boolean oculta; //Condição para exibir na busca

    Anotacao (String texto) throws Exception { //Construtor

        this.texto = texto;
        this.data = LocalDateTime.now().withSecond(0).withNano(0);;
        this.id = gerarID();
        this.oculta = false;
    }
    public static int gerarID() { //Gerador de ID
        return nextId ++;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String formatarData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(formatter);
    }
    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }

    public boolean isOculta() {
        return oculta;
    }

    @Override
    public String toString() {
        return  "\nAnotação " + id + ":\n" + texto + "\nCriada em: " + formatarData();
    }
}

