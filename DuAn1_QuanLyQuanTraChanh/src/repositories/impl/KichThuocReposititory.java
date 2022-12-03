/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;
import domainmodels.KichThuoc;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.jdbcUtil;


/**
 *
 * @author Inspiron
 */
public class KichThuocReposititory {
    public ArrayList<KichThuoc> getAll() {
        ArrayList<KichThuoc> list_kThuocs = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT * FROM KICHTHUOC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaKT");
                String ten = rs.getString("TenKT");
                int gia = rs.getInt("Gia");
                int trangthai = rs.getInt("TrangThai");
                KichThuoc kichThuoc = new KichThuoc(id, ma, ten, gia, trangthai);
                list_kThuocs.add(kichThuoc);

            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_kThuocs;
    }
    public void insert(KichThuoc kichThuoc) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "INSERT INTO KICHTHUOC" + "(MaKT,TenKT,Gia,TrangThai)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kichThuoc.getMakt());
            ps.setString(2, kichThuoc.getTenkt());
            ps.setDouble(3, kichThuoc.getGia());
            ps.setInt(4, kichThuoc.getTrangthai());
            ps.execute();
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "DELETE FROM KICHTHUOC WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void update(String id, KichThuoc kichThuoc) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "update KICHTHUOC set MaKT=?,TenKT=?,Gia=?,TrangThai=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kichThuoc.getMakt());
            ps.setString(2, kichThuoc.getTenkt());
            ps.setDouble(3, kichThuoc.getGia());
            ps.setInt(4, kichThuoc.getTrangthai());
            ps.setString(5, id);
            ps.execute();

            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
