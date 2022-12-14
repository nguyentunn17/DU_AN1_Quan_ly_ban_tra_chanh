/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodels.Ban;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.IBanService;
import services.impl.BanService;

/**
 *
 * @author Hung
 */
public class ViewKhuBan extends javax.swing.JPanel {

    /**
     * Creates new form viewKhuban
     */
    public ViewKhuBan() {
        initComponents();
        rdTrangThai();
        loaddat();
    }
    private final IBanService csv = new BanService();
    private DefaultTableModel defaultTableModel;

    ButtonGroup buttonGroup;

    private void rdTrangThai() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdDuoc);
        buttonGroup.add(rdKo);
    }

    private void loaddat() {
        defaultTableModel = (DefaultTableModel) tbBan.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (Ban b : csv.getlist()) {
            defaultTableModel.addRow(new Object[]{
                stt++, b.getMaBan(), b.getTenBan(), b.getSoNguoi(), getTrangThai(b.getTrangThai())});
        }

    }

    private String getTrangThai(int a) {
        if (a == 0) {
            return "Dùng được";
        } else {
            return "Không dùng được";
        }

    }

    void clear() {
        txt_maca.setText("");
        txt_tenca.setText("");
        txt_soLg.setText("");
        buttonGroup.clearSelection();
    }

    private Ban getdata() {
        try {
            Ban b = new Ban();
            String maban = this.txt_maca.getText().trim();
            String tenban = this.txt_tenca.getText().trim();
            int soNguoi = Integer.parseInt(txt_soLg.getText());
            if (maban.length() == 0 || tenban.length() == 0) {
                JOptionPane.showMessageDialog(this, "Không để trống");
                return null;
            }
            try {

                if (soNguoi < 0) {
                    JOptionPane.showMessageDialog(this,
                            "Số người phải là số dương");
                    return null;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Số người phải là số");
                return null;
            }
            b.setMaBan(maban);
            b.setTenBan(tenban);
            b.setSoNguoi(soNguoi);
            if (rdDuoc.isSelected()) {
                b.setTrangThai(0);
            } else {
                b.setTrangThai(1);
            }
            return b;
        } catch (Exception e) {
        }
        return null;
    }

    private String getid(String ma) {
        for (Ban b : this.csv.getlist()) {
            if (b.getMaBan().equals(ma)) {
                return b.getId();
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbBan = new com.raven.swing.table.Table();
        jLabel16 = new javax.swing.JLabel();
        txt_tenca = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        txt_soLg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_maca = new javax.swing.JTextField();
        rdDuoc = new javax.swing.JRadioButton();
        rdKo = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã bàn", "Tên bàn", "Số lượng chỗ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbBan);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Trạng thái:");

        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_them.setText("THÊM");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Số lượng chỗ:");

        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_sua.setText("SỬA");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã bàn:");

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_xoa.setText("XÓA");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên bàn:");

        rdDuoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdDuoc.setText("Dùng được");

        rdKo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdKo.setText("Không dùng được");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdDuoc)
                                .addGap(27, 27, 27)
                                .addComponent(rdKo))
                            .addComponent(txt_maca, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(txt_tenca)
                            .addComponent(txt_soLg)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_soLg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(rdDuoc)
                    .addComponent(rdKo))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_xoa)
                    .addComponent(btn_sua))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
//            JOptionPane.showMessageDialog(this, csv.insert(getdata1()));
//            loaddat();
//            clear();
//{
//            int row = tbBan.getSelectedRow();
//            if (this.txt_maca.equals(tbBan.getValueAt(row, 0).toString())) {
//                JOptionPane.showMessageDialog(this, "Đã có mã");
//                return;
//            }
//            if (this.txt_tenca.equals(tbBan.getValueAt(row, 1).toString())) {
//                JOptionPane.showMessageDialog(this, "Đã có tên bàn");
//                return;
//            }
//}
        String ma = txt_maca.getText().trim();
        boolean check = csv.checkTrung(ma);
        Ban b = this.getdata();
        if (b == null) {
            return;
        } else if (check) {
            JOptionPane.showMessageDialog(this, "Trùng mã bàn");
            return;
        }
        this.csv.insert(b);
        loaddat();
        clear();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:luong lg=this.getdata();
        int row = tbBan.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        Ban b = this.getdata();
        if (b == null) {
            return;
        }
        String ma = tbBan.getValueAt(row, 0).toString();
        this.csv.Update(getid(ma), b);
        this.loaddat();
        clear();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int i = tbBan.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Xác nhận xóa?");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String ma = tbBan.getValueAt(i, 0).toString();
        this.csv.delete(getid(ma));
        this.loaddat();
        clear();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        // TODO add your handling code here:
        int row = tbBan.getSelectedRow();
        txt_maca.setText(tbBan.getValueAt(row, 1).toString());
        txt_tenca.setText(tbBan.getValueAt(row, 2).toString());
        txt_soLg.setText(tbBan.getValueAt(row, 3).toString());
        if (tbBan.getValueAt(row, 4).toString().equals("Dùng được")) {
            rdDuoc.setSelected(true);
        } else {
            rdKo.setSelected(true);
        }
    }//GEN-LAST:event_tbBanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JRadioButton rdDuoc;
    private javax.swing.JRadioButton rdKo;
    private com.raven.swing.table.Table tbBan;
    private javax.swing.JTextField txt_maca;
    private javax.swing.JTextField txt_soLg;
    private javax.swing.JTextField txt_tenca;
    // End of variables declaration//GEN-END:variables
}
