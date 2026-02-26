package main.java.br.worldMapChart.chart.imp;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import main.java.br.worldMapChart.chart.IWorldMapEngine;
import main.java.br.worldMapChart.dto.WorldMapChartDataset;
import main.java.br.worldMapChart.mapper.LegendMapper;
import main.java.br.worldMapChart.useful.ColorUtils;
import main.java.br.worldMapChart.useful.GenerateFile;
import main.java.br.worldMapChart.useful.ImageUtils;

import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public class WorldMapEngine implements IWorldMapEngine {

	private static final String pathSvg = "svg/world.svg";
	private static final String ImageName = "worldMapChart";
	private static final String formatImage = ".png";
	private Element country;
	private String countryRgb;

	/**
	 * Carrega o arquivo SVG do mapa-múndi localizado em
	 * {@code resources/svg/world.svg} e o retorna como um objeto
	 * {@link SVGDocument}.
	 * <p>
	 * O método utiliza a fábrica {@link SAXSVGDocumentFactory} da biblioteca Apache
	 * Batik para interpretar o SVG e gerar a representação DOM do documento.
	 * </p>
	 *
	 * @return o documento SVG do mapa-múndi carregado a partir dos recursos da
	 *         aplicação.
	 * 
	 * @throws Exception se ocorrer algum erro ao localizar ou ler o arquivo SVG.
	 */
	private SVGDocument getImageEarth() throws Exception {
		return new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName()).createSVGDocument(getClass().getClassLoader().getResource(pathSvg).toURI().toString());
	}

	/**
	 * Altera a cor de preenchimento ("fill") dos países em um documento SVG de
	 * acordo com a lista de identificadores fornecida.
	 * <p>
	 * Cada elemento da lista {@code countries} deve conter o identificador do país
	 * (atributo {@code id} do elemento <path> no SVG). Para cada país encontrado, o
	 * atributo {@code fill} será definido como {@code #4dff88}.
	 * </p>
	 * <p>
	 * Caso algum identificador não seja encontrado no documento SVG, uma mensagem
	 * de aviso será exibida no console.
	 * </p>
	 *
	 * @param countries   lista contendo os identificadores dos países cujas cores
	 *                    devem ser alteradas.
	 * @param svgDocument documento SVG no qual as cores serão modificadas.
	 */
	private void changeColorCountries(List<WorldMapChartDataset> countries, SVGDocument svgDocument) {
		for (WorldMapChartDataset countryName : countries) {
			
			//Brasil
			if(countryName.getId() == 1) {
				countryRgb = ColorUtils.rgbToHex(countryName.getRgb());
				country = svgDocument.getElementById("brazil");
				country.setAttribute("fill", countryRgb);
			}
			
			//Estados Unidos
			if(countryName.getId() == 2) {
				countryRgb = ColorUtils.rgbToHex(countryName.getRgb());
				country = svgDocument.getElementById("usa");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("alaska-westcopy");
				country.setAttribute("fill", countryRgb);
			}
			
			//Europa
			if(countryName.getId() == 3) {
				countryRgb = ColorUtils.rgbToHex(countryName.getRgb());
				country = svgDocument.getElementById("albania");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("austria"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("belarus"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("belgium"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bosnia"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bulgaria"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("croatia"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("czech");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("denmark"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("estonia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("finland");	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("france");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("germany"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("greece"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("hungary"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("iceland"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("ireland");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("italy"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("lithuania"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("malta");	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("moldova");	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("montenegro"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("netherlands"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("macedonia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("norway");	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("poland"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("portugal"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("romania"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("serbia"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("slovakia"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("slovenia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("spain"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sweden"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("switzerland"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("ukraine"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("britain"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("ulster"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("path302"); 
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sicily");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("majorca");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sardinia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("crete");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("cyprus");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("corsica");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("saaremaa");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("hiumaa");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sjælland");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("thrace");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("gotland");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("novaya zemlya south");
				country.setAttribute("fill", countryRgb);
			}
			
			//Asia
			if(countryName.getId() == 4) {
				countryRgb = ColorUtils.rgbToHex(countryName.getRgb());
				country = svgDocument.getElementById("india");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("china");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("pakistan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bangladesh");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("nepal");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bhutan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("vietnam");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("south korea");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("north korea");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("russia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("turkey"); 	
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("taiwan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("iran");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("laos");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("cambodia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("malaysia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("thailand");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("burma");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("afghanistan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("kirgizstan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("tajikistan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("uzbekistan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("turkmenistan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("kazakhstan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("mongolia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("azerbaijan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("honshu");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("hokkaido");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("hokkaido");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("iturup");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("urup");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("paramushir");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("onekotan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sakhalin");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sri lanka");
				country.setAttribute("fill", countryRgb);	
				country = svgDocument.getElementById("sumatra");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("hainan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("kyushu");
				country.setAttribute("fill", countryRgb);			
				country = svgDocument.getElementById("shikoku");
				country.setAttribute("fill", countryRgb);	
				country = svgDocument.getElementById("luzon");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sumatra");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("kotelny");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("october");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("kalimantan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("georgia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("armenia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("novaya sibir");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("lyakhovsky");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("wrangel");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bolshevik");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("komsomolets");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("east malaysia");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("brunei");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("java");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("palawan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("irian jaya");
				country.setAttribute("fill", countryRgb);	
				country = svgDocument.getElementById("sulawesi");
				country.setAttribute("fill", countryRgb);	
				country = svgDocument.getElementById("path7462");
				country.setAttribute("fill", countryRgb);	
				country = svgDocument.getElementById("maluku");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("seram");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("timor");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("flores");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("sumba");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("lombok");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bali");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("samar");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("cebu");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("negros");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("mindoro");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("male");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("maldive");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("gan");
				country.setAttribute("fill", countryRgb);
				country = svgDocument.getElementById("bering island");
				country.setAttribute("fill", countryRgb);
			}
			
			//Gra-Bretanha
			if(countryName.getId() == 5) {
				countryRgb = ColorUtils.rgbToHex(countryName.getRgb());
				country = svgDocument.getElementById("britain"); 
				country.setAttribute("fill", countryRgb);
			}
			
			//country = svgDocument.getElementById(countryName.getCountry());
			//if (country != null) country.setAttribute("fill", ColorUtils.rgbToHex(countryName.getRgb()));
			//else System.out.println("[WorldMapArea] ⚠️ País não encontrado: " + countryName);
		}
	}
	
	/**
	 * Converte um {@link SVGDocument} em um fluxo de bytes PNG.
	 * <p>
	 * Este método usa o {@link org.apache.batik.transcoder.image.PNGTranscoder} 
	 * para transcodificar o SVG em PNG em memória, retornando um {@link InputStream} 
	 * que pode ser usado para salvar em arquivo ou processar diretamente.
	 * </p>
	 *
	 * @param svgDocument o documento SVG que será convertido em PNG; não pode ser {@code null}
	 * @return um {@link InputStream} contendo os bytes do PNG gerado
	 * @throws Exception se ocorrer algum erro durante a transcodificação do SVG para PNG
	 *
	 */
	private InputStream svgToPng(SVGDocument svgDocument) throws Exception {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();

	    new PNGTranscoder().transcode(new TranscoderInput(svgDocument), new TranscoderOutput(baos));

	    return new ByteArrayInputStream(baos.toByteArray());
	}

	public File createWorldMapChart(List<WorldMapChartDataset> countries, Font font, Color colorlegend) throws Exception {
		SVGDocument svgDocument = getImageEarth();
		
		changeColorCountries(countries, svgDocument);
			
		return GenerateFile.getFile(ImageUtils.addLegend(svgToPng(svgDocument), LegendMapper.generateLegend(countries),font, colorlegend,formatImage), ImageName, formatImage);
	}
	
}