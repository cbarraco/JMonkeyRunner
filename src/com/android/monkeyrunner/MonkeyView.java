package com.android.monkeyrunner;

import com.android.chimpchat.core.IChimpView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MonkeyView {
    private static final Logger LOG = Logger.getLogger(MonkeyView.class.getName());
    private IChimpView impl;

    public MonkeyView(IChimpView paramIChimpView) {
        this.impl = paramIChimpView;
    }

    public Boolean getChecked() {
        return this.impl.getChecked();
    }

    public String getViewClass() {
        return this.impl.getViewClass();
    }

    public String getText() {
        return this.impl.getText();
    }

    public MonkeyRect getLocation() {
        return new MonkeyRect(this.impl.getLocation());
    }

    public Boolean getEnabled() {
        return this.impl.getEnabled();
    }

    public Boolean getSelected() {
        return this.impl.getSelected();
    }

    public void setSelected(Boolean bool) {
        this.impl.setSelected(bool);
    }

    public void setSelected() {
        this.impl.setSelected(true);
    }

    public Boolean getFocused() {
        return this.impl.getFocused();
    }

    public void setFocused(Boolean bool) {
        this.impl.setFocused(bool);
    }

    public void setFocused() {
        this.impl.setFocused(true);
    }

    public MonkeyView getParent() {
        return new MonkeyView(this.impl.getParent());
    }

    public ArrayList<MonkeyView> getChildren() {
        List<IChimpView> localList = this.impl.getChildren();
        ArrayList<MonkeyView> localArrayList = new ArrayList<MonkeyView>();
        for (IChimpView localIChimpView : localList) {
            localArrayList.add(new MonkeyView(localIChimpView));
        }
        return localArrayList;
    }

    public ArrayList<Integer> getAccessibilityIds() {
        int[] arrayOfInt = this.impl.getAccessibilityIds();
        ArrayList<Integer> localArrayList = new ArrayList<Integer>();
        for (int anArrayOfInt : arrayOfInt) {
            localArrayList.add(anArrayOfInt);
        }
        return localArrayList;
    }
}
