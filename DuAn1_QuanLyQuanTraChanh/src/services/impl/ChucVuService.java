/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChucVu;
import java.util.ArrayList;
import repositories.impl.ChucVuRepo;
import services.IChucVuSevrice;

/**
 *
 * @author Quang
 */
public class ChucVuService implements IChucVuSevrice {
    
    private static ChucVuRepo chucVuRePo;
    
    public ChucVuService() {
        chucVuRePo = new ChucVuRepo();
    }
    
    @Override
    public ArrayList<ChucVu> listAll() {
        return chucVuRePo.listAll();
    }
    
    @Override
    public void insert(ChucVu cv) {
        chucVuRePo.insert(cv);
    }
    
    @Override
    public void update(ChucVu cv, String ma) { 
        chucVuRePo.update(cv, ma);
    }
    
    @Override
    public void delete(String ma) {
        chucVuRePo.delete(ma);
    }
    
}
