public class AlertWidget implements Widget, Interactivo {

    private int id;
    private String nombre;
    private int memoriaKB;
    private String mensaje;
    private String prioridad;
    private boolean leida;

    public AlertWidget(int id, String nombre, int memoriaKB, String mensaje, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leida = false;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public int getMemoriaKB() { return memoriaKB; }

    public String getMensaje() { return mensaje; }

    public String getPrioridad() { return prioridad; }

    public boolean isLeida() { return leida; }

    @Override
    public String renderizar() {
        String estado = leida ? "LEIDA" : "NUEVA";
        return "[Alerta] Prioridad " + prioridad + " (" + estado + "): " + mensaje;
    }

    @Override
    public String interactuar() {
        if (leida) {
            return "Esa alerta ya la habias leido.";
        }
        leida = true;
        return "Listo, la alerta quedo marcada como leida.";
    }

    @Override
    public String toString() {
        return String.format("ID %d | %s | %d KB | %s", id, nombre, memoriaKB, renderizar());
    }
}
