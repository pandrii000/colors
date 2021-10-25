package src.test.java;

import src.main.java.*;

class TestImageManager
{
    public static void TestDrawImage() {
        Image image = new Image("src/test/resources/example.jpg");
        ImageManager.DrawImage(image);
    }

    public static void TestFilter()
    {
        Image image = new Image("src/test/resources/example.jpg");
        ImageManager.DrawImage(image);

        int [][]values = {
            {
                (new ColorRGBA(0, 255, 0)).valueInt(),
                (new ColorRGBA(0, 255, 0)).valueInt(),
            },
            {                
                (new ColorRGBA(0, 255, 0)).valueInt(),
                (new ColorRGBA(0, 255, 0)).valueInt(),
            }
        };
        Mask mask = new Mask(values);

        String operation = "xor";

        ImageManager.Filter(image, mask, operation, 2, 2);
        ImageManager.DrawImage(image);
    }

    public static void main(String[] args) {
        TestDrawImage();
        TestFilter();
    }
}