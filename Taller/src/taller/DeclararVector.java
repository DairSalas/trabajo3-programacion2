package taller;

import java.util.Arrays;

public class DeclararVector {

    private Vehiculo datos[];
    private int tam;

    public DeclararVector() {
        datos = null;
        tam = 0;
    }

    public void crearVector() {
        datos = new Vehiculo[tam];
    }

    public void setTam(int t) {
        tam = t;
    }

    public int getTam() {
        return tam;
    }

    public void setDatos(int p, Vehiculo nuevo) {
        datos[p] = nuevo;
    }

    public Vehiculo getDatos(int p) {
        return datos[p];
    }

    public Vehiculo[] getDatos() {
        return datos;
    }

    public int buscarFacturaLineal(float val) {
        for (int i = 0; i < getTam(); i++) {
            if (getDatos(i).getValor() == val) {
                return i;
            }
        }
        return -1;
    }

    public int busquedaBinaria(float val) {
        ordenarBurbujaValor();
        int pos, izq, der, centro;
        izq = 0;
        der = getTam() - 1;
        pos = -1;

        while ((izq <= der) && (pos == -1)) {
            centro = (izq + der) / 2;
            if (val == (getDatos(centro).getValor())) {
                pos = centro;
            } else if (val < (getDatos(centro).getValor())) {
                der = centro - 1;
            } else {
                izq = centro + 1;
            }
        }
        return pos;
    }

    public void cambiar(int p1, int p2) {
        Vehiculo aux;
        aux = getDatos(p1);
        setDatos(p1, getDatos(p2));
        setDatos(p2, aux);
    }

    public void ordenarBurbuja() {
        for (int i = 0; i < getTam(); i++) {
            for (int j = 0; j <= (getTam() - i) - 2; j++) {
                if (getDatos(j).getHora() > getDatos(j + 1).getHora()) {
                    cambiar(j, j + 1);
                }
            }
        }
    }

    private int ordenarHoras(int inicio) {
        int posMayor;
        int mayorElemento;
        posMayor = inicio;

        mayorElemento = getDatos(inicio).getHora();

        for (int i = inicio + 1; i < getTam(); i++) {
            if (getDatos(i).getHora() < mayorElemento) {
                mayorElemento = getDatos(i).getHora();
                posMayor = i;
            }
        }
        return posMayor;
    }

    public void ordenarIntercambio() {
        for (int i = 0; i < getTam(); i++) {
            cambiar(i, ordenarHoras(i));
        }
    }

    public void quickSort(int izq, int der) {
        Vehiculo pivote = getDatos(izq);
        int i = izq;
        int j = der;

        while (i < j) {
            while (getDatos(i).getHora() <= pivote.getHora() && i < j) {
                i++;
            }
            while (getDatos(j).getHora() > pivote.getHora()) {
                j--;
            }
            if (i < j) {
                cambiar(i, j);
            }
        }

        setDatos(izq, getDatos(j));
        setDatos(j, pivote);
        if (izq < j - 1) {
            quickSort(izq, j - 1);
        }
        if (j + 1 < der) {
            quickSort(j + 1, der);
        }
    }

    public void ordenarBurbujaAlfabetico() {
        Arrays.sort(datos, new ComparadorNombre());
    }

    public void ordenarBurbujaValor() {
        for (int i = 0; i < getTam(); i++) {
            for (int j = 0; j <= (getTam() - i) - 2; j++) {
                if (getDatos(j).precioTotal() > getDatos(j + 1).precioTotal()) {
                    cambiar(j, j + 1);
                }
            }
        }
    }

}
