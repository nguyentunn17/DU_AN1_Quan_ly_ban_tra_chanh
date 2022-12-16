/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.util.Date;

/**
 *
 * @author Phuong
 */
public class HoaDonVM {

    private String mahd;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String nguoiTao;
    private String masp;
    private String tensp;
    private double thanhTien;
    private int trangthai;
    private String tenBan;

    public HoaDonVM() {
    }

    public HoaDonVM(String mahd, Date ngayTao, String nguoiTao, int trangthai) {
        this.mahd = mahd;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.trangthai = trangthai;
    }

    public HoaDonVM(String tenBan) {
        this.tenBan = tenBan;
    }

    public HoaDonVM(String mahd, Date ngayTao, Date ngayThanhToan, String nguoiTao, double thanhTien, int trangthai) {
        this.mahd = mahd;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.nguoiTao = nguoiTao;
        this.thanhTien = thanhTien;
        this.trangthai = trangthai;
    }

    public HoaDonVM(String mahd, Date ngayTao, String nguoiTao, double thanhTien, String tenBan) {
        this.mahd = mahd;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.thanhTien = thanhTien;
        this.tenBan = tenBan;
    }

    public HoaDonVM(String mahd, Date ngayTao, Date ngayThanhToan, String masp, String tensp, double thanhTien, int trangthai, String tenBan) {
        this.mahd = mahd;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.masp = masp;
        this.tensp = tensp;
        this.thanhTien = thanhTien;
        this.trangthai = trangthai;
        this.tenBan = tenBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
