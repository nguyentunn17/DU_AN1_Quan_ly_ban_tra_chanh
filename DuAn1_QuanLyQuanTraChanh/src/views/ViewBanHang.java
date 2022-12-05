package views;

import domainmodels.Ban;
import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import domainmodels.SanPham;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.IBanHangService;
import services.IBanService;
import services.IHoaDonService;
import services.INhanVienService;
import services.ISanPhamService;
import services.impl.BanHangService;
import services.impl.BanService;
import services.impl.HoaDonService;
import services.impl.NhanVienService;
import services.impl.SanPhamService;
import viewmodels.HoaDonChiTietViewModel;
import viewmodels.HoaDonVM;
import viewmodels.SanPhamViewModel;

public class ViewBanHang extends javax.swing.JPanel implements ActionListener {

    private final IBanService csv = new BanService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private final IHoaDonService hoaDonService = new HoaDonService();
    private final INhanVienService nhanVienService = new NhanVienService();
    private final ISanPhamService sanPhamService;
    private final IBanHangService banHangService;
    ArrayList<SanPham> listddsp = new ArrayList<>();

    public ViewBanHang() {
        initComponents();
        this.Ban();
        this.loadTableHoaDon();
        this.sanPhamService = new SanPhamService();
        this.banHangService = new BanHangService();
        this.loadAnhSanPham();
        this.loadTableSanPham();
    }

    private void Ban() {
        GridLayout gr = new GridLayout(4, 3);
        this.JP_Ban.setLayout(gr);
        for (Ban b : csv.getlist()) {
            JButton btn = new JButton(b.getTenBan());
            this.JP_Ban.add(btn);
            btn.setActionCommand("OK");
            btn.addActionListener(this);
        }

    }

    private void loadAnhSanPham() {
//        GridLayout gr = new GridLayout(4, 3);
//        this.JPMenu.setLayout(gr);
//        for (SanPhamViewModel sp : this.sanPhamService.getByID()) {
//            String hinh = sp.getAnh();
//            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + hinh));
//            Image image = imageIcon.getImage();
//            imageIcon = new ImageIcon(image);
//            JButton btn = new JButton(imageIcon);
//            btn.setText(" " + sp.getTensp());
//            this.JPMenu.add(btn);
//            btn.setActionCommand("SP");
//            btn.addActionListener(this);
//        }
    }

    private void loadTableHoaDon() {
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (HoaDonVM hd : hoaDonService.listH()) {
            Object[] row = {
                i, hd.getMahd(), hd.getNgayTao(), "Administrator", hd.getTrangthai() == 0 ? "Đã thanh toán" : "Chờ thanh toán"
            };
            dtm.addRow(row);
            i++;
        }
    }

    private void loadTableSanPham() {
        dtm = (DefaultTableModel) tb_sanpham.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (SanPham sp : this.sanPhamService.read()) {
            Object[] row = {
                i++,
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getSoLuongTon(),
                sp.getGiaBan()
            };
            dtm.addRow(row);

        }
    }

    private void loadTableGioHang(ArrayList<SanPham> list) {
        dtm = (DefaultTableModel) tbGioHang.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (SanPham sp : list) {
            Object[] row = {
                i,
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getSoLuongTon(),
                sp.getGiaBan(),
                sp.getSoLuongTon() * sp.getGiaBan()
            };
            dtm.addRow(row);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("OK".equals(e.getActionCommand())) {
            jTabbedPane1.setSelectedComponent(JPMenu);
            for (Ban b : csv.getlist()) {
                this.lbl_banquay.setText(b.getTenBan());
            }
        }
        if ("SP".equalsIgnoreCase(e.getActionCommand())) {
            for (SanPhamViewModel sanPham : this.sanPhamService.getByID()) {
                JOptionPane.showInputDialog("Hãy nhập số lượng sản phẩm");
                System.out.println(sanPham.getTensp());
                return;
            }
        }
    }

    private HoaDonChiTiet getForm() {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        return hdct;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        JP_Ban = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JPMenu = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sanpham = new com.raven.swing.table.Table();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new com.raven.swing.table.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new com.raven.swing.table.Table();
        btnTaoHoaDon = new javax.swing.JButton();
        btnClearGioHang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbl_ma = new javax.swing.JLabel();
        lbl_banquay = new javax.swing.JLabel();
        lbl_ngaytao = new javax.swing.JLabel();
        lbl_tennhanvien = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        txt_tienkhachtra = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        cbb_htth = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();

        setOpaque(false);

        JP_Ban.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JP_BanLayout = new javax.swing.GroupLayout(JP_Ban);
        JP_Ban.setLayout(JP_BanLayout);
        JP_BanLayout.setHorizontalGroup(
            JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        JP_BanLayout.setVerticalGroup(
            JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Bàn", JP_Ban);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quầy", jPanel2);

        JPMenu.setBackground(new java.awt.Color(255, 255, 255));

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_sanpham);

        javax.swing.GroupLayout JPMenuLayout = new javax.swing.GroupLayout(JPMenu);
        JPMenu.setLayout(JPMenuLayout);
        JPMenuLayout.setHorizontalGroup(
            JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        JPMenuLayout.setVerticalGroup(
            JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", JPMenu);

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Người tạo", "Trạng thái"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tbGioHang);

        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnClearGioHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnClearGioHang.setText("Làm mới giỏ hàng");
        btnClearGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHangActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tổng tiền");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tiền khách trả");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Tiền thừa");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Tên nhân viên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Bàn/Quầy");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Hình thức thanh toán");

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton5.setText("In hóa đơn");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Ngày tạo");

        lbl_ma.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_ma.setText("jLabel9");

        lbl_banquay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_banquay.setText("jLabel10");

        lbl_ngaytao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_ngaytao.setText("jLabel11");

        lbl_tennhanvien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_tennhanvien.setText("jLabel12");

        lbl_tongtien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_tongtien.setText("jLabel13");

        txt_tienkhachtra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienkhachtraCaretUpdate(evt);
            }
        });

        cbb_htth.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_htth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thanh toán trực tiếp", "Chuyển khoản" }));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton7.setText("In phiếu bếp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(51, 51, 51))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnTaoHoaDon)
                                .addGap(75, 75, 75)
                                .addComponent(btnClearGioHang))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButton5)
                                .addGap(102, 102, 102)
                                .addComponent(jButton7)))
                        .addGap(70, 70, 70)
                        .addComponent(btnThanhToan)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(42, 42, 42)
                                        .addComponent(lbl_tennhanvien))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_ma)
                                                    .addComponent(lbl_banquay)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(lbl_ngaytao)
                                                .addGap(1, 1, 1)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_tienkhachtra, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_tongtien)))
                                        .addGap(16, 16, 16))
                                    .addComponent(cbb_htth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(btnClearGioHang))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbl_ma)
                            .addComponent(lbl_tongtien))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_banquay)
                            .addComponent(txt_tienkhachtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbb_htth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lbl_ngaytao))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lbl_tennhanvien)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton5))
                    .addComponent(btnThanhToan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        Random rd = new Random();
        HoaDon hd = new HoaDon();
        hd.setMa("HD" + rd.nextInt(99999999));
        hd.setNgaytao(new Date());
        hd.setTrangthai(1);
        hoaDonService.insert(hd);
        loadTableHoaDon();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = tbHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thanh toán");
            return;
        }
        HoaDon hd = new HoaDon();
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        hoaDonService.update(ma, hd);
        loadTableHoaDon();
        JOptionPane.showMessageDialog(this, "Thanh toán thành công");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnClearGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHangActionPerformed
        dtm = (DefaultTableModel) tbGioHang.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_btnClearGioHangActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int row = tbHoaDon.getSelectedRow();
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        dtm = (DefaultTableModel) tbGioHang.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietViewModel SanPham : this.banHangService.loadSp(ma)) {
            Object[] rowdata = {
                stt++,
                SanPham.getMasp(),
                SanPham.getTensp(),
                SanPham.getSoLuong(),
                SanPham.getGiaBan(),
                SanPham.getSoLuong() * SanPham.getGiaBan()
            };
            dtm.addRow(rowdata);
        }
        float sum = 0;
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : this.banHangService.loadSp(ma)) {

            sum += hoaDonChiTietViewModel.getSoLuong() * hoaDonChiTietViewModel.getGiaBan();

            lbl_tongtien.setText(String.valueOf(sum));
        }
        String ngayTao = tbHoaDon.getValueAt(row, 2).toString();
        String nguoiTao = tbHoaDon.getValueAt(row, 3).toString();

        lbl_ma.setText(ma);
        lbl_ngaytao.setText(ngayTao);
        lbl_tennhanvien.setText(nguoiTao);

    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void txt_tienkhachtraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienkhachtraCaretUpdate
        if (txt_tienkhachtra.getText().isBlank() || !txt_tienkhachtra.getText().matches("\\d+")) {
            return;
        }
        txt_tienThua.setText(String.valueOf(Float.parseFloat(txt_tienkhachtra.getText()) - Float.parseFloat(lbl_tongtien.getText())));
    }//GEN-LAST:event_txt_tienkhachtraCaretUpdate

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int row = tb_sanpham.getSelectedRow();

        String soLuongStr = JOptionPane.showInputDialog("Mời nhập số lượng");

        String ma = tb_sanpham.getValueAt(row, 1).toString();
        String ten = tb_sanpham.getValueAt(row, 2).toString();
        String giabanStr = tb_sanpham.getValueAt(row, 4).toString();

        Double giaBan = Double.parseDouble(giabanStr);
        Integer soLuong = Integer.parseInt(soLuongStr);

        SanPham sp = new SanPham(ma, ten, giaBan, soLuong);

//        if (iHD < 0) {
//            JOptionPane.showMessageDialog(this, "Chon hoa don");
//            return;
//        }
//        if (gettrangthai(lbl_ma.getText().trim()) == 0 || gettrangthai(txt_maHD.getText().trim()) == 2) {
//            JOptionPane.showMessageDialog(this, "Hoa don khong hoat dong");
//            return;
//        }
//        String soLuongStr = JOptionPane.showInputDialog("Moi nhap so luong");
//        if (soLuongStr
//                == null) {
//            return;
//        }
//        getSoLuong = Integer.parseInt(soLuongStr);
//        for (QLSanPham qLSanPham : this.banHangService.getAllById()) {
//            if (getSoLuong > qLSanPham.getSoLuongSP()) {
//                JOptionPane.showMessageDialog(this, "Khong du hang");
//                return;
//            }
//        }
//        for (QLSanPham qLSanPham : listaddsp) {
//            if (qLSanPham.getMa().equals(masp)) {
//                int soluong = qLSanPham.getSoLuongSP() + getSoLuong;
//                qlsp.setSoLuongSP(soluong);
//                listaddsp.set(i, qlsp);
//                this.loadTableGH(listaddsp);
//                return;
//            }
//        }
        listddsp.add(sp);
        this.loadTableGioHang(listddsp);
    }//GEN-LAST:event_tb_sanphamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMenu;
    private javax.swing.JPanel JP_Ban;
    private javax.swing.JButton btnClearGioHang;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cbb_htth;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_banquay;
    private javax.swing.JLabel lbl_ma;
    private javax.swing.JLabel lbl_ngaytao;
    private javax.swing.JLabel lbl_tennhanvien;
    private javax.swing.JLabel lbl_tongtien;
    private com.raven.swing.table.Table tbGioHang;
    private com.raven.swing.table.Table tbHoaDon;
    private com.raven.swing.table.Table tb_sanpham;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tienkhachtra;
    // End of variables declaration//GEN-END:variables

}
