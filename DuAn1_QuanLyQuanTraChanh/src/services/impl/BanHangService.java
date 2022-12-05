package services.impl;

import java.util.ArrayList;
import repositories.IBanHangRepository;
import repositories.impl.BanHangRepository;
import services.IBanHangService;
import viewmodels.SanPhamViewModel;

public class BanHangService implements IBanHangService {

    private IBanHangRepository banHangRepository;

    public BanHangService() {
        this.banHangRepository=new BanHangRepository();
    }

    @Override
    public ArrayList<SanPhamViewModel> loadSp(String mahd) {
        SanPhamViewModel sanPhamViewModel = new SanPhamViewModel();
        ArrayList<SanPhamViewModel> listspvm = new ArrayList<>();
        for (SanPhamViewModel sanPhamViewModel1 : this.banHangRepository.loadSp(mahd)) {
            sanPhamViewModel.setMasp(sanPhamViewModel1.getMasp());
            sanPhamViewModel.setTensp(sanPhamViewModel1.getTensp());
            sanPhamViewModel.setSoLuong(sanPhamViewModel1.getSoLuong());
            sanPhamViewModel.setGiaBan(sanPhamViewModel1.getGiaBan());
            Double giaBan = sanPhamViewModel1.getGiaBan().doubleValue();
            sanPhamViewModel.setThanhTien(giaBan - sanPhamViewModel1.getSoLuong());

            listspvm.add(sanPhamViewModel);
        }
        return listspvm;
    }

}
