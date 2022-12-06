package services;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangService {

    ArrayList<HoaDonChiTietViewModel> loadSp(String mahd);

    ArrayList<HoaDonChiTiet> getAll();

    void createHD(HoaDonChiTiet hdct);

}
