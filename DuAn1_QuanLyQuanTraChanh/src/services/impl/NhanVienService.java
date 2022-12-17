/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.NhanVien;
import viewmodels.NhanVienVMD;
import java.util.ArrayList;
import repositories.impl.NhanVienRepository;
import services.INhanVienService;

/**
 *
 * @author Quang
 */
public class NhanVienService implements INhanVienService {

    private NhanVienRepository qLNVRepo;

    public NhanVienService() {
        qLNVRepo = new NhanVienRepository();
    }

    @Override
    public ArrayList<NhanVien> listAll() {
        return qLNVRepo.listall();
    }

    @Override
    public void insert(NhanVien nv) {
        qLNVRepo.insert(nv);
    }

    @Override
    public void update(String id, NhanVien nv) {
        qLNVRepo.update(id, nv);
    }

    @Override
    public void delete(String id) {
        qLNVRepo.delete(id);
    }

    @Override
    public ArrayList<NhanVienVMD> listViewMoDel() {
        return qLNVRepo.listViewMoDel();
    }

    @Override
    public ArrayList<NhanVienVMD> listSearch(String ma) {
        return qLNVRepo.list(ma);
    }

    @Override
    public boolean checkTrung(String maNV) {
        return qLNVRepo.checkTrung(maNV);
    }

}
