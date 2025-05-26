package org.prashant;

import java.util.*;

public class Endings {

    Set<Integer> good_endings, bad_endings;
    Map<Integer, List<Integer>> choices;
    int end;
    List<Integer> res;
    Set<Integer> visited;

    public void mainCaller() {
        Integer[] good_endings = new Integer[]{10, 15, 25, 34};
        Integer[] bad_endings = new Integer[]{21, 30, 40};

        this.choices = new HashMap<>();
        visited = new HashSet<>();

//        int[][] choices = new int[][]{{3, 16, 19}, {20, 2, 17}};
        int[][] choices = new int[][]{{9, 16, 26}, {13, 31, 14}, {14, 16, 13}, {27, 12, 24}, {32, 34, 15}};

        for(int[] choice: choices) {
            this.choices.put(choice[0], Arrays.asList(choice[1], choice[2]));
        }

        Set<Integer> good = new HashSet<Integer>(Arrays.asList(good_endings));
        Set<Integer> bad = new HashSet<Integer>(Arrays.asList(bad_endings));
        this.good_endings = good;
        this.bad_endings = bad;
        end = good_endings[good_endings.length-1];
        res = new ArrayList<>();

        findGoodEndings(1);

        System.out.println(res);
    }

    private void findGoodEndings(int index) {

        if(index>end) return;
        if(visited.contains(index)) return;

        visited.add(index);
        if(bad_endings.contains(index)) return;

        if(good_endings.contains(index)) {
            res.add(index);
        }

        if(choices.containsKey(index)) {
            findGoodEndings(choices.get(index).get(0));
            findGoodEndings(choices.get(index).get(1));
        } else {
            findGoodEndings(index+1);
        }

    }
}
