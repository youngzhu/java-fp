package com.youngzy.book.fpij.ch07;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author youngzy
 * @since 2023-03-27
 */
public class Memoizer {
    public static <T, R> R callMemoized(BiFunction<Function<T,R>, T, R> func,
                                        T input) {
        Function<T, R> memoized = new Function<T, R>() {
            private final Map<T, R> store = new HashMap<>();

            /*
            因为变量名，导致堆栈溢出了
            方法签名 (T t) 是自动生成的
            而源代码中是 (T input)，所以下面计算的时候也是 input，跟上面的参数重名了
             */
            @Override
            public R apply(T t) {
                return store.computeIfAbsent(t,
                        key -> func.apply(this, key));
            }
        };

        return memoized.apply(input);
    }
}
