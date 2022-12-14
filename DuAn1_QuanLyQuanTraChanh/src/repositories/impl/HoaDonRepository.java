package repositories.impl;

import domainmodels.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import repositories.IHoaDonRepository;
import utilities.jdbcUtil;
import viewmodels.HoaDonVM;

/**
 *
 * @author Inspiron
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public ArrayList<HoaDonVM> getAll() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();

        Connection conn;
        try {
            conn = jdbcUtil.getConnection();
            String sql = """
                           SELECT MaHD,TenBan,HOADON.NgayTao,HOADON.NgayTao,MaSP,TenSP,ThanhTien,hoadon.TrangThai FROM SANPHAM 
                                                                                         INNER JOIN HOADONCHITIET ON SANPHAM.ID=HOADONCHITIET.IdSP 
                                                                                         INNER JOIN HOADON ON HOADONCHITIET.IdHD=HOADON.Id	
                          															   inner join BAN on BAN.Id=HOADON.IdBAN						
                                                               """;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayTao");
                String masp = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                Double thanhtien = rs.getDouble("ThanhTien");
                int trangthai = rs.getInt("TrangThai");
                String tenban = rs.getString("tenban");
                HoaDonVM hoaDonVM = new HoaDonVM(mahd, ngaytao, ngayThanhToan, masp, tensp, thanhtien, trangthai, tenban);
                listhdvm.add(hoaDonVM);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listhdvm;
    }

    public void insert(HoaDon hd) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         INSERT INTO [dbo].[HOADON]
                                    ([IdNV]
                                    ,[IdKH]
                                    ,[IdBAN]
                                    ,[MaHD]
                                    ,[NgayTao]
                                    ,[NgayThanhToan]
                                    ,[TongTien]
                                    ,[TrangThai])
                              VALUES
                                    (?,?,?,?,?,?,?,?)""";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hd.getIdnv());
            ps.setObject(2, hd.getIdkh());
            ps.setObject(3, hd.getIdban());
            ps.setObject(4, hd.getMa());
            ps.setObject(5, hd.getNgaytao());
            ps.setObject(6, hd.getNgaythanhtoan());
            ps.setObject(7, hd.getTongTien());
            ps.setObject(8, hd.getTrangthai());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(String ma, HoaDon hd) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         UPDATE [dbo].[HOADON]
                            SET [TrangThai] = 0 
                            WHERE mahd like ?""";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<HoaDonVM> listHoaDon() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT dbo.HOADON.MaHD, dbo.HOADON.NgayTao, dbo.NHANVIEN.Ten, dbo.HOADON.TrangThai
                         FROM dbo.HOADON INNER JOIN dbo.NHANVIEN ON dbo.HOADON.IdNV = dbo.NHANVIEN.Id""";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("ten");
                int trangthai = rs.getInt("TrangThai");
                HoaDonVM hdvm = new HoaDonVM(mahd, ngaytao, nguoiTao, trangthai);
                listhdvm.add(hdvm);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listhdvm;
    }

    @Override
    public ArrayList<HoaDon> getAll1() {
        ArrayList<HoaDon> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT  [Id]                                
                                 ,[MaHD]                               
                             FROM [QuanLyCuaHangTraChanh].[dbo].[HOADON]""";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String mahd = rs.getString("MaHD");
                HoaDon hd = new HoaDon(id, mahd);
                listhdvm.add(hd);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return listhdvm;
    }

}
