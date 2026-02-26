package main.java.br.worldMapChart.useful;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageUtils {
	
    public static InputStream addLegend(InputStream inputStream, List<String> legendas, Font font, Color colorlegend, String formatImage) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);

        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(font);

        Integer padding = 20;
        Integer lineSpacing = 5; // espaço entre linhas
        Integer textWidth;
        Integer textHeight;
        Integer x;
        Integer y;
        String linha;
        

        // Calcula a altura total da legenda
        FontMetrics fm = g.getFontMetrics();
        int totalHeight = legendas.size() * fm.getHeight() + (legendas.size() - 1) * lineSpacing;

        // Desenha cada linha de legenda
        for (int i = 0; i < legendas.size(); i++) {
            linha = legendas.get(i);
            textWidth = fm.stringWidth(linha);
            textHeight = fm.getHeight();

            x = padding;
            y = image.getHeight() - padding - (totalHeight - i * (textHeight + lineSpacing));

            // Fundo semi-transparente por linha
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
            g.setColor(Color.WHITE);
            g.fillRoundRect(x - 10, y - textHeight, textWidth + 20, textHeight + 10, 10, 10);

            // Texto
            g.setComposite(AlphaComposite.SrcOver);
            g.setColor(colorlegend);
            g.drawString(linha, x, y);
        }

        g.dispose();

        // Retorna como InputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, formatImage.replace(".", ""), baos);
        return new ByteArrayInputStream(baos.toByteArray());
    }

}
