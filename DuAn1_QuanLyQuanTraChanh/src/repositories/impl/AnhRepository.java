/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.AnhSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IAnhRepository;
import viewmodels.AnhViewModel;

/**
 *
 * @author Hung
 */
public class AnhRepository implements IAnhRepository {

    @Override
    public ArrayList<AnhViewModel> read() {
        ArrayList<AnhViewModel> listsp = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "select hinhanh.Id,TenHA,TenSP,DuongDan,hinhanh.TrangThai from HINHANH inner join SANPHAM on HINHANH.IdSanPham=SANPHAM.Id";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenSP = rs.getString("Tensp");
                String ten = rs.getString("tenha");
                String duongDan = rs.getString("duongDan");
                Integer trangThai = rs.getInt("trangThai");
                AnhViewModel asp = new AnhViewModel(id, tenSP, ten, duongDan, trangThai);
                listsp.add(asp);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    @Override
    public void create(AnhSanPham asp) {
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "INSERT INTO HINHANH(IDSanPham,TENHA,DUONGDAN,TRANGTHAI) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, asp.getTenAnh());
            ps.setObject(2, asp.getIdSP());
            ps.setObject(3, asp.getDuongDan());
            ps.setObject(4, asp.getTrangThai());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(AnhSanPham asp, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
