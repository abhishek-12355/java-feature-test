package com.netshell.test.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JsonListMapTest implements Test {
    @Override
    public void execute() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        final String request = "[{\n" +
                "            \"name\": \"relatedInstanceId\",\n" +
                "            \"value\": \"a06760be-4b7e-4e7e-85d6-8bbc2fbb212d\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"dns_address\",\n" +
                "            \"value\": \"10.0.0.1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"subnet_name\",\n" +
                "            \"value\": \"/24\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"is_hub_site\",\n" +
                "            \"value\": \"Y\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"site_contact_email_address\",\n" +
                "            \"value\": \"11@amdocs.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ntp_address\",\n" +
                "            \"value\": \"10.0.0.1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"is_ipsec\",\n" +
                "            \"value\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"assign\",\n" +
                "            \"value\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"activate\",\n" +
                "            \"value\": \"false\"\n" +
                "        }]";

        List<Map<String, String>> list = mapper.readValue(request, new TypeReference<LinkedList<HashMap<String, String>>>(){});
        System.out.println(list);
    }
}
