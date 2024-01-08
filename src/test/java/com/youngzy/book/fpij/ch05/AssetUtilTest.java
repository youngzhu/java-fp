package com.youngzy.book.fpij.ch05;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AssetUtilTest {
    final List<Asset> assets = Arrays.asList(
            new Asset(Asset.AssetType.BOND,1000),
            new Asset(Asset.AssetType.BOND,2000),
            new Asset(Asset.AssetType.STOCK,3000),
            new Asset(Asset.AssetType.STOCK,4000)
    );

    @Test
    public void totalAssetValues() {
        assertEquals(10_000, AssetUtil.totalAssetValues(assets));

        // refactored
        assertEquals(10_000, AssetUtil2.totalAssetValues(assets, asset -> true));
    }

    @Test
    public void totalBondValues() {
        assertEquals(3_000, AssetUtil.totalBondValues(assets));

        // refactored
        assertEquals(3_000, AssetUtil2.totalAssetValues(assets,
                asset -> asset.getType() == Asset.AssetType.BOND));
    }

    @Test
    public void totalStockValues() {
        assertEquals(7_000, AssetUtil.totalStockValues(assets));

        // refactored
        assertEquals(7_000, AssetUtil2.totalAssetValues(assets,
                asset -> asset.getType() == Asset.AssetType.STOCK));
    }
}