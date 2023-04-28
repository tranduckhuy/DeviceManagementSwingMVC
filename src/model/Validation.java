
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Validation {
    
    private static int checkInteger(String s) {
        
        if(!s.isEmpty()) {
            try {
                int i = Integer.parseInt(s);
                if(i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        }
        return -1;
    }
    
    private static double checkDouble(String s) {
        
        if(!s.isEmpty()) {
            try {
                double i = Double.parseDouble(s);
                if(i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        }
        return -1;
    }
    
    private static String checkString(String s) {
            s = s.trim();
            s = s.replaceAll("\\s+", " ");
            return s;
    }
    
    
    public static Device checkDeviceInfo(String id, String name, String quantity, String price) {
        int cId = checkInteger(id);
        int cQuantity = checkInteger(quantity);
        double cPrice = checkDouble(price);
        if(name.isEmpty() || cQuantity == -1 || cPrice == -1) {
            return null;
        }
        String cName = checkString(name);
        return new Device(cId, cName, cQuantity, cPrice);
    }
}
