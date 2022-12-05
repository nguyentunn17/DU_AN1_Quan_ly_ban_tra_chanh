package domainmodels;


public class SanPham {
//Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
//	IdKT UNIQUEIDENTIFIER,
//	IdDM UNIQUEIDENTIFIER,
//	MaSP VARCHAR(30) UNIQUE, 
//	TenSP NVARCHAR(50) DEFAULT NULL,
//	GiaNhap DECIMAL(20,0) DEFAULT 0,
//	GiaBan DECIMAL(20,0) DEFAULT 0,
//	SoLuongTon int,
//	MoTa nvarchar(50),
//	TrangThai INT DEFAULT 0

    private String id;
    private String idKT;
    private String idDM;
    private String maSP;
    private String TenSP;
    private Double giaNhap;
    private Double giaBan;
    private Integer soLuongTon;
    private String moTa;
    private Integer trangThai;

    public SanPham(String maSP, String TenSP, Double giaBan, Integer soLuongTon) {
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
    }

    public SanPham() {
    }

    public SanPham(String id, String idKT, String idDM, String maSP, String TenSP, Double giaNhap, Double giaBan, Integer soLuongTon, String moTa, Integer trangThai) {
        this.id = id;
        this.idKT = idKT;
        this.idDM = idDM;
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public SanPham(String idKT, String idDM, String maSP, String TenSP, Double giaNhap, Double giaBan, Integer soLuongTon, String moTa, Integer trangThai) {
        this.idKT = idKT;
        this.idDM = idDM;
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKT() {
        return idKT;
    }

    public void setIdKT(String idKT) {
        this.idKT = idKT;
    }

    public String getIdDM() {
        return idDM;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
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

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
