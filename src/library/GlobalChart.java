package library;

import library.enumerations.ChartType;

public class GlobalChart 
{
	private ChartType chartType;
	private static GlobalChart globalChart;

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
}