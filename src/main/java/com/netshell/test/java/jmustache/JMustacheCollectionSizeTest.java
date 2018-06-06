package com.netshell.test.java.jmustache;

import com.netshell.test.java.Test;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JMustacheCollectionSizeTest implements Test {
    private static final String TEMPLATE = "{{#items1}}{{.}} {{/items1}}" +
            "{{#items1}}{{#-first}}, {{/-first}}{{/items1}}" +
            "{{#items2}}{{.}} {{/items2}}" +
            "{{#items2}}{{#-first}}, {{/-first}}{{/items2}}" + //"{{^items2}}{{#items1}}{{#-first}}, {{/-first}}{{/items1}}{{/items2}}" +
            "{{#items3}}{{.}} {{/items3}}";

    @Override
    public void execute() throws Exception {
        final Template tmpl = Mustache.compiler().compile(TEMPLATE);
        final Map<String, Object> data = new HashMap<>();

        data.put("items1", Arrays.asList("ABC", 1234, 15.0));
//        data.put("items1", Collections.emptyList());
//        data.put("items2", Arrays.asList("DEF", 55645, 30.0));
        data.put("items2", Collections.emptyList());
        data.put("items3", Arrays.asList("XYZ", 8795, 45.0));
        System.out.println(tmpl.execute(data));
    }
}
