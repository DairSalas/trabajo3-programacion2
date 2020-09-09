/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import javax.swing.JOptionPane;

/**
 *
 * @author pd
 */
public class Taller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Object facturas[][] = {{112, "Victor", "Auto", 8},
        {213, "Pedro", "Bus", 4},
        {314, "Javier", "Bus", 6},
        {415, "Gonzalo", "Auto", 2},
        {516, "Jose", "Camioneta", 1},
        {617, "Santiago", "Auto", 7},
        {724, "Daniel", "Auto", 9},
        {827, "Julio", "Bus", 3},
        {920, "Cesar", "Bus", 1},
        {021, "Ivan", "Auto", 5},
        {122, "Diego", "Camioneta", 7},
        {223, "Oscar", "Camioneta", 6}};

        int t = facturas.length;

        DeclararVector vec = new DeclararVector();
        Vehiculo vehiculo;

        vec.setTam(t);
        vec.crearVector();

        for (int i = 0; i < vec.getTam(); i++) {
            vehiculo = new Vehiculo();
            for (int j = 0; j < 5; j++) {
                switch (j) {
                    case 0:
                        vehiculo.setCodigo((int) facturas[i][j]);
                        break;
                    case 1:
                        vehiculo.setCliente((String) facturas[i][j]);
                        break;
                    case 2:
                        vehiculo.setTipovehiculo((String) facturas[i][j]);
                        break;
                    case 3:
                        vehiculo.setHora((int) facturas[i][j]);
                        break;
                    case 4:
                        float val = vehiculo.precioTotal();
                        vehiculo.setValor(val);
                        break;
                }
            }
            vec.setDatos(i, vehiculo);
        }

        int opc = 0;
        int con = t;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion:\n"
                    + "\n1. IMPRIMIR FACTURAS"
                    + "\n2. BUSCAR FACTURA (Lineal)"
                    + "\n3. BUSCAR FACTURA (Binario)"
                    + "\n4. MÉTODO BURBUJA"
                    + "\n5. MÉTODO INTERCAMBIO"
                    + "\n6. MÉTODO QUICKSORT"
                    + "\n7. ORDENAR POR CLIENE"
                    + "\n8. SALIR"
                    + "\nSeleccione una opción del 1 al 8"));

            switch (opc) {

                case 1:
                    for (int i = 0; i < vec.getTam(); i++) {
                        if (vec.getDatos(i) != null) {
                            String mensaje = "";
                            mensaje += vec.getDatos(i).getCodigo()
                                    + "\n" + vec.getDatos(i).getCliente()
                                    + "\n" + vec.getDatos(i).getTipoVehiculo()
                                    + "\n" + vec.getDatos(i).getHora()
                                    + "\n" + vec.getDatos(i).getValor() + "\n";
                            JOptionPane.showMessageDialog(null, "Los datos del vehiculo son:\n" + mensaje);
                        }
                    }
                    break;

                case 2:
                    float val = Integer.parseInt(JOptionPane.showInputDialog("ingrese valor a buscar"));
                    int buscado = vec.buscarFacturaLineal(val);
                    if (buscado != -1) { //el valor se encontro
                        String mensaje = "";
                        mensaje += vec.getDatos(buscado).getCodigo()
                                + "\n" + vec.getDatos(buscado).getCliente()
                                + "\n" + vec.getDatos(buscado).getTipoVehiculo()
                                + "\n" + vec.getDatos(buscado).getHora()
                                + "\n" + vec.getDatos(buscado).getValor() + "\n";
                        JOptionPane.showMessageDialog(null, "Los datos del vehiculo son:\n" + mensaje);
                    } else {

                        JOptionPane.showMessageDialog(null, "el valor no se encuentra");

                    }
                    break;

                case 3:
                    float val1 = Float.parseFloat(JOptionPane.showInputDialog("ingrese valor a buscar"));
                    int buscado1 = vec.busquedaBinaria(val1);
                    System.out.println(buscado1);

                    if (buscado1 != -1) {
                        String mensaje = "";
                        mensaje += vec.getDatos(buscado1).getCodigo()
                                + "\n" + vec.getDatos(buscado1).getCliente()
                                + "\n" + vec.getDatos(buscado1).getTipoVehiculo()
                                + "\n" + vec.getDatos(buscado1).getHora()
                                + "\n" + vec.getDatos(buscado1).getValor() + "\n";
                        JOptionPane.showMessageDialog(null, "Los datos del vehiculo son:\n" + mensaje);

                    } else {
                        JOptionPane.showMessageDialog(null, "el valor no se encuentra");
                    }

                    break;

                case 4:
                    vec.ordenarBurbuja();
                    JOptionPane.showMessageDialog(null, "El vector se ordeno");
                    break;
                case 5:
                    vec.ordenarIntercambio();
                    JOptionPane.showMessageDialog(null, "El vector se ordeno");
                    break;
                case 6:
                    vec.quickSort(0, vec.getTam() - 1);
                    JOptionPane.showMessageDialog(null, "El vector se ordeno");
                    break;
                case 7:
                    vec.ordenarBurbujaAlfabetico();
                    JOptionPane.showMessageDialog(null, "El vector se ordeno por cliente");
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (opc != 8);

    }

}
