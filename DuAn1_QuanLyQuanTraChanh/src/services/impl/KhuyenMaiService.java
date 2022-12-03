package services.impl;

import domainmodels.KhuyenMai;
import java.util.ArrayList;
import repositories.IKhuyenMaiRepository;
import repositories.impl.KhuyenMaiRepository;
import services.IKhuyenMaiService;

public class KhuyenMaiService implements IKhuyenMaiService {

    private final IKhuyenMaiRepository khuyenMaiRepository;

    public KhuyenMaiService() {
        this.khuyenMaiRepository = new KhuyenMaiRepository();
    }

    @Override
    public ArrayList<KhuyenMai> read() {
        return this.khuyenMaiRepository.read();
    }

    @Override
    public void create(KhuyenMai km) {
        this.khuyenMaiRepository.create(km);
    }

    @Override
    public void update(KhuyenMai km, String id) {
        this.khuyenMaiRepository.update(km, id);
    }

    @Override
    public ArrayList<KhuyenMai> timKiem(String id) {
        return this.khuyenMaiRepository.timKiem(id);
    }

    @Override
    public ArrayList<KhuyenMai> trangThai(String id) {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        for (KhuyenMai khuyenMai : this.khuyenMaiRepository.read()) {
            if (khuyenMai.getTrangThai() == Integer.parseInt(id)) {
                list.add(khuyenMai);
            }
        }
        return list;
    }

    @Override
    public void delete(String id) {
        this.khuyenMaiRepository.delete(id);
    }
}
