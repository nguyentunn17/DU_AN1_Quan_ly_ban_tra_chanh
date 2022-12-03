/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.HoaDon;
import java.util.ArrayList;
import viewmodels.HoaDonVM;

/**
 *
 * @author Inspiron
 */
public interface IHoaDonService {

    ArrayList<HoaDonVM> getByID();

    ArrayList<HoaDon> getAll();

    public void insert(HoaDon hoaDon);

    public void update(String id, HoaDon hoaDon);

    public void delete(String id);

}
