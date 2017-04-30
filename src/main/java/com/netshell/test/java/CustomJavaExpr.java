package com.netshell.test.java;

import java.lang.management.ManagementFactory;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomJavaExpr implements Test {

    @Override
    public void execute() throws Exception {
        System.out.println(
                MessageFormat.format(
                        "Parent Project with ID <{0}> isn''t found in ProjectStore.",
                        "AA", "BB", "CC", "DD", "EE"));
    }

}
