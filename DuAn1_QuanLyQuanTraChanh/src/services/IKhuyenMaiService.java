package services;

import domainmodels.KhuyenMai;
import java.util.ArrayList;

public interface IKhuyenMaiService {

    ArrayList<KhuyenMai> read();

    void create(KhuyenMai km);

    void update(KhuyenMai km, String id);

    ArrayList<KhuyenMai> timKiem(String id);

    ArrayList<KhuyenMai> trangThai(String id);

    void delete(String id);

}
