package org.prashant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridFind {

    char[][] grid;
    Map<String, List<String>> res;

    public void mainCaller() {
        this.grid = new char[][]{
                {'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
                {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
                {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
                {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
                {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
                {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'}
        };
        String[] words = new String[] {"access", "balloon"};
        res = new HashMap<>();

        for(String word: words) {
//            List<String> res = new ArrayList<>();

            for(int row=0; row<grid.length; row++) {
                for(int col=0; col<grid[0].length; col++) {
                    List<String> path = new ArrayList<>();
                    trace(row,col,0,word,path);
                }
            }


        }

        for(Map.Entry<String, List<String>> entry: res.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private void trace(int row, int col, int index, String word, List<String> path) {

        if(index==word.length()) {
            res.putIfAbsent(word, new ArrayList<>(path));
            return;
        }

        if(row==grid.length || col==grid[0].length || grid[row][col]!=word.charAt(index)) {
            return;
        }

        path.add(row+","+col);

        trace(row+1, col, index+1, word, path);
        trace(row, col+1, index+1, word, path);

        path.remove(path.size()-1);

    }
}
