package viewmodels;

import java.math.BigDecimal;

public class SanPhamViewModel {

    private String masp;
    private String tensp;
    private String loaiSP;
    private String size;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private Integer soLuong;
    private Integer trangThai;
    private String moTa;
    private String anh;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String masp, String tensp, String loaiSP, String size, BigDecimal giaNhap, BigDecimal giaBan, Integer soLuong, Integer trangThai, String moTa, String anh) {
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

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
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

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "masp=" + masp + ", tensp=" + tensp + ", loaiSP=" + loaiSP + ", size=" + size + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", trangThai=" + trangThai + ", moTa=" + moTa + ", anh=" + anh + '}';
    }

}
