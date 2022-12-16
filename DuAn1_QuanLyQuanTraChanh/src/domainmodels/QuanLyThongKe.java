package domainmodels;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import services.impl.ThongKeService;

public class QuanLyThongKe {

    private ThongKeService thongKe_sv = null;

    public QuanLyThongKe() {
        thongKe_sv = new ThongKeService();
    }

    public void setDateToChartl(JPanel jPanel) {
        ArrayList<ThongKe> thongke = thongKe_sv.getList();
        if (thongke != null) {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            for (ThongKe ke : thongke) {
                categoryDataset.addValue(ke.getTongtien(),"Tổng tiền" , ke.getNgayThanhToan());
            }
            JFreeChart chart = ChartFactory.createBarChart("DOANH THU (VND)", "Ngay Thanh Toan", "Gia Tien", categoryDataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jPanel.getWidth(), 500));
            jPanel.removeAll();
            jPanel.setLayout(new CardLayout());
            jPanel.add(chartPanel);
            jPanel.validate();
            jPanel.repaint();
        }
    }

    public void setDateToo(Date ngaya, Date ngayb, JPanel jPanel) {
        ArrayList<ThongKe> thongke = thongKe_sv.timkiem(ngaya, ngayb);
        if (thongke != null) {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            for (ThongKe ke : thongke) {
                categoryDataset.addValue(ke.getTongtien(), "Tong Tien", ke.getNgayThanhToan());
            }
            JFreeChart chart = ChartFactory.createBarChart("DOANH THU (VND)", "Ngay Thanh Toan", "Gia Tien", categoryDataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jPanel.getWidth(), 500));
            jPanel.removeAll();
            jPanel.setLayout(new CardLayout());
            jPanel.add(chartPanel);
            jPanel.validate();
            jPanel.repaint();
        }
    }

    public void setDate(Date ngay, JPanel jPanel) {
        ArrayList<ThongKe> thongke = thongKe_sv.timkiem(ngay);
        if (thongke != null) {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            for (ThongKe ke : thongke) {
                categoryDataset.addValue(ke.getTongtien(), "Tong Tien", ke.getNgayThanhToan());
            }
            JFreeChart chart = ChartFactory.createBarChart("DOANH THU (VND)", "Ngay Thanh Toan", "Gia Tien", categoryDataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jPanel.getWidth(), 500));
            jPanel.removeAll();
            jPanel.setLayout(new CardLayout());
            jPanel.add(chartPanel);
            jPanel.validate();
            jPanel.repaint();

        }
    }
}
