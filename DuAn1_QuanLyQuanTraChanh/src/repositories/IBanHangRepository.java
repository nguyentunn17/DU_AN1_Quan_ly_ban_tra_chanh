package repositories;

import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import domainmodels.SanPham;
import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangRepository {

    ArrayList<HoaDonChiTietViewModel> loadHDCT(String id);

    ArrayList<HoaDonChiTiet> getAll();

    ArrayList<HoaDonChiTietViewModel> getByGH();

    void createHD(HoaDonChiTiet hdct);

    void delete(String idsp, String idhd);

    void updateTotal(HoaDon hd, String mahd);

    void update(SanPham sp, String id);
}
