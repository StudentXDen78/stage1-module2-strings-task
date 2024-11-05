package com.epam.mjc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new java.util.ArrayList<>(List.of());
        String[] sourceArr = source.split(Arrays.toString(delimiters.toArray()));
        result.addAll(Arrays.asList(sourceArr));
        return result;
    }
}