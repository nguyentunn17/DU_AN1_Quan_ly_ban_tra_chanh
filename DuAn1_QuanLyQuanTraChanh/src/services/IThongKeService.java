package services;

import domainmodels.ThongKe;
import java.util.ArrayList;
import java.util.Date;

public interface IThongKeService {

    public ArrayList<ThongKe> getList();

    public ArrayList<ThongKe> timkiem(Date ngay);

    public ArrayList<ThongKe> timkiem(Date ngaya, Date ngayb);

}
