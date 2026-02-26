package main.java.br.worldMapChart.dto;

import java.math.BigDecimal;

public class WorldMapChartDataset {
	
	private Integer id;
	private String country;
	private BigDecimal value;
	private BigDecimal percent;
	private String rgb;

	public WorldMapChartDataset() {
		
	}
	
	public WorldMapChartDataset(Integer id, String country, BigDecimal value, BigDecimal percent, String rgb) {
		this.id = id;
		this.country = country;
		this.value = value;
		this.percent = percent;
		this.rgb = rgb;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public String getRgb() {
		return rgb;
	}

	public void setRgb(String rgb) {
		this.rgb = rgb;
	}
	
}
