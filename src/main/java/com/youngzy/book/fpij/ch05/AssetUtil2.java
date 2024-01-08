package com.youngzy.book.fpij.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * @author youngzy
 * @since 2023-03-20
 */
public class AssetUtil2 {
    public static int totalAssetValues(final List<Asset> assets,
                                       final Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }

}
