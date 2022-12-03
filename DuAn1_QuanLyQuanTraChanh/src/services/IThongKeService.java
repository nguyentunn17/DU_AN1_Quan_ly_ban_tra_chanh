/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ThongKe;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Inspiron
 */
public interface IThongKeService {
    public ArrayList<ThongKe> getList();
    public ArrayList<ThongKe> timkiem(Date ngayThanhToan);
  
    
}
