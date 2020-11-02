package ru.job4j.io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
//        LOG.trace("trace message");
//        LOG.debug("debug message");
//        LOG.info("info message");
//        LOG.warn("warn message");
//        LOG.error("error message");
        String name = "Petr Arsentev";
        int age = 33;
        double price = 4.5;
        short count = 3;
        boolean verify = true;
        float f = 12.23F;
        long lightYears = 32200000000L;
        char sex = 'm';
        LOG.debug("User info name : {}, age : {}, price : {}," +
                " count {}, verify {}, f {}, light {}" +
                " sex {}", name, age, price, count, verify,
                f, lightYears, sex);
    }
}
