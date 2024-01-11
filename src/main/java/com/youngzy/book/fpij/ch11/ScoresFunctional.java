package com.youngzy.book.fpij.ch11;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * @author youngzy
 * @since 2024-01-11
 */
public class ScoresFunctional extends Scores {
    public Map<Integer, Set<String>> namesForScores(
            Map<String, Integer> scores) {

        return scores.keySet()
                .stream()
                .collect(groupingBy(scores::get, toSet()));
    }
}
