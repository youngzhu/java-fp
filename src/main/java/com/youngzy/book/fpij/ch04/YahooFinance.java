package com.youngzy.book.fpij.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class YahooFinance {
    public static BigDecimal getPrice(String ticker) {
        try {
            final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String data = reader.lines().skip(1).findFirst().get();
            String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[dataItems.length-1]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
