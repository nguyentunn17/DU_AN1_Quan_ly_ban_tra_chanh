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
private IHoaDonRepository rhdvm=new HoaDonRepository();
    @Override
    public ArrayList<HoaDonVM> getlist() {
        return rhdvm.getAll();
    }

    
    }

    

    


