package repositories.impl;

import domainmodels.Ban;
import domainmodels.HoaDonChiTiet;
import domainmodels.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IBanHangRepository;
import utilities.jdbcUtil;
import viewmodels.HoaDonChiTietViewModel;

public class BanHangRepository implements IBanHangRepository {

    @Override
    public ArrayList<HoaDonChiTietViewModel> loadSp(String mahd) {
        ArrayList<HoaDonChiTietViewModel> listsp = new ArrayList<>();
        Connection conn;
        try {
            conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT MaSP,TenSP,SoLuongTon,GiaBan,ThanhTien FROM SANPHAM 
                         INNER JOIN HOADONCHITIET ON SANPHAM.ID=HOADONCHITIET.IdSP 
                         INNER JOIN HOADON ON HOADONCHITIET.IdHD=HOADON.Id
                         WHERE MaHD=? """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                String ma = rs.getString("masp");
                String ten = rs.getString("tensp");
                Double giaBan = rs.getDouble("giaBan");
                Integer soLuongTon = rs.getInt("soLuongTon");
                Double thanhTien = rs.getDouble("ThanhTien");

                HoaDonChiTietViewModel hoaDonChiTietViewModel
                        = new HoaDonChiTietViewModel(ma, ten, giaBan, soLuongTon, thanhTien);
                listsp.add(hoaDonChiTietViewModel);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    @Override
    public void createHD(HoaDonChiTiet hdct) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "INSERT INTO HOADONCHITIET(IDHD,IDSP,IDDA,IDDUONG,SOLUONG,DONGIA,GIADUONG,GIADA,THANHTIEN,TRANGTHAI)"
                    + " values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, hdct.getIdHD());
            ps.setObject(2, hdct.getIdSP());
            ps.setObject(3, hdct.getIdDa());
            ps.setObject(4, hdct.getIdDuong());
            ps.setObject(5, hdct.getSoLuong());
            ps.setObject(6, hdct.getDonGia());
            ps.setObject(7, hdct.getGiaDuong());
            ps.setObject(8, hdct.getGiaDa());
            ps.setObject(9, hdct.getThanhTien());
            ps.setObject(10, hdct.getTrangThai());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<HoaDonChiTiet> getAll() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = """
                           SELECT TOP (1000) [Id]
                                 ,[IdHD]
                                 ,[IdSP]
                                 ,[IdDa]
                                 ,[IdDuong]
                                 ,[SoLuong]
                                 ,[DonGia]
                                 ,[GiaDuong]
                                 ,[GiaDa]
                                 ,[ThanhTien]
                                 ,[TrangThai]
                             FROM [QuanLyCuaHangTraChanh].[dbo].[HOADONCHITIET]""";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String idhd = rs.getString("IdHD");
                String idsp = rs.getString("IdSP");
                String idda = rs.getString("IdDa");
                String idduong = rs.getString("IdDuong");
                Integer soluong = rs.getInt("soluong");
                Double dongia = rs.getDouble("DonGia");
                Double giaduong = rs.getDouble("GiaDuong");
                Double giada = rs.getDouble("GiaDa");
                Double thanhTien = rs.getDouble("ThanhTien");
                Integer trangthai = rs.getInt("TrangThai");
                HoaDonChiTiet hdct = new HoaDonChiTiet(id, idhd, idsp, idda, idduong, soluong, dongia, giaduong, giada, thanhTien, trangthai);
                list.add(hdct);
            }
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
