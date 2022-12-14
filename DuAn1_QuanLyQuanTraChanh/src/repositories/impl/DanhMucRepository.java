/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.DanhMuc;
import domainmodels.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IDanhMucRepository;

/**
 *
 * @author Hung
 */
public class DanhMucRepository implements IDanhMucRepository {

    @Override
    public ArrayList<DanhMuc> read() {
        ArrayList<DanhMuc> listdm = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "SELECT * FROM DANHMUC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("matl");
                String ten = rs.getString("tentl");
                Integer trangThai = rs.getInt("TrangThai");
                DanhMuc dm = new DanhMuc(id, ma, ten, trangThai);

                listdm.add(dm);

            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listdm;
    }

    @Override
    public void create(DanhMuc dm) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "INSERT INTO DANHMUC(MATL,TENTL,TRANGTHAI) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, dm.getMa());
            ps.setObject(2, dm.getTen());
            ps.setObject(3, dm.getTrangThai());

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DanhMuc dm, String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "UPDATE DANHMUC set MATL=?,TENTL=?,TRANGTHAI=? where id=? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, dm.getMa());
            ps.setObject(2, dm.getTen());
            ps.setObject(3, dm.getTrangThai());
            ps.setObject(4, id);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "DELETE FROM DANHMUC WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, id);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
