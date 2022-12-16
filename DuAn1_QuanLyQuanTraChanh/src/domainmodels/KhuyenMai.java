package domainmodels;


import java.math.BigDecimal;
import java.util.Date;

public class KhuyenMai {
//Id  UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
//	Ma VARCHAR(20) UNIQUE,
//	Ten NVARCHAR(50) DEFAULT NULL,
//	NgayBatDau DATETIME DEFAULT NULL,
//	NgayKetThuc DATETIME DEFAULT NULL,
//	MucGiamGiaPhanTram DECIMAL(20,0),
//	MucGiamGiaTienMat DECIMAL(20,0),
//	DieuKienGiamGia NVARCHAR(50) DEFAULT NULL,
//	LoaiGiamGia NVARCHAR(50) DEFAULT NULL,
//	TrangThai INT DEFAULT 0,

    private String id;
    private String ma;
    private String ten;
    private String loaiGiamGia;
    private Double mucGiamGiaPhanTram;
    private Double mucGiamGiaTienMat;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String id, String ma, String ten, String loaiGiamGia, Double mucGiamGiaPhanTram, Date ngayBatDau, Date ngayKetThuc, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loaiGiamGia = loaiGiamGia;
        this.mucGiamGiaPhanTram = mucGiamGiaPhanTram;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public KhuyenMai(String id, String ma, String ten, String loaiGiamGia, Double mucGiamGiaPhanTram, Double mucGiamGiaTienMat, Date ngayBatDau, Date ngayKetThuc, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loaiGiamGia = loaiGiamGia;
        this.mucGiamGiaPhanTram = mucGiamGiaPhanTram;
        this.mucGiamGiaTienMat = mucGiamGiaTienMat;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public KhuyenMai(String ma, String ten, String loaiGiamGia, Double mucGiamGiaPhanTram, Double mucGiamGiaTienMat, Date ngayBatDau, Date ngayKetThuc, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.loaiGiamGia = loaiGiamGia;
        this.mucGiamGiaPhanTram = mucGiamGiaPhanTram;
        this.mucGiamGiaTienMat = mucGiamGiaTienMat;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoaiGiamGia() {
        return loaiGiamGia;
    }

    public void setLoaiGiamGia(String loaiGiamGia) {
        this.loaiGiamGia = loaiGiamGia;
    }

    public Double getMucGiamGiaPhanTram() {
        return mucGiamGiaPhanTram;
    }

    public void setMucGiamGiaPhanTram(Double mucGiamGiaPhanTram) {
        this.mucGiamGiaPhanTram = mucGiamGiaPhanTram;
    }

    public Double getMucGiamGiaTienMat() {
        return mucGiamGiaTienMat;
    }

    public void setMucGiamGiaTienMat(Double mucGiamGiaTienMat) {
        this.mucGiamGiaTienMat = mucGiamGiaTienMat;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
