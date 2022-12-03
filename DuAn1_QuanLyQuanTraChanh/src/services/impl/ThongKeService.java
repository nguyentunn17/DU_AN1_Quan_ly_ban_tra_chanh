/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ThongKe;
import java.util.ArrayList;
import java.util.Date;
import repositories.impl.ThongKeRepository;
import services.IThongKeService;

/**
 *
 * @author Inspiron
 */
public class ThongKeService implements IThongKeService{
    private ThongKeRepository thong_Ke_rep;

    public ThongKeService() {
        this.thong_Ke_rep=new ThongKeRepository();
                
    }
    

    @Override
    public ArrayList<ThongKe> getList() {
        return thong_Ke_rep.getList();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThongKe> timkiem(Date ngayThanhToan) {
        return this.thong_Ke_rep.timkiem(ngayThanhToan);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
