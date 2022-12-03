/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.KichThuoc;
import java.util.ArrayList;
import repositories.impl.KichThuocReposititory;
import services.IKichThuocService;

/**
 *
 * @author Inspiron
 */
public class KichThuocService implements IKichThuocService{
    private KichThuocReposititory kichThuoc_impl;

    public KichThuocService() {
        this.kichThuoc_impl=new KichThuocReposititory();
    }
    

    @Override
    public ArrayList<KichThuoc> getList() {
       return this.kichThuoc_impl.getAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(KichThuoc kichThuoc) {
        this.kichThuoc_impl.insert(kichThuoc);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        this.kichThuoc_impl.delete(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, KichThuoc kichThuoc) {
        this.kichThuoc_impl.update(id, kichThuoc);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
