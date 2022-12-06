package services.impl;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import repositories.IBanHangRepository;
import repositories.impl.BanHangRepository;
import services.IBanHangService;
import viewmodels.HoaDonChiTietViewModel;

public class BanHangService implements IBanHangService {

    private final IBanHangRepository banHangRepository;

    public BanHangService() {
        this.banHangRepository = new BanHangRepository();
    }

    @Override
    public ArrayList<HoaDonChiTietViewModel> loadSp(String mahd) {
        return this.banHangRepository.loadSp(mahd);

    }

    @Override
    public void createHD(HoaDonChiTiet hdct) {
        this.banHangRepository.createHD(hdct);
    }

    @Override
    public ArrayList<HoaDonChiTiet> getAll() {
        return this.banHangRepository.getAll();
    }
}
