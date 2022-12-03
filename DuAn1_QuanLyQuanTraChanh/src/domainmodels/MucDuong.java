/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author Inspiron
 */
public class MucDuong {
    private String id;
    private String mad;
    private String tend;
    private int giad;
    private int trangthai;

    public MucDuong() {
    }

    public MucDuong(String id, String mad, String tend, int giad, int trangthai) {
        this.id = id;
        this.mad = mad;
        this.tend = tend;
        this.giad = giad;
        this.trangthai = trangthai;
    }

    public MucDuong(String mad, String tend, int giad, int trangthai) {
        this.mad = mad;
        this.tend = tend;
        this.giad = giad;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMad() {
        return mad;
    }

    public void setMad(String mad) {
        this.mad = mad;
    }

    public String getTend() {
        return tend;
    }

    public void setTend(String tend) {
        this.tend = tend;
    }

    public int getGiad() {
        return giad;
    }

    public void setGiad(int giad) {
        this.giad = giad;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    
}
