package src.test.java;

import src.main.java.*;

class TestImage 
{
    public static void TestWriteToFile() {
        Image image = new Image("src/test/resources/example.jpg");
        image.WriteToFile("src/test/resources/output.jpg", "jpg");
    }

    public static void main(String[] args) {
        TestWriteToFile();
    }
}