package viewmodels;

public class HoaDonChiTietViewModel {

    private String masp;
    private String tensp;
    private Integer soLuong;
    private String mucDuong;
    private String mucDa;

    private Double giaBan;
    private Double thanhTien;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String masp, String tensp, Double giaBan, Integer soLuong, Double thanhTien) {
        this.masp = masp;
        this.tensp = tensp;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
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

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
