package com.netshell.test.java;

public class StaticMethodInheritence implements Test {

    @Override
    public void execute() throws Exception {
        B.execute();
    }
}


class A {
    public static void execute() {
        print();
    }

    protected static void print() {
        System.out.println("Inside A");
    }
}

class B extends A {
    protected static void print() {
        System.out.println("Inside B");
    }
}

