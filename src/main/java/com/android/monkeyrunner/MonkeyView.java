package com.android.monkeyrunner;

import com.android.chimpchat.core.IChimpView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class MonkeyView {
    private static final Logger LOG = Logger.getLogger(MonkeyView.class.getName());
    private IChimpView chimpView;

    public MonkeyView(IChimpView chimpView) {
        this.chimpView = chimpView;
    }

    public Boolean getChecked() {
        return this.chimpView.getChecked();
    }

    public String getViewClass() {
        return this.chimpView.getViewClass();
    }

    public String getText() {
        return this.chimpView.getText();
    }

    public MonkeyRect getLocation() {
        return new MonkeyRect(this.chimpView.getLocation());
    }

    public Boolean getEnabled() {
        return this.chimpView.getEnabled();
    }

    public Boolean getSelected() {
        return this.chimpView.getSelected();
    }

    public void setSelected(Boolean bool) {
        this.chimpView.setSelected(bool);
    }

    public void setSelected() {
        this.chimpView.setSelected(true);
    }

    public Boolean getFocused() {
        return this.chimpView.getFocused();
    }

    public void setFocused(Boolean bool) {
        this.chimpView.setFocused(bool);
    }

    public void setFocused() {
        this.chimpView.setFocused(true);
    }

    public MonkeyView getParent() {
        return new MonkeyView(this.chimpView.getParent());
    }

    public ArrayList<MonkeyView> getChildren() {
        List<IChimpView> chimpViewList = this.chimpView.getChildren();
        ArrayList<MonkeyView> monkeyViews = new ArrayList<MonkeyView>();
        for (IChimpView chimpView : chimpViewList) {
            monkeyViews.add(new MonkeyView(chimpView));
        }
        return monkeyViews;
    }

    public ArrayList<Integer> getAccessibilityIds() {
        int[] accessibilityIds = this.chimpView.getAccessibilityIds();
        ArrayList<Integer> accessibilityIdList = new ArrayList<Integer>();
        for (int accessibilityId : accessibilityIds) {
            accessibilityIdList.add(accessibilityId);
        }
        return accessibilityIdList;
    }
}
