package library;

import library.enumerations.ChartType;
import library.enumerations.ReportType;

public class GlobalChart 
{
	private ChartType chartType;
	private static GlobalChart globalChart;
	private ReportType report;

	private GlobalChart()
	{
		
	}
	
	public static GlobalChart getInstance()
	{
		if(globalChart == null)
		{
			globalChart = new GlobalChart();
		}
		return globalChart;
	}

	public ChartType getChartType() {
		return chartType;
	}

	public void setChartType(ChartType chartType) {
		this.chartType = chartType;
	}

	public ReportType getReport() {
		return report;
	}

	public void setReport(ReportType report) {
		this.report = report;
	}
}