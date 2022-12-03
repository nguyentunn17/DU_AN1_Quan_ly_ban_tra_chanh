/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.HoaDon;
import java.util.ArrayList;
import repositories.IHoaDonRepository;
import repositories.impl.HoaDonRepository;
import viewmodels.HoaDonVM;
import services.IHoaDonService;

public class HoaDonService implements IHoaDonService {

    private IHoaDonRepository hoaDonRepository;

    public HoaDonService() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    @Override
    public void insert(HoaDon hoaDon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, HoaDon hoaDon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoaDon> getAll() {
        return this.hoaDonRepository.getAll();
    }

    @Override
    public ArrayList<HoaDonVM> getByID() {
        return this.hoaDonRepository.getByID();
    }

}
