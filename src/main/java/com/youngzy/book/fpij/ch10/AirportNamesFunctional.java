package com.youngzy.book.fpij.ch10;

import java.util.List;


/**
 * @author youngzy
 * @since 2024-01-10
 */
public class AirportNamesFunctional {
    public static List<Try<String>> getNamesOfAirports(List<String> iataCodes) {
        return iataCodes.stream()
                .map(iataCode -> Try.of(() -> AirportInfo.getNameOfAirport(iataCode)))
                .map(name -> name.map(String::toUpperCase))
                .toList();
    }

    public static void main(String[] args) {
        var iataCodes = List.of("AUS", "DFW", "HOU", "IHA", "SAT");

        // JDK 版本问题，编译不通过
        /*getNamesOfAirports(iataCodes).stream()
                .map(name -> switch(name) {
                    case Success(String result) -> result;
                    case Failure(Throwable throwable) -> "Error: " + throwable.getMessage();
                })
                .forEach(System.out::println);*/
    }
}
