package src.main.java;

public abstract class Color
{
    /**
     * Gets this Color in RGBA system.
     * @return new ColorRGBA instance, converted to Color.
     */
    abstract public Color ToRGBA();

    /**
     * Gets this Color in XYZ system.
     * @return new ColorXYZ instance, converted to Color.
     */
    abstract public Color ToXYZ();

    /**
     * Gets this Color in HSB system.
     * @return new ColorHSB instance, converted to Color.
     */
    abstract public Color ToHSB();

    /**
     * Gets this Color in CMYK system.
     * @return new ColorCMYK instance, converted to Color.
     */
    abstract public Color ToCMYK();

    /**
     * Gets its hex representation.
     * @return int value.
     */
    abstract public int valueInt();

    /**
     * Gets its hex representation divided by 2^32.
     * @return float value.
     */
    abstract public float valueFloat();

    /**
     * Gets its string representation.
     * @return string.
     */
    abstract public String toString();
}