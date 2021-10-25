package src.main.java;

public class ColorCMYK extends Color
{
    public float c, m, y, k;

    public ColorCMYK(int c, int m, int y, int k)
    {
        this.c = c / 100f;
        this.m = m / 100f;
        this.y = y / 100f;
        this.k = k / 100f;
    }

    public ColorCMYK(float c, float m, float y, float k)
    {
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }

    @Override
    public Color ToRGBA() {
        float c_new = c;
        float m_new = m;
        float y_new = y;
        float k_new = k;

        if (k_new == 1){
            c_new = m_new = y_new = 0;
        } else {
            c_new = c_new * (1 - k_new) + k_new;
            m_new = m_new * (1 - k_new) + k_new;
            y_new = y_new * (1 - k_new) + k_new;
        }

        float r = 1 - c_new;
        float g = 1 - m_new;
        float b = 1 - y_new;

        return new ColorRGBA(r, g, b);
    }

    @Override
    public Color ToXYZ() {
        return ToRGBA().ToXYZ();
    }

    @Override
    public Color ToHSB() {
        return ToRGBA().ToHSB();
    }

    @Override
    public Color ToCMYK() {
        return new ColorCMYK(c, m, y, k);
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
        String s = String.format("Color system: CMYK, value: (%d, %d, %d, %d)", 
        (int) (100 * c),
        (int) (100 * m),
        (int) (100 * y),
        (int) (100 * k));

        return s;
    }
}