package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import services.ISanPhamService;
import viewmodels.SanPhamViewModel;
import views.ViewBanHang;

public class ButtonSanPhamListener implements ActionListener {

    private final JButton btn;
    private final ISanPhamService sanPhamService;
    private final ViewBanHang view;

    public ButtonSanPhamListener(JButton btn, ISanPhamService sanPhamService, ViewBanHang view) {
        this.btn = btn;
        this.sanPhamService = sanPhamService;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (SanPhamViewModel sanPhamViewModel : this.sanPhamService.getByID()) {
            if (sanPhamViewModel.getTensp().equalsIgnoreCase(btn.getText())) {
                String ma = sanPhamViewModel.getMasp();
                String ten = sanPhamViewModel.getTensp();

                Double giaBan = sanPhamViewModel.getGiaBan();
                
                view.getThongTinSP(ma, ten, giaBan);
                return;
            }
        }
    }
}
