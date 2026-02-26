package main.java.br.worldMapChart;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import main.java.br.worldMapChart.chart.IWorldMapEngine;
import main.java.br.worldMapChart.chart.imp.WorldMapEngine;
import main.java.br.worldMapChart.dto.WorldMapChartDataset;

public class WorldMapChartApplication {

	private final IWorldMapEngine worldMapEngine = new WorldMapEngine();
	
	
	/**
	 * Chama o engine para criação do gráfico.
	 *
	 * @return File mapa-múndi carregado a partir dos recursos da
	 *         aplicação.
	 * 
	 */
	public File getImageChart(List<WorldMapChartDataset> countries, Font font, Color colorlegend) {
		try {
			return worldMapEngine.createWorldMapChart(countries,font,colorlegend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
