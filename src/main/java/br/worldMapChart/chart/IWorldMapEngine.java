package main.java.br.worldMapChart.chart;

import main.java.br.worldMapChart.dto.WorldMapChartDataset;

import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

public interface IWorldMapEngine {

	File createWorldMapChart(List<WorldMapChartDataset> countries, Font font, Color colorlegend) throws Exception;
	
}