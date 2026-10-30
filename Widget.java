public interface Widget extends Comparable<Widget> {

    int getId();

    String getNombre();

    int getMemoriaKB();

    String renderizar();

    @Override
    default int compareTo(Widget otro) {
        return Integer.compare(this.getMemoriaKB(), otro.getMemoriaKB());
    }
}
