package exercises.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import static java.nio.file.Paths.get;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 3 homework
 * <p>
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
    private final List<String> sourceWords;

    /**
     * Constructor
     *
     * @throws IOException If the source words file cannot be read
     */
    public RandomWords() throws IOException {
        final Path path = get("module-3-advanced-streams-and-lambda-concepts", "src", "main", "resources", "words" +
                ".txt")
                .toAbsolutePath();

        sourceWords = Files.lines(path)
                           .collect(toList());

        System.out.println("Loaded " + sourceWords.size() + " words");
    }

    /**
     * Create a list of a given size containing random words
     *
     * @param listSize The size of the list to create
     * @return The created list
     */
    public List<String> createList(int listSize) {
        final Random r = new Random();

        final List<String> list = r.ints(listSize, 0, sourceWords.size())
                             .boxed()
                             .map(sourceWords::get)
                             .collect(toList());

        return list;
    }

    /**
     * Return the list of all source words, which cannot be modified
     *
     * @return The unmodifiable list of all source words
     */
    public List<String> allWords() {
        return unmodifiableList(sourceWords);
    }
}