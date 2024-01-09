package com.youngzy.book.fpij.ch08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorialRec() {
        System.out.println(Factorial.factorialRec(5));
    }

    @Test
    void factorialRecWithLarge() {
        try {
            System.out.println(Factorial.factorialRec(20000));
        } catch (StackOverflowError e) {
            System.out.println(e);
        }
    }

    @Test
    void factorialTailRec() {
        System.out.println("==START:FACT_TAIL_REC_DISPLAY_5_OUTPUT");
        System.out.println(Factorial.factorialTailRec(1, 5).invoke());
        System.out.println("==END:FACT_TAIL_REC_DISPLAY_5_OUTPUT");
    }

    @Test
    void factorialTailRecWithLarge() {
        System.out.println("==START:FACT_TAIL_REC_DISPLAY_LARGE_OUTPUT");
        System.out.println(Factorial.factorialTailRec(1, 20000).invoke());
        System.out.println("==END:FACT_TAIL_REC_DISPLAY_LARGE_OUTPUT");
    }

    @Test
    void factorial() {
        System.out.println("==START:FACTORIAL_DISPLAY_OUTPUT");
        System.out.println(Factorial.factorial(5));
        System.out.println(Factorial.factorial(20000));
        System.out.println("==END:FACTORIAL_DISPLAY_OUTPUT");
    }
}