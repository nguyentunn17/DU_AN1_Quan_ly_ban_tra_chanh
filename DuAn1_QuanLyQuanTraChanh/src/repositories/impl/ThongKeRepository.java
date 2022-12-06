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
            String sql = """
                         SELECT NgayTao , sum(ThanhTien) as tongtien FROM HOADON inner join HOADONCHITIET on HOADON.Id=HOADONCHITIET.IdHD
                         group by NgayTao
                         """;
            ArrayList<ThongKe> tks = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setNgayThanhToan(rs.getDate("ngaytao"));
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
            String sql = """
                         SELECT  NgayTao , sum(ThanhTien) as tongtien FROM HOADON inner join HOADONCHITIET on HOADON.Id=HOADONCHITIET.IdHD
                                       where NgayThanhToan between ? And ?  GROUP BY ngaytao""";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setObject(1, ngaya);
            ps.setObject(2, ngayb);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setNgayThanhToan(rs.getDate("ngaytao"));
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

    public ArrayList<ThongKe> timkiemtheongay(Date ngay) {
        ArrayList<ThongKe> thongKes = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT  NgayTao , sum(ThanhTien) as tongtien FROM HOADON inner join HOADONCHITIET on HOADON.Id=HOADONCHITIET.IdHD
                                                    where NgayTao =? GROUP BY ngaytao""";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setObject(1, ngay);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe ke = new ThongKe();
                ke.setNgayThanhToan(rs.getDate("ngaytao"));
                ke.setTongtien(rs.getDouble("tongtien"));
                thongKes.add(ke);

            }
            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thongKes;
    }

}
