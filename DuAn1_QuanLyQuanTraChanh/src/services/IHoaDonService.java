package services;

import domainmodels.HoaDon;
import java.util.ArrayList;
import viewmodels.HoaDonVM;

public interface IHoaDonService {

    ArrayList<HoaDon> getAll1();

    void insert(HoaDon hd);

    void update(String ma, HoaDon hd);

    ArrayList<HoaDonVM> getHoaDon();

    ArrayList<HoaDonVM> listH();
    
    ArrayList<HoaDonVM> listBan(String ma);
    

}
