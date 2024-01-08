package com.youngzy.book.fpij.ch06;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static com.youngzy.book.fpij.ch06.TestHelper.assertThrows;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class RodCutterTest {
    private RodCutter rodCutter;
    private List<Integer> prices;

    protected RodCutter createCutter() {
        return new RodCutter(false);
    }

    @Before
    public void init() {
        rodCutter = createCutter();
        prices = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
    }

    @Test
    public void verboseExceptionTest() {
        rodCutter.setPrices(prices);

        try {
            rodCutter.maxProfit(0);
            fail("Expected exception for zero length");
        } catch (RodCutterException e) {
            assertTrue("expected", true);
        }
    }

    // Using annotation
    // 简明扼要。
    // 但是，如果 setPrices 方法也抛出这个一样，这个测试也会通过
    @Test(expected = RodCutterException.class)
    public void terseExceptionTest() {
        rodCutter.setPrices(prices);
        rodCutter.maxProfit(0);
    }

    // Using Lambda Expressions
    // 只有 maxProfit 方法抛出异常时，才能通过
    @Test
    public void conciseExceptionTest() {
        rodCutter.setPrices(prices);
        assertThrows(RodCutterException.class,
                () -> rodCutter.maxProfit(0));
    }
}
