package com.youngzy.book.fpij.ch11;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2024-01-11
 */
public class PythagoreanTriplesFunctional extends PythagoreanTriples {
    public List<Triple> compute(int numberOfValues) {
        return Stream.iterate(2, e -> e + 1)
                .flatMap(m -> IntStream.range(1, m)
                        .mapToObj(n -> getTripleEuclidsWay(m, n)))
                .limit(numberOfValues)
                .toList();
    }
}
