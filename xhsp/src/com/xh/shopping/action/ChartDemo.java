package com.xh.shopping.action;

import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.xh.shopping.util.JFreeChartUtil;

/**
 * Servlet implementation class ChartDemo
 */
@WebServlet("/ChartDemo")
public class ChartDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("image/jpeg");// 将输出设置为image/jepg格式
		// JFreeChart chart = null;
		// JFreeChartUtil.getInstance().getPie(chart);
		//
		// ChartUtilities.writeChartAsJPEG(resp.getOutputStream(), 1.0f, chart,
		// 800, 450, null);// 输出图表

		JFreeChart chart2 = null;
		JFreeChartUtil.getInstance().geti(chart2);
		FileOutputStream fos = new FileOutputStream("F:\\fff.jpg");
		ChartUtilities.writeChartAsJPEG(fos, 100, chart2, 800, 450, null);// 输出图表

	}

}
