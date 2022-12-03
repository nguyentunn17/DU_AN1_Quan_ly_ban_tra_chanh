/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public interface IChucVuSevrice {

    ArrayList<ChucVu> listAll();

    void insert(ChucVu cv);

    void update(ChucVu cv, String ma);

    void delete(String ma);

}
