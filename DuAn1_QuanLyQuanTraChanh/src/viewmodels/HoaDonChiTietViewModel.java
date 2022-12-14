package viewmodels;

public class HoaDonChiTietViewModel {

    private String masp;
    private String tensp;
    private Integer soLuong;
    private String mucDuong;
    private String mucDa;
    private Double giaBan;
    private Double thanhTien;
    private String tenban;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String masp, String tensp, Integer soLuong, Double giaBan, Double thanhTien, String tenban) {
        this.masp = masp;
        this.tensp = tensp;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.tenban = tenban;
    }

    public HoaDonChiTietViewModel(String masp, String tensp, Integer soLuong, Double giaBan, Double thanhTien) {
        this.masp = masp;
        this.tensp = tensp;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
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

    public String getMucDuong() {
        return mucDuong;
    }

    public void setMucDuong(String mucDuong) {
        this.mucDuong = mucDuong;
    }

    public String getMucDa() {
        return mucDa;
    }

    public void setMucDa(String mucDa) {
        this.mucDa = mucDa;
    }

    public String getTenban() {
        return tenban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
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
