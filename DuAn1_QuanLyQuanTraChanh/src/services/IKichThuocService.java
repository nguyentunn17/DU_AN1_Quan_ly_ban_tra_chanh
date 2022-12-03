/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.KichThuoc;
import java.util.ArrayList;

/**
 *
 * @author Inspiron
 */
public interface IKichThuocService {
        ArrayList<KichThuoc> getList();
        public void insert(KichThuoc kichThuoc);
        public void delete(String id);
        public void update(String id,KichThuoc kichThuoc);
                
    
}
