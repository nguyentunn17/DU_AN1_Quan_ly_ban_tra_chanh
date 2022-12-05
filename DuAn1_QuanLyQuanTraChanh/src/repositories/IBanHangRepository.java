package repositories;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangRepository {

    ArrayList<HoaDonChiTietViewModel> loadSp(String mahd);
}
