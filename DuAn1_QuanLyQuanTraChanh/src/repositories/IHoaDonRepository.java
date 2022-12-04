package repositories;

import domainmodels.HoaDon;
import java.util.ArrayList;
import viewmodels.HoaDonVM;

public interface IHoaDonRepository {

    ArrayList<HoaDonVM> getAll();

    
}
