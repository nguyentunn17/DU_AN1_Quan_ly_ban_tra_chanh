package domainmodels;

public class AnhSanPham {

    private String id;
    private String idSP;
    private String tenAnh;
    private String duongDan;
    private Integer trangThai;

    public AnhSanPham() {
    }

    public AnhSanPham(String id, String idSP, String tenAnh, String duongDan, Integer trangThai) {
        this.id = id;
        this.idSP = idSP;
        this.tenAnh = tenAnh;
        this.duongDan = duongDan;
        this.trangThai = trangThai;
    }

    public AnhSanPham(String idSP, String tenAnh, String duongDan, Integer trangThai) {
        this.idSP = idSP;
        this.tenAnh = tenAnh;
        this.duongDan = duongDan;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
