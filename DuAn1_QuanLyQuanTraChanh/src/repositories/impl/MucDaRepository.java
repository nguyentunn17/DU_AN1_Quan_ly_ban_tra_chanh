/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;
import domainmodels.MucDa;
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
public class MucDaRepository {
    public ArrayList<MucDa> getAll() {
        ArrayList<MucDa> list_MucDa = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT * FROM MUCDA";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaD");
                String ten = rs.getString("TenD");
                int gia = rs.getInt("GiaD");
                int trangthai = rs.getInt("TrangThai");
                MucDa mucDa = new MucDa(id, ma, ten, gia, trangthai);
                list_MucDa.add(mucDa);

            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_MucDa;
    }
    public void insert(MucDa mucDa) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "INSERT INTO MUCDA" + "(MaD,TenD,GiaD,TrangThai)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mucDa.getMad());
            ps.setString(2, mucDa.getTend());
            ps.setDouble(3, mucDa.getGiad());
            ps.setInt(4, mucDa.getTrangthai());
            ps.execute();
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "DELETE FROM MUCDA WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void update(String id, MucDa mucDa) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "update MUCDA set MaD=?,TenD=?,GiaD=?,TrangThai=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mucDa.getMad());
            ps.setString(2, mucDa.getTend());
            ps.setDouble(3, mucDa.getGiad());
            ps.setInt(4, mucDa.getTrangthai());
            ps.setString(5, id);
            ps.execute();

            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
