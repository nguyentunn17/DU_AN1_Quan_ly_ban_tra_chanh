package repositories.impl;

import domainmodels.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IHoaDonRepository;
import utilities.jdbcUtil;
import viewmodels.HoaDonVM;

public class HoaDonRepository implements IHoaDonRepository {

    @Override
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

    @Override
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

    @Override
    public ArrayList<HoaDonVM> listHoaDon() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT dbo.HOADON.MaHD,TENBAN, dbo.HOADON.NgayTao, dbo.NHANVIEN.Ten, dbo.HOADON.TrangThai
                         FROM dbo.HOADON INNER JOIN dbo.NHANVIEN ON dbo.HOADON.IdNV = dbo.NHANVIEN.Id 
                         INNER JOIN BAN ON BAN.ID=HOADON.IDBAN
                         where hoadon.trangthai=1""";
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getTimestamp("NgayTao");
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

    @Override
    public ArrayList<HoaDonVM> getHoaDon() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT dbo.HOADON.MaHD, dbo.NHANVIEN.Ten,dbo.HOADON.NgayTao,HOADON.NgayThanhToan,sum(thanhtien) as'TongTien',dbo.HOADON.TrangThai
                                        FROM dbo.HOADON INNER JOIN dbo.NHANVIEN ON dbo.HOADON.IdNV = dbo.NHANVIEN.Id 
                         		inner join hoadonchitiet on HOADONCHITIET.IdHD=HOADON.Id
                         		where hoadon.trangthai=0 group by dbo.HOADON.MaHD,dbo.NHANVIEN.Ten,dbo.HOADON.NgayTao,HOADON.NgayThanhToan,dbo.HOADON.TrangThai""";
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getTimestamp("NgayTao");
                Date ngayThanhToan = rs.getTimestamp("NgayThanhToan");
                String nguoiTao = rs.getString("ten");
                int trangthai = rs.getInt("TrangThai");
                Double tongTien = rs.getDouble("TongTien");
                HoaDonVM hdvm = new HoaDonVM(mahd, ngaytao, ngayThanhToan, nguoiTao, tongTien, trangthai);
                listhdvm.add(hdvm);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhdvm;
    }

    @Override
    public ArrayList<HoaDonVM> listBan(String ma) {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();

        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "select TenBan from HOADON inner join BAN on HOADON.IdBAN=BAN.id where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tenban = rs.getString("tenban");
                HoaDonVM hdvm = new HoaDonVM(tenban);
                listhdvm.add(hdvm);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhdvm;
    }

    @Override
    public ArrayList<HoaDonVM> listSoLuong() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();

        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         select mahd,sum(soluong) as'soluong' from HOADONCHITIET inner join HOADON on HOADON.Id=HOADONCHITIET.IdHD
                         where mahd=? group by mahd""";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tenban = rs.getString("tenban");
                HoaDonVM hdvm = new HoaDonVM(tenban);
                listhdvm.add(hdvm);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhdvm;
    }

}
