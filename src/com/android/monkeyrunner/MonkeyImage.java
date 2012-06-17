package com.android.monkeyrunner;

import com.android.chimpchat.core.IChimpImage;

import java.util.logging.Logger;

public class MonkeyImage {
    private static Logger LOG = Logger.getLogger(MonkeyImage.class.getCanonicalName());
    private final IChimpImage impl;

    public MonkeyImage(IChimpImage paramIChimpImage) {
        this.impl = paramIChimpImage;
    }

    public IChimpImage getImpl() {
        return this.impl;
    }

    public byte[] convertToBytes() {
        return this.impl.convertToBytes("png");
    }

    public byte[] convertToBytes(String str) {
        return this.impl.convertToBytes(str);
    }

    public boolean writeToFile(String str1) {
        return this.impl.writeToFile(str1, null);
    }

    public boolean writeToFile(String str1, String str2) {
        return this.impl.writeToFile(str1, str2);
    }

    public Integer[] getRawPixel(int i, int j) {
        int k = this.impl.getPixel(i, j);
        Integer localInteger1 = (k & 0xFF000000) >> 24;
        Integer localInteger2 = (k & 0xFF0000) >> 16;
        Integer localInteger3 = (k & 0xFF00) >> 8;
        Integer localInteger4 = (k & 0xFF);
        return new Integer[]{localInteger1, localInteger2, localInteger3, localInteger4};
    }

    public int getRawPixelInt(int i, int j) {
        return this.impl.getPixel(i, j);
    }

    public boolean sameAs(MonkeyImage monkeyImage) {
        IChimpImage localIChimpImage = monkeyImage.getImpl();
        double d = 1.0D;
        return this.impl.sameAs(localIChimpImage, d);
    }

    public boolean sameAs(MonkeyImage monkeyImage, double d) {
        IChimpImage localIChimpImage = monkeyImage.getImpl();
        return this.impl.sameAs(localIChimpImage, d);
    }

    public MonkeyImage getSubImage(int x, int y, int w, int h) {
        IChimpImage localIChimpImage = this.impl.getSubImage(x, y, w, h);
        return new MonkeyImage(localIChimpImage);
    }
}