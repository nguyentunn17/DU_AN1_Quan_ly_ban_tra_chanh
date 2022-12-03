/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.HoaDon;
import domainmodels.ThongKe;
import java.util.ArrayList;
import utilities.jdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.IThongKeService;

/**
 *
 * @author Inspiron
 */
public class ThongKeRepository implements IThongKeService{

    @Override
    public ArrayList<ThongKe> getList() {
        try {
            Connection conn= jdbcUtil.getConnection();
            String sql="select NgayThanhToan , SUM(Tongtien) AS TONGTIEN FROM HOADON GROUP BY NGAYTHANHTOAN";
            ArrayList<ThongKe> tks=new ArrayList<>();
            PreparedStatement ps=conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ThongKe ke=new ThongKe();
                ke.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                ke.setTongtien(rs.getDouble("Tongtien"));
                tks.add(ke);
                
                
            }
            
            
            return tks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ThongKe> timkiem(Date ngayThanhToan) {
        ArrayList<ThongKe>thongKes=new ArrayList<>();
        try {
            Connection conn=jdbcUtil.getConnection();
            String sql="SELECT ngayThanhToan , sum(tongtien) as tongtien FROM HOADON  where NgayThanhToan = ? GROUP BY NGAYTHANHTOAN";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setObject(1, ngayThanhToan);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                ThongKe ke=new ThongKe();
                ke.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                ke.setTongtien(rs.getDouble("TongTien"));
                thongKes.add(ke);
                
                
            }
            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thongKes;
    }

    
    
}
