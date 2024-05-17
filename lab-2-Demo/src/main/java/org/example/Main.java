package org.example;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<String> goodGuys = new ArrayList<>(
                List.of("Mario", "Luigi", "Toad", "Yoshi", "Peach")
        );
        List<String> badGuys = new ArrayList<>(
                List.of("Goomba", "Bowser", "Birdo", "Koopa")
        );

        Collections.sort(goodGuys);
        System.out.println(goodGuys);
//        badGuys.sort(Comparator.naturalOrder());
//        badGuys.sort((x,y) -> x.compareTo(y));
        badGuys.sort(String::compareTo);
        System.out.println(badGuys);

        //CollectionUtils.collate Combines
        System.out.println(CollectionUtils.collate(goodGuys, badGuys));

        //Using Streams
        Stream.concat(goodGuys.stream(), badGuys.stream()).sorted().forEach(System.out::println);
    }

}