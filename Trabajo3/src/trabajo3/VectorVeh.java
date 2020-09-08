package trabajo3;

public class VectorVeh {

    private vehiculo[] vectorVehiculos;
    private int numElementos;

    public VectorVeh() {
        vectorVehiculos = null;
        numElementos = 0;
    }

    public void crearVector() {
        vectorVehiculos = new vehiculo[numElementos];
    }

    public void setNumElementos(int t) {
        numElementos = t;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setVectorVehiculos(int p, vehiculo nuevo) {
        vectorVehiculos[p] = nuevo;
    }

    public vehiculo getVectorVehiculos(int p) {
        return vectorVehiculos[p];
    }

    public vehiculo[] getVectorVehiculos() {
        return vectorVehiculos;
    }

    public int valorLineal(float v) {
        int p = -1;
        for (int i = 0; i <= getNumElementos()-1; i++) {
            if (getVectorVehiculos(i).getValor() == v) {
                p = i;
                break;
            }
        }
        return p;
    }

    public int ValorBinario(float val) {
        metodoBurbuja();
        int pos, izq, der, centro;
        izq = 0;
        der = getNumElementos() - 1;
        pos = -1;

        while ((izq <= der) && (pos == -1)) {
            centro = (izq + der) / 2;
            if (val == (getVectorVehiculos(centro).getValor())) {
                pos = centro;
            } else if (val < (getVectorVehiculos(centro).getValor())) {
                der = centro - 1;
            } else {
                izq = centro + 1;
            }
        }
        return pos;
    }

    public void intercambiar(int p1, int p2) {
        vehiculo aux;
        aux = getVectorVehiculos(p1);
        setVectorVehiculos(p1, getVectorVehiculos(p2));
        setVectorVehiculos(p2, aux);
    }

    public void metodoBurbuja() {
        for (int i = 0; i < getNumElementos(); i++) {
            for (int j = 0; j <= (getNumElementos() - i) - 2; j++) {
                if (getVectorVehiculos(j).getHora() > getVectorVehiculos(j + 1).getHora()) {
                    intercambiar(j, j + 1);
                }
            }
        }
    }

    private int metodoParaIntercambio(int inicio) {
        int posMayor;
        int mayorElemento;
        posMayor = inicio;

        mayorElemento = getVectorVehiculos(inicio).getHora();

        for (int i = inicio + 1; i < getNumElementos(); i++) {
            if (getVectorVehiculos(i).getHora() < mayorElemento) {
                mayorElemento = getVectorVehiculos(i).getHora();
                posMayor = i;
            }
        }
        return posMayor;
    }

    public void metodoIntercambio() {
        for (int i = 0; i < getNumElementos(); i++) {
            intercambiar(i, metodoParaIntercambio(i));
        }
    }

    public void llamarQuicksort() {
        metodoQuicksort(0, getNumElementos() - 1);
    }

    public void metodoQuicksort(int izq, int der) {
        vehiculo pivote = getVectorVehiculos(izq);
        int i = izq;
        int j = der;

        while (i < j) {
            while (getVectorVehiculos(i).getHora() <= pivote.getHora() && i < j) {
                i++;
            }
            while (getVectorVehiculos(j).getHora() > pivote.getHora()) {
                j--;
            }
            if (i < j) {
                intercambiar(i, j);
            }
        }

        setVectorVehiculos(izq, getVectorVehiculos(j));
        setVectorVehiculos(j, pivote);
        if (izq < j - 1) {
            metodoQuicksort(izq, j - 1);
        }
        if (j + 1 < der) {
            metodoQuicksort(j + 1, der);
        }
    }

}
