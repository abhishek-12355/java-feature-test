package com.netshell.test.java;

import com.netshell.test.java.dependency.DependencyGraphTest;
import com.netshell.test.java.dependency.DependencyResolutionTest;

/**
 * Created by ASHEKHA
 * on 4/30/2017.
 */
public class JavaFeatureTest {

    public static void main(String[] args) throws Exception {
        Test test = new JsonListMapTest();
        test.execute();
    }
}
