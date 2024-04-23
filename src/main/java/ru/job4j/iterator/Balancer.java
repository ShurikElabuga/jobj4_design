package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {

    public static void split(List<ArrayList<Integer>> nods, Iterator<Integer> source) {
        while (source.hasNext()) {
            for (int i = 0; i < nods.size(); i++) {
                if (!source.hasNext()) {
                    break;
                }
                nods.get(i).add(source.next());
            }
        }
    }
}
