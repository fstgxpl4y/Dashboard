public class WeatherWidget implements Widget, Interactivo {

    private int id;
    private String nombre;
    private int memoriaKB;
    private String ciudad;
    private double temperaturaCelsius;
    private boolean enFahrenheit;

    public WeatherWidget(int id, String nombre, int memoriaKB, String ciudad, double temperaturaCelsius) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.ciudad = ciudad;
        this.temperaturaCelsius = temperaturaCelsius;
        this.enFahrenheit = false;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public int getMemoriaKB() { return memoriaKB; }

    public String getCiudad() { return ciudad; }

    public double getTemperaturaCelsius() { return temperaturaCelsius; }

    public void setTemperaturaCelsius(double temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }

    public double getTemperaturaMostrada() {
        if (enFahrenheit) {
            return temperaturaCelsius * 9 / 5 + 32;
        }
        return temperaturaCelsius;
    }

    public String getUnidad() {
        return enFahrenheit ? "°F" : "°C";
    }

    @Override
    public String renderizar() {
        return String.format("[Clima] %s: %.1f %s", ciudad, getTemperaturaMostrada(), getUnidad());
    }

    @Override
    public String interactuar() {
        enFahrenheit = !enFahrenheit;
        return "Unidad cambiada a " + getUnidad() + " -> " + renderizar();
    }

    @Override
    public String toString() {
        return String.format("ID %d | %s | %d KB | %s", id, nombre, memoriaKB, renderizar());
    }
}
