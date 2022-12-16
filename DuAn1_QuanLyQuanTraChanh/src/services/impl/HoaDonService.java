package services.impl;

import domainmodels.HoaDon;
import java.util.ArrayList;
import repositories.IHoaDonRepository;
import repositories.impl.HoaDonRepository;
import viewmodels.HoaDonVM;
import services.IHoaDonService;

public class HoaDonService implements IHoaDonService {

    private final IHoaDonRepository rhdvm = new HoaDonRepository();
    private final HoaDonRepository hdrp = new HoaDonRepository();

    @Override
    public void insert(HoaDon hd) {
        hdrp.insert(hd);
    }

    @Override
    public void update(String ma, HoaDon hd) {
        hdrp.update(ma, hd);
    }

    @Override
    public ArrayList<HoaDonVM> getHoaDon() {
        return hdrp.getHoaDon();
    }

    @Override
    public ArrayList<HoaDonVM> listH() {
        return hdrp.listHoaDon();
    }

    @Override
    public ArrayList<HoaDon> getAll1() {
        return this.hdrp.getAll1();
    }

    @Override
    public ArrayList<HoaDonVM> listBan(String ma) {
      return  this.hdrp.listBan(ma);
    }
}
