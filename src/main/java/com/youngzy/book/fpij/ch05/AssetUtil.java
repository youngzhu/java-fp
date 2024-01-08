package com.youngzy.book.fpij.ch05;

import java.util.List;

/**
 * @author youngzy
 * @since 2023-03-20
 */
public class AssetUtil {
    public static int totalAssetValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalBondValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset ->
                        asset.getType() == Asset.AssetType.BOND ? asset.getValue() : 0)
                .sum();
    }

    public static int totalStockValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset ->
                        asset.getType() == Asset.AssetType.STOCK ? asset.getValue() : 0)
                .sum();
    }

}

