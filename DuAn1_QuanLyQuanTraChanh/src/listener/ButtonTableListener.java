/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import domainmodels.Ban;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import services.IBanService;
import views.ViewBanHang;

/**
 *
 * @author Hung
 */
public class ButtonTableListener implements ActionListener {

    private IBanService csv;
    private JButton btn;
    private ViewBanHang view;

    public ButtonTableListener(IBanService csv, JButton btn, ViewBanHang view) {
        this.csv = csv;
        this.btn = btn;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ban b : csv.getlist()) {
            if (b.getTenBan().equalsIgnoreCase(btn.getText())) {
                view.setTextBan(b.getTenBan());
                btn.setBackground(Color.red);
                return;
            }
        }
    }

}
