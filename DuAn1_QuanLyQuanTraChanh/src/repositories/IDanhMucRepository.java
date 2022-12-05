package repositories;

import domainmodels.DanhMuc;
import java.util.ArrayList;

public interface IDanhMucRepository {

    ArrayList<DanhMuc> read();

    void create(DanhMuc dm);

    void update(DanhMuc dm, String id);

    void delete(String id);
}
