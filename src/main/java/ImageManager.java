package src.main.java;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

public class ImageManager
{
    /**
     * Change the image using a mask.
     * While moving in the image with increments (stepX, stepY) in a coordinate manner, 
     * uses operation as scalar operation for each pair of overlapping submatrices.
     * @param image image.
     * @param mask  mask.
     * @param operation operation (can be merge, union, intersect or xor).
     * @param stepX increment by x coordinate.
     * @param stepY increment by y coordinate.
     */
    public static void Filter(Image image, Mask mask, String operation, int stepX, int stepY) 
    {
        int dn = image.n - mask.n;  
        int dm = image.m - mask.m;

        if (dn < 0 || dm < 0) {
            throw new IllegalArgumentException("Size of image can not be lower than size of mask.");
        }

        for (int i = 0; i <= dn; i += stepX) {
            for (int j = 0; j <= dm; j += stepY) {
                for (int k = 0; k < mask.n; k++) {
                    for (int l = 0; l < mask.m; l++) {
                        switch (operation) {
                            case "merge":
                                image.M[i + k][j + l] = ColorManager.MergeColors(image.M[i + k][j + l], new ColorRGBA(mask.M[k][l]));
                                break;
                            case "union":
                                image.M[i + k][j + l] = ColorManager.UnionColors(image.M[i + k][j + l], new ColorRGBA(mask.M[k][l]));
                                break;
                            case "intersect":
                                image.M[i + k][j + l] = ColorManager.IntersectColors(image.M[i + k][j + l], new ColorRGBA(mask.M[k][l]));
                                break;
                            case "xor":
                                image.M[i + k][j + l] = ColorManager.XORColors(image.M[i + k][j + l], new ColorRGBA(mask.M[k][l]));
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid value of operation.");
                        }
                    }
                }
            }
        }
    } 

    /**
     * Draw image using JFrame.
     * @param image Image object to draw.
     */
    public static void DrawImage(Image image) {
        int width = image.n, height = image.m;
        JFrame frame = new JFrame("Image");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BufferedImage img = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                img.setRGB(j, i, image.M[i][j].valueInt());
            }
        }
        frame.add(new JLabel(new ImageIcon(img)));
        frame.setVisible(true);
    }
}