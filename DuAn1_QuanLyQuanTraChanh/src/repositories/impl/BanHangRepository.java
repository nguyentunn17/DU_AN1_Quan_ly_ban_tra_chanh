package repositories.impl;

import domainmodels.Ban;
import domainmodels.SanPham;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IBanHangRepository;
import utilities.jdbcUtil;
import viewmodels.SanPhamViewModel;

public class BanHangRepository implements IBanHangRepository {

    @Override
    public ArrayList<SanPhamViewModel> loadSp(String mahd) {
        ArrayList<SanPhamViewModel> listsp = new ArrayList<>();
        Connection conn;
        try {
            conn = jdbcUtil.getConnection();
            String sql = """
                         SELECT MaSP,TenSP,SoLuongTon,GiaBan FROM SANPHAM 
                         INNER JOIN HOADONCHITIET ON SANPHAM.ID=HOADONCHITIET.IdSP 
                         INNER JOIN HOADON ON HOADONCHITIET.IdHD=HOADON.Id
                         WHERE MaHD=? """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                Integer soluong = rs.getInt("SoLuongTon");
                Double giaBan = rs.getDouble("GiaBan");

                BigDecimal bigDecimalgiaban = new BigDecimal(giaBan);
                SanPhamViewModel spvm = new SanPhamViewModel(masp, tensp, bigDecimalgiaban, soluong);
                listsp.add(spvm);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

}
