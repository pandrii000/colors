package src.main.java;

public class Mask
{
    int n, m;
    int [][]M;

    public Mask(int[][] values)
    {
        this.n = values.length;
        this.m = values[0].length;
        this.M = values;
    }
}