package services.impl;

import domainmodels.SanPham;
import java.util.ArrayList;
import repositories.ISanPhamRepository;
import repositories.impl.SanPhamRepository;
import services.ISanPhamService;
import viewmodels.SanPhamViewModel;

public class SanPhamService implements ISanPhamService {

    private final ISanPhamRepository sanPhamRepository;

    public SanPhamService() {
        this.sanPhamRepository = new SanPhamRepository();
    }

    @Override
    public ArrayList<SanPham> read() {
        return this.sanPhamRepository.read();
    }

    @Override
    public ArrayList<SanPhamViewModel> getByID() {
        return this.sanPhamRepository.getByID();
    }

    @Override
    public void create(SanPham sp) {
        this.sanPhamRepository.create(sp);
    }

    @Override
    public void update(SanPham sp, String id) {
        this.sanPhamRepository.update(sp, id);
    }

    @Override
    public void delete(String id) {
        this.sanPhamRepository.delete(id);
    }

    @Override
    public boolean checkTrung(String ma) {
        return sanPhamRepository.checkTrung(ma);
    }

}
