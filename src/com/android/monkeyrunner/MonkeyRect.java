package com.android.monkeyrunner;

import com.android.chimpchat.core.ChimpRect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MonkeyRect {
    private static final Logger LOG = Logger.getLogger(MonkeyRect.class.getName());
    private ChimpRect rect;
    public int left;
    public int top;
    public int right;
    public int bottom;

    public MonkeyRect(ChimpRect paramChimpRect) {
        this.rect = paramChimpRect;
        this.left = paramChimpRect.left;
        this.right = paramChimpRect.right;
        this.top = paramChimpRect.top;
        this.bottom = paramChimpRect.bottom;
    }

    public Integer getWidth() {
        return this.right - this.left;
    }

    public Integer getHeight() {
        return this.bottom - this.top;
    }

    public ArrayList<Integer> getCenter() {
        LinkedList<Integer> localLinkedList = new LinkedList<Integer>();
        localLinkedList.add(this.left + (this.right - this.left) / 2);
        localLinkedList.add(this.top + (this.bottom - this.top) / 2);
        return new ArrayList<Integer>(localLinkedList);
    }
}