package com.android.monkeyrunner;

import com.android.chimpchat.core.ChimpRect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MonkeyRect {
    private static final Logger LOG = Logger.getLogger(MonkeyRect.class.getName());
    private ChimpRect chimpRect;
    public int left;
    public int top;
    public int right;
    public int bottom;

    public MonkeyRect(ChimpRect chimpRect) {
        this.chimpRect = chimpRect;
        this.left = chimpRect.left;
        this.right = chimpRect.right;
        this.top = chimpRect.top;
        this.bottom = chimpRect.bottom;
    }

    public Integer getWidth() {
        return this.right - this.left;
    }

    public Integer getHeight() {
        return this.bottom - this.top;
    }

    public ArrayList<Integer> getCenter() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(this.left + (this.right - this.left) / 2);
        linkedList.add(this.top + (this.bottom - this.top) / 2);
        return new ArrayList<Integer>(linkedList);
    }
}