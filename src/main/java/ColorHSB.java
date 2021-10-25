package src.main.java;

public class ColorHSB extends Color
{
    public float hue, sat, bri;

    public ColorHSB(int h, int s, int b)
    {
        hue = h;
        sat = s / 100f;
        bri = b / 100f;
    }

    public ColorHSB(float h, float s, float b)
    {
        hue = h;
        sat = s;
        bri = b;
    }

    @Override
    public Color ToRGBA() {
        float c = (1 - Math.abs(2 * bri - 1)) * sat;
        float x = c * (1 - Math.abs((hue / 60) % 2 - 1));
        float m = bri - c / 2;

        float _r, _g, _b;
        if (0 <= hue && hue < 60) {
            _r = c;
            _g = x;
            _b = 0;
        } else if (60 <= hue && hue < 120) {
            _r = x;
            _g = c;
            _b = 0;
        } else if (120 <= hue && hue < 180) {
            _r = 0;
            _g = c;
            _b = x;
        } else if (180 <= hue && hue < 240) {
            _r = 0;
            _g = x;
            _b = c;
        } else if (240 <= hue && hue < 300) {
            _r = x;
            _g = 0;
            _b = c;
        } else if (300 <= hue && hue < 360) {
            _r = c;
            _g = 0;
            _b = x;
        } else {
            throw new IllegalArgumentException("Hue must be between 0 and 360.");
        }

        float r = _r + m;
        float g = _g + m;
        float b = _b + m;

        return new ColorRGBA(r, g, b);
    }

    @Override
    public Color ToXYZ() {
        return ToRGBA().ToXYZ();
    }

    @Override
    public Color ToHSB() {
        return new ColorHSB(hue, sat, bri);
    }

    @Override
    public Color ToCMYK() {
        return ToRGBA().ToCMYK();
    }

    @Override
    public int valueInt() {
        return ToRGBA().valueInt();
    }

    @Override
    public float valueFloat() {
        return ToRGBA().valueFloat();
    }

    public String toString() {
        String s = String.format("Color system: HSB, value: (%d, %d, %d)", 
        (int) (hue),
        (int) (100 * sat),
        (int) (100 * bri));

        return s;
    }
}