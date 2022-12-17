/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.Ban;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IBanRepository;
import utilities.jdbcUtil;

/**
 *
 * @author ASUS
 */
public class BanRepository implements IBanRepository {

    @Override
    public ArrayList<Ban> getAll() {
        ArrayList<Ban> listBan = new ArrayList<>();
        Connection conn;
        try {
            conn = jdbcUtil.getConnection();
            String sql = "select * from Ban order by maban asc";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String maca = rs.getString("MaBan");
                String tenca = rs.getString("TenBan");
                int soNguoi = rs.getInt("SoNguoi");
                int trangThai = rs.getInt("TrangThai");
                Ban b = new Ban(id, maca, tenca, soNguoi, trangThai);
                listBan.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBan;
    }

    @Override
    public boolean insert(Ban b) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String insert = "insert into Ban" + "(MaBan,TenBan,SoNguoi,TrangThai)" + "Values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, b.getMaBan());
            ps.setString(2, b.getTenBan());
            ps.setInt(3, b.getSoNguoi());
            ps.setInt(4, b.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean Update(String id, Ban b) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String Update = "update Ban set MaBan=?,TenBan=?,SoNguoi=?,TrangThai=? Where id=?";
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(5, id);
            ps.setString(1, b.getMaBan());
            ps.setString(2, b.getTenBan());
            ps.setInt(3, b.getSoNguoi());
            ps.setInt(4, b.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String delete = "delete from Ban where id = ?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public ArrayList<Ban> getTenBan(String ten) {
        ArrayList<Ban> listBan = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "select * from Ban where tenban=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setObject(1, ten);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String maca = rs.getString("MaBan");
                String tenca = rs.getString("TenBan");
                int soNguoi = rs.getInt("SoNguoi");
                int trangThai = rs.getInt("TrangThai");
                Ban b = new Ban(id, maca, tenca, soNguoi, trangThai);
                listBan.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBan;
    }

    public boolean checkTrung(String ma) {
        String query = "select * from ban where maban=?";
        boolean isExists = false;
        try ( Connection con = jdbcUtil.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }
}
