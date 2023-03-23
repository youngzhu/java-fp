package com.youngzy.book.fpij.ch06;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class HolderNaive {
    private Heavy heavy;

    public HolderNaive() {
        System.out.println("Holder created");
    }

    public Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }

        return heavy;
    }

    public static void main(String[] args) {
        HolderNaive holder = new HolderNaive();
        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }
}
