/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：JFreeChartTest2.java
 * 内容摘要：JFreeChartTest2.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年8月12日 下午1:16:30
 * 修改记录：
 * 修改日期：2016年8月12日 下午1:16:30
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.test.acticon;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * @filename 文件名称：JFreeChartTest2.java
 * @contents 内容摘要：
 */
public class JFreeChartTest2 extends ApplicationFrame {
	public JFreeChartTest2(String title) {
		super(title);

		this.setContentPane(createPanel());
	}

	public static CategoryDataset getDataset() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(22, "外联", "外联部");
		dataset.setValue(25, "宣传", "宣传部");
		dataset.setValue(12, "财务", "财务部");
		dataset.setValue(33, "技术", "技术部");

		return dataset;
	}

	public static JFreeChart getChart(CategoryDataset dataset) {
		// 此标题 ‘某社团各部门 ’将被后面的chart.setTitle的标题 ‘某社团各部门柱状图’ 覆盖
		JFreeChart chart = ChartFactory.createBarChart("某社团各部门", "部门名称",
				"人员数量", dataset, PlotOrientation.VERTICAL, true, true, false);

		// 设置柱状图 主标题的文字
		chart.setTitle(new TextTitle("某社团各部门柱状图", new Font("宋 体", Font.BOLD
				+ Font.ITALIC, 20)));

		// 设置柱状图最下方说明的文字
		chart.getLegend().setItemFont(new Font("微软雅黑", Font.BOLD, 12));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		CategoryAxis axis = plot.getDomainAxis();
		// 设置X轴坐标上标题的文字
		axis.setLabelFont(new Font("微软雅黑", Font.BOLD, 22));
		// 设置X轴坐标上的文字，
		axis.setTickLabelFont(new Font("微软雅黑", Font.BOLD, 12));

		ValueAxis valueAxis = plot.getRangeAxis();
		// 设置Y轴坐标上标题的文字
		valueAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 12));
		// 设置Y轴坐标上的文字
		valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));

		return chart;
	}

	public static JPanel createPanel() {
		JFreeChart chart = getChart(getDataset());

		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		JFreeChartTest2 chartFrame = new JFreeChartTest2("某社团各部门分布图");
		chartFrame.pack();
		chartFrame.setVisible(true);
	}
}
