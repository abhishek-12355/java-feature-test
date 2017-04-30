package com.netshell.test.java.stream;

import com.netshell.test.java.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by ashekha
 * on 1/2/2017.
 */
public class StreamFilterTest implements Test {

    private List<Product> products = Arrays.asList(
            new Product(1, 11, 21),
            new Product(2, 16, 22),
            new Product(3, 13, 23),
            new Product(4, 11, 24),
            new Product(5, 12, 21),
            new Product(6, 15, 22),
            new Product(7, 11, 23),
            new Product(8, 12, 21),
            new Product(9, 13, 22),
            new Product(10, 14, 22)
    );

    @Override
    public void execute() throws Exception {
        final Map<Integer, List<Integer>> collect = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.vendorId,
                        Collectors.mapping(p -> p.siteId, Collector.of(
                                ArrayList::new,
                                (list, item) -> { if (!list.contains(item)) list.add(item); },
                                (acc, list) -> { acc.addAll(list); return acc; }
                        ))
                ));
        System.out.println(collect);
    }

    private static final class Product {
        int siteId;
        int productId;
        int vendorId;

        Product(int productId, int siteId, int vendorId) {
            this.siteId = siteId;
            this.productId = productId;
            this.vendorId = vendorId;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "siteId=" + siteId +
                    ", productId=" + productId +
                    ", vendorId=" + vendorId +
                    '}';
        }
    }
}
