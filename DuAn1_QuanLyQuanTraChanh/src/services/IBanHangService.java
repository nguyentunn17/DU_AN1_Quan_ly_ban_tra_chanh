package services;

import java.util.ArrayList;
import viewmodels.SanPhamViewModel;

public interface IBanHangService {

    ArrayList<SanPhamViewModel> loadSp(String mahd);

}
