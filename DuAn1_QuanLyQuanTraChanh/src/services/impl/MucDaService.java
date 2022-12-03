/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.MucDa;
import java.util.ArrayList;
import repositories.impl.KichThuocReposititory;
import repositories.impl.MucDaRepository;
import repositories.impl.MucDuongRepository;
import services.IKichThuocService;
import services.IMucDaService;
import services.IMucDuongService;

/**
 *
 * @author Inspiron
 */
public class MucDaService implements IMucDaService{
    private MucDaRepository mucDa_impl;

    public MucDaService() {
        this.mucDa_impl=new MucDaRepository();
    }
    

    @Override
    public ArrayList<MucDa> getList() {
       return this.mucDa_impl.getAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(MucDa mucDa) {
        this.mucDa_impl.insert(mucDa);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        this.mucDa_impl.delete(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, MucDa mucDa) {
        this.mucDa_impl.update(id, mucDa);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
