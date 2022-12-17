/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.NhanVien;
import viewmodels.NhanVienVMD;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public interface INhanVienService {

    ArrayList<NhanVien> listAll();

    void insert(NhanVien nv);

    void update(String id, NhanVien nv);

    void delete(String id);

    ArrayList<NhanVienVMD> listViewMoDel();

    ArrayList<NhanVienVMD> listSearch(String ma);

    boolean checkTrung(String maNV);
}
