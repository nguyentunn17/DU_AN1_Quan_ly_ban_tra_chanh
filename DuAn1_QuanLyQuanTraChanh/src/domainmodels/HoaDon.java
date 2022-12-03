/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author Inspiron
 */
public class HoaDon {
    private String id;
    private String ma;
    private String ngaytao;
    private String ngaythanhtoan;
    private String ngayship;
    private String ngaynhap;
    private int trangthai;
    private String ten;
    private String diachi;
    private String sdt;

    public HoaDon(String ma, String ngaytao, String ngaythanhtoan, String ngayship, String ngaynhap, int trangthai, String ten, String diachi, String sdt) {
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.ngayship = ngayship;
        this.ngaynhap = ngaynhap;
        this.trangthai = trangthai;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public HoaDon(String id, String ma, String ngaytao, String ngaythanhtoan, String ngayship, String ngaynhap, int trangthai, String ten, String diachi, String sdt) {
        this.id = id;
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.ngayship = ngayship;
        this.ngaynhap = ngaynhap;
        this.trangthai = trangthai;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public HoaDon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public String getNgayship() {
        return ngayship;
    }

    public void setNgayship(String ngayship) {
        this.ngayship = ngayship;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

   
    
    
}
