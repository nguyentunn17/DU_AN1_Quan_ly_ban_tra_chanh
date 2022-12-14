package repositories;

import domainmodels.KhuyenMai;
import domainmodels.SanPhamKhuyenMai;
import java.util.ArrayList;
import viewmodels.SanPhamKhuyenMaiViewModel;

public interface IKhuyenMaiRepository {

    ArrayList<KhuyenMai> read();

    ArrayList<SanPhamKhuyenMaiViewModel> readspkm();

    void create(KhuyenMai km);

    void update(KhuyenMai km, String id);

    ArrayList<KhuyenMai> timKiem(String id);

    void delete(String id);

    void create(SanPhamKhuyenMai spkm);
}
