package com.netshell.test.java;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Arrays;

public class ClassLoadingTest implements Test {
    @Override
    public void execute() throws Exception {
        // Debugging to understand which classloader loads this class.
        final URL url = new URL("file:/C:\\Users\\ashekha\\.m2\\repository\\org\\openecomp\\so\\mso-api-handler-infra\\1.1.0-SNAPSHOT\\mso-api-handler-infra-1.1.0-SNAPSHOT-classes.jar");
        System.out.println(Files.exists(Paths.get(url.toURI()), LinkOption.NOFOLLOW_LINKS));
        final URLClassLoader loader = new URLClassLoader(new URL[]{url}, this.getClass().getClassLoader());
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try{
            Thread.currentThread().setContextClassLoader(loader);
            System.out.println(Arrays.toString(loader.getURLs()));
            final Class<?> testClassClass = Class.forName("org.openecomp.mso.apihandlerinfra.ServiceInstances");
            System.out.println(testClassClass.getClassLoader());
        } finally {
            Thread.currentThread().setContextClassLoader(contextClassLoader);
        }
    }

    private static final class TestClass {
        int a;
    }
}
