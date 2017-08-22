package com.netshell.test.java.dependency;

import com.netshell.test.java.Test;

import java.util.*;

public class DependencyResolutionTest implements Test {

    private List<DependencyTestNode> list = createTestSource();

    @Override
    public void execute() throws Exception {

        printList(list, "****************************************Init List********************************************");

        /*PriorityQueue<DependencyTestNode> integers = new PriorityQueue<>(getComparator());
        integers.addAll(list);
        DependencyTestNode i;
        while ((i = integers.poll()) != null) {
            System.out.println(i);
        }*/
        printList(parseDependencies(list), "****************************************final List********************************************");
    }

    private void printList(List<DependencyTestNode> list, String initMessage) {
        System.out.println(initMessage);
        for (DependencyTestNode dependencyTestNode : list) {
            System.out.println(dependencyTestNode);
        }

        System.out.println("**********************************************************************************************\n");
    }

    private List<DependencyTestNode> parseDependencies(List<DependencyTestNode> relatedInstances) {
        // TODO: Need to confirm whether to parse nested relatedInstances
        List<DependencyTestNode> instancesList = new ArrayList<>();
        final String s = "****************************************%d itr List********************************************";
        int i=0;
        for (DependencyTestNode relatedInstance : relatedInstances) {
            printList(instancesList, String.format(s, i));
            if (instancesList.size() == 0) {
                instancesList.add(relatedInstance);
            } else {
                addInstance(instancesList, relatedInstance);
            }
            i++;
        }
        return instancesList;
    }

    private void addInstance(List<DependencyTestNode> instancesList, DependencyTestNode relatedInstance) {
        int i;
        for (i = 0; i < instancesList.size(); i++) {
            final DependencyTestNode node = instancesList.get(i);
            if (node.dependencies.contains(relatedInstance.dependencyId)) {
                break;
            }
        }

        instancesList.add(i, relatedInstance);
        shift(instancesList, relatedInstance, i + 1);

        /*for (Integer dependency : relatedInstance.dependencies) {
            for (int k = i; k < instancesList.size(); k++) {
                final DependencyTestNode node = instancesList.get(k);
                if (node.dependencyId == dependency && i < k) i = k;
            }
        }*/

        /*for (int k = 0; k < instancesList.size(); k++) {
            final DependencyTestNode node = instancesList.get(k);
            if (node.dependencies.contains(relatedInstance.dependencyId) && i < k) {
                throw new RuntimeException("Cyclic Reference " + relatedInstance + " and " + node);
            }
        }*/

//        instancesList.add(i, relatedInstance);
    }

    private void shift(List<DependencyTestNode> instancesList, DependencyTestNode relatedInstance, int k) {
        for (int i = k; i < instancesList.size(); i++) {
            final DependencyTestNode node = instancesList.get(i);
            if (relatedInstance.dependencies.contains(node.dependencyId)) {
                instancesList.remove(i);
                int index = k - 2;
                /*if (index == -1) {
                    index = 0;
                }*/
                instancesList.add(index, node);
            }
        }
    }

    private Comparator<DependencyTestNode> getComparator() {
        return (o1, o2) -> o2.dependencies.contains(o1.dependencyId) ? -1 : 0;
    }

    private List<DependencyTestNode> createTestSource() {
        final List<DependencyTestNode> list = new ArrayList<>();

        /*for (int i = 0; i < 10; i++) {
            final DependencyTestNode e = new DependencyTestNode();
            e.dependencyId = i;
            for (int j = 0; j < Math.random() * 10; j++) {
                final int dep = (int) (Math.random() * 10);
                if (dep == i) {
                    j--;
                    continue;
                }
                e.dependencies.add(dep);
            }
            list.add(e);
        }

        list.get(list.size() - 1).dependencies.clear();*/

        DependencyTestNode node0 = new DependencyTestNode();
        node0.dependencyId = 0;
        node0.dependencies = new HashSet<>(Arrays.asList(1, 3));
        list.add(node0);

        DependencyTestNode node2 = new DependencyTestNode();
        node2.dependencyId = 2;
        node2.dependencies = new HashSet<>(Arrays.asList(3, 6));
        list.add(node2);

        DependencyTestNode node3 = new DependencyTestNode();
        node3.dependencyId = 3;
        node3.dependencies = new HashSet<>(Collections.singletonList(1));
        list.add(node3);

        DependencyTestNode node4 = new DependencyTestNode();
        node4.dependencyId = 4;
        node4.dependencies = new HashSet<>(Arrays.asList(2, 8));
        list.add(node4);

        DependencyTestNode node5 = new DependencyTestNode();
        node5.dependencyId = 5;
        node5.dependencies = new HashSet<>(Collections.singletonList(7));
        list.add(node5);

        DependencyTestNode node6 = new DependencyTestNode();
        node6.dependencyId = 6;
        node6.dependencies = new HashSet<>(Arrays.asList(5, 7));
        list.add(node6);

        DependencyTestNode node7 = new DependencyTestNode();
        node7.dependencyId = 7;
        node7.dependencies = new HashSet<>(Arrays.asList(1, 3, 4, 5));
        list.add(node7);

        DependencyTestNode node1 = new DependencyTestNode();
        node1.dependencyId = 1;
        node1.dependencies = new HashSet<>();
        list.add(node1);

        return list;
    }

    private static final class DependencyTestNode {
        int dependencyId;
        Set<Integer> dependencies = new HashSet<>();

        @Override
        public String toString() {
            return "DependencyTestNode{" +
                    "dependencyId=" + dependencyId +
                    ", dependencies=" + dependencies +
                    '}';
        }
    }
}
