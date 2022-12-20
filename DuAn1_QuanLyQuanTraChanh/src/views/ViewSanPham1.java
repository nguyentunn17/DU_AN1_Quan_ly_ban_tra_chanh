package views;

import domainmodels.DanhMuc;
import domainmodels.KichThuoc;
import domainmodels.SanPham;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import services.IDanhMucService;
import services.IKichThuocService;
import services.ISanPhamService;
import services.impl.DanhMucService;
import services.impl.KichThuocService;
import services.impl.SanPhamService;
import viewmodels.SanPhamViewModel;

public class ViewSanPham1 extends javax.swing.JPanel {

    private final ISanPhamService sanPhamService;
    private final IKichThuocService kichThuocService;
    private final IDanhMucService danhMucService;
    DefaultTableModel dtm;

    public ViewSanPham1() {
        initComponents();
        this.sanPhamService = new SanPhamService();
        this.kichThuocService = new KichThuocService();
        this.danhMucService = new DanhMucService();
        this.loadTableSP(this.sanPhamService.getByID());
        this.loadCBSize();
        this.loadCBDanhMuc();
        this.loadCBDanhMucLoc();
    }

    private void loadTableSP(ArrayList<SanPhamViewModel> list) {
        dtm = (DefaultTableModel) tb_sanpham.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (SanPhamViewModel spmd : list) {
            Object[] rowdata = {
                stt++,
                spmd.getMasp(),
                spmd.getTensp(),
                spmd.getLoaiSP(),
                spmd.getSize(),
                spmd.getGiaNhap(),
                spmd.getGiaBan(),
                spmd.getSoLuong(),
                spmd.getTrangThai() == 0 ? "Đang bán" : "Ngừng bán",
                spmd.getMoTa(),
                spmd.getAnh()
            };
            dtm.addRow(rowdata);
        }
    }

    private void loadCBSize() {
        cbb_size.removeAllItems();
        for (KichThuoc kichThuoc : this.kichThuocService.getList()) {
            if (kichThuoc.getTrangthai() == 0) {
                cbb_size.addItem(kichThuoc.getTenkt());

            }
        }
    }

    private void loadCBDanhMuc() {
        cbb_loaisanpham.removeAllItems();
        for (DanhMuc dm : this.danhMucService.read()) {
            if (dm.getTrangThai() == 0) {
                cbb_loaisanpham.addItem(dm.getTen());
            }
        }
    }

    private void loadCBDanhMucLoc() {
        cbb_lcodanhmuc.removeAllItems();
        for (DanhMuc dm : this.danhMucService.read()) {
            if (dm.getTrangThai() == 0) {
                cbb_lcodanhmuc.addItem(dm.getTen());
            }
        }
    }

    private SanPham getForm() {
        String ma = txt_ma.getText().trim();
        String ten = txt_ten.getText().trim();
        String giaBanStr = txt_giaban.getText().trim();
        String giaNhapStr = txt_gianhap.getText().trim();
        String soLuongTonStr = txt_soLuongton.getText().trim();
        String moTa = txa_moTa.getText().trim();
        String loai = cbb_loaisanpham.getSelectedItem().toString();
        String size = cbb_size.getSelectedItem().toString();
        String trangThai = cbb_trangThai.getSelectedItem().toString();

        Double giaNhap = Double.parseDouble(giaNhapStr);
        Double giaBan = Double.parseDouble(giaBanStr);
        Integer soLuongTon = Integer.parseInt(soLuongTonStr);

        SanPham sp = new SanPham(getidSize(size), getidDanhMuc(loai), ma, ten, giaNhap, giaBan, soLuongTon, moTa, WIDTH);
        if (trangThai.equalsIgnoreCase("Đang bán")) {
            sp.setTrangThai(0);
        } else {
            sp.setTrangThai(1);
        }
        return sp;
    }

    private String getidSp(String ma) {
        for (SanPham sanPham : this.sanPhamService.read()) {
            if (sanPham.getMaSP().equalsIgnoreCase(ma)) {
                return sanPham.getId();
            }
        }
        return null;
    }

    private String getidSize(String ten) {
        for (KichThuoc kt : this.kichThuocService.getList()) {
            if (kt.getTenkt().equalsIgnoreCase(ten)) {
                return kt.getId();
            }
        }
        return null;
    }

    private String getidDanhMuc(String ten) {
        for (DanhMuc danhMuc : this.danhMucService.read()) {
            if (danhMuc.getTen().equalsIgnoreCase(ten)) {
                return danhMuc.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        txt_gianhap = new javax.swing.JTextField();
        txt_soLuongton = new javax.swing.JTextField();
        cbb_loaisanpham = new javax.swing.JComboBox<>();
        cbb_size = new javax.swing.JComboBox<>();
        cbb_trangThai = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_moTa = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txt_giaban = new javax.swing.JTextField();
        lbl_anh = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_hinhanh = new javax.swing.JLabel();
        btn_themloaisp = new javax.swing.JButton();
        btn_themsize = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbb_lcodanhmuc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbb_loctrangthai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_sanpham = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Mã sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Giá nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Số lượng tồn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Loại sản phẩm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Size");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Trạng thái");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Mô tả");

        txt_soLuongton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongtonActionPerformed(evt);
            }
        });

        cbb_trangThai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Ngừng bán" }));

        txa_moTa.setColumns(20);
        txa_moTa.setRows(5);
        jScrollPane2.setViewportView(txa_moTa);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Giá bán");

        lbl_anh.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_hinhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hinhanhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        btn_themloaisp.setText("+");
        btn_themloaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themloaispActionPerformed(evt);
            }
        });

        btn_themsize.setText("+");
        btn_themsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themsizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbb_size, javax.swing.GroupLayout.Alignment.LEADING, 0, 217, Short.MAX_VALUE)
                        .addComponent(cbb_loaisanpham, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_themsize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(48, 48, 48))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_themloaisp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_soLuongton, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_giaban, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_gianhap, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbb_trangThai, 0, 217, Short.MAX_VALUE))
                .addGap(115, 115, 115)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_loaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btn_themloaisp))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btn_themsize)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuongton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Tìm kiếm");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Loại sản phẩm");

        cbb_lcodanhmuc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Trạng thái");

        cbb_loctrangthai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Size", "Giá nhập", "Giá bán", "Số lượng tồn", "Trạng thái", "Mô tả", "Ảnh"
            }
        ));
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_sanpham);
        if (tb_sanpham.getColumnModel().getColumnCount() > 0) {
            tb_sanpham.getColumnModel().getColumn(0).setMinWidth(50);
            tb_sanpham.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_sanpham.getColumnModel().getColumn(4).setMinWidth(50);
            tb_sanpham.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cbb_lcodanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel11)
                .addGap(35, 35, 35)
                .addComponent(cbb_loctrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbb_lcodanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbb_loctrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_soLuongtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongtonActionPerformed

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int row = tb_sanpham.getSelectedRow();

        String ma = tb_sanpham.getValueAt(row, 1).toString();
        String ten = tb_sanpham.getValueAt(row, 2).toString();
        String loai = tb_sanpham.getValueAt(row, 3).toString();
        String size = tb_sanpham.getValueAt(row, 4).toString();
        String giaNhap = tb_sanpham.getValueAt(row, 5).toString();
        String giaBan = tb_sanpham.getValueAt(row, 6).toString();
        String soLuongTon = tb_sanpham.getValueAt(row, 7).toString();
        String trangThai = tb_sanpham.getValueAt(row, 8).toString();
        String moTa = tb_sanpham.getValueAt(row, 9).toString();
        String hinh = tb_sanpham.getValueAt(row, 10).toString();

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + hinh));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lbl_hinhanh.getWidth(), lbl_hinhanh.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        txt_ma.setText(ma);
        txt_ten.setText(ten);
        txt_gianhap.setText(giaNhap);
        txt_giaban.setText(giaBan);
        txt_soLuongton.setText(soLuongTon);
        txa_moTa.setText(moTa);
        cbb_loaisanpham.setSelectedItem(loai);
        cbb_size.setSelectedItem(size);
        cbb_trangThai.setSelectedItem(trangThai);
        lbl_hinhanh.setIcon(imageIcon);

    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void btn_themsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themsizeActionPerformed
        ViewSize viewSize = new ViewSize();
        viewSize.setVisible(true);
    }//GEN-LAST:event_btn_themsizeActionPerformed

    private void btn_themloaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themloaispActionPerformed
        ViewDanhMuc viewDanhMuc = new ViewDanhMuc();
        viewDanhMuc.setVisible(true);
    }//GEN-LAST:event_btn_themloaispActionPerformed

    private void lbl_hinhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hinhanhMouseClicked
        ViewAnh viewAnh = new ViewAnh();
        viewAnh.setVisible(true);
    }//GEN-LAST:event_lbl_hinhanhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_themloaisp;
    private javax.swing.JButton btn_themsize;
    private javax.swing.JComboBox<String> cbb_lcodanhmuc;
    private javax.swing.JComboBox<String> cbb_loaisanpham;
    private javax.swing.JComboBox<String> cbb_loctrangthai;
    private javax.swing.JComboBox<String> cbb_size;
    private javax.swing.JComboBox<String> cbb_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JLabel lbl_hinhanh;
    private com.raven.swing.table.Table tb_sanpham;
    private javax.swing.JTextArea txa_moTa;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_gianhap;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_soLuongton;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
