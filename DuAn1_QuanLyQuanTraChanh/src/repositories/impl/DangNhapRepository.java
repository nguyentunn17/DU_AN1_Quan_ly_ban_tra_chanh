/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IDangNhapRepository;
import viewmodels.NhanVienViewModel;

public class DangNhapRepository implements IDangNhapRepository {

    @Override
    public NhanVienViewModel login(String taiKhoan, String matKhau) {

        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String sql = "SELECT * FROM NHANVIEN INNER JOIN CHUCVU ON NHANVIEN.IDCV=CHUCVU.ID WHERE MA=? AND MATKHAU=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            if (rs.next() == false) {
                return null;
            }
            String tencv = rs.getString("tencv");
            String tenNV = rs.getString("ten");
            String anhNV=rs.getString("anh");
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel(taiKhoan, matKhau, tencv, tenNV, anhNV);

            return nhanVienViewModel;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(DangNhapRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
