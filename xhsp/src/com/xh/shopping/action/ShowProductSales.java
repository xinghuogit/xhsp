package com.xh.shopping.action;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.xh.shopping.manage.ProductMgr;
import com.xh.shopping.model.Product;

/**
 * Servlet implementation class ShowProductSales
 */
@WebServlet("/ShowProductSales")
public class ShowProductSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset datasetBar = new DefaultCategoryDataset();
	private DefaultPieDataset datasetPie = new DefaultPieDataset();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getdataset();
		getChart();
		this.getServletContext()
				.getRequestDispatcher("/admin/showproductsales.jsp")
				.forward(request, response);
	}

	private void getChart() {
		JFreeChart chartbar = ChartFactory.createBarChart("商品交易图",// 标题
				"商品",// x轴
				"产量",// y轴
				datasetBar,// 数据
				PlotOrientation.VERTICAL,// 定位，VERTICAL：垂直
				true,// 是否显示图例注释(对于简单的柱状图必须是false)
				false,// 是否生成工具//没用过
				false);// 是否生成URL链接//没用过

		JFreeChart createPie3D = ChartFactory.createPieChart3D("商品交易图",
				datasetPie, true, true, true);

		setFont1(chartbar);// 设置字体以及百分比
		setFont(createPie3D);// 设置字体以及百分比

		FileOutputStream fosbar_jpg = null;
		FileOutputStream fospie_jpg = null;
		try {
			fosbar_jpg = new FileOutputStream(
					"E:\\git\\J2EE\\xhsps\\xhsp\\WebContent\\image\\chart\\fosbar_jpg.jpg");
			ChartUtilities.writeChartAsJPEG(fosbar_jpg, 1.0f, chartbar, 800,
					400, null);

			fospie_jpg = new FileOutputStream(
					"E:\\git\\J2EE\\xhsps\\xhsp\\WebContent\\image\\chart\\fospie_jpg.jpg");
			ChartUtilities.writeChartAsJPEG(fospie_jpg, 1.0f, createPie3D, 800,
					400, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fosbar_jpg.close();
				fospie_jpg.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取数据
	 * 
	 * @return
	 */
	private void getdataset() {
		List<Product> productsSum = ProductMgr.getInstance()
				.getSalesProductsSum();
		for (int i = 0; i < productsSum.size(); i++) {
			/**
			 * @double value, 值
			 * @Comparable rowKey, 列
			 * @Comparable columnKey 比较
			 */
			String name = productsSum.get(i).getName();
			if (name.length() > 4) {
				name = name.substring(0, 4);
			}
			datasetBar.addValue(productsSum.get(i).getSum(), "", name);
			datasetPie.setValue(name, productsSum.get(i).getSum());
		}
	}

	/**
	 * 设置字体以及百分比
	 * 
	 * @param chart
	 */
	private void setFont(JFreeChart chart) {
		Font titleFont = new Font("黑体", Font.BOLD, 20);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(titleFont);// 为标题设置上字体

		Font LegendFont = new Font("楷体", Font.PLAIN, 18);
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(LegendFont);// 为图例说明设置字体

		Font plotFont = new Font("宋体", Font.PLAIN, 16);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(plotFont); // 为饼图元素设置上字体

		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}",
				NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));// 显示百分比
	}

	private void setFont1(JFreeChart chart) {
		Font titleFont = new Font("黑体", Font.BOLD, 20);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(titleFont);// 为标题设置上字体

		// 得到一个参考
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 生成图片的背景色
		plot.setBackgroundPaint(Color.white);
		// 行线的颜色
		plot.setRangeGridlinePaint(Color.BLACK);
		// 刻度字体
		plot.getDomainAxis().setTickLabelFont(titleFont);
		// X轴名称字体
		plot.getDomainAxis().setLabelFont(titleFont);

		ValueAxis valueAxis = plot.getRangeAxis();
		// 设置Y轴坐标上标题的文字
		valueAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 12));
		// 设置Y轴坐标上的文字
		valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));
	}

}
