package services.impl;

import domainmodels.ThongKe;
import java.util.ArrayList;
import java.util.Date;
import repositories.impl.ThongKeRepository;
import services.IThongKeService;

public class ThongKeService implements IThongKeService {

    private final ThongKeRepository thong_Ke_rep;

    public ThongKeService() {
        this.thong_Ke_rep = new ThongKeRepository();

    }

    @Override
    public ArrayList<ThongKe> getList() {
        return thong_Ke_rep.getList();
    }

    @Override
    public ArrayList<ThongKe> timkiem(Date ngaya, Date ngayb) {
        return thong_Ke_rep.timkiemm(ngaya, ngayb);// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThongKe> timkiem(Date ngay) {
        return thong_Ke_rep.timkiemtheongay(ngay);//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
