package main.java.br.worldMapChart.useful;

public class ColorUtils {

	public static String rgbToHex(String rgb) {
		String[] parts = rgb.split(",");

		Integer r = Integer.parseInt(parts[0]);
		Integer g = Integer.parseInt(parts[1]);
		Integer b = Integer.parseInt(parts[2]);

		return String.format("#%02x%02x%02x", r, g, b); 
	}
}
