public class Main {

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(dashboard, vista);
        controlador.iniciar();
    }
}
