package src.test.java;

import src.main.java.*;

class TestColor
{
    public static void TestRGBAToAll() {
        ColorRGBA rgba = new ColorRGBA(20, 200, 80);
        System.out.println((ColorRGBA) rgba.ToRGBA());
        System.out.println((ColorHSB) rgba.ToHSB());
        System.out.println((ColorCMYK) rgba.ToCMYK());
        System.out.println((ColorXYZ) rgba.ToXYZ());
    }

    public static void TestHSBToAll() {
        ColorHSB hsb = new ColorHSB(140, 81, 43);
        System.out.println((ColorRGBA) hsb.ToRGBA());
        System.out.println((ColorHSB) hsb.ToHSB());
        System.out.println((ColorCMYK) hsb.ToCMYK());
        System.out.println((ColorXYZ) hsb.ToXYZ());
    }

    public static void TestCMYKToAll() {
        ColorCMYK cmyk = new ColorCMYK(90, 0, 60, 21);
        System.out.println((ColorRGBA) cmyk.ToRGBA());
        System.out.println((ColorHSB) cmyk.ToHSB());
        System.out.println((ColorCMYK) cmyk.ToCMYK());
        System.out.println((ColorXYZ) cmyk.ToXYZ());
    }

    public static void TestXYZToAll() {
        ColorXYZ xyz = new ColorXYZ(1.9456072f, 3.6977553f, 1.7993554f); 
        System.out.println((ColorRGBA) xyz.ToRGBA());
        System.out.println((ColorHSB) xyz.ToHSB());
        System.out.println((ColorCMYK) xyz.ToCMYK());
        System.out.println((ColorXYZ) xyz.ToXYZ());
    }
    
    public static void TestValueInt() {
        ColorRGBA rgba = new ColorRGBA(20, 200, 80);
        System.out.println(rgba.valueInt());
    }
    
    public static void TestValueFloat() {
        ColorRGBA rgba = new ColorRGBA(20, 200, 80);
        System.out.println(rgba.valueFloat());
    }

    public static void main(String[] args) {
        TestRGBAToAll();
        TestHSBToAll();
        TestCMYKToAll();
        TestXYZToAll();
        TestValueInt();
        TestValueFloat();
    }
}