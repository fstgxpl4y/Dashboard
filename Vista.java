import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println();
        System.out.println("===== DASHBOARD EMPRESARIAL =====");
        System.out.println("1. Ver todos los widgets");
        System.out.println("2. Buscar un widget");
        System.out.println("3. Interactuar con un widget");
        System.out.println("4. Ordenar por memoria (KB)");
        System.out.println("5. Salir");
        return leerEntero("Que queres hacer? ");
    }

    public void mostrarWidgets(ArrayList<Widget> widgets) {
        System.out.println();
        for (Widget w : widgets) {
            System.out.println(w.toString());
        }
    }

    public void mostrarDetalle(Widget w) {
        System.out.println();
        System.out.println("Esto es lo que encontre:");
        System.out.println(w.toString());
        System.out.println(w.renderizar());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Eso no es un numero, proba otra vez: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
}
