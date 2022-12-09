package viewmodels;

import java.math.BigDecimal;

public class SanPhamViewModel {

    private String masp;
    private String tensp;
    private String loaiSP;
    private String size;
    private Double giaNhap;
    private Double giaBan;
    private Double thanhTien;
    private Integer soLuong;
    private Integer trangThai;
    private String moTa;
    private String anh;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String masp, String tensp, String loaiSP, String size, Double giaNhap, Double giaBan, Double thanhTien, Integer soLuong, Integer trangThai, String moTa, String anh) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaiSP = loaiSP;
        this.size = size;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.anh = anh;
    }

    public SanPhamViewModel(String masp, String tensp, Double giaBan, Integer soLuong) {
        this.masp = masp;
        this.tensp = tensp;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public SanPhamViewModel(String masp, String tensp, Double giaBan, Double thanhTien, Integer soLuong) {
        this.masp = masp;
        this.tensp = tensp;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.soLuong = soLuong;
    }

    public SanPhamViewModel(String masp, String tensp, String loaiSP, String size, Double giaNhap, Double giaBan, Integer soLuong, Integer trangThai, String moTa, String anh) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaiSP = loaiSP;
        this.size = size;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.anh = anh;
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

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "masp=" + masp + ", tensp=" + tensp + ", loaiSP=" + loaiSP + ", size=" + size + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", trangThai=" + trangThai + ", moTa=" + moTa + ", anh=" + anh + '}';
    }

}
