package views;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import domainmodels.Ban;
import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import domainmodels.NhanVien;
import domainmodels.NhanVienLogin;
import domainmodels.SanPham;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import listener.ButtonSanPhamListener;
import listener.ButtonTableListener;
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

public class ViewBanHang extends javax.swing.JPanel {

    private final IBanService banService = new BanService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private final IHoaDonService hoaDonService = new HoaDonService();
    private final INhanVienService nhanVienService = new NhanVienService();
    private final ISanPhamService sanPhamService;
    private final IBanHangService banHangService;
    ArrayList<SanPham> listddsp = new ArrayList<>();
    private String getMaHD = null;
    private String gettrangthai;
    private int getrowhd;
    private static final Font catFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font tenQ = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);

    public ViewBanHang() {
        initComponents();
        this.Ban();
        this.sanPhamService = new SanPhamService();
        this.banHangService = new BanHangService();
        this.loadAnhSanPham();
        this.loadTableHoaDon();
    }

    private void Ban() {
        GridLayout gr = new GridLayout(4, 3);
        this.JP_Ban.setLayout(gr);
        for (Ban b : banService.getlist()) {
            JButton btn = new JButton(b.getTenBan());
            this.JP_Ban.add(btn);
            ButtonTableListener listener = new ButtonTableListener(banService, btn, this);
            btn.addActionListener(listener);
        }
    }

    public void setTextBan(String name) {
        jTabbedPane1.setSelectedComponent(JPMenu);
        lbl_banquay.setText(name);
        Random rd = new Random();
        String tennv = NhanVienLogin.getTenLogin();
        String mahd = "HD" + rd.nextInt(99999999);
        Date ngayTao = new Date();
        Integer trangThai = 1;
        String idNV = getIDNV(tennv);
        String idban = getIDban(name);

        HoaDon hd = new HoaDon(idNV, idban, mahd, ngayTao, trangThai);
        this.hoaDonService.insert(hd);
        loadTableHoaDon();
    }

    private void loadAnhSanPham() {
        GridLayout gr = new GridLayout(4, 3);
        this.JPMenu.setLayout(gr);
        for (SanPhamViewModel sp : this.sanPhamService.getByID()) {
            JButton btn = new JButton();

            String hinh = sp.getAnh();
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + hinh));
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            btn.setIcon(imageIcon);
            btn.setText(sp.getTensp());
            this.JPMenu.add(btn);

            btn.setHorizontalTextPosition(JButton.CENTER);
            btn.setVerticalTextPosition(JButton.BOTTOM);

            ButtonSanPhamListener buttonSanPhamListener = new ButtonSanPhamListener(btn, sanPhamService, this);
            btn.addActionListener(buttonSanPhamListener);
        }
    }

    public void getThongTinSP(String ma, Double giaban, Integer soLuongTon) {
        int rowHD = tbHoaDon.getSelectedRow();

        if (rowHD < 0) {
            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn");
            return;
        }
        String soLuongStr = JOptionPane.showInputDialog("Chọn số lượng sản phẩm");
        if (soLuongStr == null) {
            return;
        }
        Integer soLuong = Integer.parseInt(soLuongStr);

        if (soLuong > soLuongTon) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không đủ");
        }
        String maHD = tbHoaDon.getValueAt(rowHD, 1).toString();

        Double thanhtien = soLuong * giaban;
        HoaDonChiTiet hdct = new HoaDonChiTiet(getidHD(maHD), getidSP(ma), soLuong, giaban, thanhtien);
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : this.banHangService.loadSp(maHD)) {
            if (hoaDonChiTietViewModel.getMasp().equals(ma)) {
                this.banHangService.delete(getidSP(ma), getidHD(maHD));
                int soluong = hoaDonChiTietViewModel.getSoLuong() + soLuong;
                Double thanhTien = soluong * giaban;
                HoaDonChiTiet hdct1 = new HoaDonChiTiet(getidHD(maHD), getidSP(ma), soluong, giaban, thanhTien);
                this.banHangService.createHD(hdct1);
                sum();
                this.loadTableGioHang(this.banHangService.loadSp(maHD));
                return;
            }
        }
        this.banHangService.createHD(hdct);
        this.loadTableGioHang(this.banHangService.loadSp(maHD));
        sum();
    }

    private void sum() {
        float sum = 0;
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : this.banHangService.loadSp(getMaHD)) {
            sum += hoaDonChiTietViewModel.getSoLuong() * hoaDonChiTietViewModel.getGiaBan();
            lbl_tongtien.setText(String.valueOf(sum));
        }
    }

    private void loadTableHoaDon() {
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        int i = 1;
        for (HoaDonVM hd : hoaDonService.listH()) {
            Object[] rowData = {
                i++,
                hd.getMahd(),
                df.format(hd.getNgayTao()),
                hd.getNguoiTao(),
                hd.getTrangthai() == 0 ? "Đã thanh toán" : "Chờ thanh toán"
            };
            dtm.addRow(rowData);

        }
    }

    private void loadTableGioHang(ArrayList<HoaDonChiTietViewModel> list) {
        dtm = (DefaultTableModel) tbGioHang.getModel();
        dtm.setRowCount(0);
        int i = 1;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (HoaDonChiTietViewModel sp : list) {
            Object[] row = {
                i++,
                sp.getMasp(),
                sp.getTensp(),
                sp.getSoLuong(),
                sp.getGiaBan(),
                sp.getSoLuong() * sp.getGiaBan()
            };
            dtm.addRow(row);

        }
    }
//    private HoaDonChiTiet getForm() {
//
//        String mahd = getMaHD;
//        for (SanPham sanPham : listddsp) {
//            String masp = sanPham.getMaSP();
//            Integer soLuong = sanPham.getSoLuongTon();
//            Double donGia = sanPham.getGiaBan();
//            Double thanhTien = sanPham.getSoLuongTon() * sanPham.getGiaBan();
//            HoaDonChiTiet hdct = new HoaDonChiTiet(getidHD(mahd), getidSP(masp), soLuong, donGia, thanhTien);
//            return hdct;
//        }
//        return null;
//    }

//    private int gettrangthai(String ma) {
//        for (HoaDonVM QLHoaDon : hoaDonService.listH()) {
//            if (QLHoaDon.getMahd().equals(ma)) {
//                return QLHoaDon.getTrangthai();
//            }
//        }
//        return 0;
//    }
    private String getidHD(String ma) {
        for (HoaDon hoaDon : this.hoaDonService.getAll1()) {
            if (hoaDon.getMa().equalsIgnoreCase(ma)) {
                return hoaDon.getId();
            }
        }
        return null;
    }

    private String getidSP(String ma) {
        for (SanPham sp : this.sanPhamService.read()) {
            if (sp.getMaSP().equalsIgnoreCase(ma)) {
                return sp.getId();
            }
        }
        return null;
    }

    private String getIDNV(String ten) {
        for (NhanVien nv : this.nhanVienService.listAll()) {
            if (nv.getHoTen().equalsIgnoreCase(ten)) {
                return nv.getId();
            }
        }
        return null;
    }

    private String getIDban(String ten) {
        for (Ban ban : this.banService.getlist()) {
            if (ban.getTenBan().equalsIgnoreCase(ten)) {
                return ban.getId();
            }
        }
        return null;
    }

    private float getdongiasp(String id) {
        for (SanPham x : sanPhamService.read()) {
            if (x.getId().equalsIgnoreCase(id)) {
                String giaban = String.valueOf(x.getGiaBan());
                return Float.parseFloat(giaban);
            }
        }
        return 0f;
    }

    private int gettrangThai(String trangthai) {
        if (trangthai.equalsIgnoreCase("Chờ hoạt động")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void InHD() {
        String path = "";
        Date ngayTao = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "InHoaDon.pdf"));

            doc.open();
            Paragraph TenQ = new Paragraph("Cua hang tra chanh MR.Tu", tenQ);
            TenQ.setAlignment(Element.ALIGN_CENTER);
            TenQ.setSpacingAfter(5);
            Paragraph DC = new Paragraph("                  DC: So 4, TDP Phuc Ly 2, Minh Khai, Bac Tu Liem, HN");
            DC.setAlignment(Element.ALIGN_LEFT);
            Paragraph SDT = new Paragraph("                  SDT: 0964233464");
            SDT.setAlignment(Element.ALIGN_LEFT);
            Paragraph tenPhieu = new Paragraph("PHIEU THANH TOAN", catFont);
            tenPhieu.setAlignment(Element.ALIGN_CENTER);
            tenPhieu.setSpacingAfter(10);

            Paragraph maTen = new Paragraph();
            maTen.setAlignment(Element.ALIGN_LEFT);
            maTen.add("                  MaHD: " + lbl_mahd.getText() + "                               Tên bàn: " + lbl_banquay.getText());
            Paragraph tenNV = new Paragraph();
            tenNV.add("                  Tên thu ngân: " + lbl_tennv.getText());
            Paragraph ngayGio = new Paragraph();
            ngayGio.setAlignment(Element.ALIGN_LEFT);
            ngayGio.add("                  Gio vào: " + lbl_ngaytaoo.getText() + "                        Gio ra: " + df.format(ngayTao).toString());

            ngayGio.setSpacingAfter(10);
//             Anchor anchor = new Anchor("First Chapter", catFont);
//        anchor.setName("First Chapter");
//            Chapter catPart = new Chapter(new Paragraph(anchor), 2);
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Tensanpham");
            tbl.addCell("SoLuong");
            tbl.addCell("GiaBan");
            tbl.addCell("ThanhTien");

            for (int i = 0; i < tbGioHang.getRowCount(); i++) {
                String sanPham = tbGioHang.getValueAt(i, 2).toString();
                String soLuong = tbGioHang.getValueAt(i, 3).toString();
                String giaBan = tbGioHang.getValueAt(i, 4).toString();
                String thanhTien = tbGioHang.getValueAt(i, 5).toString();

                tbl.addCell(sanPham);
                tbl.addCell(soLuong);
                tbl.addCell(giaBan);
                tbl.addCell(thanhTien);

            }
            Paragraph tongTien = new Paragraph("                  Tong tien: " + lbl_tongtien.getText());
            tongTien.setAlignment(Element.ALIGN_LEFT);
            Paragraph khachDua = new Paragraph("                  Tien khach dua: " + txt_tienkhachtra.getText());
            khachDua.setAlignment(Element.ALIGN_LEFT);
            Paragraph tienthua = new Paragraph("                  Tien thua: " + lbl_tienthua.getText());
            tienthua.setAlignment(Element.ALIGN_LEFT);
            Paragraph GB = new Paragraph("Xin cam on quy khach/ Thank you");
            GB.setAlignment(Element.ALIGN_CENTER);

            doc.add(TenQ);
            doc.add(DC);
            doc.add(SDT);
            doc.add(tenPhieu);
            doc.add(maTen);
            doc.add(tenNV);
            doc.add(ngayGio);
            doc.add(tbl);
            doc.add(tongTien);
            doc.add(khachDua);
            doc.add(tienthua);
            doc.add(GB);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }

    public void InPB() {
        String path = "";
        Date ngayTao = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "InPhieuBep.pdf"));
            doc.open();
            Paragraph TenQ = new Paragraph("Cua hang tra chanh MR.Tu", tenQ);
            TenQ.setAlignment(Element.ALIGN_CENTER);
            TenQ.setSpacingAfter(5);
            Paragraph tenPhieu = new Paragraph("PHIEU BEP", catFont);
            tenPhieu.setAlignment(Element.ALIGN_CENTER);
            tenPhieu.setSpacingAfter(10);

            Paragraph maTen = new Paragraph();
            maTen.setAlignment(Element.ALIGN_LEFT);
            maTen.add("                  MaHD: " + lbl_mahd.getText() + "                               Tên bàn: " + lbl_banquay.getText());
            Paragraph tenNV = new Paragraph();
            tenNV.add("                  Tên thu ngân: " + lbl_tennv.getText());
            Paragraph ngayGio = new Paragraph();
            ngayGio.setAlignment(Element.ALIGN_LEFT);
            ngayGio.add("                  Gio in: " + df.format(ngayTao).toString());

            ngayGio.setSpacingAfter(10);
//             Anchor anchor = new Anchor("First Chapter", catFont);
//        anchor.setName("First Chapter");
//            Chapter catPart = new Chapter(new Paragraph(anchor), 2);
            PdfPTable tbl = new PdfPTable(3);
            tbl.addCell("STT");
            tbl.addCell("Tensanpham");
            tbl.addCell("SoLuong");

            for (int i = 0; i < tbGioHang.getRowCount(); i++) {
                String STT = tbGioHang.getValueAt(i, 0).toString();
                String sanPham = tbGioHang.getValueAt(i, 2).toString();
                String soLuong = tbGioHang.getValueAt(i, 3).toString();

                tbl.addCell(STT);
                tbl.addCell(sanPham);
                tbl.addCell(soLuong);
            }

            Paragraph GB = new Paragraph("Thank you");
            GB.setAlignment(Element.ALIGN_CENTER);
            GB.setSpacingBefore(10);
            doc.add(TenQ);
            doc.add(tenPhieu);
            doc.add(maTen);
            doc.add(tenNV);
            doc.add(ngayGio);
            doc.add(tbl);
            doc.add(GB);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "In thành công");
        doc.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        JP_Ban = new javax.swing.JPanel();
        JPMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new com.raven.swing.table.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new com.raven.swing.table.Table();
        btnClearGioHang = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        lbl_tienthua = new javax.swing.JLabel();
        lbl_banquay = new javax.swing.JLabel();
        lbl_ngaytaoo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_mahd = new javax.swing.JLabel();
        txt_tienkhachtra = new javax.swing.JTextField();
        lbl_tennv = new javax.swing.JLabel();
        cbb_htth = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_inphieubep = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();

        setOpaque(false);

        JP_Ban.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JP_BanLayout = new javax.swing.GroupLayout(JP_Ban);
        JP_Ban.setLayout(JP_BanLayout);
        JP_BanLayout.setHorizontalGroup(
            JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );
        JP_BanLayout.setVerticalGroup(
            JP_BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Bàn", JP_Ban);

        JPMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JPMenuLayout = new javax.swing.GroupLayout(JPMenu);
        JPMenu.setLayout(JPMenuLayout);
        JPMenuLayout.setHorizontalGroup(
            JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );
        JPMenuLayout.setVerticalGroup(
            JPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbGioHang);
        if (tbGioHang.getColumnModel().getColumnCount() > 0) {
            tbGioHang.getColumnModel().getColumn(0).setMinWidth(50);
            tbGioHang.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnClearGioHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnClearGioHang.setText("Làm mới giỏ hàng");
        btnClearGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHangActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Bàn/Quầy");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Ngày tạo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Tên nhân viên");

        lbl_tongtien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_tongtien.setText("_________________");

        lbl_tienthua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_tienthua.setText("_________________");

        lbl_banquay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_banquay.setText("_________________");

        lbl_ngaytaoo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_ngaytaoo.setText("_________________");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tiền khách trả");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tổng tiền");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Tiền thừa");

        lbl_mahd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_mahd.setText("_________________");

        txt_tienkhachtra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienkhachtraCaretUpdate(evt);
            }
        });
        txt_tienkhachtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienkhachtraActionPerformed(evt);
            }
        });

        lbl_tennv.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_tennv.setText("________________________");

        cbb_htth.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbb_htth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thanh toán trực tiếp", "Chuyển khoản" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Hình thức thanh toán");

        btn_inphieubep.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_inphieubep.setText("In phiếu bếp");
        btn_inphieubep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inphieubepActionPerformed(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(39, 39, 39)
                        .addComponent(lbl_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_banquay, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_ngaytaoo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_inphieubep, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(lbl_tienthua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbb_htth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tienkhachtra)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnThanhToan)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lbl_tongtien)
                    .addComponent(lbl_mahd))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_banquay)
                    .addComponent(jLabel3)
                    .addComponent(txt_tienkhachtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_ngaytaoo)
                    .addComponent(jLabel4)
                    .addComponent(lbl_tienthua))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lbl_tennv))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbb_htth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_inphieubep))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(btnClearGioHang)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearGioHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnClearGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHangActionPerformed
        dtm = (DefaultTableModel) tbGioHang.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_btnClearGioHangActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int rowHD = tbHoaDon.getSelectedRow();
        getrowhd = rowHD;
        String ma = tbHoaDon.getValueAt(rowHD, 1).toString();
        String ngayTao = tbHoaDon.getValueAt(rowHD, 2).toString();
        String nguoiTao = tbHoaDon.getValueAt(rowHD, 3).toString();
        String trangThai = tbHoaDon.getValueAt(rowHD, 4).toString();
        for (HoaDonVM hoaDonVM : this.hoaDonService.listBan(ma)) {
            lbl_banquay.setText(hoaDonVM.getTenBan());
        }
        gettrangthai = trangThai;
        getMaHD = ma;
        lbl_ngaytaoo.setText(ngayTao);
        lbl_tennv.setText(nguoiTao);
        lbl_mahd.setText(ma);
        sum();

        this.loadTableGioHang(this.banHangService.loadSp(ma));
    }//GEN-LAST:event_tbHoaDonMouseClicked


    private void tbGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGioHangMouseClicked
        int row = tbGioHang.getSelectedRow();
        String ma = tbGioHang.getValueAt(row, 1).toString();
        int rowhd = tbHoaDon.getSelectedRow();
        String maHD = tbHoaDon.getValueAt(rowhd, 1).toString();
        String soLuongStr = JOptionPane.showInputDialog("Mời nhập số lượng");
        if (soLuongStr == null) {
            return;
        }
        Integer soLuong = Integer.parseInt(soLuongStr);
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : this.banHangService.loadSp(maHD)) {
            if (hoaDonChiTietViewModel.getMasp().equals(ma)) {
                this.banHangService.delete(getidSP(ma), getidHD(maHD));
                int soluong = hoaDonChiTietViewModel.getSoLuong() - soLuong;

                Double thanhTien = soluong * hoaDonChiTietViewModel.getGiaBan();

                if (soLuong == 0) {
                    this.banHangService.delete(getidSP(ma), getidHD(maHD));
                } else {
                    HoaDonChiTiet hdct1 = new HoaDonChiTiet(getidHD(maHD), getidSP(ma), soluong, hoaDonChiTietViewModel.getGiaBan(), thanhTien);
                    this.banHangService.createHD(hdct1);
                }
                sum();
                this.loadTableGioHang(this.banHangService.loadSp(maHD));
                return;
            }
        }
    }//GEN-LAST:event_tbGioHangMouseClicked

    private void txt_tienkhachtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienkhachtraActionPerformed

    }//GEN-LAST:event_txt_tienkhachtraActionPerformed

    private void txt_tienkhachtraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienkhachtraCaretUpdate
        if (txt_tienkhachtra.getText().isBlank() || !txt_tienkhachtra.getText().matches("\\d+")) {
            return;
        }
        lbl_tienthua.setText(String.valueOf(Float.parseFloat(txt_tienkhachtra.getText()) - Float.parseFloat(lbl_tongtien.getText())));
    }//GEN-LAST:event_txt_tienkhachtraCaretUpdate

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = tbHoaDon.getSelectedRow();
        Date ngaythanhtoan = new Date();
        String totalStr = lbl_tongtien.getText();
        Float total = Float.parseFloat(totalStr);
        this.InHD();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thanh toán");
            return;
        }

        HoaDon hd = new HoaDon();
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        HoaDon hd2 = new HoaDon(ngaythanhtoan, total);
        this.banHangService.updateTotal(hd2, ma);
        hoaDonService.update(ma, hd);
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        dtm.removeRow(row);
        dtm = (DefaultTableModel) tbGioHang.getModel();
        dtm.setRowCount(0);

        loadTableHoaDon();

        JOptionPane.showMessageDialog(this, "Thanh toan va In hoa don thanh cong");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btn_inphieubepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inphieubepActionPerformed
        this.InPB();
    }//GEN-LAST:event_btn_inphieubepActionPerformed

    private void tbHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseEntered

    }//GEN-LAST:event_tbHoaDonMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMenu;
    private javax.swing.JPanel JP_Ban;
    private javax.swing.JButton btnClearGioHang;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btn_inphieubep;
    private javax.swing.JComboBox<String> cbb_htth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_banquay;
    private javax.swing.JLabel lbl_mahd;
    private javax.swing.JLabel lbl_ngaytaoo;
    private javax.swing.JLabel lbl_tennv;
    private javax.swing.JLabel lbl_tienthua;
    private javax.swing.JLabel lbl_tongtien;
    private com.raven.swing.table.Table tbGioHang;
    private com.raven.swing.table.Table tbHoaDon;
    private javax.swing.JTextField txt_tienkhachtra;
    // End of variables declaration//GEN-END:variables

}
