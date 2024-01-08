package com.youngzy.book.fpij.ch06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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

    @BeforeEach
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
            assertTrue( true);
        }
    }

    // Using annotation
    // 简明扼要。
    // 但是，如果 setPrices 方法也抛出这个一样，这个测试也会通过
//    @Test(expected = RodCutterException.class) // JUnit 4
//    public void terseExceptionTest() {
//        rodCutter.setPrices(prices);
//        rodCutter.maxProfit(0);
//    }

    // Using Lambda Expressions
    // 只有 maxProfit 方法抛出异常时，才能通过
    @Test
    public void conciseExceptionTest() {
        rodCutter.setPrices(prices);

        Exception ex =
                assertThrows(RodCutterException.class, () -> rodCutter.maxProfit(0));

        assertEquals("length should be greater than zero", ex.getMessage());
    }
}
