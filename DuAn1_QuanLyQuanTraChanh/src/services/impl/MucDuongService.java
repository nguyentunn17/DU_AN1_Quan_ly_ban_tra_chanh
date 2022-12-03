/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.MucDuong;
import java.util.ArrayList;
import repositories.impl.KichThuocReposititory;
import repositories.impl.MucDuongRepository;
import services.IKichThuocService;
import services.IMucDuongService;

/**
 *
 * @author Inspiron
 */
public class MucDuongService implements IMucDuongService{
    private MucDuongRepository mucDuong_impl;

    public MucDuongService() {
        this.mucDuong_impl=new MucDuongRepository();
    }
    

    @Override
    public ArrayList<MucDuong> getList() {
       return this.mucDuong_impl.getAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(MucDuong mucDuong) {
        this.mucDuong_impl.insert(mucDuong);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        this.mucDuong_impl.delete(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, MucDuong mucDuong) {
        this.mucDuong_impl.update(id, mucDuong);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
