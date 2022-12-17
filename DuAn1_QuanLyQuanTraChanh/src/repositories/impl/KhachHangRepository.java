/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.KhachHang;
import utilities.jdbcUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;

public class KhachHangRepository {

    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "select * from khachhang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String maKH = rs.getString(2);
                String tenKH = rs.getString(3);
                Date ngaySinh = rs.getDate(4);
                String sdt = rs.getString(5);
                String diaChi = rs.getString(6);
                String gioiTinh = rs.getString(7);
                String ghiChu = rs.getString(8);
                int trangThai = rs.getInt(9);
                KhachHang kh = new KhachHang(id, maKH, tenKH, ngaySinh, sdt, diaChi, gioiTinh, ghiChu, trangThai);
                list.add(kh);
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(KhachHang kh) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "INSERT INTO [dbo].[KHACHHANG]\n"
                    + "           ([Ma]\n"
                    + "           ,[Ten]\n"
                    + "           ,[NgaySinh]\n"
                    + "           ,[Sdt]\n"
                    + "           ,[DiaChi]\n"
                    + "           ,[GioiTinh]\n"
                    + "           ,[GhiChu]\n"
                    + "           ,[TrangThai])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, kh.getMakh());
            ps.setObject(2, kh.getTenkh());
            ps.setObject(3, kh.getNgaysinh());
            ps.setObject(4, kh.getSdt());
            ps.setObject(5, kh.getDiachi());
            ps.setObject(6, kh.getGioitinh());
            ps.setObject(7, kh.getGhichu());
            ps.setObject(8, kh.getTrangThai());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String id, KhachHang kh) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "UPDATE [dbo].[KHACHHANG]\n"
                    + "   SET [Ten] = ?\n"
                    + "      ,[NgaySinh] = ?\n"
                    + "      ,[Sdt] = ?\n"
                    + "      ,[DiaChi] = ?\n"
                    + "      ,[GioiTinh] = ?\n"
                    + "      ,[GhiChu] = ?\n"
                    + " WHERE ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, kh.getTenkh());
            ps.setObject(2, kh.getNgaysinh());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getDiachi());
            ps.setObject(5, kh.getGioitinh());
            ps.setObject(6, kh.getGhichu());
            ps.setObject(7, id);
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "delete from khachhang where ma like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkTrung(String maKH) {
        String query = "select * from khachhang where ma =?";
        boolean isExists = false;
        try ( Connection con = jdbcUtil.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }
}
