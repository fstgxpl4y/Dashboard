import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {

    private ArrayList<Widget> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
    }

    public void init() {
        widgets.add(new WeatherWidget(1, "Clima capital", 120, "Ciudad de Guatemala", 24.0));

        TaskWidget tareasTrabajo = new TaskWidget(2, "Pendientes de trabajo", 85);
        tareasTrabajo.agregarTarea("Entregar archivos DAA");
        tareasTrabajo.agregarTarea("Registrar usuarios nuevos");
        tareasTrabajo.agregarTarea("Reunion de equipo");
        widgets.add(tareasTrabajo);

        widgets.add(new AlertWidget(3, "Alerta servidor", 40, "Servidor principal con CPU al 95%", "ALTA"));
        widgets.add(new ClockWidget(4, "Reloj Guatemala", 30, "America/Guatemala"));
        widgets.add(new QuoteWidget(5, "Frase del dia", 15, "El exito es la suma de pequenos esfuerzos repetidos dia tras dia", "Robert Collier"));
        widgets.add(new WeatherWidget(6, "Clima Xela", 118, "Quetzaltenango", 15.0));

        TaskWidget tareasCasa = new TaskWidget(7, "Pendientes de la U", 64);
        tareasCasa.agregarTarea("Terminar el ejercicio de POO");
        tareasCasa.agregarTarea("Estudiar para el parcial");
        widgets.add(tareasCasa);

        widgets.add(new AlertWidget(8, "Alerta respaldo", 38, "El respaldo de anoche no se completo", "MEDIA"));
        widgets.add(new ClockWidget(9, "Reloj Madrid", 28, "Europe/Madrid"));
        widgets.add(new QuoteWidget(10, "Frase motivacional", 12, "No cuenta los dias, haz que los dias cuenten", "Muhammad Ali"));
    }

    public void agregarWidget(Widget widget) {
        widgets.add(widget);
    }

    public ArrayList<Widget> getWidgets() {
        return widgets;
    }

    public Widget buscarPorId(int id) {
        for (Widget w : widgets) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public Widget buscarPorNombre(String nombre) {
        for (Widget w : widgets) {
            if (w.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return w;
            }
        }
        return null;
    }

    public String interactuarCon(int id) {
        Widget w = buscarPorId(id);
        if (w == null) {
            return "No encontre ningun widget con ese ID.";
        }
        if (w instanceof Interactivo) {
            Interactivo interactivo = (Interactivo) w;
            return interactivo.interactuar();
        }
        return "Ese widget solo se muestra en pantalla, no tiene nada que hacerle.";
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }

    public int getMemoriaTotal() {
        int total = 0;
        for (Widget w : widgets) {
            total += w.getMemoriaKB();
        }
        return total;
    }
}
