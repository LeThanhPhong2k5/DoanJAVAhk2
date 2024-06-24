package chart;

import java.awt.BorderLayout;  
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.view.Dashboard;
import ite.computer_management.view.DashboardForManager;

import javax.swing.JLabel;

import java.awt.Panel;

public class Columnchart extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private Dashboard dashboard;
	private DashboardForManager dashboardForManager;
	 public Columnchart(Dashboard dashboard) {
	        this.dashboard = dashboard;
	        init();
	    }

	    public Columnchart(DashboardForManager dashboardForManager) {
	    	this.dashboardForManager = dashboardForManager;
	    	init();
	}

		public void init() {
	        setLayout(null); 

	        createPieChartFromDatabase1();
	        createPieChartFromDatabase2();
	        createColumnChartFromDatabase();
	    }

	    private void createColumnChartFromDatabase() {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    	  try (Connection conn = ConnectDatabase.getConnection()) {
    	        String query = "SELECT category, SUM(total_Amount) AS total_value " +
    	                       "FROM ( " +
    	                       "    SELECT 'import_coupon' AS category, total_Amount FROM import_coupon " +
    	                       "    UNION ALL " +
    	                       "    SELECT 'exports_coupon' AS category, total_Amount FROM exports_coupon " +
    	                       ") AS combined_data " +
    	                       "GROUP BY category";  

    	        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
    	            while (rs.next()) {
    	                String category = rs.getString("category");
    	                double totalValue = rs.getDouble("total_value"); 
    	                dataset.addValue(totalValue, category, "total amount"); 
    	            }
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        JOptionPane.showMessageDialog(this, "fail" + e.getMessage()); 
    	    }

        JFreeChart barChart = ChartFactory.createBarChart(
            "Total amount column chart (Import, Export, Computer)",
            "Import   Export",
            "total amount",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setBounds(0, 0, 613, 753);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        add(chartPanel);
       
	}
	    private void createPieChartFromDatabase2() {
    	int importCount = 0; 
        int exportCount = 0;
        int productCount =0;
        try (Connection connection = ConnectDatabase.getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet importResult = statement.executeQuery("SELECT COUNT(*) FROM import_coupon")) {
                if (importResult.next()) {
                    importCount = importResult.getInt(1);
                }
            }
            try (ResultSet exportResult = statement.executeQuery("SELECT COUNT(*) FROM exports_coupon")) {
                if (exportResult.next()) {
                    exportCount = exportResult.getInt(1);
                }
            }
            try (ResultSet product = statement.executeQuery("SELECT COUNT(*) FROM computer")) {
            	if(product.next()) {
            		productCount = product.getInt(1);
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "fail");
        }

            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Import coupon", importCount);
            dataset.setValue("Export coupon", exportCount);
            dataset.setValue("Computer", productCount);
            JFreeChart chart = ChartFactory.createPieChart("Statistical import, export coupon and computer", dataset);
            PiePlot piePlot = (PiePlot) chart.getPlot();
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
            	    "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));


            	piePlot.setLabelGenerator(labelGenerator);
            	ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setBounds(613, 0, 613, 376); 
                chartPanel.setPreferredSize(new Dimension(500, 300));
                add(chartPanel); 
	}

	    private void createPieChartFromDatabase1() {
    	int importCount = 0; 
        int exportCount = 0;

        try (Connection connection = ConnectDatabase.getConnection()) {
            Statement statement = connection.createStatement();

            // Truy vấn và lấy giá trị trước khi đóng kết nối
            try (ResultSet importResult = statement.executeQuery("SELECT COUNT(*) FROM import_coupon")) {
                if (importResult.next()) {
                    importCount = importResult.getInt(1);
                }
            }
            try (ResultSet exportResult = statement.executeQuery("SELECT COUNT(*) FROM exports_coupon")) {
                if (exportResult.next()) {
                    exportCount = exportResult.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "fail");
        }

            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Import coupon", importCount);
            dataset.setValue("Export coupon", exportCount);

            JFreeChart chart = ChartFactory.createPieChart("Statistical import and export coupon", dataset, true, true, false);
            PiePlot piePlot = (PiePlot) chart.getPlot();
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
            	    "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));

 
            	piePlot.setLabelGenerator(labelGenerator);
 
            	ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setBounds(613, 386, 613, 376);
                chartPanel.setPreferredSize(new Dimension(500, 300));
                add(chartPanel); 

    }
}
