package com.my.programmers.lv2;

import java.util.*;


public class P12952 {
    private static boolean isPossible(boolean[] queens, int n){

        int[][] dxdy = {{0,-1},{1,-1},{1,0},{1, 1},{0,1},{-1,1},{-1,0},{-1,-1}};

        boolean[][] board = new boolean[n][n];
        List<int[]> queenIndex = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                boolean isQueen = queens[(i * n) + j];
                if(isQueen){
                    board[i][j] = isQueen;
                    queenIndex.add(new int[]{i, j});
                }

            }
        }

        for(int[] queen : queenIndex){

            int x = queen[0];
            int y = queen[1];

            for(int i = 0 ; i < 8 ; i++){

                int dx = x;
                int dy = y;
                while(true){

                    dx = dx + dxdy[i][0];
                    dy = dy + dxdy[i][1];

                    if(0 <= dx && dx < n && 0 <= dy && dy < n){
                        if(board[dx][dy]){
                            return false;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return true;

    }

    private static int countPossiblePosition(List<boolean[]> list, int n){

        int count = 0;

        for(int i = 0 ; i < list.size() ; i++){

            boolean[] queens = list.get(i);

            if(isPossible(queens, n)){
                count++;
            }
        }
        return count;
    }


    private static void combination(boolean[] visited, int start, int r, int n, List<boolean[]> placedList){

        if(r == 0){
            placedList.add(Arrays.copyOf(visited, visited.length));
            return;
        }


        for(int i = start ; i < visited.length ; i++){
            visited[i] = true;
            combination(visited, i+1, r-1, n, placedList);
            visited[i] = false;
        }

    }

    static public int solution(int n) {

        //n*n 개에서 4개씩 갯수 뽑기.
        //뽑아서 각각의 경우의 수가 올바른 케이스인지 확인

        List<boolean[]> placedList = new ArrayList<>();

        boolean[] queenPlace = new boolean[n*n];
        combination(queenPlace, 0, n, queenPlace.length, placedList);

        int count = countPossiblePosition(placedList, n);

        return count;
    }


    public static void main(String[] args) {

        int result = P12952.solution(4);
        System.out.println(result);

    }
}

