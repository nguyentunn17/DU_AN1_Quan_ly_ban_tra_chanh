package repositories;

import java.util.ArrayList;
import viewmodels.SanPhamViewModel;

public interface IBanHangRepository {

    ArrayList<SanPhamViewModel> loadSp(String mahd);
}
