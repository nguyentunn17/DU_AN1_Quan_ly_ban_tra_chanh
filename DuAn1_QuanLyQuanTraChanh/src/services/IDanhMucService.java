/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public interface IDanhMucService {

    ArrayList<DanhMuc> read();

    void create(DanhMuc dm);

    void update(DanhMuc dm, String id);

    void delete(String id);
}
