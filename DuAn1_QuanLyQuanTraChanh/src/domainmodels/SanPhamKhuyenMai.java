/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author Hung
 */
public class SanPhamKhuyenMai {

    private String id;
    private String idkm;
    private String idsp;
    private Double donGia;
    private Double soTienConlai;
    private Integer trangThai;

    public SanPhamKhuyenMai() {
    }

    public SanPhamKhuyenMai(String id, String idkm, String idsp, Double donGia, Double soTienConlai, Integer trangThai) {
        this.id = id;
        this.idkm = idkm;
        this.idsp = idsp;
        this.donGia = donGia;
        this.soTienConlai = soTienConlai;
        this.trangThai = trangThai;
    }

    public SanPhamKhuyenMai(String idkm, String idsp, Double donGia, Double soTienConlai, Integer trangThai) {
        this.idkm = idkm;
        this.idsp = idsp;
        this.donGia = donGia;
        this.soTienConlai = soTienConlai;
        this.trangThai = trangThai;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdkm() {
        return idkm;
    }

    public void setIdkm(String idkm) {
        this.idkm = idkm;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getSoTienConlai() {
        return soTienConlai;
    }

    public void setSoTienConlai(Double soTienConlai) {
        this.soTienConlai = soTienConlai;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
