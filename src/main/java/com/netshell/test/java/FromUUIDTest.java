package com.netshell.test.java;

import java.util.UUID;

/**
 * Created by ASHEKHA
 * on 4/30/2017.
 */
public class FromUUIDTest implements Test {
    @Override
    public void execute() throws Exception {
        final UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(UUID.fromString(uuid.toString()));
        System.out.println(UUID.fromString(uuid.toString()));
    }
}
