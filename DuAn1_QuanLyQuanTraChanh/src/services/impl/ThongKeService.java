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
public class ThongKeService implements IThongKeService {

    private ThongKeRepository thong_Ke_rep;

    public ThongKeService() {
        this.thong_Ke_rep = new ThongKeRepository();

    }

    @Override
    public ArrayList<ThongKe> getList() {
        return thong_Ke_rep.getList();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThongKe> timkiem(Date ngaya, Date ngayb) {
        return thong_Ke_rep.timkiemm(ngaya, ngayb);// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThongKe> ngay() {
        return thong_Ke_rep.sanphambanchay();//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThongKe> timkiemsanpham(Date ngaya, Date ngayb) {
        return thong_Ke_rep.timsanphambanchay(ngaya, ngayb);//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThongKe> getList2() {
        return thong_Ke_rep.getList2();
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
