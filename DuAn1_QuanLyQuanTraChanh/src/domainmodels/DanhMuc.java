package domainmodels;

public class DanhMuc {
//    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
//	IdTL UNIQUEIDENTIFIER,
//	MaTL VARCHAR(30) UNIQUE,
//	TenTL NVARCHAR(50) DEFAULT NULL,
//	TrangThai INT DEFAULT 0
//)

    private String id;
    private String idTL;
    private String ma;
    private String ten;
    private Integer trangThai;

    public DanhMuc() {
    }

    public DanhMuc(String id, String idTL, String ma, String ten, Integer trangThai) {
        this.id = id;
        this.idTL = idTL;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public DanhMuc(String ma, String ten, Integer trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public DanhMuc(String id, String ma, String ten, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTL() {
        return idTL;
    }

    public void setIdTL(String idTL) {
        this.idTL = idTL;
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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
