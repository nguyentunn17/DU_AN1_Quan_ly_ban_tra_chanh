package utilities;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Validation {

    private static Boolean showMessage(String txtValue, String P_number, String msg, String error, int msg2, JTextField txtField, boolean expression) {
        if (expression) {
            JOptionPane.showMessageDialog(null, msg, error, msg2);
            txtField.setBackground(Color.red);
            txtField.requestFocus();
            return false;
        } else {
            txtField.setBackground(Color.white);
            return true;
        }
    }

    public static Boolean isEmpty(JTextField txtField, String msg, String error, int msg2) {
        String txtValue = txtField.getText().trim();
        boolean exp = (txtValue.equals(""));
        return showMessage(txtValue, error, msg, error, msg2, txtField, exp);
    }

    public static Boolean isEmail(JTextField txtField, String msg, String error, int msg2) {
        String txtValue = txtField.getText().trim();
        String P_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        boolean exp = (!txtValue.matches(P_EMAIL));
        return showMessage(txtValue, P_EMAIL, msg, error, msg2, txtField, exp);
    }

    public static Boolean isNumber(JTextField txtField, String msg, String error, int msg2) {
        String txtValue = txtField.getText().trim();
        String P_number = "^//d$";
        boolean exp = (!txtValue.matches(P_number));
        return showMessage(txtValue, P_number, msg, error, msg2, txtField, exp);
    }

    public static Boolean isSDT(JTextField txtField, String msg, String error, int msg2) {
        String txtValue = txtField.getText().trim();
        String SDT = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        boolean exp = (!txtValue.matches(SDT));
        return showMessage(txtValue, SDT, msg, error, msg2, txtField, exp);
    }

    public static boolean isDiem(JTextField txtField) {
        try {
            double diem = Double.parseDouble(txtField.getText());
            if (diem < 0 || diem > 10) {
                JOptionPane.showMessageDialog(null, "Diem phải trong khoảng từ 0 -> 10", "Error", JOptionPane.ERROR_MESSAGE);
                txtField.setBackground(Color.red);
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Diem phải nhập số", "Error", JOptionPane.ERROR_MESSAGE);
            txtField.setBackground(Color.red);
            return false;
        }
        return true;
    }

}
