package repositories.impl;

import domainmodels.SanPham;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.ISanPhamRepository;
import viewmodels.SanPhamViewModel;

public class SanPhamRepository implements ISanPhamRepository {

    @Override
    public ArrayList<domainmodels.SanPham> read() {
        ArrayList<SanPham> listsp = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "SELECT * FROM SANPHAM";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String idKT = rs.getString("idKT");
                String idDM = rs.getString("idDM");
                String ma = rs.getString("masp");
                String ten = rs.getString("tensp");
                Double giaNhap = rs.getDouble("giaNhap");
                BigDecimal giaNhapBigDecimal = new BigDecimal(giaNhap);
                Double giaBan = rs.getDouble("giaBan");
                BigDecimal giaBanBigDecimal = new BigDecimal(giaBan);
                Integer soLuongTon = rs.getInt("soLuongTon");
                String moTa = rs.getString("mota");
                Integer trangThai = rs.getInt("trangThai");
                SanPham sp = new SanPham(id, idKT, idDM, ma, ten, giaNhapBigDecimal, giaBanBigDecimal, soLuongTon, moTa, trangThai);
                listsp.add(sp);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    @Override
    public void create(SanPham sp) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "INSERT INTO KHUYENMAI(ma,ten,loaigiamgia,mucgiamgiaphantram,mucgiamgiatienmat,ngaybatdau,ngayketthuc,trangthai) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setObject(1, km.getMa());
//            ps.setObject(2, km.getTen());
//            ps.setObject(3, km.getLoaiGiamGia());
//            ps.setObject(4, km.getMucGiamGiaPhanTram());
//            ps.setObject(5, km.getMucGiamGiaTienMat());
//            ps.setObject(6, km.getNgayBatDau());
//            ps.setObject(7, km.getNgayKetThuc());
//            ps.setObject(8, km.getTrangThai());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham sp, String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "UPDATE KHUYENMAI SET ma=?,ten=?,loaigiamgia=?,mucgiamgiaphantram=?,mucgiamgiatienmat=?,ngaybatdau=?,ngayketthuc=?,trangthai=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setObject(1, km.getMa());
//            ps.setObject(2, km.getTen());
//            ps.setObject(3, km.getLoaiGiamGia());
//            ps.setObject(4, km.getMucGiamGiaPhanTram());
//            ps.setObject(5, km.getMucGiamGiaTienMat());
//            ps.setObject(6, km.getNgayBatDau());
//            ps.setObject(7, km.getNgayKetThuc());
//            ps.setObject(8, km.getTrangThai());
            ps.setObject(9, id);

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "DELETE FROM KHUYENMAI WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, id);
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<SanPhamViewModel> getByID() {
        ArrayList<SanPhamViewModel> listsp = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = """
                           SELECT MaSP,TenSP,TenTL,TenKT,GiaNhap,GiaBan,SoLuongTon,SANPHAM.TrangThai,MoTa,DuongDan FROM SANPHAM 
                           INNER JOIN KICHTHUOC ON SANPHAM.IdKT=KICHTHUOC.Id
                           INNER JOIN DANHMUC ON SANPHAM.IdDM=DANHMUC.ID 
                           INNER JOIN HINHANH ON HINHANH.IdSanPham=SANPHAM.Id""";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("masp");
                String ten = rs.getString("tensp");
                String tenLoai = rs.getString("TenTL");
                String tenSize = rs.getString("TenKT");
                String giaNhap = rs.getString("gianhap");
                String giaBan = rs.getString("giaban");
                Integer soLuongTon = rs.getInt("soluongton");
                Integer trangThai = rs.getInt("trangthai");
                String moTa = rs.getString("moTa");
                String duongDan = rs.getString("duongDan");
                BigDecimal bdcgiaNhap = new BigDecimal(giaNhap);
                BigDecimal bdcgiaBan = new BigDecimal(giaBan);

                SanPhamViewModel sanPhamViewModel
                        = new SanPhamViewModel(ma, ten, tenLoai, tenSize, bdcgiaNhap, bdcgiaBan, soLuongTon, trangThai, moTa, duongDan);
                listsp.add(sanPhamViewModel);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

}
