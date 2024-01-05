package com.youngzy.book.fpij.ch03;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }

}
