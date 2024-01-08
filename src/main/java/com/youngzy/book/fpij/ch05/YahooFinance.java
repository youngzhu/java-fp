package com.youngzy.book.fpij.ch05;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class YahooFinance {
    public static BigDecimal getPrice(String ticker) {

        // 模拟网络延迟
        try {
            Random random = new Random(System.currentTimeMillis());
            Thread.sleep(random.nextInt(500));
        } catch (Exception e) {

        }
        return BigDecimal.valueOf(ticker.hashCode() % 811);

        // 服务已不可用
//        try {
//            final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(url.openStream())
//            );
//            String data = reader.lines().skip(1).findFirst().get();
//            String[] dataItems = data.split(",");
//            return new BigDecimal(dataItems[dataItems.length-1]);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
