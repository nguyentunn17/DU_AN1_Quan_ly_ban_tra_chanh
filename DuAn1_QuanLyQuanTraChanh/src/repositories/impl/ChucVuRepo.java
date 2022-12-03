/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.ChucVu;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.jdbcUtil;

/**
 *
 * @author Quang
 */
public class ChucVuRepo {

    public ArrayList<ChucVu> listAll() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "SELECT [Id]\n"
                    + "      ,[MaCV]\n"
                    + "      ,[TenCV]\n"
                    + "      ,[GhiChu]\n"
                    + "  FROM [dbo].[CHUCVU]";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                ChucVu cv = new ChucVu(id, ma, ten);
                list.add(cv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insert(ChucVu cv) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "INSERT INTO chucvu "
                    + "(macv,tencv) "
                    + "values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, cv.getMaCV());
            ps.setObject(2, cv.getTenCV());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(ChucVu cv, String ma) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "UPDATE [dbo].[CHUCVU]\n"
                    + "   SET [TenCV] = <TenCV, nvarchar(30),>\n"
                    + " WHERE macv=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(2, cv.getMaCV());
            ps.setObject(1, cv.getTenCV());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String ma) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "delete from [dbo].[CHUCVU]\n"
                    + " WHERE macv=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
