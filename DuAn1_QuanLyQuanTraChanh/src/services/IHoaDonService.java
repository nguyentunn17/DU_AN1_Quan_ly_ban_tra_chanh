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

    ArrayList<HoaDonVM> getAll();

    ArrayList<HoaDon> getAll1();

    void insert(HoaDon hd);

    void update(String ma, HoaDon hd);

//    ArrayList<HoaDonVM> getHoaDon();

    ArrayList<HoaDonVM> listH();

}
