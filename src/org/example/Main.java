package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var number = "555100";
        List list = CoolNumbers.generateCoolNumbers();
        System.out.println("Number of rooms: " + list.size());

        long time1 = System.nanoTime();
        String seach = CoolNumbers.bruteForceSearchInList(list, number) ? "found" : "not found";
        long time2 = System.nanoTime();
        String time = Long.toString(time2 - time1);
        System.out.println("Brute force search: number " + seach + ", search took " + time + "ns");

        List sortedList = new ArrayList(list);
        Collections.sort(sortedList);
        time1 = System.nanoTime();
        seach = CoolNumbers.binarySearchInList(sortedList, number) ? "found" : "not found";
        time2 = System.nanoTime();
        time = Long.toString(time2 - time1);
        System.out.println("Binary search: number " + seach + ", search took " + time + "ns");

        HashSet<String> hashSet = new HashSet<>(list);
        time1 = System.nanoTime();
        seach = CoolNumbers.searchInHashSet(hashSet, number) ? "found" : "not found";
        time2 = System.nanoTime();
        time = Long.toString(time2 - time1);
        System.out.println("Search in HashSet: number " + seach + ", search took " + time + "ns");

        TreeSet<String> treeSet = new TreeSet<>(list);
        time1 = System.nanoTime();
        seach = CoolNumbers.searchInTreeSet(treeSet, number) ? "found" : "not found";
        time2 = System.nanoTime();
        time = Long.toString(time2 - time1);
        System.out.println("Search in TreeSet: number " + seach + ", search took " + time + "ns");
    }
}