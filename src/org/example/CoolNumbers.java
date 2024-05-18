package org.example;

import java.util.*;

public class CoolNumbers {
// Method for generating "beautiful" license plates
    public static List<String> generateCoolNumbers() {
// List of letters that can be used in numbers
        String[] lettersForNumbers1 = {"A", "B", "E", "K", "M", "N", "O", "P", "S", "T", "U", "X"};

// Create an array for combinations of letters on numbers
        String[] lettersForNumbers2 = new String[(lettersForNumbers1.length - 1) *
                (lettersForNumbers1.length - 1) + 1];

// Generate all combinations of letters for numbers
        for (int i = 0; i < lettersForNumbers1.length; i++) {
            for (int j = 0; j < lettersForNumbers1.length; j++) {
                StringBuilder builder = new StringBuilder();
                // Compose a combination of letters and save it to an array
                lettersForNumbers2[i * 10 + j] = builder.append(lettersForNumbers1[i]).
                        append(lettersForNumbers1[j]).toString();
            }
        }

// Create an array for digits on numbers
        String[] digitsForNumbers = new String[9];
        for (int i = 0; i < digitsForNumbers.length; i++) {
            // Generate numbers by multiplying by 111
            digitsForNumbers[i] = Integer.toString(((i + 1) * 111));
        }

// List for storing "beautiful" numbers
        List<String> coolNumbers = new ArrayList<>();

// Generate numbers with different combinations of letters, numbers and regions
        for (int i = 1; i < 200; i++) {
            StringBuilder region = new StringBuilder();
            // Format the region so that there are two zeros before the number
            String formatRegion = region.append("00").append(i).substring(region.length() - 3);
            for (int j = 0; j < digitsForNumbers.length; j++) {
                for (int k = 0; k < lettersForNumbers1.length; k++) {
                    for (int l = 0; l < lettersForNumbers2.length; l++) {
                        StringBuilder builder = new StringBuilder();
                        // Generate a number and add it to the list
                        coolNumbers.add(builder.append(lettersForNumbers1[k]).
                                append(digitsForNumbers[j]).append(lettersForNumbers2[l]).
                                append(formatRegion).toString());
                    }
                }
            }
        }
        return coolNumbers;
    }

    // Method for searching for a number by searching through the list
    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    // Method for binary search for a number in a sorted list
    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    // Method for searching a number in a HashSet
    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    // Method for searching for a number in a TreeSet
    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}