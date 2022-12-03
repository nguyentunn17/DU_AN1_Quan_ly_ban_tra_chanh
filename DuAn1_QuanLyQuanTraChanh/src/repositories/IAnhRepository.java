package repositories;

import domainmodels.AnhSanPham;
import java.util.ArrayList;
import viewmodels.AnhViewModel;

public interface IAnhRepository {

    ArrayList<AnhViewModel> read();

    void create(AnhSanPham asp);

    void update(AnhSanPham asp, String id);

    void delete(String id);
}
