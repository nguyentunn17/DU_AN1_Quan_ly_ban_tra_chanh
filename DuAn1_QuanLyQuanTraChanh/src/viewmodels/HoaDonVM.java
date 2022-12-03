/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Phuong
 */
public class HoaDonVM {
    private String mahd;
    private String ngayTao;
    private String nguoitao;
    private String tenkh;
    private String diachi;
    private String tongtien;
    private String sdtnguoinhan;
    private int trangthai;

    public HoaDonVM() {
    }

    public HoaDonVM(String mahd, String ngayTao, String nguoitao, String tenkh, String diachi, String tongtien, String sdtnguoinhan, int trangthai) {
        this.mahd = mahd;
        this.ngayTao = ngayTao;
        this.nguoitao = nguoitao;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.tongtien = tongtien;
        this.sdtnguoinhan = sdtnguoinhan;
        this.trangthai = trangthai;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(String nguoitao) {
        this.nguoitao = nguoitao;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getSdtnguoinhan() {
        return sdtnguoinhan;
    }

    public void setSdtnguoinhan(String sdtnguoinhan) {
        this.sdtnguoinhan = sdtnguoinhan;
    }


    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    
    
    
}
