package domainmodels;

import java.util.Date;

public class ThongKe {

    private Date ngayThanhToan;
    private double tongtien;
    private String mahd;

    public ThongKe() {
    }

    public ThongKe(Date ngayThanhToan, double tongtien) {
        this.ngayThanhToan = ngayThanhToan;
        this.tongtien = tongtien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
}
