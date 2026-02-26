package main.java.br.worldMapChart.mapper;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import main.java.br.worldMapChart.dto.WorldMapChartDataset;

public class LegendMapper {

	public static List<String> generateLegend(List<WorldMapChartDataset> countries) {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		return countries.stream().map(c -> c.getCountry().concat(" ").concat(decimalFormat.format(c.getPercent())).concat("%")).collect(Collectors.toList()); 
	}
}

