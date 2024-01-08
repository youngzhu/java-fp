package com.youngzy.book.fpij.ch06;

import java.util.List;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class RodCutter {
    private boolean mustFail;

    public RodCutter(boolean mustFail) {
        this.mustFail = mustFail;
    }

    public void setPrices(List<Integer> prices) {
        // ...
        if (mustFail) {
            throw new RodCutterException("Invalid prices");
        }
    }

    public int maxProfit(int length) {
        if (length == 0)
            throw new RodCutterException("length should be greater than zero");

        return 0;
    }
}
