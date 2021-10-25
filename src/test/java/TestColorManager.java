package src.test.java;

import src.main.java.*;

class TestColorManager
{
    public static void TestMergeColors() {
        Color color1 = new ColorRGBA(0, 200, 0);
        Color color2 = new ColorRGBA(255, 255, 255);
        System.out.println(color1);        
        System.out.println(color2);  
        Color color3 = ColorManager.MergeColors(color1, color2);
        System.out.println(color3);  
    }

    public static void TestUnionColors() {
        Color color1 = new ColorRGBA(0, 0, 0);
        Color color2 = new ColorRGBA(255, 255, 255);
        System.out.println(color1);        
        System.out.println(color2);
        Color color3 = ColorManager.UnionColors(color1, color2);
        System.out.println(color3);   
    }

    public static void TestIntersectColors() {
        Color color1 = new ColorRGBA(0, 255, 0);
        Color color2 = new ColorRGBA(255, 255, 255);
        System.out.println(color1);        
        System.out.println(color2);  
        Color color3 = ColorManager.IntersectColors(color1, color2);
        System.out.println(color3);  
    }

    public static void TestXORColors() {
        Color color1 = new ColorRGBA(0, 255, 255);
        Color color2 = new ColorRGBA(255, 0, 255);
        System.out.println(color1);        
        System.out.println(color2);  
        Color color3 = ColorManager.XORColors(color1, color2);
        System.out.println(color3);  
    }

    public static void TestWriteColorsIntoFile() {
        ColorRGBA rgba = new ColorRGBA(20, 200, 80);
        ColorHSB hsb = new ColorHSB(140, 81, 43);
        ColorCMYK cmyk = new ColorCMYK(90, 0, 60, 21);
        ColorXYZ xyz = new ColorXYZ(1.9456072f, 3.6977553f, 1.7993554f); 
        Color []colors = {rgba, hsb, cmyk, xyz};
        ColorManager.WriteColorsIntoFile("src/test/resources/colors.txt", colors);
    }

    public static void TestReadColorsFromFile() {
        ColorManager.ReadColorsFromFile("src/test/resources/colors.txt");
    }

    public static void TestDrawColor() {
        Color color = new ColorCMYK(0, 0, 100, 0);
        ColorManager.DrawColor(color);
    }

    public static void main(String[] args) {
        TestMergeColors();
        TestUnionColors();
        TestIntersectColors();
        TestXORColors();
        TestWriteColorsIntoFile();
        TestReadColorsFromFile();    
        TestDrawColor();
    }
}
