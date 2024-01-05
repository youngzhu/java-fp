package com.youngzy.book.fpij.ch0401;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class MailerBuilder {
    public MailerBuilder from(final String address) {
        return this;
    }

    public MailerBuilder to(final String address) {
        return this;
    }

    public MailerBuilder subject(final String subject) {
        return this;
    }

    public MailerBuilder body(final String message) {
        return this;
    }

    public void send() {
        System.out.println("send...");
    }

    public static void main(String[] args) {
        new MailerBuilder()
                .from("from@youngzy.com")
                .to("to@youngzy.com")
                .subject("Say hi")
                .body("Hello, ")
                .send();
    }
}
