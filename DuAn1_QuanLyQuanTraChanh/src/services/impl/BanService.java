/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.Ban;
import java.util.ArrayList;
import repositories.impl.BanRepository;
import services.IBanService;

/**
 *
 * @author ASUS
 */
public class BanService implements IBanService {

    public BanRepository RBan = new BanRepository();

    @Override
    public ArrayList<Ban> getlist() {
        return RBan.getAll();
    }

    @Override
    public String insert(Ban b) {
        if (RBan.insert(b)) {
            return "Thêm Thành Công";
        }
        return "Thêm Thất bại";
    }

    @Override
    public String Update(String id, Ban b) {
        if (RBan.Update(id, b)) {
            return "Sửa Thành Công";
        }
        return "Sửa Thất bại";
    }

    @Override
    public String delete(String id) {
        if (RBan.delete(id)) {
            return "xóa Thành Công";
        }
        return "xóa Thất bại";
    }

    @Override
    public ArrayList<Ban> getTenBan(String ten) {
        return this.RBan.getTenBan(ten);
    }

    @Override
    public boolean checkTrung(String ma) {
        return RBan.checkTrung(ma);
    }

}
