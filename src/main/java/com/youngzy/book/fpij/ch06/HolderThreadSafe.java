package com.youngzy.book.fpij.ch06;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class HolderThreadSafe {
    private Heavy heavy;

    public HolderThreadSafe() {
        System.out.println("Holder created");
    }

    /*
    虽然是线程安全的，但做了太多没必要的“同步”
    因为只有在需要创建 heavy 实例的瞬间才需要同步，之后的，只要直接返回即可
     */
    public synchronized Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }

        return heavy;
    }

    public static void main(String[] args) {
        HolderThreadSafe holder = new HolderThreadSafe();
        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }
}
