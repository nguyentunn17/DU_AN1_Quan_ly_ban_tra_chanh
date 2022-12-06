package domainmodels;

public class HoaDonChiTiet {
//    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
//	IdHD UNIQUEIDENTIFIER,
//	IdSP UNIQUEIDENTIFIER,
//	IdDa UNIQUEIDENTIFIER,
//	IdDuong UNIQUEIDENTIFIER,
//	SoLuong DECIMAL(20,0) DEFAULT 0, 
//	DonGia DECIMAL(20,0) DEFAULT 0,
//	GiaDuong DECIMAL(20,0) DEFAULT 0,
//	GiaDa DECIMAL(20,0) DEFAULT 0,
//	ThanhTien DECIMAL(20,0) DEFAULT 0,
//	TrangThai INT DEFAULT 0

    private String id;
    private String idHD;
    private String idSP;
    private String idDa;
    private String idDuong;
    private Integer soLuong;
    private Double donGia;
    private Double giaDuong;
    private Double giaDa;
    private Double thanhTien;
    private Integer trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, String idHD, String idSP, String idDa, String idDuong, Integer soLuong, Double donGia, Double giaDuong, Double giaDa, Double thanhTien, Integer trangThai) {
        this.id = id;
        this.idHD = idHD;
        this.idSP = idSP;
        this.idDa = idDa;
        this.idDuong = idDuong;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.giaDuong = giaDuong;
        this.giaDa = giaDa;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(String idHD, String idSP, Integer soLuong, Double donGia, Double thanhTien) {
        this.idHD = idHD;
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdDa() {
        return idDa;
    }

    public void setIdDa(String idDa) {
        this.idDa = idDa;
    }

    public String getIdDuong() {
        return idDuong;
    }

    public void setIdDuong(String idDuong) {
        this.idDuong = idDuong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getGiaDuong() {
        return giaDuong;
    }

    public void setGiaDuong(Double giaDuong) {
        this.giaDuong = giaDuong;
    }

    public Double getGiaDa() {
        return giaDa;
    }

    public void setGiaDa(Double giaDa) {
        this.giaDa = giaDa;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
