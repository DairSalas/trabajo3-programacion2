package trabajo3;

import javax.swing.JOptionPane;

public class Trabajo3 {

    public static void mostrarTodo(VectorVeh declararVector) {

        String msg = "";
        for (int i = 0; i < declararVector.getNumElementos(); i++) {
            msg += mostrarVehiculo(declararVector.getVectorVehiculos(i));
        }

        JOptionPane.showMessageDialog(null, "Facturas guardadas:\n" + msg);
    }

    public static String mostrarVehiculo(vehiculo vehiculo) {
        String datos = "";
        datos += "Código::" + vehiculo.getCodigo()
                + "    Cliente::" + vehiculo.getCliente()
                + "    Vehiculo::" + vehiculo.getTipoVehiculo()
                + "    Horas::" + vehiculo.getHora()
                + "    Valor::" + vehiculo.getValor() + "\n";
        return datos;
    }

    public static int menu() {
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion:\n"
                    + "\n1. Inicializar vector facturas"
                    + "\n2. mostrar facturas"
                    + "\n3. buscar factura por valor usando el método lineal"
                    + "\n4. buscar factura por valor usando el método binario"
                    + "\n5. Ordenar por el método quicksort"
                    + "\n6. Ordenar por el método burbuja"
                    + "\n7. Ordenar por el método intercambio"
                    + "\n8. SALIR"
                    + "\nSeleccione una opción del 1 al 8"));
        } while (opc <= 0 || opc > 8);
        return opc;
    }

    public static void main(String[] args) {

        vehiculo v1 = new vehiculo();
        v1.setCliente("Juan");
        v1.setCodigo(123);
        v1.setNumHora(45);
        v1.setTipovehiculo("Auto");

        vehiculo v2 = new vehiculo();
        v2.setCliente("Andrés");
        v2.setCodigo(432);
        v2.setNumHora(2);
        v2.setTipovehiculo("Camioneta");

        vehiculo v3 = new vehiculo();
        v3.setCliente("Cristiano");
        v3.setCodigo(543);
        v3.setNumHora(21);
        v3.setTipovehiculo("Bus");

        vehiculo v4 = new vehiculo();
        v4.setCliente("Gerad");
        v4.setCodigo(322);
        v4.setNumHora(65);
        v4.setTipovehiculo("Auto");

        vehiculo v5 = new vehiculo();
        v5.setCliente("Leo");
        v5.setCodigo(123);
        v5.setNumHora(21);
        v5.setTipovehiculo("Auto");

        vehiculo v6 = new vehiculo();
        v6.setCliente("Neymar");
        v6.setCodigo(342);
        v6.setNumHora(45);
        v6.setTipovehiculo("Auto");

        vehiculo v7 = new vehiculo();
        v7.setCliente("Ana");
        v7.setCodigo(323);
        v7.setNumHora(7);
        v7.setTipovehiculo("Camioneta");

        vehiculo v8 = new vehiculo();
        v8.setCliente("Enzo");
        v8.setCodigo(164);
        v8.setNumHora(5);
        v8.setTipovehiculo("Bus");

        vehiculo v9 = new vehiculo();
        v9.setCliente("Eric");
        v9.setCodigo(233);
        v9.setNumHora(4);
        v9.setTipovehiculo("Auto");

        vehiculo v10 = new vehiculo();
        v10.setCliente("Eva");
        v10.setCodigo(643);
        v10.setNumHora(21);
        v10.setTipovehiculo("Bus");

        vehiculo v11 = new vehiculo();
        v11.setCliente("Wall-e");
        v11.setCodigo(431);
        v11.setNumHora(5);
        v11.setTipovehiculo("Camioneta");

        vehiculo v12 = new vehiculo();
        v12.setCliente("Hugo");
        v12.setCodigo(854);
        v12.setNumHora(81);
        v12.setTipovehiculo("Bus");

        vehiculo v13 = new vehiculo();
        v13.setCliente("Luz");
        v13.setCodigo(875);
        v13.setNumHora(76);
        v13.setTipovehiculo("Camioneta");

        vehiculo v14 = new vehiculo();
        v14.setCliente("Mar");
        v14.setCodigo(653);
        v14.setNumHora(56);
        v14.setTipovehiculo("Auto");

        int t = 14;

        VectorVeh declararVector = new VectorVeh();

        float val;
        int searched;

        int opc = 0;

        do {
            opc = menu();

            switch (opc) {
                case 1:
                    declararVector.setNumElementos(t);
                    declararVector.crearVector();

                    declararVector.setVectorVehiculos(0, v1);
                    declararVector.setVectorVehiculos(1, v2);
                    declararVector.setVectorVehiculos(2, v3);
                    declararVector.setVectorVehiculos(3, v4);
                    declararVector.setVectorVehiculos(4, v5);
                    declararVector.setVectorVehiculos(5, v6);
                    declararVector.setVectorVehiculos(6, v7);
                    declararVector.setVectorVehiculos(7, v8);
                    declararVector.setVectorVehiculos(8, v9);
                    declararVector.setVectorVehiculos(9, v10);
                    declararVector.setVectorVehiculos(10, v11);
                    declararVector.setVectorVehiculos(11, v12);
                    declararVector.setVectorVehiculos(12, v13);
                    declararVector.setVectorVehiculos(13, v14);

                    JOptionPane.showMessageDialog(null, "Se insertaron los primeros 12");
                    break;

                case 2:

                    if (declararVector.getNumElementos() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe llenar el vector, EJECUTAR la opción 1");
                    } else {
                        mostrarTodo(declararVector);
                    }

                    break;

                case 3:

                    if (declararVector.getNumElementos() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe llenar el vector, EJECUTAR la opción 1");
                    } else {
                        val = Integer.parseInt(JOptionPane.showInputDialog("ingrese valor a buscar"));

                        searched = declararVector.valorLineal(val);

                        if (searched != -1) {
                            JOptionPane.showMessageDialog(null, mostrarVehiculo(declararVector.getVectorVehiculos(searched)));
                        } else {
                            JOptionPane.showMessageDialog(null, "el valor no se encuentra");
                        }
                    }

                    break;

                case 4:

                    if (declararVector.getNumElementos() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe llenar el vector, EJECUTAR la opción 1");
                    } else {
                        val = Float.parseFloat(JOptionPane.showInputDialog("ingrese valor a buscar"));
                        searched = declararVector.ValorBinario(val);
                        System.out.println(searched);

                        if (searched != -1) {

                            JOptionPane.showMessageDialog(null, mostrarVehiculo(declararVector.getVectorVehiculos(searched)));

                        } else {
                            JOptionPane.showMessageDialog(null, "Ningún vehiculo conincide con el valor");
                        }
                    }

                    break;

                case 5:

                    if (declararVector.getNumElementos() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe llenar el vector, EJECUTAR la opción 1");
                    } else {
                        declararVector.llamarQuicksort();
                        JOptionPane.showMessageDialog(null, "El vector se ordeno");
                        mostrarTodo(declararVector);
                    }

                    break;

                case 6:

                    if (declararVector.getNumElementos() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe llenar el vector, EJECUTAR la opción 1");
                    } else {
                        declararVector.metodoBurbuja();
                        JOptionPane.showMessageDialog(null, "Se ordenó el vector");
                        mostrarTodo(declararVector);
                    }

                    break;

                case 7:

                    if (declararVector.getNumElementos() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe llenar el vector, EJECUTAR la opción 1");
                    } else {
                        declararVector.metodoIntercambio();
                        JOptionPane.showMessageDialog(null, "Se ordenó el vector");
                        mostrarTodo(declararVector);
                    }

                    break;
            }
        } while (opc != 8);

    }

}
