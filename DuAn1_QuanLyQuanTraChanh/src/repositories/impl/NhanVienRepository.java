/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.NhanVien;
import viewmodels.NhanVienVMD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import utilities.jdbcUtil;
import java.sql.SQLException;
/**
 *
 * @author Quang
 */
public class NhanVienRepository {

    public ArrayList<NhanVien> listall() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "select * from nhanvien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String gioiTinh = rs.getString("gioitinh");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matkhau");
                int trangThai = rs.getInt("trangThai");
                String anh = rs.getString("anh");
                String idcv = rs.getString("idcv");
                NhanVien nv = new NhanVien(id, ma, ten, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai, anh, idcv);
                list.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insert(NhanVien nv) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "insert into nhanvien "
                    + "(ma,ten,gioitinh,ngaysinh,diachi,sdt,matkhau,trangthai,anh,idcv)"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getMatKhau());
            ps.setInt(8, nv.getTrangThai());
            ps.setString(9, nv.getAnh());
            ps.setString(10, nv.getIdCV());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(String id, NhanVien nv) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "update nhanvien set ma=?, ten=?,gioitinh=?,ngaysinh=?,diachi=?,sdt=?,matkhau=?,trangthai=?,anh=?,idcv=? where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getMatKhau());
            ps.setInt(8, nv.getTrangThai());
            ps.setString(9, nv.getAnh());
            ps.setString(10, nv.getIdCV());
            ps.setString(11, id);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "delete nhanvien where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<NhanVienVMD> listViewMoDel() {
        ArrayList<NhanVienVMD> listView = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "select chucvu.tencv, nhanvien.ma,nhanvien.ten,nhanvien.gioitinh,nhanvien.ngaysinh,nhanvien.diachi,nhanvien.sdt,nhanvien.matkhau,nhanvien.trangthai,nhanvien.anh from chucvu inner join nhanvien on nhanvien.idcv = chucvu.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String gioiTinh = rs.getString("gioitinh");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matkhau");
                int trangThai = rs.getInt("trangThai");
                String anh = rs.getString("anh");
                String chucVu = rs.getString("tencv");
                NhanVienVMD nvvmd = new NhanVienVMD(ma, ten, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai, anh, chucVu);
                listView.add(nvvmd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listView;
    }

    public ArrayList<NhanVienVMD> list(String ma) {
        ArrayList<NhanVienVMD> listSearch = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT dbo.NHANVIEN.Ma, dbo.NHANVIEN.Ten, dbo.NHANVIEN.NgaySinh, dbo.NHANVIEN.GioiTinh, dbo.NHANVIEN.Sdt, dbo.CHUCVU.TenCV, dbo.NHANVIEN.MatKhau, dbo.NHANVIEN.TrangThai, dbo.NHANVIEN.DiaChi, dbo.NHANVIEN.Anh\n"
                    + "FROM   dbo.CHUCVU INNER JOIN\n"
                    + "dbo.NHANVIEN ON dbo.CHUCVU.Id = dbo.NHANVIEN.IdCV where ma like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma1 = rs.getString("ma");
                String ten = rs.getString("ten");
                String gioiTinh = rs.getString("gioitinh");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matkhau");
                int trangThai = rs.getInt("trangThai");
                String anh = rs.getString("anh");
                String chucVu = rs.getString("tencv");
                NhanVienVMD nv = new NhanVienVMD(ma1, ten, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai, anh, chucVu);
                listSearch.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listSearch;
    }
    
    public boolean checkTrung(String maNV) {
        String query = "select * from nhanvien where ma=?";
        boolean isExists = false;
        try (Connection con = jdbcUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }
}
