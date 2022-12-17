/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.KhachHang;
import java.util.ArrayList;
import repositories.impl.KhachHangRepository;
import services.IKhachHangService;

/**
 *
 * @author Quang
 */
public class KhachHangService implements IKhachHangService {

    private static KhachHangRepository khrp = new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getAll() {
        return khrp.getAll();
    }

    @Override
    public void isnert(KhachHang kh) {
        khrp.insert(kh);
    }

    @Override
    public void delete(String id) {
        khrp.delete(id);
    }

    @Override
    public void update(String id, KhachHang kh) {
        khrp.update(id, kh);
    }

    @Override
    public boolean checkTrung(String maKH) {
        return khrp.checkTrung(maKH);
    }

}
