package services;

import domainmodels.KhuyenMai;
import domainmodels.SanPhamKhuyenMai;
import java.util.ArrayList;
import viewmodels.SanPhamKhuyenMaiViewModel;

public interface IKhuyenMaiService {

    ArrayList<KhuyenMai> read();

    ArrayList<SanPhamKhuyenMaiViewModel> readspkm();

    void create(KhuyenMai km);

    void update(KhuyenMai km, String id);

    ArrayList<KhuyenMai> timKiem(String id);

    ArrayList<KhuyenMai> trangThai(String id);

    void delete(String id);

    void create(SanPhamKhuyenMai spkm);

}
