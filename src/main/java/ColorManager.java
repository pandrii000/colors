package src.main.java;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorManager
{
    /**
     * Return merged color of color1 and color2.
     * Merged color is RGBA color which parameters is an average parameters of RGBA representations of color1 and color2. 
     * @param color1 first color.
     * @param color2 second color.
     * @return new ColorRGBA instance, converted to Color.
     */
    public static ColorRGBA MergeColors(Color color1, Color color2) {
        ColorRGBA rgb1 = (ColorRGBA) color1.ToRGBA();
        ColorRGBA rgb2 = (ColorRGBA) color2.ToRGBA();
        return new ColorRGBA(
            (rgb1.r + rgb2.r) / 2,
            (rgb1.g + rgb2.g) / 2,
            (rgb1.b + rgb2.b) / 2,
            (rgb1.a + rgb2.a) / 2);
    }

    /**
     * Return union color of color1 and color2.
     * Union color is RGBA color that hex representation is a result of a bit union operation applied to hex-color1 and hex-color2.
     * @param color1 first color.
     * @param color2 second color.
     * @return new ColorRGBA instance, converted to Color.
     */
    public static ColorRGBA UnionColors(Color color1, Color color2) {
        return new ColorRGBA(color1.valueInt() | color2.valueInt());
    }

    /**
     * Return intersect color of color1 and color2.
     * Intersect color is RGBA color that hex representation is a result of a bit intersect operation applied to hex-color1 and hex-color2.
     * @param color1 first color.
     * @param color2 second color.
     * @return new ColorRGBA instance, converted to Color.
     */
    public static ColorRGBA IntersectColors(Color color1, Color color2) {
        return new ColorRGBA(color1.valueInt() & color2.valueInt());
    }

    /**
     * Return xor color of color1 and color2.
     * Xor color is RGBA color that hex representation is a result of a bit xor operation applied to hex-color1 and hex-color2.
     * @param color1 first color.
     * @param color2 second color.
     * @return new ColorRGBA instance, converted to Color.
     */
    public static ColorRGBA XORColors(Color color1, Color color2) {
        return new ColorRGBA(color1.valueInt() ^ color2.valueInt());
    }

    /**
     * Create file which path is filename.
     * Write to file array of colors in string representations.
     * @param filename path to file.
     * @param colors array of colors.
     */
    public static void WriteColorsIntoFile(String filename, Color[] colors)
    {
        try {
            FileWriter fw = new FileWriter(filename);
            Iterator<Color> iterator = Arrays.stream(colors).iterator();
            while (iterator.hasNext()){
                fw.write(String.format("%d", iterator.next().valueInt()));
                fw.write("\n");
            }
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Successfully wrote colors!");
    }

    /**
     * Read colors from textfile which path is filename.
     * Colors are in hex-representations.
     * Then print it all.
     * @param filename path to file.
     */
    public static void ReadColorsFromFile(String filename) {
        try { 
            FileReader fr = new FileReader(filename);
            Scanner reader = new Scanner(fr);
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                int hex = Integer.parseInt(s);
                ColorRGBA color = new ColorRGBA(hex);
                System.out.printf("%s: %s HEX=%h\n", s, color, hex);
            }
            reader.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Draw color using JFrame.
     * @param color color to draw.
     */
    public static void DrawColor(Color color) {
        int width = 400, height = 400;
        JFrame frame = new JFrame("Color");
        JLabel label = new JLabel(color.toString(), 0);
        frame.add(label);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(color.valueInt()));
        frame.setVisible(true);
    }
}