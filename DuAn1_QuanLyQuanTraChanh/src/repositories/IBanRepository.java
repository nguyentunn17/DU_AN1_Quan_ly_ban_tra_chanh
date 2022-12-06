/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainmodels.Ban;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface IBanRepository {

    ArrayList<Ban> getAll();

    boolean insert(Ban b);

    boolean Update(String id, Ban b);

    boolean delete(String id);
    
    ArrayList<Ban> getTenBan(String ten);
}
