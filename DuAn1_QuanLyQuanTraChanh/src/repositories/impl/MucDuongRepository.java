/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;
import domainmodels.MucDuong;
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
public class MucDuongRepository {
    public ArrayList<MucDuong> getAll() {
        ArrayList<MucDuong> list_MucDuongs = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT * FROM MUCDUONG";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaD");
                String ten = rs.getString("TenD");
                int gia = rs.getInt("GiaD");
                int trangthai = rs.getInt("TrangThai");
                MucDuong mucDuong = new MucDuong(id, ma, ten, gia, trangthai);
                list_MucDuongs.add(mucDuong);

            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_MucDuongs;
    }
    public void insert(MucDuong mucDuong) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "INSERT INTO MUCDUONG" + "(MaD,TenD,GiaD,TrangThai)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mucDuong.getMad());
            ps.setString(2, mucDuong.getTend());
            ps.setDouble(3, mucDuong.getGiad());
            ps.setInt(4, mucDuong.getTrangthai());
            ps.execute();
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "DELETE FROM MUCDUONG WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void update(String id, MucDuong mucDuong) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "update MUCDUONG set MaD=?,TenD=?,GiaD=?,TrangThai=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mucDuong.getMad());
            ps.setString(2, mucDuong.getTend());
            ps.setDouble(3, mucDuong.getGiad());
            ps.setInt(4, mucDuong.getTrangthai());
            ps.setString(5, id);
            ps.execute();

            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
