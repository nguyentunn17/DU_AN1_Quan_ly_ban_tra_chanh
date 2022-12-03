/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.MucDa;
import java.util.ArrayList;

/**
 *
 * @author Inspiron
 */
public interface IMucDaService {
        ArrayList<MucDa> getList();
        public void insert(MucDa mucDa);
        public void delete(String id);
        public void update(String id,MucDa mucDa);
                
    
}
