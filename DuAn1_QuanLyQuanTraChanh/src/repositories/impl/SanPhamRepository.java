package repositories.impl;

import domainmodels.SanPham;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.ISanPhamRepository;
import utilities.jdbcUtil;
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
                Double giaBan = rs.getDouble("giaBan");
                Integer soLuongTon = rs.getInt("soLuongTon");
                String moTa = rs.getString("mota");
                Integer trangThai = rs.getInt("trangThai");
                SanPham sp = new SanPham(id, idKT, idDM, ma, ten, giaNhap, giaBan, soLuongTon, moTa, trangThai);
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
            String query = "INSERT INTO SANPHAM(idKT,idDM,masp,tensp,giaNhap,giaBan,soLuongTon,mota,trangThai) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, sp.getIdKT());
            ps.setObject(2, sp.getIdDM());
            ps.setObject(3, sp.getMaSP());
            ps.setObject(4, sp.getTenSP());
            ps.setObject(5, sp.getGiaNhap());
            ps.setObject(6, sp.getGiaBan());
            ps.setObject(7, sp.getSoLuongTon());
            ps.setObject(8, sp.getMoTa());
            ps.setObject(9, sp.getTrangThai());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham sp, String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "UPDATE SANPHAM SET idKT=?,idDM=?,masp=?,tensp=?,giaNhap=?,giaBan=?,soLuongTon=?,mota=?,trangthai=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, sp.getIdKT());
            ps.setObject(2, sp.getIdDM());
            ps.setObject(3, sp.getMaSP());
            ps.setObject(4, sp.getTenSP());
            ps.setObject(5, sp.getGiaNhap());
            ps.setObject(6, sp.getGiaBan());
            ps.setObject(7, sp.getSoLuongTon());
            ps.setObject(8, sp.getMoTa());
            ps.setObject(9, sp.getTrangThai());
            ps.setObject(10, id);

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "DELETE FROM SANPHAM WHERE ID=?";
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
                         SELECT dbo.SANPHAM.MaSP, dbo.SANPHAM.TenSP, dbo.KICHTHUOC.TenKT, dbo.DANHMUC.TenTL, dbo.SANPHAM.GiaNhap, dbo.SANPHAM.GiaBan, dbo.SANPHAM.SoLuongTon, dbo.SANPHAM.MoTa, dbo.SANPHAM.TrangThai,dbo.HINHANH.DuongDan
                                             FROM dbo.SANPHAM INNER JOIN dbo.KICHTHUOC ON dbo.SANPHAM.IdKT = dbo.KICHTHUOC.Id 
                                             INNER JOIN dbo.DANHMUC ON dbo.SANPHAM.IdDM = dbo.DANHMUC.Id 
                                             INNER JOIN dbo.HINHANH ON dbo.SANPHAM.Id = dbo.HINHANH.IdSanPham""";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("masp");
                String ten = rs.getString("tensp");
                String tenLoai = rs.getString("TenTL");
                String tenSize = rs.getString("TenKT");
                Double giaNhap = rs.getDouble("gianhap");
                Double giaBan = rs.getDouble("giaban");
                Integer soLuongTon = rs.getInt("soluongton");
                Integer trangThai = rs.getInt("trangthai");
                String moTa = rs.getString("moTa");
                String duongDan = rs.getString("duongDan");

                SanPhamViewModel sanPhamViewModel
                        = new SanPhamViewModel(ma, ten, tenLoai, tenSize, giaNhap, giaBan, soLuongTon, trangThai, moTa, duongDan);
                listsp.add(sanPhamViewModel);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    @Override
    public boolean checkTrung(String ma) {
        String query = "select * from sanpham where masp=?";
        boolean isExists = false;
        try ( Connection con = jdbcUtil.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }
}
