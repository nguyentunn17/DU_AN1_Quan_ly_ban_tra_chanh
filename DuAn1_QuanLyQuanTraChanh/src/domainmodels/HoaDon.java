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
public class HoaDon {
    private String id;
    private String idnv;
    private String idkh;
    private String idban;
    private String ma;
    private Date ngaytao;
    private Date ngaythanhtoan;
    private int trangthai;
    private float tongTien;

    public HoaDon() {
    }

    public HoaDon(String id, String idnv, String idkh, String idban, String ma, Date ngaytao, Date ngaythanhtoan, int trangthai, float tongTien) {
        this.id = id;
        this.idnv = idnv;
        this.idkh = idkh;
        this.idban = idban;
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.trangthai = trangthai;
        this.tongTien = tongTien;
    }

    public HoaDon(String idnv, String idban, String ma, Date ngaytao, int trangthai) {
        this.idnv = idnv;
        this.idban = idban;
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public HoaDon(Date ngaythanhtoan, float tongTien) {
        this.ngaythanhtoan = ngaythanhtoan;
        this.tongTien = tongTien;
    }
    

    public HoaDon(String id, String ma) {
        this.id = id;
        this.ma = ma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public String getIdban() {
        return idban;
    }

    public void setIdban(String idban) {
        this.idban = idban;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(Date ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

   
}
