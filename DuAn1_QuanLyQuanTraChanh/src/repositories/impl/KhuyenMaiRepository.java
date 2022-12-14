package repositories.impl;

import domainmodels.KhuyenMai;
import domainmodels.SanPhamKhuyenMai;
import java.util.ArrayList;
import repositories.IKhuyenMaiRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.SanPhamKhuyenMaiViewModel;

public class KhuyenMaiRepository implements IKhuyenMaiRepository {

    @Override
    public ArrayList<KhuyenMai> read() {
        ArrayList<KhuyenMai> listkm = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "SELECT * FROM KHUYENMAI";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String loaiGiamGia = rs.getString("loaigiamgia");
                Double mucGiaPhanTram = rs.getDouble("MucGiamGiaPhanTram");
                Double mucGiaTienMat = rs.getDouble("MucGiamGiaTienMat");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");
                int trangThai = rs.getInt("trangThai");
                KhuyenMai khuyenMai = new KhuyenMai(id, ma, ten, loaiGiamGia, mucGiaPhanTram, mucGiaTienMat, ngayBatDau, ngayKetThuc, trangThai);
                listkm.add(khuyenMai);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listkm;
    }

    @Override
    public void create(KhuyenMai km) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "INSERT INTO KHUYENMAI(ma,ten,loaigiamgia,mucgiamgiaphantram,mucgiamgiatienmat,ngaybatdau,ngayketthuc,trangthai) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getTen());
            ps.setObject(3, km.getLoaiGiamGia());
            ps.setObject(4, km.getMucGiamGiaPhanTram());
            ps.setObject(5, km.getMucGiamGiaTienMat());
            ps.setObject(6, km.getNgayBatDau());
            ps.setObject(7, km.getNgayKetThuc());
            ps.setObject(8, km.getTrangThai());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(KhuyenMai km, String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "UPDATE KHUYENMAI SET ma=?,ten=?,loaigiamgia=?,mucgiamgiaphantram=?,mucgiamgiatienmat=?,ngaybatdau=?,ngayketthuc=?,trangthai=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getTen());
            ps.setObject(3, km.getLoaiGiamGia());
            ps.setObject(4, km.getMucGiamGiaPhanTram());
            ps.setObject(5, km.getMucGiamGiaTienMat());
            ps.setObject(6, km.getNgayBatDau());
            ps.setObject(7, km.getNgayKetThuc());
            ps.setObject(8, km.getTrangThai());
            ps.setObject(9, id);

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<KhuyenMai> timKiem(String idTimKiem) {
        ArrayList<KhuyenMai> listkm = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "SELECT * FROM KHUYENMAI where ten like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idTimKiem);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String loaiGiamGia = rs.getString("loaigiamgia");
                Double mucGiaPhanTram = rs.getDouble("MucGiamGiaPhanTram");
                Double mucGiaTienMat = rs.getDouble("MucGiamGiaTienMat");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKetThuc = rs.getDate("ngayKThuc");
                int trangThai = rs.getInt("trangThai");
                KhuyenMai khuyenMai = new KhuyenMai(id, ma, ten, loaiGiamGia, mucGiaPhanTram, mucGiaTienMat, ngayBatDau, ngayKetThuc, trangThai);
                listkm.add(khuyenMai);
            }
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listkm;
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
    public void create(SanPhamKhuyenMai spkm) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "INSERT INTO SPKHUYENMAI(idKm,idsp,dongia,dongiakhigiam,trangthai) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, spkm.getIdkm());
            ps.setObject(1, spkm.getIdsp());
            ps.setObject(1, spkm.getDonGia());
            ps.setObject(1, spkm.getSoTienConlai());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<SanPhamKhuyenMaiViewModel> readspkm() {
        ArrayList<SanPhamKhuyenMaiViewModel> listkm = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = """
                           SELECT MA,TEN,LOAIGIAMGIA,MUCGIAMGIAPHANTRAM,TenSP,GiaBan,SoTienConLai,SPKHUYENMAI.TrangThai FROM KHUYENMAI 
                           INNER JOIN SPKHUYENMAI ON KHUYENMAI.ID=SPKHUYENMAI.IDKM 
                           INNER JOIN SANPHAM ON SANPHAM.Id=SPKHUYENMAI.IdSP
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String loaiGiamGia = rs.getString("loaigiamgia");
                Double mucGiaPhanTram = rs.getDouble("MucGiamGiaPhanTram");
                String tensp = rs.getString("tensp");
                Double giaban = rs.getDouble("giaban");
                Double sotienconlai = rs.getDouble("SoTienConLai");
                int trangThai = rs.getInt("trangThai");
                SanPhamKhuyenMaiViewModel spkmvm = new SanPhamKhuyenMaiViewModel(ma, ten, tensp, loaiGiamGia, mucGiaPhanTram, giaban, sotienconlai, trangThai);
                listkm.add(spkmvm);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listkm;
    }

}
