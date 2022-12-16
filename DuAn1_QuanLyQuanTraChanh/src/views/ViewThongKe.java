package views;

import domainmodels.QuanLyThongKe;
import domainmodels.ThongKe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.IThongKeService;
import services.impl.ThongKeService;

public class ViewThongKe extends javax.swing.JPanel {

    private final IThongKeService thongKe_sv = new ThongKeService();
    private DefaultTableModel defaultTableModel;

    public ViewThongKe() {
        initComponents();
        initComponents();
        loadTable();
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateToChartl(chiu3);
        loadngay();
        ke.bieudotron(chiu10);

    }

    private void loadngay() {
        defaultTableModel = (DefaultTableModel) this.tb_doanhthu1.getModel();
        defaultTableModel.setRowCount(0);
        for (ThongKe ke : this.thongKe_sv.ngay()) {
            Object[] rowdata = {
                ke.getTiensanpham(),
                ke.getSoluongban()
            };
            defaultTableModel.addRow(rowdata);
        }
    }

    private void loadTable() {
        defaultTableModel = (DefaultTableModel) this.tb_doanhthu.getModel();
        defaultTableModel.setRowCount(0);
        for (ThongKe ke : this.thongKe_sv.getList2()) {
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

        chiu1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        JP_Ban = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_doanhthu = new com.raven.swing.table.Table();
        dc_ngaya = new com.toedter.calendar.JDateChooser();
        dc_ngayb = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        chiu3 = new javax.swing.JPanel();
        JPMenu = new javax.swing.JPanel();
        JP_Ban1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_doanhthu1 = new com.raven.swing.table.Table();
        dc_ngaya1 = new com.toedter.calendar.JDateChooser();
        dc_ngayb2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        chiu10 = new javax.swing.JPanel();

        javax.swing.GroupLayout chiu1Layout = new javax.swing.GroupLayout(chiu1);
        chiu1.setLayout(chiu1Layout);
        chiu1Layout.setHorizontalGroup(
            chiu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        chiu1Layout.setVerticalGroup(
            chiu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        setOpaque(false);

        JP_Ban.setBackground(new java.awt.Color(255, 255, 255));

        tb_doanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày ", "Tổng tiền"
            }
        ));
        tb_doanhthu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_doanhthuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb_doanhthuMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tb_doanhthu);

        dc_ngaya.setDateFormatString("yyyy-MM-dd");

        dc_ngayb.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Từ ngày");

        jLabel2.setText("Đến ngày");

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("In Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Resert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        chiu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chiu3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout chiu3Layout = new javax.swing.GroupLayout(chiu3);
        chiu3.setLayout(chiu3Layout);
        chiu3Layout.setHorizontalGroup(
            chiu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chiu3Layout.setVerticalGroup(
            chiu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JP_BanLayout = new javax.swing.GroupLayout(JP_Ban);
        JP_Ban.setLayout(JP_BanLayout);
        JP_BanLayout.setHorizontalGroup(
            JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_BanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_BanLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dc_ngayb, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_ngaya, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chiu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_BanLayout.setVerticalGroup(
            JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_BanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_BanLayout.createSequentialGroup()
                        .addGroup(JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dc_ngayb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dc_ngaya, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(chiu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh thu", JP_Ban);

        JPMenu.setBackground(new java.awt.Color(255, 255, 255));

        JP_Ban1.setBackground(new java.awt.Color(255, 255, 255));

        tb_doanhthu1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản phẩm", "Tổng số lượng"
            }
        ));
        tb_doanhthu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_doanhthu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb_doanhthu1MouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tb_doanhthu1);

        dc_ngaya1.setDateFormatString("yyyy-MM-dd");

        dc_ngayb2.setDateFormatString("yyyy-MM-dd");

        jLabel4.setText("Từ ngày");

        jLabel5.setText("Đến ngày");

        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("In Excel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Resert");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chiu10Layout = new javax.swing.GroupLayout(chiu10);
        chiu10.setLayout(chiu10Layout);
        chiu10Layout.setHorizontalGroup(
            chiu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chiu10Layout.setVerticalGroup(
            chiu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JP_Ban1Layout = new javax.swing.GroupLayout(JP_Ban1);
        JP_Ban1.setLayout(JP_Ban1Layout);
        JP_Ban1Layout.setHorizontalGroup(
            JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Ban1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Ban1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(dc_ngayb2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(dc_ngaya1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(chiu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_Ban1Layout.setVerticalGroup(
            JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Ban1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dc_ngaya1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dc_ngayb2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JP_Ban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chiu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(JP_Ban1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPMenuLayout = new javax.swing.GroupLayout(JPMenu);
        JPMenu.setLayout(JPMenuLayout);
        JPMenuLayout.setHorizontalGroup(
            JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPMenuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JP_Ban1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        JPMenuLayout.setVerticalGroup(
            JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPMenuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JP_Ban1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sản phẩm bán chạy", JPMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_doanhthuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_doanhthuMouseClicked


    }//GEN-LAST:event_tb_doanhthuMouseClicked


    private void tb_doanhthuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_doanhthuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_doanhthuMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  try {
            XSSFWorkbook workbook = new XSSFWorkbook(); // lay wordbook ra
            XSSFSheet sheet = workbook.createSheet("danhSach"); // tao sheet va dat ten
            XSSFRow row = null; //tao cot
            Cell cell = null;
            row = sheet.createRow(3);// xuoong 3 dong
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Ngày ");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tổng tiền");
            for (int i = 0; i < thongKe_sv.getList().size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(thongKe_sv.getList().get(i).getNgayThanhToan());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(thongKe_sv.getList().get(i).getTongtien());
            }
            File f = new File("F:\\JAVA1\\New folder(9)hoadon.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }

        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "In thành công");                                             // TODO add your handling code here:

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date ngay = dc_ngayb.getDate();
        Date ngayy = dc_ngaya.getDate();
        DefaultTableModel dtm = (DefaultTableModel) tb_doanhthu.getModel();
        dtm.setRowCount(0);
        ThongKe thongKe = new ThongKe();
        for (ThongKe data : thongKe_sv.timkiem(ngay, ngayy)) {
            Object[] row = {data.getNgayThanhToan(), data.getTongtien()

            };
            dtm.addRow(row);

        }
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateToo(ngay, ngayy, chiu3);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadTable();
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateToChartl(chiu3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tb_doanhthu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_doanhthu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_doanhthu1MouseClicked

    private void tb_doanhthu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_doanhthu1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_doanhthu1MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date ngay = dc_ngayb2.getDate();
        Date ngayy = dc_ngaya1.getDate();
        DefaultTableModel dtm = (DefaultTableModel) tb_doanhthu1.getModel();
        dtm.setRowCount(0);
        ThongKe thongKe = new ThongKe();
        for (ThongKe data : thongKe_sv.timkiemsanpham(ngay, ngayy)) {
            Object[] row = {data.getTiensanpham(), data.getSoluongban()

            };
            dtm.addRow(row);

        }
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.bieudotron(ngay, ngayy, chiu10);   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
try {
            XSSFWorkbook workbook = new XSSFWorkbook(); // lay wordbook ra
            XSSFSheet sheet = workbook.createSheet("danhSach"); // tao sheet va dat ten
            XSSFRow row = null; //tao cot
            Cell cell = null;
            row = sheet.createRow(3);// xuoong 3 dong
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Sản phẩm");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tổng số lượng");
            for (int i = 0; i < thongKe_sv.getList().size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(thongKe_sv.getList().get(i).getTiensanpham());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(thongKe_sv.getList().get(i).getSoluongban());
            }
            File f = new File("F:\\JAVA1\\New folder(9)hoadon.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }

        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "In thành công");                                             // TODO add your handling code here:

                                 // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        loadngay();
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.bieudotron(chiu10);     // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void chiu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chiu3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chiu3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMenu;
    private javax.swing.JPanel JP_Ban;
    private javax.swing.JPanel JP_Ban1;
    private javax.swing.JPanel chiu1;
    private javax.swing.JPanel chiu10;
    private javax.swing.JPanel chiu3;
    private com.toedter.calendar.JDateChooser dc_ngaya;
    private com.toedter.calendar.JDateChooser dc_ngaya1;
    private com.toedter.calendar.JDateChooser dc_ngayb;
    private com.toedter.calendar.JDateChooser dc_ngayb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.table.Table tb_doanhthu;
    private com.raven.swing.table.Table tb_doanhthu1;
    // End of variables declaration//GEN-END:variables

}
