package services;

import domainmodels.KhuyenMai;
import domainmodels.SanPhamKhuyenMai;
import java.util.ArrayList;

public interface IKhuyenMaiService {

    ArrayList<KhuyenMai> read();

    ArrayList<SanPhamKhuyenMai> readspkm();

    void create(KhuyenMai km);

    void update(KhuyenMai km, String id);

    ArrayList<KhuyenMai> timKiem(String id);

    ArrayList<KhuyenMai> trangThai(String id);

    void delete(String id);

    void create(SanPhamKhuyenMai spkm);

}
