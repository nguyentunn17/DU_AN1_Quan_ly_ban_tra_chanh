/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.Ban;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface IBanService {

    ArrayList<Ban> getlist();

    String insert(Ban b);

    String Update(String id, Ban b);

    String delete(String id);

    ArrayList<Ban> getTenBan(String ten);

    boolean checkTrung(String ma);
    
}
