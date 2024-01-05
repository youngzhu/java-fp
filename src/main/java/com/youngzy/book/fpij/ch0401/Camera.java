package com.youngzy.book.fpij.ch0401;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class Camera {
    private Function<Color, Color> filter;

    public void setFilters(Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                .reduce((filter, next) -> filter.compose(next))
                .orElse(color -> color);
    }

    public Camera() {
        setFilters();
    }

    public Color capture(Color input) {
        Color processedColor = filter.apply(input);

        return processedColor;
    }

    public static void main(String[] args) {
        Camera camera = new Camera();
        Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("with %s: %s", filterInfo,
                        camera.capture(new Color(200, 100, 200))));

        System.out.println("==START: NOFILTER_OUTPUT");
        printCaptured.accept("no filter");
        System.out.println("==END  : NOFILTER_OUTPUT");

        System.out.println("==START: BRIGHT_OUTPUT");
        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");
        System.out.println("==END  : BRIGHT_OUTPUT");

        System.out.println("==START: DARK_OUTPUT");
        camera.setFilters(Color::darker);
        printCaptured.accept("darker filter");
        System.out.println("==END  : DARK_OUTPUT");

        System.out.println("==START: BOTH_OUTPUT");
        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("bright & darker filter");
        System.out.println("==END  : BOTH_OUTPUT");
    }
}
