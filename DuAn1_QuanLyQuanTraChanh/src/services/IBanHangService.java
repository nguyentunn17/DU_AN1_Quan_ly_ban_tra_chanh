package services;

import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangService {

    ArrayList<HoaDonChiTietViewModel> loadSp(String id);

    ArrayList<HoaDonChiTiet> getAll();

    void createHD(HoaDonChiTiet hdct);

    ArrayList<HoaDonChiTietViewModel> getByGH();

    void delete(String idsp, String idhd);

    void updateTotal(HoaDon hd, String mahd);

}
