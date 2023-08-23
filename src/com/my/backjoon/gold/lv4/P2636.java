package com.my.backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {

    static Cheese[][] cheese;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new Cheese[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                int c = Integer.parseInt(st.nextToken());
                cheese[i][j] = new Cheese(c, i, j);
            }
        }


        int depth = 0;
        int count = 0;
        //모든 치즈가 녹았는지 확인
        while(!isAllCheeseMelt()){

            //치즈밖의 공기 bfs로 확인(2로 변경)
            fillAir();
            count = 0;
            depth += 1;

            //공기(2)와 닿은 치즈 녹이면서 depth 증가
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){

                    //상하 좌우 확인하면서
                    //공기와 닿은 치즈 녹이면서 depth, 녹인개수 증가.
                    for(int k = 0 ; k < 4 ; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || y < 0 || x >= n || y >= m) {
                            continue;
                        }
                        if(cheese[i][j].cheese == 2
                            && cheese[x][y].cheese == 1) {

                            cheese[x][y].melt();
                            cheese[x][y].depth = depth;
                            count += 1;

                        }
                    }
                }
            }

            //visited 초기화
            Arrays.stream(cheese)
                .forEach(ca -> Arrays.stream(ca)
                .forEach(Cheese::resetVisit));

        }


        System.out.println(depth);
        System.out.println(count);

    }

    //모든 치즈 녹았는지 확인
    private static boolean isAllCheeseMelt() {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(cheese[i][j].hasCheese())
                    return false;
            }
        }
        return true;
    }

    //bfs순회로 치즈 밖의 공기(0)를 확인(2로 변경)
    private static void fillAir() {
        Queue<Cheese> q = new LinkedList<>();
        Cheese now = cheese[0][0];
        now.visit();
        q.add(now);

        while(!q.isEmpty()){

            Cheese c = q.poll();

            c.isAir();//방문한곳 2로 표시

            //bfs순회
            for(int k = 0 ; k < 4 ; k++){
                int x = c.x + dx[k];
                int y = c.y + dy[k];
                if(x < 0 || y < 0 || x == n || y == m){
                    continue;
                }
                Cheese next = cheese[x][y];
                if(!next.isVisited() && !next.hasCheese()){
                    next.visit();
                    q.add(next);
                }

            }
        }
    }

    private static class Cheese {
        int x;
        int y;
        int cheese;
        int depth;
        boolean visited;

        public Cheese(int cheese, int x, int y) {
            this.cheese = cheese;
            visited = false;
            this.x = x;
            this.y = y;
        }

        boolean hasCheese(){
            return cheese == 1;
        }
        void isAir(){this.cheese = 2;}
        void melt(){
            cheese = 0;
        }
        void visit(){
            this.visited = true;
        }
        boolean isVisited(){
            return visited;
        }
        void resetVisit() {this.visited = false;}
    }
}
