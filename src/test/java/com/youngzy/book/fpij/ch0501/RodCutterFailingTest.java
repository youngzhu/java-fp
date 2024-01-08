package com.youngzy.book.fpij.ch0501;

import junit.framework.JUnit4TestAdapter;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class RodCutterFailingTest extends RodCutterTest {
    @Override
    protected RodCutter createCutter() {
        return new RodCutter(true);
    }

//    @Test
//    public void test() {
//        junit.textui.TestRunner.run(
//                new JUnit4TestAdapter(RodCutterFailingTest.class)
//        );
//    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(
                new JUnit4TestAdapter(RodCutterFailingTest.class)
        );
    }
}
