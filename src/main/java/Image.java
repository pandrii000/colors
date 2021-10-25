package src.main.java;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Image
{
    int n, m;
    Color[][] M;

    public Image(Color[][] colors) {
        this.n = colors.length;
        this.m = colors[0].length;
        this.M = colors;
    }

    public Image(String pathToPicture) {
        BufferedImage img = null;
        try {
            File imgFile = new File(pathToPicture);
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
              e.printStackTrace();
        }

        this.n = img.getHeight();
        this.m = img.getWidth();
        this.M = new Color[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                M[i][j] = new ColorRGBA(img.getRGB(j, i));
            }
        }
    }

    /**
     * Create picture file with path "pathToPicture", with format "format"
     * format can be jpg, png or gif
     * @param pathToPicture path to the created file
     * @param format format of picture
     */
    public void WriteToFile(String pathToPicture, String format) {
        BufferedImage img = new BufferedImage(m, n, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                img.setRGB(j, i, M[i][j].valueInt());
            }
        }
        try {
            File outputFile = new File(pathToPicture);
            ImageIO.write(img, format, outputFile);
        } catch (IOException e) {
              e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%s ", M[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
}