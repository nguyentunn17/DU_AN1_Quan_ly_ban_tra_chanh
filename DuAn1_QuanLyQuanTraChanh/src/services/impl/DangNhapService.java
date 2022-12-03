package services.impl;

import repositories.IDangNhapRepository;
import repositories.impl.DangNhapRepository;
import services.IDangNhapService;
import viewmodels.NhanVienViewModel;

public class DangNhapService implements IDangNhapService {

    private final IDangNhapRepository dangNhapRepository;

    public DangNhapService() {
        this.dangNhapRepository = new DangNhapRepository();
    }

    @Override
    public NhanVienViewModel login(String taiKhoan, String matKhau) {
        return this.dangNhapRepository.login(taiKhoan, matKhau);
    }

}
