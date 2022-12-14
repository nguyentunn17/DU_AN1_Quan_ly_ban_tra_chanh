package viewmodels;

public class NhanVienViewModel {

    private String taiKhoan;
    private String matKhau;
    private String chucVu;
    private String tenNV;
    private String anh;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String taiKhoan, String matKhau, String chucVu, String tenNV, String anh) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.tenNV = tenNV;
        this.anh = anh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

   

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

}
