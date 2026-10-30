import java.util.ArrayList;

public class TaskWidget implements Widget, Interactivo {

    private int id;
    private String nombre;
    private int memoriaKB;
    private ArrayList<String> pendientes;
    private ArrayList<String> completadas;

    public TaskWidget(int id, String nombre, int memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.pendientes = new ArrayList<>();
        this.completadas = new ArrayList<>();
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public int getMemoriaKB() { return memoriaKB; }

    public void agregarTarea(String tarea) {
        pendientes.add(tarea);
    }

    public boolean completarTarea(int indice) {
        if (indice < 0 || indice >= pendientes.size()) {
            return false;
        }
        completadas.add(pendientes.remove(indice));
        return true;
    }

    public int getCantidadPendientes() { return pendientes.size(); }

    @Override
    public String renderizar() {
        StringBuilder sb = new StringBuilder("[Tareas] " + nombre + "\n");
        for (String t : pendientes) {
            sb.append("  [ ] ").append(t).append("\n");
        }
        for (String t : completadas) {
            sb.append("  [x] ").append(t).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String interactuar() {
        if (pendientes.isEmpty()) {
            return "No hay tareas pendientes.";
        }
        String tarea = pendientes.get(0);
        completarTarea(0);
        return "Tarea completada: " + tarea;
    }

    @Override
    public String toString() {
        return String.format("ID %d | %s | %d KB | %d pendientes, %d hechas",
                id, nombre, memoriaKB, pendientes.size(), completadas.size());
    }
}
