/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.ThongKe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.jdbcUtil;

/**
 *
 * @author Inspiron
 */
public class ThongKeRepository {

    public ArrayList<ThongKe> getList() {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT top 7 NgayThanhtoan , sum(tongtien) as tongtien FROM HOADON inner join HOADONCHITIET on HOADON.Id=HOADONCHITIET.IdHD group by NgayThanhtoan order by ngaythanhtoan desc ";
            ArrayList<ThongKe> tks = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setNgayThanhToan(rs.getDate("ngaythanhtoan"));
                ke.setTongtien(rs.getDouble("tongtien"));
                tks.add(ke);

            }

            return tks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<ThongKe> getList2() {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT top 7 CONVert(Datetime,Left(((NgayThanhtoan)),11),103) as ngaythanhtoan, sum(thanhtien) as tongtien FROM HOADON inner join HOADONCHITIET on HOADON.Id=HOADONCHITIET.IdHD group by Left((NgayThanhtoan),11) order by Left((NgayThanhtoan),11) asc ";
            ArrayList<ThongKe> tks = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setNgayThanhToan(rs.getDate("ngaythanhtoan"));
                ke.setTongtien(rs.getDouble("tongtien"));
                tks.add(ke);

            }

            return tks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ThongKe> timkiemm(Date ngaya, Date ngayb) {
        ArrayList<ThongKe> thongKes = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT CONVert(Datetime,Left(((NgayThanhtoan)),11),103) as ngaythanhtoan, sum(thanhtien) as tongtien FROM HOADON inner join HOADONCHITIET on HOADON.Id=HOADONCHITIET.IdHD  where CONVert(Datetime,Left(((NgayThanhtoan)),11),103) between ? and ? group by CONVert(Datetime,Left(((NgayThanhtoan)),11),103) order by CONVert(Datetime,Left(((NgayThanhtoan)),11),103) desc ";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setObject(1, ngaya);
            ps.setObject(2, ngayb);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setNgayThanhToan(rs.getDate("ngaythanhtoan"));
                ke.setTongtien(rs.getDouble("tongtien"));
                thongKes.add(ke);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thongKes;
    }

    public ArrayList<ThongKe> sanphambanchay() {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "Select top 10 TenSP,sum(SoLuong)  as Tongsoluong from SANPHAM inner join HOADONCHITIET ON SANPHAM.Id = HOADONCHITIET.IdSP group by TenSP order by Tongsoluong desc";
            ArrayList<ThongKe> tks = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setTiensanpham(rs.getString("TenSP"));
                ke.setSoluongban(rs.getInt("Tongsoluong"));
                tks.add(ke);

            }

            return tks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<ThongKe> timsanphambanchay(Date ngaya, Date ngayb) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "Select Top 10 TenSP , ngaythanhtoan, SUM(Soluong)  as Tongsoluong from SANPHAM inner join HOADONCHITIET ON SANPHAM.Id = HOADONCHITIET.IdSP inner join HOADON ON HOADONCHITIET.IdHD=HOADON.Id where NgayThanhToan between ? And ? group by TenSP , NgayThanhToan order by ngaythanhtoan,  Tongsoluong desc";
            ArrayList<ThongKe> tks = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setObject(1, ngaya);
            ps.setObject(2, ngayb);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();

                ke.setTiensanpham(rs.getString("TenSP"));

                ke.setSoluongban(rs.getInt("Tongsoluong"));
                tks.add(ke);

            }

            return tks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
