package repositories;

import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangRepository {

    ArrayList<HoaDonChiTietViewModel> loadSp(String mahd);
}
