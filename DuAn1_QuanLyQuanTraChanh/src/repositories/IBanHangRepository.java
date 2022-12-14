package repositories;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangRepository {

    ArrayList<HoaDonChiTietViewModel> loadHDCT(String id);

    ArrayList<HoaDonChiTiet> getAll();

    ArrayList<HoaDonChiTietViewModel> getByGH();

    void createHD(HoaDonChiTiet hdct);

    void delete(String idsp,String idhd);
}
