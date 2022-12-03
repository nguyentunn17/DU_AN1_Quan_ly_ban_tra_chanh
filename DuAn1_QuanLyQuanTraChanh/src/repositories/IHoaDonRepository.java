package repositories;

import domainmodels.HoaDon;
import java.util.ArrayList;
import viewmodels.HoaDonVM;

public interface IHoaDonRepository {

    ArrayList<HoaDonVM> getByID();

    ArrayList<HoaDon> getAll();

    public void insert(HoaDon hoaDon);

    public void update(String id, HoaDon hoaDon);

    public void delete(String id);

}
