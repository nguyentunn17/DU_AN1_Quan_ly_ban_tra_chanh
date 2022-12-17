package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.IBanHangService;
import services.impl.HoaDonService;
import viewmodels.HoaDonVM;
import services.IHoaDonService;
import services.impl.BanHangService;
import viewmodels.HoaDonChiTietViewModel;

public class ViewHoaDon extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private final IHoaDonService hdsvvm = new HoaDonService();
    private final IBanHangService banHangService;
    private DefaultTableModel dtm;

    public ViewHoaDon() {
        initComponents();
        this.banHangService = new BanHangService();
        loatTable();
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
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        int stt = 1;
        for (HoaDonVM hdvm : hdsvvm.getHoaDon()) {
            Object[] rowdata = {
                stt++,
                hdvm.getMahd(),
                hdvm.getNguoiTao(),
                df.format(hdvm.getNgayTao()),
                df.format(hdvm.getNgayThanhToan()),
                hdvm.getThanhTien(),
                hdvm.getTrangthai() == 0 ? "Đã thanh toán" : "Chờ thanh toán"

            };
            defaultTableModel.addRow(rowdata);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tb_hoadon = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        txt_tk = new javax.swing.JTextField();
        btn_tk = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_hoadon1 = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MaHD", "Người tạo", "NgayTao", "Ngày thanh toán", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_hoadon);
        if (tb_hoadon.getColumnModel().getColumnCount() > 0) {
            tb_hoadon.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setText("Ngày tạo");

        btn_tk.setText("Lọc");
        btn_tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tkActionPerformed(evt);
            }
        });

        btnIn.setText("In Excel");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        tb_hoadon1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số Lượng", "Giá bán", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb_hoadon1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(btn_tk)
                .addGap(113, 113, 113)
                .addComponent(btnIn)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tk)
                    .addComponent(btnIn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danhSach");
            XSSFRow row = null; //tao cot
            Cell cell = null;
            row = sheet.createRow(3);// xuoong 3 dong
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã hóa đơn");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Người tạo");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày tạo");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Ngày thanh toán");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Tổng tiền");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Trạng thái");

            for (int i = 0; i < hdsvvm.getHoaDon().size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(hdsvvm.getHoaDon().get(i).getMahd());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(hdsvvm.getHoaDon().get(i).getNguoiTao());

                cell = row.createCell(3, CellType.FORMULA);
                cell.setCellValue(hdsvvm.getHoaDon().get(i).getNgayTao());

                cell = row.createCell(4, CellType.FORMULA);
                cell.setCellValue(hdsvvm.getHoaDon().get(i).getNgayThanhToan());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(hdsvvm.getHoaDon().get(i).getThanhTien());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(hdsvvm.getHoaDon().get(i).getTrangthai() == 0 ? "Đã thanh toán" : "Chờ thanh toán");

            }
            File f = new File("D:\\hoadon.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }

        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "In thành công");
    }//GEN-LAST:event_btnInActionPerformed

    private void btn_tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tkActionPerformed
        if (!txt_tk.getText().equalsIgnoreCase("")) {
            try {
                String date = new SimpleDateFormat("dd/mm/yyyy").format(new SimpleDateFormat("dd/mm/yyyy").parse(txt_tk.getText()));
                loatTable();
                for (int i = 0; i < tb_hoadon.getRowCount(); i++) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date da = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(String.valueOf(tb_hoadon.getValueAt(i, 3)));
                    String d2 = format.format(da);
                    if (!d2.equals(date)) {
                        ((DefaultTableModel) tb_hoadon.getModel()).removeRow(i);
                        i = -1;
                    }
                }
                if (tb_hoadon.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Không có thông tin ngày này");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ViewHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            loatTable();
        }
    }//GEN-LAST:event_btn_tkActionPerformed

    private void tb_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoadonMouseClicked
        dtm = (DefaultTableModel) tb_hoadon1.getModel();
        dtm.setRowCount(0);
        int row = tb_hoadon.getSelectedRow();
        String ma = tb_hoadon.getValueAt(row, 1).toString();
        int stt = 1;
        for (HoaDonChiTietViewModel hdct : this.banHangService.loadSp(ma)) {
            Object[] rowdata = {
                stt++,
                hdct.getMasp(),
                hdct.getTensp(),
                hdct.getSoLuong(),
                hdct.getGiaBan(),
                hdct.getSoLuong() * hdct.getGiaBan()
            };
            dtm.addRow(rowdata);
        }
    }//GEN-LAST:event_tb_hoadonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btn_tk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.raven.swing.table.Table tb_hoadon;
    private com.raven.swing.table.Table tb_hoadon1;
    private javax.swing.JTextField txt_tk;
    // End of variables declaration//GEN-END:variables
}
