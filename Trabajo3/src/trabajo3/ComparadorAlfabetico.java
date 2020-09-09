package trabajo3;

import java.util.Comparator;

public class ComparadorAlfabetico implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        vehiculo e1 = (vehiculo) o1;
        vehiculo e2 = (vehiculo) o2;
        return e1.getCliente().compareTo(e2.getCliente());
    }

}
