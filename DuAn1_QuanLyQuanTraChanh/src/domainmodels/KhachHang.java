/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.util.Date;

/**
 *
 * @author Phuong
 */
public class KhachHang {
    private String id;
    private String makh;
    private String tenkh;
    private Date ngaysinh;
    private String sdt;
    private String diachi;
    private String gioitinh;
    private String ghichu;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(String makh, String tenkh, Date ngaysinh, String sdt, String diachi, String gioitinh, String ghichu) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ghichu = ghichu;
    }
    
    public KhachHang(String id, String makh, String tenkh, Date ngaysinh, String sdt, String diachi, String gioitinh, String ghichu, int trangThai) {
        this.id = id;
        this.makh = makh;
        this.tenkh = tenkh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ghichu = ghichu;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   
}
