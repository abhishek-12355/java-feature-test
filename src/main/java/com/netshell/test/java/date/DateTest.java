package com.netshell.test.java.date;

import com.netshell.test.java.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Created by ashekha
 * on 1/12/2017.
 */
public class DateTest implements Test {
    @Override
    public void execute() throws Exception {
        System.out.println(Instant.now().atZone(ZoneId.systemDefault()));
        System.out.println(Instant.now());
    }
}
