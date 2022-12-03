/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.MucDuong;
import java.util.ArrayList;

/**
 *
 * @author Inspiron
 */
public interface IMucDuongService {
        ArrayList<MucDuong> getList();
        public void insert(MucDuong mucDuong);
        public void delete(String id);
        public void update(String id,MucDuong mucDuong);
                
    
}
