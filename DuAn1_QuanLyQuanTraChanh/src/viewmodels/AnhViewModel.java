package viewmodels;

/**
 *
 * @author Hung
 */
public class AnhViewModel {

    private String id;
    private String tenSP;
    private String tenAnh;
    private String duongDan;
    private Integer trangThai;

    public AnhViewModel(String id, String tenSP, String tenAnh, String duongDan, Integer trangThai) {
        this.id = id;
        this.tenSP = tenSP;
        this.tenAnh = tenAnh;
        this.duongDan = duongDan;
        this.trangThai = trangThai;
    }

    public AnhViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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
