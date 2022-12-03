package repositories;

import domainmodels.KhuyenMai;
import java.util.ArrayList;

public interface IKhuyenMaiRepository {

    ArrayList<KhuyenMai> read();

    void create(KhuyenMai km);

    void update(KhuyenMai km, String id);

    ArrayList<KhuyenMai> timKiem(String id);

    void delete(String id);
}
