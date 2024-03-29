package com.youngzy.book.fpij.ch05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class CalculateNAVTest {
    @Test
    public void testComputeStockWorth() {
        CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));

        BigDecimal expected = new BigDecimal("6010.00");
        BigDecimal got = calculateNAV.computeStockWorth("GOOG", 1000);

        assertEquals(expected.doubleValue(), got.doubleValue(), 0.001);
    }
}
