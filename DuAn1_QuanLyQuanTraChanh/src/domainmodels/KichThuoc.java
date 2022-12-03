/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author Inspiron
 */
public class KichThuoc {
    private String id;
    private String makt;
    private String tenkt;
    private int gia;
    private int trangthai;

    public KichThuoc() {
    }

    public KichThuoc(String makt, String tenkt, int gia, int trangthai) {
        this.makt = makt;
        this.tenkt = tenkt;
        this.gia = gia;
        this.trangthai = trangthai;
    }

    public KichThuoc(String id, String makt, String tenkt, int gia, int trangthai) {
        this.id = id;
        this.makt = makt;
        this.tenkt = tenkt;
        this.gia = gia;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMakt() {
        return makt;
    }

    public void setMakt(String makt) {
        this.makt = makt;
    }

    public String getTenkt() {
        return tenkt;
    }

    public void setTenkt(String tenkt) {
        this.tenkt = tenkt;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
    
}
