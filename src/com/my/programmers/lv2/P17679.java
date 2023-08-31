package com.my.programmers.lv2;

import java.util.*;


class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class P17679 {
    int[][] dxdy = {{0,0}, {0,1}, {1,0}, {1,1}};

    public int solution(int m, int n, String[] board) {

        String[] pivot = pivoting(m, n, board);

        int answer = 0;
        Set<Coordinate> blocks = new HashSet<>();


        do{
            blocks.clear();

            for(int i = 0 ; i < n-1; i++){
                for(int j = 0 ; j < pivot[i].length()-1; j++){
                    if(isMatched(i, j, pivot)){
                        for(int[] d : dxdy){
                            blocks.add(new Coordinate(i+d[0], j+d[1]));
                        }
                    }
                }
            }

            answer += blocks.size();

            for(Coordinate block : blocks){
                String s = pivot[block.x].substring(0, block.y)
                        + 'X' + pivot[block.x].substring(block.y+1);

                pivot[block.x] = s;
            }

            for(int i = 0 ; i < n ; i++){
                pivot[i] = pivot[i].replaceAll("X", "");
            }

        }while(!blocks.isEmpty());

        return answer;

    }

    boolean isMatched(int i, int j, String[] pivot){

        char[] carr = new char[4];
        for(int n = 0 ; n < 4 ; n++){
            int dx = i + dxdy[n][0];
            int dy = j + dxdy[n][1];
            if(0 <= dx && dx < pivot.length && 0 <= dy && dy < pivot[dx].length()){
                carr[n] = pivot[dx].charAt(dy);
            }else{
                return false;
            }
        }

        return carr[0] == carr[1]
                && carr[1] == carr[2]
                && carr[2] == carr[3];

    }


    String[] pivoting(int m, int n, String[] board){

        String[] pivot = new String[n];

        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = m-1 ; j >= 0 ; j--){
                sb.append(board[j].charAt(i));
            }
            pivot[i] = sb.toString();
        }

        return pivot;
    }


}
