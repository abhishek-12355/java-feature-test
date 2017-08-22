package com.netshell.test.java.dependency;

import com.netshell.test.java.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DependencyGraphTest implements Test {

    private DependencyNode<Integer> dependencyNode;

    @Override
    public void execute() throws Exception {
        createTestSource();
        printList(dependencyNode, "******************************init node***********************************************");
    }

    private void createTestSource() {
        final DependencyNode<Integer> node0 = new DependencyNode<>(0);
        final DependencyNode<Integer> node1 = new DependencyNode<>(1);
        final DependencyNode<Integer> node2 = new DependencyNode<>(2);
        final DependencyNode<Integer> node3 = new DependencyNode<>(3);
        final DependencyNode<Integer> node4 = new DependencyNode<>(4);
        final DependencyNode<Integer> node5 = new DependencyNode<>(5);
        final DependencyNode<Integer> node6 = new DependencyNode<>(6);
        final DependencyNode<Integer> node7 = new DependencyNode<>(7);

        node0.nodeList.addAll(Arrays.asList(node1, node3));
        node2.nodeList.addAll(Arrays.asList(node3, node6));
        node3.nodeList.addAll(Collections.singletonList(node1));
        node4.nodeList.addAll(Collections.singletonList(node2));
        node5.nodeList.addAll(Collections.singletonList(node7));
        node6.nodeList.addAll(Arrays.asList(node5, node7));
        node7.nodeList.addAll(Arrays.asList(node1, node3, node4, node5));

        dependencyNode = node0;
    }

    private void printList(DependencyNode<?> node, String initMessage) {
        System.out.println(initMessage);
        printNode(node);
        System.out.println("**********************************************************************************************\n");
    }

    private void printNode(DependencyNode<?> node) {
        System.out.println(node.data);
        for(DependencyNode dependencyNode : node.nodeList) {
            printNode(dependencyNode);
        }
    }

    private static final class DependencyNode<T> {
        private final T data;
        final List<DependencyNode<T>> nodeList = new ArrayList<>();

        private DependencyNode(T data) {
            this.data = data;
        }
    }
}
