
package interfazdepetita;

import javax.swing.JOptionPane;

/**
 *
 * @author Lady Diane
 */
public class Alerts {
       public static int inputInt(String texto){
        return Integer.parseInt(JOptionPane.showInputDialog(texto));
    }
    
    public static double inputDouble(String texto){
        return Double.parseDouble(JOptionPane.showInputDialog(texto));
    }
    
    public static String inputString(String texto){
        return JOptionPane.showInputDialog(texto);
    } 
    
    public static void print(String texto){
        JOptionPane.showMessageDialog(null, texto);
    } 
}
