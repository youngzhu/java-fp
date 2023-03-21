package com.youngzy.book.fpij.ch04;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class Mailer {
    public void from(final String address) {}
    public void to(final String address) {}
    public void subject(final String subject) {}
    public void body(final String message) {}
    public void send() {
        System.out.println("send...");
    }

    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("from@youngzy.com");
        mailer.to("to@youngzy.com");
        mailer.subject("Say hi");
        mailer.body("Hello, ");
        mailer.send();
    }
}
