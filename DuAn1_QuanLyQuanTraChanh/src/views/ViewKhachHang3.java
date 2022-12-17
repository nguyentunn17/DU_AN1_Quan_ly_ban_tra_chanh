
package views;

import com.google.zxing.qrcode.encoder.QRCode;
import domainmodels.KhachHang;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import services.IKhachHangService;
import services.impl.KhachHangService;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import net.glxn.qrgen.image.ImageType;


public class ViewKhachHang3 extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private IKhachHangService khachHangService = new KhachHangService();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    
    public ViewKhachHang3() {
        initComponents();

        loadTable();
    }

    private void loadTable() {
        dtm = (DefaultTableModel) tbKhachHang.getModel();
        dtm.setRowCount(0);
        for (KhachHang kh : khachHangService.getAll()) {
            Object[] row = {
                kh.getMakh(), kh.getTenkh(), kh.getNgaysinh(), kh.getSdt(), kh.getDiachi(), kh.getGioitinh(), kh.getGhichu()
            };
            dtm.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tbKhachHang = new com.raven.swing.table.Table();

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Giới tính", "Ghi chú"
            }
        ));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbKhachHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked

    }//GEN-LAST:event_tbKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane5;
    private com.raven.swing.table.Table tbKhachHang;
    // End of variables declaration//GEN-END:variables
}
