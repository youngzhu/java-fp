package com.youngzy.book.fpij.ch05;

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
            throw new RodCutterException();
        }
    }

    public int maxProfit(int length) {
        if (length == 0)
            throw new RodCutterException();

        return 0;
    }
}
