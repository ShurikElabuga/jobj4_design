package ru.job4j.io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte b = 123;
        int i = 1234567890;
        short s = 12345;
        long l = 1234567890987654321L;
        float f = 36.6f;
        double d = 3.14;
        boolean t = true;
        char ch = 102;
        LOG.debug("byte b = {}, int i = {}, short s = {}, long l = {}, "
                + "float f = {}, double d = {}, boolean t = {}, char ch = {}", b, i, s, l, f, d, t, ch);
    }
}
