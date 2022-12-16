package views;

import domainmodels.KhuyenMai;
import domainmodels.SanPham;
import domainmodels.SanPhamKhuyenMai;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.IKhuyenMaiService;
import services.ISanPhamService;
import services.impl.KhuyenMaiService;
import services.impl.SanPhamService;
import viewmodels.SanPhamKhuyenMaiViewModel;

public class ViewKhuyenMai extends javax.swing.JPanel {

    private final IKhuyenMaiService khuyenMaiService;
    private final ISanPhamService sanPhamService;
    ArrayList<SanPhamKhuyenMai> listspkm = new ArrayList<>();
    ArrayList<SanPhamKhuyenMai> listspkmdelete = new ArrayList<>();

    DefaultTableModel dtm;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String getmakm;
    private String getmasp;
    private Double getgiaban;
    private String gethinhthuc;
    private Boolean getluachon;

    public ViewKhuyenMai() {
        initComponents();
        this.khuyenMaiService = new KhuyenMaiService();
        this.sanPhamService = new SanPhamService();
        this.loadTableKM(this.khuyenMaiService.read());
        this.loadTableSP(this.sanPhamService.read());
        this.loadTableDSKM();

    }

    private void loadTableKM(ArrayList<KhuyenMai> list) {
        dtm = (DefaultTableModel) tb_khuyenmai.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (KhuyenMai khuyenMai : list) {
            Object[] rowdata = {
                stt++,
                khuyenMai.getMa(),
                khuyenMai.getTen(),
                khuyenMai.getLoaiGiamGia(),
                khuyenMai.getMucGiamGiaPhanTram(),
                khuyenMai.getNgayBatDau(),
                khuyenMai.getNgayKetThuc(),
                khuyenMai.getTrangThai() == 0 ? "Hoạt động" : "Ngừng hoạt động"
            };
            dtm.addRow(rowdata);
        }
    }

    private void loadTableSP(ArrayList<SanPham> list) {
        dtm = (DefaultTableModel) tb_sanpham.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (SanPham sp : list) {
            Object[] rowdata = {
                stt++, sp.getMaSP(), sp.getTenSP()};
            dtm.addRow(rowdata);
        }
    }

    private KhuyenMai getForm() {
        KhuyenMai km = new KhuyenMai();
        String ma = txt_ma.getText().trim();
        String ten = txt_ten.getText().trim();
        String hinhThuc = cbb_hinhthuc.getSelectedItem().toString();
        String mucGiamStr = txt_mucgiam.getText().trim();
        Date ngayBatDau = dsc_ngaybatdau.getDate();
        Date ngayKetThuc = dsc_ngayketthuc.getDate();
        String trangThai = cbb_trangthai.getSelectedItem().toString();

        Double mucGiam = Double.parseDouble(mucGiamStr);
        km.setMa(ma);
        km.setTen(ten);
        km.setLoaiGiamGia(hinhThuc);
        km.setNgayBatDau(ngayBatDau);
        km.setNgayKetThuc(ngayKetThuc);
        km.setMucGiamGiaPhanTram(mucGiam);

        if (trangThai.equalsIgnoreCase("hoạt động")) {
            km.setTrangThai(0);
        } else {
            km.setTrangThai(1);
        }
        return km;
    }

    private SanPhamKhuyenMai getFormSPKM() {
        String makm = getmakm;
        String masp = getmasp;

        Double dongiaconlai = null;
        for (KhuyenMai khuyenMai : this.khuyenMaiService.read()) {
            if (khuyenMai.getLoaiGiamGia().equalsIgnoreCase("Theo %")) {
                dongiaconlai = getGiaSp(masp) - (getGiaSp(masp) * khuyenMai.getMucGiamGiaPhanTram() / 100);
            } else {
                dongiaconlai = getGiaSp(masp) - khuyenMai.getMucGiamGiaPhanTram();
            }
        }
        SanPhamKhuyenMai spkm = new SanPhamKhuyenMai(getIdkm(makm), getIdsp(masp), getGiaSp(masp), dongiaconlai, 0);

        return spkm;
    }

    private String getIdkm(String ma) {
        for (KhuyenMai khuyenMai : this.khuyenMaiService.read()) {
            if (khuyenMai.getMa().equals(ma)) {
                return khuyenMai.getId();
            }
        }
        return null;
    }

    private String getIdsp(String ma) {
        for (SanPham sp : this.sanPhamService.read()) {
            if (sp.getMaSP().equals(ma)) {
                return sp.getId();
            }
        }
        return null;
    }

    private Double getGiaSp(String ma) {
        for (SanPham sp : this.sanPhamService.read()) {
            if (sp.getMaSP().equals(ma)) {
                return sp.getGiaBan();
            }
        }
        return null;
    }

    private void newForm() {
        txt_ma.setText("");
        txt_mucgiam.setText("");
        txt_ten.setText("");
        cbb_hinhthuc.setSelectedIndex(0);
        cbb_trangthai.setSelectedIndex(0);
        dsc_ngaybatdau.setDate(null);
        dsc_ngayketthuc.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        cbb_hinhthuc = new javax.swing.JComboBox<>();
        txt_mucgiam = new javax.swing.JTextField();
        dsc_ngaybatdau = new com.toedter.calendar.JDateChooser();
        dsc_ngayketthuc = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        cbb_trangthai = new javax.swing.JComboBox<>();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbb_loctrangthai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbb_lochinhthuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_timkiemsp = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_danhsachkhuyenmai = new com.raven.swing.table.Table();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sanpham = new com.raven.swing.table.Table();
        btn_apdung = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_khuyenmai = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setText("Mã khuyến mãi");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setText("Tên khuyến mãi");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setText("Loại giảm giá");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel26.setText("Mức giảm giá");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel27.setText("Ngày bắt đầu");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel28.setText("Ngày kết thúc");

        cbb_hinhthuc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_hinhthuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo %", "Theo giá tiền" }));

        dsc_ngaybatdau.setDateFormatString("yyyy-MM-dd");

        dsc_ngayketthuc.setDateFormatString("yyyy-MM-dd");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel29.setText("Trạng thái");

        cbb_trangthai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Ngừng hoạt động" }));

        btn_new.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_new.setText("Mới");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_save.setText("Lưu");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ma)
                            .addComponent(txt_ten)
                            .addComponent(cbb_hinhthuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mucgiam)
                            .addComponent(dsc_ngaybatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dsc_ngayketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_new)
                            .addComponent(btn_xoa))
                        .addGap(129, 129, 129)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_update)
                            .addComponent(btn_save))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(cbb_hinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txt_mucgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel27))
                    .addComponent(dsc_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(dsc_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cbb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa)
                    .addComponent(btn_update))
                .addGap(57, 57, 57))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Trạng thái");

        cbb_loctrangthai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_loctrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hoạt động", "Ngừng hoạt động" }));
        cbb_loctrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_loctrangthaiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Hình thức");

        cbb_lochinhthuc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_lochinhthuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Theo %", "Theo giá tiền" }));
        cbb_lochinhthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_lochinhthucActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Tìm kiếm");

        txt_timkiemsp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemspKeyReleased(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jCheckBox1.setText("Select All");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        tb_danhsachkhuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khuyến mãi", "Tên khuyến mãi", "Loại giảm giá", "Mức giảm", "Tên sản phẩm", "Giá ban đầu", "Giá sau khi giảm", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_danhsachkhuyenmai);

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
        if (tb_sanpham.getColumnModel().getColumnCount() > 0) {
            tb_sanpham.getColumnModel().getColumn(0).setMinWidth(100);
            tb_sanpham.getColumnModel().getColumn(0).setMaxWidth(100);
            tb_sanpham.getColumnModel().getColumn(3).setMinWidth(100);
            tb_sanpham.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        btn_apdung.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_apdung.setText("Áp dụng");
        btn_apdung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apdungActionPerformed(evt);
            }
        });

        tb_khuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khuyến mãi", "Tên khuyến mãi", "Hình thức", "Mức giảm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_khuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khuyenmaiMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_khuyenmai);
        if (tb_khuyenmai.getColumnModel().getColumnCount() > 0) {
            tb_khuyenmai.getColumnModel().getColumn(4).setHeaderValue("Mức giảm");
            tb_khuyenmai.getColumnModel().getColumn(5).setHeaderValue("Ngày bắt đầu");
            tb_khuyenmai.getColumnModel().getColumn(6).setHeaderValue("Ngày kết thúc");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_timkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(btn_apdung)
                        .addGap(143, 143, 143)
                        .addComponent(jCheckBox1)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_loctrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbb_lochinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(366, 366, 366)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cbb_loctrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cbb_lochinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_timkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jCheckBox1)
                            .addComponent(btn_apdung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        this.newForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        KhuyenMai km = this.getForm();

        this.khuyenMaiService.create(km);
        this.loadTableKM(this.khuyenMaiService.read());
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        KhuyenMai km = this.getForm();
        int row = tb_khuyenmai.getSelectedRow();
        String ma = tb_khuyenmai.getValueAt(row, 1).toString();
        this.khuyenMaiService.update(km, getIdkm(ma));
        this.loadTableKM(this.khuyenMaiService.read());
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = tb_khuyenmai.getSelectedRow();
        String ma = tb_khuyenmai.getValueAt(row, 1).toString();
        this.khuyenMaiService.delete(getIdkm(ma));
        this.loadTableKM(this.khuyenMaiService.read());
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyReleased
        String tk = txt_timkiem.getText().trim();
        if (tk.equals("")) {
            this.loadTableKM(this.khuyenMaiService.read());
        } else {
            this.loadTableKM(this.khuyenMaiService.timKiem(tk));
        }
    }//GEN-LAST:event_txt_timkiemKeyReleased

    private void cbb_loctrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_loctrangthaiActionPerformed
        switch (cbb_loctrangthai.getSelectedIndex()) {
            case 0 ->
                this.loadTableKM(this.khuyenMaiService.read());
            case 1 ->
                this.loadTableKM(this.khuyenMaiService.trangThai(String.valueOf(0)));
            default ->
                this.loadTableKM(this.khuyenMaiService.trangThai(String.valueOf(1)));
        }
    }//GEN-LAST:event_cbb_loctrangthaiActionPerformed

    private void cbb_lochinhthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_lochinhthucActionPerformed

    }//GEN-LAST:event_cbb_lochinhthucActionPerformed

    private void txt_timkiemspKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemspKeyReleased
        String timKiem = txt_timkiem.getText().trim();
        this.loadTableKM(this.khuyenMaiService.timKiem(timKiem));
    }//GEN-LAST:event_txt_timkiemspKeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        for (int i = 0; i < tb_sanpham.getRowCount(); i++) {
            tb_sanpham.setValueAt(true, i, 3);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int row = tb_sanpham.getSelectedRow();
        String ma = tb_sanpham.getValueAt(row, 1).toString();
        getmasp = ma;
        String luaChonStr = tb_sanpham.getValueAt(row, 3).toString();

        Boolean luachon = Boolean.parseBoolean(luaChonStr);
        getluachon = luachon;


    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void btn_apdungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apdungActionPerformed
        SanPhamKhuyenMai spkm = this.getFormSPKM();
        this.khuyenMaiService.create(spkm);
        this.loadTableDSKM();
//        try {
//            for (int i = 0; i < tb_sanpham.getRowCount(); i++) {
//                boolean check = Boolean.parseBoolean(tb_sanpham.getValueAt(i, 7).toString());
//                if (check) {
//                    UUID idHDCT = .get(i).getId();
//                    List<ImelDaBanRespone> lstImelXoa = bhs.getImelBan(idHDCT);
//                    for (ImelDaBanRespone imel : lstImelXoa) {
//                        bhs.deleteImelBan(imel.getMa());
//                    }
//                    for (int j = 0; j < Integer.parseInt(tb_sanpham.getValueAt(i, 6).toString()); j++) {
//                        bhs.updateGHXoa(idHDCT);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Không xóa được giỏ hàng");
//            return;
//        }
//        JOptionPane.showMessageDialog(this, "Đã xóa các sản phẩm chọn khỏi giỏ hàng");
    }//GEN-LAST:event_btn_apdungActionPerformed

    private void tb_khuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khuyenmaiMouseClicked
        int row = tb_khuyenmai.getSelectedRow();
        String ma = tb_khuyenmai.getValueAt(row, 1).toString();
        getmakm = ma;
        String ten = tb_khuyenmai.getValueAt(row, 2).toString();
        String hinhThuc = tb_khuyenmai.getValueAt(row, 3).toString();
        gethinhthuc = hinhThuc;
        String mucGiam = tb_khuyenmai.getValueAt(row, 4).toString();
        String ngayBatDau = tb_khuyenmai.getValueAt(row, 5).toString();
        String ngayKetThuc = tb_khuyenmai.getValueAt(row, 6).toString();
        String trangThai = tb_khuyenmai.getValueAt(row, 7).toString();

        txt_ma.setText(ma);
        txt_ten.setText(ten);
        cbb_hinhthuc.setSelectedItem(hinhThuc);
        txt_mucgiam.setText(mucGiam);
        try {
            dsc_ngaybatdau.setDate(sdf.parse(ngayBatDau));
            dsc_ngayketthuc.setDate(sdf.parse(ngayKetThuc));
        } catch (ParseException ex) {
            Logger.getLogger(ViewKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbb_trangthai.setSelectedItem(trangThai);
    }//GEN-LAST:event_tb_khuyenmaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_apdung;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_hinhthuc;
    private javax.swing.JComboBox<String> cbb_lochinhthuc;
    private javax.swing.JComboBox<String> cbb_loctrangthai;
    private javax.swing.JComboBox<String> cbb_trangthai;
    private com.toedter.calendar.JDateChooser dsc_ngaybatdau;
    private com.toedter.calendar.JDateChooser dsc_ngayketthuc;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private com.raven.swing.table.Table tb_danhsachkhuyenmai;
    private com.raven.swing.table.Table tb_khuyenmai;
    private com.raven.swing.table.Table tb_sanpham;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_mucgiam;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_timkiemsp;
    // End of variables declaration//GEN-END:variables

    private void loadTableDSKM() {
        dtm = (DefaultTableModel) tb_danhsachkhuyenmai.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (SanPhamKhuyenMaiViewModel sanPhamKhuyenMaiViewModel : this.khuyenMaiService.readspkm()) {
            Object[] rowdata = {
                stt++,
                sanPhamKhuyenMaiViewModel.getMakm(),
                sanPhamKhuyenMaiViewModel.getTenkm(),
                sanPhamKhuyenMaiViewModel.getLoaiGiamGia(),
                sanPhamKhuyenMaiViewModel.getMucGiamPhanTram(),
                sanPhamKhuyenMaiViewModel.getTensp(),
                sanPhamKhuyenMaiViewModel.getGiaBan(),
                sanPhamKhuyenMaiViewModel.getGiaTienConLai(),
                sanPhamKhuyenMaiViewModel.getTrangThai() == 0 ? "Đang áp dụng" : "Ngừng áp dụng",};
            dtm.addRow(rowdata);
        }
    }

}
