package views;

import domainmodels.QuanLyThongKe;
import domainmodels.ThongKe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.impl.ThongKeService;
import services.IThongKeService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ViewThongKe extends javax.swing.JPanel {

    private final IThongKeService thongKe_sv = new ThongKeService();
    private DefaultTableModel defaultTableModel;

    public ViewThongKe() {
        initComponents();
        loadTable();
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateToChartl(chiu1);
    }

    private void loadTable() {
        defaultTableModel = (DefaultTableModel) this.tbl_ngaythanhtoan.getModel();
        defaultTableModel.setRowCount(0);
        for (ThongKe ke : this.thongKe_sv.getList()) {
            Object[] rowdata = {
                ke.getNgayThanhToan(),
                ke.getTongtien()
            };
            defaultTableModel.addRow(rowdata);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        khongcodau = new javax.swing.JPanel();
        chiu1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ngaythanhtoan = new javax.swing.JTable();
        btn_timkiem = new javax.swing.JButton();
        dc_ngay = new com.toedter.calendar.JDateChooser();
        btn_timkhoang = new javax.swing.JButton();
        dc_ngaya = new com.toedter.calendar.JDateChooser();
        dc_ngayb = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        khongcodau.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout chiu1Layout = new javax.swing.GroupLayout(chiu1);
        chiu1.setLayout(chiu1Layout);
        chiu1Layout.setHorizontalGroup(
            chiu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chiu1Layout.setVerticalGroup(
            chiu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        tbl_ngaythanhtoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ngày thanh toán", "Tổng tiền"
            }
        ));
        tbl_ngaythanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ngaythanhtoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ngaythanhtoan);

        btn_timkiem.setText("Tìm ngày");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        dc_ngay.setDateFormatString("yyyy-MM-dd");

        btn_timkhoang.setText("Tìm khoảng ngày");
        btn_timkhoang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkhoangActionPerformed(evt);
            }
        });

        dc_ngaya.setDateFormatString("yyyy-MM-dd");

        dc_ngayb.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Resert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("In Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout khongcodauLayout = new javax.swing.GroupLayout(khongcodau);
        khongcodau.setLayout(khongcodauLayout);
        khongcodauLayout.setHorizontalGroup(
            khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, khongcodauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(khongcodauLayout.createSequentialGroup()
                        .addComponent(btn_timkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkhoang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_ngaya, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_ngayb, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(chiu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        khongcodauLayout.setVerticalGroup(
            khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, khongcodauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(khongcodauLayout.createSequentialGroup()
                        .addGroup(khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, khongcodauLayout.createSequentialGroup()
                                .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(khongcodauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dc_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(dc_ngayb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btn_timkhoang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dc_ngaya, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chiu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(khongcodau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(khongcodau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ngaythanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ngaythanhtoanMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_ngaythanhtoanMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        Date ngay = dc_ngaya.getDate();
        DefaultTableModel dtm = (DefaultTableModel) tbl_ngaythanhtoan.getModel();
        dtm.setRowCount(0);
        ThongKe thongKe = new ThongKe();
        for (ThongKe data : thongKe_sv.timkiem(ngay)) {
            Object[] row = {
                data.getNgayThanhToan(), 
                data.getTongtien()
            };
            dtm.addRow(row);

        }
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDate(ngay, chiu1);

    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_timkhoangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkhoangActionPerformed
        // TODO add your handling code here:
        Date ngay = dc_ngaya.getDate();
        Date ngayy = dc_ngayb.getDate();
        DefaultTableModel dtm = (DefaultTableModel) tbl_ngaythanhtoan.getModel();
        dtm.setRowCount(0);
        ThongKe thongKe = new ThongKe();
        for (ThongKe data : thongKe_sv.timkiem(ngay, ngayy)) {
            Object[] row = {data.getNgayThanhToan(), data.getTongtien()

            };
            dtm.addRow(row);

        }
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateToo(ngay, ngayy, chiu1);
    }//GEN-LAST:event_btn_timkhoangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadTable();
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateToChartl(chiu1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(); // lay wordbook ra
            XSSFSheet sheet = workbook.createSheet("danhSach"); // tao sheet va dat ten
            XSSFRow row = null; //tao cot
            Cell cell = null;
            row = sheet.createRow(3);// xuoong 3 dong
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Id");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tổng Tiền");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày thanh toán");

            for (int i = 0; i < thongKe_sv.getList().size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(thongKe_sv.getList().get(i).getTongtien());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(thongKe_sv.getList().get(i).getNgayThanhToan());

            }
            File f = new File("E://thongKe.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "In thành công");

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_timkhoang;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JPanel chiu1;
    private com.toedter.calendar.JDateChooser dc_ngay;
    private com.toedter.calendar.JDateChooser dc_ngaya;
    private com.toedter.calendar.JDateChooser dc_ngayb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel khongcodau;
    private javax.swing.JTable tbl_ngaythanhtoan;
    // End of variables declaration//GEN-END:variables
}
