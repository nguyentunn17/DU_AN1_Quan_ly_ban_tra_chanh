package domainmodels;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import services.impl.ThongKeService;

public class QuanLyThongKe {

    private ThongKeService thongKe_sv = null;

    public QuanLyThongKe() {
        thongKe_sv = new ThongKeService();
    }

    public void bieudotron(JPanel jPanel) {
        ArrayList<ThongKe> thongKe = thongKe_sv.ngay();
        if (thongKe != null) {
            DefaultPieDataset dataset = new DefaultPieDataset();
            for (ThongKe ke : thongKe) {
                dataset.setValue(ke.getTiensanpham(), ke.getSoluongban());

            }
            JFreeChart chart = ChartFactory.createPieChart(
                    "SẢN PHẨM ", dataset, true, true, true);

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jPanel.getWidth(), 500));
            jPanel.removeAll();
            jPanel.setLayout(new CardLayout());
            jPanel.add(chartPanel);
            jPanel.validate();
            jPanel.repaint();

        }

    }

    public void bieudotron(Date ngaya, Date ngayb, JPanel jPanel) {
        ArrayList<ThongKe> thongKe = thongKe_sv.timkiemsanpham(ngaya, ngayb);
        if (thongKe != null) {
            DefaultPieDataset dataset = new DefaultPieDataset();
            for (ThongKe ke : thongKe) {
                dataset.setValue(ke.getTiensanpham(), ke.getSoluongban());
            }
            JFreeChart chart = ChartFactory.createPieChart(
                    "SẢN PHẨM ", dataset, true, true, true);

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jPanel.getWidth(), 500));
            jPanel.removeAll();
            jPanel.setLayout(new CardLayout());
            jPanel.add(chartPanel);
            jPanel.validate();
            jPanel.repaint();

        }

    }

    public void setDateToChartl(JPanel jPanel) {
        ArrayList<ThongKe> thongke = thongKe_sv.getList2();
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

}
