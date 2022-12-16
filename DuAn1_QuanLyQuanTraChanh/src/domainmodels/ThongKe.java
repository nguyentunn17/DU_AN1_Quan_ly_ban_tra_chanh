/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.util.Date;

/**
 *
 * @author Inspiron
 */
public class ThongKe {

    private Date ngayThanhToan;
    private double tongtien;
    private String tiensanpham;
    private int soluongban;

    public ThongKe(String tiensanpham, int soluongban) {
        this.tiensanpham = tiensanpham;
        this.soluongban = soluongban;
    }

    public String getTiensanpham() {
        return tiensanpham;
    }

    public void setTiensanpham(String tiensanpham) {
        this.tiensanpham = tiensanpham;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }

    public ThongKe() {
    }

    public ThongKe(Date ngayThanhToan, double tongtien) {
        this.ngayThanhToan = ngayThanhToan;
        this.tongtien = tongtien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

}
