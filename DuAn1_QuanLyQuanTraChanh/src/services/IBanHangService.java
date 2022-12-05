package services;

import java.util.ArrayList;
import viewmodels.HoaDonChiTietViewModel;

public interface IBanHangService {

    ArrayList<HoaDonChiTietViewModel> loadSp(String mahd);

}
