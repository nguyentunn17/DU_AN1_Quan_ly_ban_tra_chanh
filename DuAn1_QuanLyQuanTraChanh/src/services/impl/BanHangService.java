package services.impl;

import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import domainmodels.SanPham;
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
    public ArrayList<HoaDonChiTietViewModel> loadSp(String id) {
        return this.banHangRepository.loadHDCT(id);

    }

    @Override
    public void createHD(HoaDonChiTiet hdct) {
        this.banHangRepository.createHD(hdct);
    }

    @Override
    public ArrayList<HoaDonChiTiet> getAll() {
        return this.banHangRepository.getAll();
    }

    @Override
    public ArrayList<HoaDonChiTietViewModel> getByGH() {
        return this.banHangRepository.getByGH();
    }

    @Override
    public void delete(String isp, String idhd) {
        this.banHangRepository.delete(isp, idhd);
    }

    @Override
    public void updateTotal(HoaDon hd, String mahd) {
        this.banHangRepository.updateTotal(hd, mahd);
    }

    @Override
    public void update(SanPham sp, String id) {
        this.banHangRepository.update(sp, id);
    }
}
