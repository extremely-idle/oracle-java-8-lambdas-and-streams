/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 1 homework
 */
package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Module1Exercises {
    /**
     * Run the exercises to ensure we got the right answers
     */
    private void runExercises() {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
    }

    /**
     * All exercises should be completed using Lambda expressions and the new
     * methods added to JDK 8 where appropriate. There is no need to use an
     * explicit loop in any of the code. Use method references rather than full
     * lambda expressions wherever possible.
     *
     * Exercise 1
     * <p>
     * Create a string that consists of the first letter of each word in the list
     * of Strings provided.
     */
    private void exercise1() {
        final List<String> list = asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

        final StringBuilder builder = new StringBuilder();

        list.stream()
            .map((string) -> string.charAt(0))
            .forEach(builder::append);

        // Or
        //list.forEach((string) -> builder.append(string.charAt(0)));

        System.out.println(builder.toString());
    }

    /**
     * Exercise 2
     * <p>
     * Remove the words that have odd lengths from the list.
     */
    private void exercise2() {
        final List<String> list = new ArrayList<>(asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        final List<String> filteredList = list.stream()
                                              .filter((string) -> string.length() % 2 == 0)
                                              .collect(toList());
        // Or
        //list.removeIf((string) -> string.length() % 2 != 0);


        filteredList.forEach(System.out::println);
    }

    /**
     * Exercise 3
     * <p>
     * Replace every word in the list with its upper case equivalent.
     */
    private void exercise3() {
        final List<String> list = new ArrayList<>(asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        final List<String> upperList = list.stream()
                                           .map(String::toUpperCase)
                                           .collect(toList());

        // Or
        //list.replaceAll(String::toUpperCase);

        upperList.forEach(System.out::println);
    }

    /**
     * Exercise 4
     * <p>
     * Convert every key-value pair of the map into a string and append them all
     * into a single string, in iteration order.
     */
    private void exercise4() {
        final Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);

        final StringBuilder builder = new StringBuilder();

        map.forEach((key, value) -> builder.append("[" + key + ", " + value + "]"));

        System.out.println(builder.toString());
    }

    /**
     * Exercise 5
     * <p>
     * Create a new thread that prints the numbers from the list.
     */
    private void exercise5() {
        final List<Integer> list = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final Thread thread = new Thread(() -> list.forEach(System.out::println));
        thread.start();
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Module1Exercises lesson = new Module1Exercises();
        lesson.runExercises();
    }
}
