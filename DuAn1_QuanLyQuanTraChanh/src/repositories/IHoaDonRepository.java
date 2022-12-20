package repositories;

import domainmodels.HoaDon;
import java.util.ArrayList;
import viewmodels.HoaDonVM;

public interface IHoaDonRepository {

    ArrayList<HoaDon> getAll1();

    public void insert(HoaDon hd);

    public void update(String ma, HoaDon hd);

    public ArrayList<HoaDonVM> getHoaDon();

    public ArrayList<HoaDonVM> listHoaDon();

    public ArrayList<HoaDonVM> listSoLuong();

    ArrayList<HoaDonVM> listBan(String ma);

}
