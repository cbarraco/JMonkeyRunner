package com.android.monkeyrunner;

import com.android.chimpchat.core.IChimpImage;

import java.awt.*;
import java.util.logging.Logger;

public class MonkeyImage {
    private static Logger LOG = Logger.getLogger(MonkeyImage.class.getCanonicalName());
    private final IChimpImage chimpImage;

    public MonkeyImage(IChimpImage chimpImage) {
        this.chimpImage = chimpImage;
    }

    public IChimpImage getChimpImage() {
        return this.chimpImage;
    }

    /**
     * Converts the current image to png (Portable Network Graphics) format and returns it as an array of bytes.
     *
     * @return A byte array containing the converted data
     */
    public byte[] convertToBytes() {
        return this.chimpImage.convertToBytes("png");
    }

    /**
     * Converts the current image to a particular format and returns it as an array of bytes.
     *
     * @param format The desired output format. All of the common raster output formats are supported.
     * @return A byte array containing the converted data
     */
    public byte[] convertToBytes(String format) {
        return this.chimpImage.convertToBytes(format);
    }

    /**
     * Writes the current image to a file specified by filename. The method tries to guess the format from the filename's extension. If no extension is provided then the default format of "png" (Portable Network Graphics) is used.
     *
     * @param filename The fully-qualified filename and extension of the output file.
     * @return True if successfully written, false otherwise
     */
    public boolean writeToFile(String filename) {
        return this.chimpImage.writeToFile(filename, null);
    }

    /**
     * Writes the current image to the file specified by filename, in the format specified by format.
     *
     * @param filename The fully-qualified filename and extension of the output file.
     * @param format   The output format to use for the file. If format is null, then the method tries to guess the format from the filename's extension. If no extension is provided and format is null, then the default format of "png" (Portable Network Graphics) is used.
     * @return True if successfully written, false otherwise
     */
    public boolean writeToFile(String filename, String format) {
        return this.chimpImage.writeToFile(filename, format);
    }

    /**
     * Returns the single pixel at the image location (x,y), as an array of integer, in the form {a,r,g,b}.
     *
     * @param x The horizontal position of the pixel, starting with 0 at the left of the screen in the orientation it had when the screenshot was taken.
     * @param y The vertical position of the pixel, starting with 0 at the top of the screen in the orientation it had when the screenshot was taken.
     * @return An array of integers representing the pixel, in the form {a,r,g,b} where a is the alpha channel value, and r, g, and b are the red, green, and blue values, respectively.
     */
    public Integer[] getRawPixel(int x, int y) {
        int pixel = this.chimpImage.getPixel(x, y);
        Integer alpha = (pixel & 0xFF000000) >> 24;
        Integer red = (pixel & 0xFF0000) >> 16;
        Integer green = (pixel & 0xFF00) >> 8;
        Integer blue = (pixel & 0xFF);
        return new Integer[]{alpha, red, green, blue};
    }

    /**
     * Returns the single pixel at the image location (x,y), as an an integer. Use this method to economize on memory.
     *
     * @param x The horizontal position of the pixel, starting with 0 at the left of the screen in the orientation it had when the screenshot was taken.
     * @param y The vertical position of the pixel, starting with 0 at the top of the screen in the orientation it had when the screenshot was taken.
     * @return The a,r,g, and b values of the pixel as 8-bit values combined into a 32-bit integer, with a as the leftmost 8 bits, r the next rightmost, and so forth.
     */
    public int getRawPixelInt(int x, int y) {
        return this.chimpImage.getPixel(x, y);
    }

    /**
     * Checks if this MonkeyImage is exactly the same as another.
     *
     * @param monkeyImage Another MonkeyImage object to compare to this one.
     * @return True if the images match, or false otherwise.
     */
    public boolean sameAs(MonkeyImage monkeyImage) {
        return sameAs(monkeyImage, 1.0D);
    }

    /**
     * Compares this MonkeyImage object to another and returns the result of the comparison. The percent argument specifies the percentage difference that is allowed for the two images to be "equal".
     *
     * @param monkeyImage Another MonkeyImage object to compare to this one.
     * @param percent     A float in the range 0.0 to 1.0, inclusive, indicating the percentage of pixels that need to be the same for the method to return true, 1.0 indicates that all the pixels must match.
     * @return True if the images match, or false otherwise.
     */
    public boolean sameAs(MonkeyImage monkeyImage, double percent) {
        IChimpImage chimpImage = monkeyImage.getChimpImage();
        return this.chimpImage.sameAs(chimpImage, percent);
    }

    /**
     * Creates a new MonkeyImage object from a rectangular selection of the current image.
     *
     * @param x      The x coordinate of the left of the rectangular selection
     * @param y      The y coordinate of the top of the rectangular selection
     * @param width  The width of the rectangular selection
     * @param height The height of the rectangular selection
     * @return A new MonkeyImage object containing the selection.
     */
    public MonkeyImage getSubImage(int x, int y, int width, int height) {
        IChimpImage subImage = this.chimpImage.getSubImage(x, y, width, height);
        return new MonkeyImage(subImage);
    }

    /**
     * Creates a new MonkeyImage object from a rectangular selection of the current image.
     *
     * @param rectangle A rectangle specifying the region to extract from this image
     * @return A new MonkeyImage object containing the selection.
     */
    public MonkeyImage getSubImage(Rectangle rectangle) {
        IChimpImage subImage = this.chimpImage.getSubImage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        return new MonkeyImage(subImage);
    }
}