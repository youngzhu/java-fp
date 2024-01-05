package com.youngzy.book.fpij.ch0401;

import java.util.function.Consumer;

/**
 * @author youngzy
 * @since 2023-03-21
 */
public class FluentMailer {
    private FluentMailer() {
    }

    public FluentMailer from(final String address) {
        return this;
    }

    public FluentMailer to(final String address) {
        return this;
    }

    public FluentMailer subject(final String subject) {
        return this;
    }

    public FluentMailer body(final String message) {
        return this;
    }

    public static void send(Consumer<FluentMailer> block) {
        FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("send...");
    }

    public static void main(String[] args) {
        FluentMailer.send(mailer ->
                mailer.from("from@youngzy.com")
                        .to("to@youngzy.com")
                        .subject("Say hi")
                        .body("Hello, "));
    }
}
