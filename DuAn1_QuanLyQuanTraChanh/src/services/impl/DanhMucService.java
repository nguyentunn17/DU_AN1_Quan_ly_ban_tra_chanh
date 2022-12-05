package services.impl;

import domainmodels.DanhMuc;
import java.util.ArrayList;
import repositories.IDanhMucRepository;
import repositories.impl.DanhMucRepository;
import services.IDanhMucService;

public class DanhMucService implements IDanhMucService {

    private final IDanhMucRepository danhMucRepository;

    public DanhMucService() {
        this.danhMucRepository = new DanhMucRepository();
    }

    @Override
    public ArrayList<DanhMuc> read() {
        return this.danhMucRepository.read();
    }

    @Override
    public void create(DanhMuc dm) {
        this.danhMucRepository.create(dm);
    }

    @Override
    public void update(DanhMuc dm, String id) {
        this.danhMucRepository.update(dm, id);
    }

    @Override
    public void delete(String id) {
        this.danhMucRepository.delete(id);
    }

}
