package views;

import domainmodels.AnhSanPham;
import domainmodels.SanPham;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import services.IAnhService;
import services.ISanPhamService;
import services.impl.AnhService;
import services.impl.SanPhamService;
import viewmodels.AnhViewModel;

public class ViewAnh extends javax.swing.JFrame {

    private final IAnhService anhService;
    private final ISanPhamService sanPhamService;
    DefaultTableModel dtm;
    private String hinhAnh = null;

    public ViewAnh() {
        initComponents();
        this.anhService = new AnhService();
        this.sanPhamService = new SanPhamService();
        this.loadTable();
        this.getcombobox();
    }

    private void loadTable() {
        dtm = (DefaultTableModel) tb_anh.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (AnhViewModel anhSanPham : this.anhService.read()) {
            Object[] rowdata = {
                stt++,
                anhSanPham.getTenAnh(),
                anhSanPham.getTenSP(),
                anhSanPham.getDuongDan(),
                anhSanPham.getTrangThai() == 1 ? "Hoạt động" : "Ngừng hoạt động"};
            dtm.addRow(rowdata);
        }
    }

    private AnhSanPham getForm() {
        AnhSanPham anhSanPham = new AnhSanPham();
        String ten = txt_ma.getText().trim();
        String sanpham = cbb_sanpham.getSelectedItem().toString();
        String trangThai = cbb_hoatdong.getSelectedItem().toString();
        anhSanPham.setTenAnh(ten);
        anhSanPham.setIdSP(getidsp(sanpham));
        anhSanPham.setTrangThai(1);

        return anhSanPham;
    }

    private void getcombobox() {
        cbb_sanpham.removeAllItems();
        for (SanPham sp : this.sanPhamService.read()) {
            cbb_sanpham.addItem(sp.getTenSP());
        }
    }

    private String getidsp(String ten) {
        for (SanPham sanPham : this.sanPhamService.read()) {
            if (sanPham.getTenSP().equalsIgnoreCase(ten)) {
                return sanPham.getId();
            }
        }
        return null;
    }

    private String getidanh(String ten) {
        for (AnhViewModel sp : this.anhService.read()) {
            if (sp.getTenSP().equalsIgnoreCase(ten)) {
                return sp.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_anh = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_anh = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_ma = new javax.swing.JTextField();
        cbb_sanpham = new javax.swing.JComboBox<>();
        cbb_hoatdong = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_anh.setBackground(new java.awt.Color(204, 204, 204));
        lbl_anh.setForeground(new java.awt.Color(204, 204, 204));
        lbl_anh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
        });

        btn_them.setText("Thêm ảnh");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        tb_anh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên ảnh", "Tên sản phẩm", "Đường dẫn", "Trạng thái"
            }
        ));
        tb_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_anhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb_anhMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tb_anh);

        jLabel2.setText("Tên ảnh");

        jLabel3.setText("Trạng thái");

        jLabel4.setText("Tên sản phẩm");

        btn_sua.setText("Sửa ảnh");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbb_sanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbb_hoatdong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động ", "Ngừng hoạt động" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_them)
                        .addGap(58, 58, 58)
                        .addComponent(btn_sua)
                        .addGap(69, 69, 69)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbb_hoatdong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbb_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(103, 103, 103)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbb_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_hoatdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(jButton3))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
        JFileChooser FileChooser = new JFileChooser("D:\\FPT_Polytechnic\\DuAn1\\DuAn1_QuanLyQuanTraChanh\\src\\image");
        int result = FileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = FileChooser.getSelectedFile();
            hinhAnh = file.getName();
            System.out.println(hinhAnh);
            Icon icon = new ImageIcon(file.getAbsolutePath());
            this.lbl_anh.setIcon(icon);
        }
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void tb_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_anhMouseClicked
        int row = tb_anh.getSelectedRow();
        String tenAnh = tb_anh.getValueAt(row, 1).toString();
        String tenSanPham = tb_anh.getValueAt(row, 2).toString();
        String trangThai = tb_anh.getValueAt(row, 4).toString();
        String hinh = tb_anh.getValueAt(row, 3).toString();

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + hinh));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lbl_anh.getWidth(), lbl_anh.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        lbl_anh.setIcon(imageIcon);
        txt_ma.setText(tenAnh);
        cbb_sanpham.setSelectedItem(tenSanPham);
        cbb_hoatdong.setSelectedItem(trangThai);
    }//GEN-LAST:event_tb_anhMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        AnhSanPham asp = this.getForm();
        this.anhService.create(asp);
        this.loadTable();
    }//GEN-LAST:event_btn_themActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ViewSanPham().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_anh.getSelectedRow();
        String ma = tb_anh.getValueAt(row, 1).toString();
        AnhSanPham asp = this.getForm();
        this.anhService.update(asp, getidanh(ma));
        this.loadTable();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tb_anhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_anhMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_anhMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAnh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAnh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAnh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAnh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAnh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JComboBox<String> cbb_hoatdong;
    private javax.swing.JComboBox<String> cbb_sanpham;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JTable tb_anh;
    private javax.swing.JTextField txt_ma;
    // End of variables declaration//GEN-END:variables
}
