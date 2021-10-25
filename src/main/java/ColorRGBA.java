package src.main.java;

import java.lang.Math;

public class ColorRGBA extends Color
{
    public float r, g, b, a;
    
    public ColorRGBA(int hex) {
        int r = (hex >> 16);
        int g = (hex - (r << 16)) >> 8;
        int b = (hex - (r << 16) - (g << 8));
        this.r = r / 255f;
        this.g = g / 255f;
        this.b = b / 255f;
        this.a = 1f;
    }

    public ColorRGBA(int r, int g, int b) {
        this.r = r / 255f;
        this.g = g / 255f;
        this.b = b / 255f;
        this.a = 1f;
    }

    public ColorRGBA(int r, int g, int b, float a) {
        this.r = r / 255f;
        this.g = g / 255f;
        this.b = b / 255f;
        this.a = a;
    }

    public ColorRGBA(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 1f;
    }

    public ColorRGBA(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color ToRGB() {
        float r_new = a * r;
        float g_new = a * g; 
        float b_new = a * b; 
        return new ColorRGBA(r_new, g_new, b_new);
    }
    
    @Override
    public Color ToRGBA() {
        return new ColorRGBA(r, g, b, a);
    }

    @Override
    public Color ToXYZ() {
        ColorRGBA rgb = (ColorRGBA) ToRGB();
        
        // matrix from https://en.wikipedia.org/wiki/CIE_1931_color_space
        float[][] M = { 
            { 2.76883f, 1.75171f, 1.13014f },
            { 1.00000f, 4.59061f, 0.06007f },
            { 0.00000f, 0.05651f, 5.59417f } };
        
        float x = rgb.r * M[0][0] + rgb.g * M[0][1] + rgb.b * M[0][2]; 
        float y = rgb.r * M[1][0] + rgb.g * M[1][1] + rgb.b * M[1][2]; 
        float z = rgb.r * M[2][0] + rgb.g * M[2][1] + rgb.b * M[2][2];

        return new ColorXYZ(x, y, z);
    }
    
    @Override
    public Color ToHSB() {
        float hue, sat, bri;        
        ColorRGBA rgb = (ColorRGBA) ToRGB();
        float max = Math.max(Math.max(rgb.r, rgb.g), rgb.b);
        float min = Math.min(Math.min(rgb.r, rgb.g), rgb.b);
        bri = (max + min) / 2;

        if (max == min) {
            hue = 0;
        } else if (max == rgb.r) {
            hue = 60 * (0 + (rgb.g - rgb.b) / (max - min));
        } else if (max == rgb.g) {
            hue = 60 * (2 + (rgb.b - rgb.r) / (max - min));
        } else {
            hue = 60 * (4 + (rgb.r - rgb.g) / (max - min));
        }

        if (hue < 0) {
            hue += 360;
        }

        if (max == 0 || min == 1) {
            sat = 0;
        } else {
            sat = (max - min) / (1 - Math.abs(max + min - 1));
        }

        return new ColorHSB(hue, sat, bri);
    }
    
    @Override
    public Color ToCMYK() {
        ColorRGBA rgb = (ColorRGBA) ToRGB();
        float c = 1 - rgb.r;
        float m = 1 - rgb.g;
        float y = 1 - rgb.b;
        float k = Math.min(c, Math.min(m, y));
        
        if (k == 1){
            c = m = y = 0;
        }
        else
        {
            float s = 1 - k;
            c = ( c - k ) / s;
            m = ( m - k ) / s;
            y = ( y - k ) / s;
        }

        return new ColorCMYK(c, m, y, k);
    }

    @Override
    public int valueInt() {
        ColorRGBA rgb = (ColorRGBA) ToRGB();
        int r_int = (int) (rgb.r * 255);
        int g_int = (int) (rgb.g * 255);
        int b_int = (int) (rgb.b * 255);
        int result = ((r_int) << 16) | ((g_int) << 8) | ((b_int) << 0); 
        return result;
    }

    @Override
    public float valueFloat() {
        float capacity = ((long)1) << 32;
        return valueInt() / capacity;
    }

    public String toString() {
        String s = String.format("Color system: RGBA, value: (%d, %d, %d, %.3f)", 
        (int) (255 * r),
        (int) (255 * g),
        (int) (255 * b),
        a);

        return s;
    }
}