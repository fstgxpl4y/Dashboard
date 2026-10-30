import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements Widget {

    private int id;
    private String nombre;
    private int memoriaKB;
    private String zonaHoraria;

    public ClockWidget(int id, String nombre, int memoriaKB, String zonaHoraria) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.zonaHoraria = zonaHoraria;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public int getMemoriaKB() { return memoriaKB; }

    public String getZonaHoraria() { return zonaHoraria; }

    public String getHoraActual() {
        LocalTime hora = LocalTime.now(ZoneId.of(zonaHoraria));
        return hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String renderizar() {
        return "[Reloj] " + zonaHoraria + ": " + getHoraActual();
    }

    @Override
    public String toString() {
        return String.format("ID %d | %s | %d KB | %s", id, nombre, memoriaKB, renderizar());
    }
}
