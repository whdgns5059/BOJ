package com.my.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P154540 {

    static int[][] dxdy = {{0, -1}, {0, 1}, {-1, 0},{1, 0}};
    static int x;
    static int y;
    static List<Integer> result;

    public int[] solution(String[] maps){

        x = maps.length;
        y = maps[0].length();

        result = new ArrayList<>();
        boolean[][] visited = new boolean[x][y];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(!visited[i][j]){
                    int day = dfs(i, j, maps, visited);
                    if(day != 0){
                        result.add(day);
                    }
                }
            }
        }

        if(result.isEmpty()){
            return new int[]{-1};
        }

        Collections.sort(result);
        int[] arr = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            arr[i] = result.get(i);
        }

        return arr;
    }

    private int dfs(int i, int j, String[] maps, boolean[][] visited) {

        visited[i][j] = true;
        int result;
        if(maps[i].charAt(j) == 'X'){
            return 0;
        }else{
            result = Character.getNumericValue(maps[i].charAt(j));
        }
        for(int n = 0 ; n < 4 ; n++){
            int dx = dxdy[n][0] + i;
            int dy = dxdy[n][1] + j;

            if(0 <= dx && dx < x && 0 <= dy && dy < y ){
                if(!visited[dx][dy]){
                    result += dfs(dx, dy, maps, visited);
                }
            }
        }

        return result;


    }

}
