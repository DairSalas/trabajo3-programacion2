package interfazdepetita;

import java.util.Arrays;
import java.util.Comparator;

public class DeclararVector {

    private Factura[] facturas;
    private int tamanio;

    public DeclararVector() {
        facturas = null;
        tamanio = 17;
    }

    public void crearVector() {
        facturas = new Factura[tamanio];
    }

    public void setTamanio(int t) {
        tamanio = t;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setVehiculos(int p, Factura nuevo) {
        facturas[p] = nuevo;
    }

    public Factura getVehiculo(int p) {
        return facturas[p];
    }

    public Factura[] getFacturas() {
        return facturas;
    }
    
    public void generarVector() {
        Factura fac1 = new Factura(1234, "Annie", "Auto", 2);
        Factura fac2 = new Factura(3542, "Antonio", "Auto", 5);
        Factura fac3 = new Factura(4325, "Luis", "Camioneta", 20);
        Factura fac4 = new Factura(6786, "Marcos", "Bus", 4);
        Factura fac5 = new Factura(4536, "Gisela", "Auto", 3);
        Factura fac6 = new Factura(8642, "Wilmer", "Bus", 56);
        Factura fac7 = new Factura(1278, "Sandy", "Bus", 3);
        Factura fac8 = new Factura(4379, "María", "Camioneta", 6);
        Factura fac9 = new Factura(9742, "Tania", "Camioneta", 8);
        Factura fac10 = new Factura(5632, "Camilo", "Bus", 7);
        Factura fac11 = new Factura(2594, "Kelly", "Auto", 15);
        Factura fac12 = new Factura(3921, "Josefa", "Camioneta", 53);
        Factura fac13 = new Factura(3469, "Bruno", "Bus", 37);
        Factura fac14 = new Factura(2435, "Oscar", "Auto", 22);
        Factura fac15 = new Factura(1133, "Brayan", "Auto", 18);
        Factura fac16 = new Factura(4522, "Valeria", "Bus", 21);
        Factura fac17 = new Factura(4317, "Victoria", "Camioneta", 14);

        setVehiculos(0, fac1);
        setVehiculos(1, fac2);
        setVehiculos(2, fac3);
        setVehiculos(3, fac4);
        setVehiculos(4, fac5);
        setVehiculos(5, fac6);
        setVehiculos(6, fac7);
        setVehiculos(7, fac8);
        setVehiculos(8, fac9);
        setVehiculos(9, fac10);
        setVehiculos(10, fac11);
        setVehiculos(11, fac12);
        setVehiculos(12, fac13);
        setVehiculos(13, fac14);
        setVehiculos(14, fac15);
        setVehiculos(15, fac16);
        setVehiculos(16, fac17);
    }
    
    public void copiar(Factura v[]) {
        tamanio = v.length;
        crearVector();
        for (int i = 0; i < v.length; i++) {
            setVehiculos(i, v[i]);
        }
    }

    public int busquedaLineal(float val) {
        for (int i = 0; i < getTamanio(); i++) {
            if (getVehiculo(i).getValor() == val) {
                return i;
            }
        }
        return -1;
    }

    public int busquedaBinaria(float val) {
        quickSortValor(0, tamanio-1);
        int pos, izq, der, centro;
        izq = 0;
        der = getTamanio() - 1;
        pos = -1;

        while ((izq <= der) && (pos == -1)) {
            centro = (izq + der) / 2;
            if (val == (getVehiculo(centro).getValor())) {
                pos = centro;
            } else if (val < (getVehiculo(centro).getValor())) {
                der = centro - 1;
            } else {
                izq = centro + 1;
            }
        }
        return pos;
    }

    public void cambiar(int p1, int p2) {
        Factura aux;
        aux = getVehiculo(p1);
        setVehiculos(p1, getVehiculo(p2));
        setVehiculos(p2, aux);
    }

    public void ordenarBurbuja() {
        for (int i = 0; i < getTamanio(); i++) {
            for (int j = 0; j <= (getTamanio() - i) - 2; j++) {
                if (getVehiculo(j).getNumero() > getVehiculo(j + 1).getNumero()) {
                    cambiar(j, j + 1);
                }
            }
        }
    }

    private int ordenarNumHoras(int inicio) {
        int posMayor;
        int mayorElemento;
        posMayor = inicio;

        mayorElemento = getVehiculo(inicio).getNumero();

        for (int i = inicio + 1; i < getTamanio(); i++) {
            if (getVehiculo(i).getNumero() < mayorElemento) {
                mayorElemento = getVehiculo(i).getNumero();
                posMayor = i;
            }
        }
        return posMayor;
    }

    public void ordenarIntercambio() {
        for (int i = 0; i < getTamanio(); i++) {
            cambiar(i, ordenarNumHoras(i));
        }
    }

    public void quickSort(int izq, int der) {
        Factura pivote = getVehiculo(izq);
        int i = izq;
        int j = der;

        while (i < j) {
            while (getVehiculo(i).getNumero() <= pivote.getNumero() && i < j) {
                i++;
            }
            while (getVehiculo(j).getNumero() > pivote.getNumero()) {
                j--;
            }
            if (i < j) {
                cambiar(i, j);
            }
        }

        setVehiculos(izq, getVehiculo(j));
        setVehiculos(j, pivote);
        if (izq < j - 1) {
            quickSort(izq, j - 1);
        }
        if (j + 1 < der) {
            quickSort(j + 1, der);
        }
    }

    public void alfabeto() {
        class ComparatorAlfabetico implements Comparator<Factura> {

            @Override
            public int compare(Factura o1, Factura o2) {
                return o1.getCliente().compareTo(o2.getCliente());
            }

        }

        Arrays.sort(facturas, new ComparatorAlfabetico());
    }

    public void quickSortValor(int izq, int der) {
        Factura pivote = getVehiculo(izq);
        int i = izq;
        int j = der;

        while (i < j) {
            while (getVehiculo(i).getValor() <= pivote.getValor() && i < j) {
                i++;
            }
            while (getVehiculo(j).getValor() > pivote.getValor()) {
                j--;
            }
            if (i < j) {
                cambiar(i, j);
            }
        }

        setVehiculos(izq, getVehiculo(j));
        setVehiculos(j, pivote);
        if (izq < j - 1) {
            quickSortValor(izq, j - 1);
        }
        if (j + 1 < der) {
            quickSortValor(j + 1, der);
        }
    }

}
