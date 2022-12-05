package services.impl;

import domainmodels.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import repositories.IBanHangRepository;
import repositories.impl.BanHangRepository;
import services.IBanHangService;
import viewmodels.HoaDonChiTietViewModel;
import viewmodels.NhanVienViewModel;
import viewmodels.SanPhamViewModel;

public class BanHangService implements IBanHangService {

    private final IBanHangRepository banHangRepository;

    public BanHangService() {
        this.banHangRepository = new BanHangRepository();
    }

    @Override
    public ArrayList<HoaDonChiTietViewModel> loadSp(String mahd) {
       return this.banHangRepository.loadSp(mahd);
       
    }
}
