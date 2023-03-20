package com.youngzy.book.fpij.ch04;

/**
 * @author youngzy
 * @since 2023-03-20
 */
public class Asset {
    public enum AssetType { BOND,STOCK }

    private final AssetType type;
    private final int value;

    public Asset(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
