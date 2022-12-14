package viewmodels;

public class SanPhamKhuyenMaiViewModel {

    private String makm;
    private String tenkm;
    private String tensp;
    private String loaiGiamGia;
    private Double mucGiamPhanTram;
    private Double giaBan;
    private Double giaTienConLai;
    private Integer trangThai;

    public SanPhamKhuyenMaiViewModel() {
    }

    public SanPhamKhuyenMaiViewModel(String makm, String tenkm, String tensp, String loaiGiamGia, Double mucGiamPhanTram, Double giaBan, Double giaTienConLai, Integer trangThai) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.tensp = tensp;
        this.loaiGiamGia = loaiGiamGia;
        this.mucGiamPhanTram = mucGiamPhanTram;
        this.giaBan = giaBan;
        this.giaTienConLai = giaTienConLai;
        this.trangThai = trangThai;
    }

    public String getLoaiGiamGia() {
        return loaiGiamGia;
    }

    public void setLoaiGiamGia(String loaiGiamGia) {
        this.loaiGiamGia = loaiGiamGia;
    }

    

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public Double getMucGiamPhanTram() {
        return mucGiamPhanTram;
    }

    public void setMucGiamPhanTram(Double mucGiamPhanTram) {
        this.mucGiamPhanTram = mucGiamPhanTram;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaTienConLai() {
        return giaTienConLai;
    }

    public void setGiaTienConLai(Double giaTienConLai) {
        this.giaTienConLai = giaTienConLai;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
