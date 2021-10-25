package src.main.java;

public class ColorXYZ extends Color
{
    public float x, y, z;

    public ColorXYZ(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Color ToRGBA() {
        // matrix from https://en.wikipedia.org/wiki/CIE_1931_color_space
        float[][] M_inv = { 
            {    0.41847f,   -0.15866f, -0.082835f },
            {  -0.091169f,    0.25243f,  0.015708f },
            { 0.00092090f, -0.0025498f,   0.17860f } };
        
        float r = x * M_inv[0][0] + y * M_inv[0][1] + z * M_inv[0][2]; 
        float g = x * M_inv[1][0] + y * M_inv[1][1] + z * M_inv[1][2]; 
        float b = x * M_inv[2][0] + y * M_inv[2][1] + z * M_inv[2][2];

        return new ColorRGBA(r, g, b);
    }

    @Override
    public Color ToXYZ() {
        return new ColorXYZ(x, y, z);
    }

    @Override
    public Color ToHSB() {
        return ToRGBA().ToHSB();
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
        String s = String.format("Color system: XYZ, value: (%.9f, %.9f, %.9f)", x, y, z);
        return s;
    }
}