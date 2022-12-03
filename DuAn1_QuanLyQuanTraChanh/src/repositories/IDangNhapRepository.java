/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import viewmodels.NhanVienViewModel;

/**
 *
 * @author Hung
 */
public interface IDangNhapRepository {
    NhanVienViewModel login(String taiKhoan, String matKhau);
}
