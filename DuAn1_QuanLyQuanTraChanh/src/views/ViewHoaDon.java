package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.impl.HoaDonService;
import viewmodels.HoaDonVM;
import services.IHoaDonService;

public class ViewHoaDon extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private final IHoaDonService hdsvvm = new HoaDonService();

    public ViewHoaDon() {
        initComponents();
    }
//    private HoaDon getData() {
//        String ma = txt_ma.getText().trim();
//        String ngaytao = txt_ngaytao.getText().trim();
//        String ngaytt = txt_ngaytt.getText().trim();
//        String ngayship = txt_ngays.getText().trim();
//        String ngaynhan = txt_ngayn.getText().trim();
//        String tt = txt_trangthai.getText().trim();
//        String ten = txt_ten.getText().trim();
//        String diachi = txt_diachi.getText().trim();
//        String sdt = txt_sdt.getText().trim();
//        if (ma.length() == 0
//                || ten.length() == 0
//                || ngaynhan.length() == 0 || ngayship.length() == 0 || ngaytao.length() == 0 || ngaytt.length() == 0) {
//            JOptionPane.showMessageDialog(this, "Ko được để trống");
//            return null;
//        }
//
//        int trangthai = -1;
//        trangthai = Integer.parseInt(tt);
//
//        HoaDon hoaDon = new HoaDon(ma, ngaytao, ngaytt, ngayship, ngaynhan, trangthai, ten, diachi, sdt);
//        return hoaDon;
//    }

    public void loatTable() {
        defaultTableModel = (DefaultTableModel) this.tb_hoadon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonVM hdvm : hdsvvm.getlist()) {
            Object[] rowdata = {
                hdvm.getMahd(),
                hdvm.getNgayTao(),
                hdvm.getNguoitao(),
                hdvm.getTongtien(),
                hdvm.getTrangthai()

            };
            defaultTableModel.addRow(rowdata);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tb_hoadon = new com.raven.swing.table.Table();
        btn_thongke = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_tk = new javax.swing.JTextField();
        btn_tk = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "NgayTao", "NguoiTao", "TenKH", "DiaChi", "TongTien", "SDTNguoiNhan", "TrangThai"
            }
        ));
        jScrollPane2.setViewportView(tb_hoadon);

        btn_thongke.setText("THỐNG KÊ");
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        jLabel1.setText("Trạng thái:");

        btn_tk.setText("TÌM KIẾM");

        btnIn.setText("In Excel");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_tk)
                .addGap(43, 43, 43)
                .addComponent(btn_thongke)
                .addGap(47, 47, 47)
                .addComponent(btnIn)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thongke)
                    .addComponent(jLabel1)
                    .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tk)
                    .addComponent(btnIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        // TODO add your handling code here:
        loatTable();
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
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
            cell.setCellValue("Mã hóa đơn");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày tạo");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Người tạo");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên khách hàng");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tổng tiền");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Trạng thái");

//            for (int i = 0; i < hdsvvm.getAll().size(); i++) {
//                row = sheet.createRow(4 + i);
//
//                cell = row.createCell(0, CellType.STRING);
//                cell.setCellValue(i + 1);
//
//                cell = row.createCell(1, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getMahd());
//
//                cell = row.createCell(2, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getNgayTao());
//
//                cell = row.createCell(3, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getNguoitao());
//
//                cell = row.createCell(4, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getTenkh());
//
//                cell = row.createCell(5, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getDiachi());
//
//                cell = row.createCell(6, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getTongtien());
//
//                cell = row.createCell(7, CellType.STRING);
//                cell.setCellValue(hdsvvm.getByID().get(i).getTrangthai());
//
//            }
            File f = new File("E://hoaDon.xlsx");
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
    }//GEN-LAST:event_btnInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JButton btn_tk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.Table tb_hoadon;
    private javax.swing.JTextField txt_tk;
    // End of variables declaration//GEN-END:variables
}
