import java.time.LocalDateTime;
//Toda anotação deve ser identificada por um número de forma única
//E deve-se associar a cada anotação a data de criação da anotação.

public class Anotacao {
    private static int nextId = 1; //Instancia para o id
    private int id; //Id único
    private String texto; //Texto da anotação
    private LocalDateTime data; //Data de criação
    private boolean oculta; //Condição para exibir na busca

    Anotacao (String texto) throws NullPointerException { //Construtor
        if (null == texto || texto.isEmpty()) {

        }
        this.texto = texto;
        this.data = LocalDateTime.now();
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

    public LocalDateTime getData() {
        return data;
    }

    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }
    public boolean isOculta() {
        return oculta;
    }

    @Override
    public String toString() {
        return  "Anotação " + id + ":\n" + texto + "\nCriada em: " + data + "\n";
    }

    public static void main(String[] args) {
        try {

        } catch (NullPointerException e)
        {
            System.out.println("Você não pode salvar um texto vazio.");
        }
    }

}

