package repositories.impl;

import domainmodels.Ban;
import domainmodels.HoaDonChiTiet;
import domainmodels.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IBanHangRepository;
import utilities.jdbcUtil;
import viewmodels.HoaDonChiTietViewModel;

public class BanHangRepository implements IBanHangRepository {

    @Override
    public ArrayList<HoaDonChiTietViewModel> loadSp(String mahd) {
        ArrayList<HoaDonChiTietViewModel> listsp = new ArrayList<>();
        Connection conn;
        try {
            conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT MaSP,TenSP,SoLuongTon,GiaBan,ThanhTien FROM SANPHAM 
                         INNER JOIN HOADONCHITIET ON SANPHAM.ID=HOADONCHITIET.IdSP 
                         INNER JOIN HOADON ON HOADONCHITIET.IdHD=HOADON.Id
                         WHERE MaHD=? """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                String ma = rs.getString("masp");
                String ten = rs.getString("tensp");
                Double giaBan = rs.getDouble("giaBan");
                Integer soLuongTon = rs.getInt("soLuongTon");
                Double thanhTien=rs.getDouble("ThanhTien");

               HoaDonChiTietViewModel hoaDonChiTietViewModel=
                       new HoaDonChiTietViewModel(ma, ten, giaBan, soLuongTon, thanhTien);
                listsp.add(hoaDonChiTietViewModel);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

}
