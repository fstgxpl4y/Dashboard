public class QuoteWidget implements Widget {

    private int id;
    private String nombre;
    private int memoriaKB;
    private String frase;
    private String autor;

    public QuoteWidget(int id, String nombre, int memoriaKB, String frase, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.frase = frase;
        this.autor = autor;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public int getMemoriaKB() { return memoriaKB; }

    public String getFrase() { return frase; }

    public String getAutor() { return autor; }

    @Override
    public String renderizar() {
        return "[Frase] \"" + frase + "\" - " + autor;
    }

    @Override
    public String toString() {
        return String.format("ID %d | %s | %d KB | %s", id, nombre, memoriaKB, renderizar());
    }
}
