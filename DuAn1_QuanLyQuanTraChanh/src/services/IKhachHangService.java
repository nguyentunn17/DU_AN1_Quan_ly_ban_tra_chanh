/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public interface IKhachHangService {

    ArrayList<KhachHang> getAll();

    void isnert(KhachHang kh);

    void update(String id, KhachHang kh);

    void delete(String id);

    boolean checkTrung(String maKH);
}
