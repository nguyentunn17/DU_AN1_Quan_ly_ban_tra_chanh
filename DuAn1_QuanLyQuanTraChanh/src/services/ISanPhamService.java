package services;

import domainmodels.SanPham;
import java.util.ArrayList;
import viewmodels.SanPhamViewModel;

public interface ISanPhamService {

    ArrayList<SanPham> read();

    ArrayList<SanPhamViewModel> getByID();

    void create(SanPham sp);

    void update(SanPham sp, String id);

    void delete(String id);
    
    boolean checkTrung(String ma);
}
