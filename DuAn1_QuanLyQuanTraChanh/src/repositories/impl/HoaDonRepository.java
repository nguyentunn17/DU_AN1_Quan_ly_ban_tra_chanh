/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Inspiron
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public ArrayList<HoaDonVM> getAll() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT dbo.HOADON.MaHD,dbo.HINHTHUCTHANHTOAN.NgayTao,dbo.NHANVIEN.Ten,dbo.KHACHHANG.Ten,\n"
                    + "dbo.KHACHHANG.DiaChi,dbo.HOADONCHITIET.ThanhTien,dbo.KHACHHANG.Sdt,dbo.HINHTHUCTHANHTOAN.TrangThai\n"
                    + "FROM   dbo.HINHTHUCTHANHTOAN INNER JOIN\n"
                    + "             dbo.HOADON ON dbo.HINHTHUCTHANHTOAN.IdHD = dbo.HOADON.Id INNER JOIN\n"
                    + "             dbo.HOADONCHITIET ON dbo.HOADON.Id = dbo.HOADONCHITIET.IdHD INNER JOIN\n"
                    + "             dbo.KHACHHANG ON dbo.HOADON.IdKH = dbo.KHACHHANG.Id INNER JOIN\n"
                    + "             dbo.NHANVIEN ON dbo.HINHTHUCTHANHTOAN.IdNV = dbo.NHANVIEN.Id AND dbo.HOADON.IdNV = dbo.NHANVIEN.Id";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getDate("NgayTao");
                String nguoitao = rs.getString("NguoiTao");
                double tongtien = rs.getDouble("Tongtien");
                int trangthai = rs.getInt("TrangThai");
                HoaDonVM hdvm = new HoaDonVM(mahd, ngaytao, nguoitao, tongtien, trangthai);
                listhdvm.add(hdvm);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listhdvm;
    }

    public void insert(HoaDon hd) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "INSERT INTO [dbo].[HOADON]\n"
                    + "           ([IdNV]\n"
                    + "           ,[IdKH]\n"
                    + "           ,[IdBAN]\n"
                    + "           ,[MaHD]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgayThanhToan]\n"
                    + "           ,[TongTien]\n"
                    + "           ,[TrangThai])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?)";
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
            String sql = "UPDATE [dbo].[HOADON]\n"
                    + "   SET [TrangThai] = 0 \n"
                    + "   WHERE mahd like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<HoaDonVM> getHoaDon() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT dbo.HOADON.MaHD, dbo.HOADON.NgayTao, dbo.NHANVIEN.Ten, dbo.HOADON.TrangThai\n"
                    + "FROM   dbo.BAN INNER JOIN\n"
                    + "             dbo.HOADON ON dbo.BAN.Id = dbo.HOADON.IdBAN INNER JOIN\n"
                    + "             dbo.NHANVIEN ON dbo.HOADON.IdNV = dbo.NHANVIEN.Id";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getDate("NgayTao");
                String nguoitao = rs.getString("NguoiTao");
                double tongtien = rs.getDouble("Tongtien");
                int trangthai = rs.getInt("TrangThai");
                HoaDonVM hdvm = new HoaDonVM(mahd, ngaytao, nguoitao, tongtien, trangthai);
                listhdvm.add(hdvm);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listhdvm;
    }

    public ArrayList<HoaDonVM> listHoaDon() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT [MaHD]\n"
                    + "      ,[NgayTao]\n"
                    + "      ,[NgayThanhToan]\n"
                    + "      ,[TongTien]\n"
                    + "      ,[TrangThai]\n"
                    + "  FROM [dbo].[HOADON]";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                Date ngaytao = rs.getDate("NgayTao");
                double tongtien = rs.getDouble("Tongtien");
                int trangthai = rs.getInt("TrangThai");
                HoaDonVM hdvm = new HoaDonVM(mahd, ngaytao, "Administrator", tongtien, trangthai);
                listhdvm.add(hdvm);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listhdvm;
    }

}
