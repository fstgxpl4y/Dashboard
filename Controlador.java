public class Controlador {

    private Dashboard dashboard;
    private Vista vista;

    public Controlador(Dashboard dashboard, Vista vista) {
        this.dashboard = dashboard;
        this.vista = vista;
    }

    public void iniciar() {
        dashboard.init();
        vista.mostrarMensaje("Se cargaron " + dashboard.getWidgets().size() + " widgets, en total usan "
                + dashboard.getMemoriaTotal() + " KB.");

        int opcion = 0;
        while (opcion != 5) {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    vista.mostrarWidgets(dashboard.getWidgets());
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    int id = vista.leerEntero("Escribi el ID del widget: ");
                    vista.mostrarMensaje(dashboard.interactuarCon(id));
                    break;
                case 4:
                    dashboard.ordenarPorMemoria();
                    vista.mostrarMensaje("Asi quedan de menor a mayor consumo:");
                    vista.mostrarWidgets(dashboard.getWidgets());
                    break;
                case 5:
                    vista.mostrarMensaje("Gracias por usar el dashboard, nos vemos.");
                    break;
                default:
                    vista.mostrarMensaje("Esa opcion no existe, elegi una del 1 al 5.");
            }
        }
    }

    private void buscar() {
        int tipo = vista.leerEntero("Buscar por 1) ID o 2) nombre: ");
        Widget encontrado = null;
        if (tipo == 1) {
            int id = vista.leerEntero("Escribi el ID: ");
            encontrado = dashboard.buscarPorId(id);
        } else if (tipo == 2) {
            String nombre = vista.leerTexto("Escribi el nombre: ");
            encontrado = dashboard.buscarPorNombre(nombre);
        }

        if (encontrado == null) {
            vista.mostrarMensaje("No aparecio ningun widget con eso.");
        } else {
            vista.mostrarDetalle(encontrado);
        }
    }
}
