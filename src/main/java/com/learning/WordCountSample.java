package com.learning;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kumade1 on 9/27/17.
 */
public class WordCountSample {

    public static void main(String[] args){

        String hugeString = "This is first String first hello hello I m trying to count words in";

        String[] tokens = hugeString.split(" ");
        List<String> sampleList = Arrays.asList(tokens);

        Map<String , Integer> wordsMap = sampleList.parallelStream().
                map(x -> new AbstractMap.SimpleEntry<>(x,1)).
                collect(Collectors.toMap(x -> x.getKey() , x -> x.getValue() ,(value1 , value2) -> (value1+value2)));

        wordsMap.keySet().parallelStream().forEach(x -> {
            System.out.println(""+x+" : "+wordsMap.get(x));
        });

    }


}
