package taller;

import java.util.Comparator;

public class ComparadorNombre implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Vehiculo e1 = (Vehiculo) o1;
        Vehiculo e2 = (Vehiculo) o2;
        return e1.getCliente().compareTo(e2.getCliente());
    }

}
