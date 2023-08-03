package com.my.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P21610 {


    private class Direct{

        private int d;
        private int s;

        Direct(int[] ds){
            this.d = ds[0];
            this.s = ds[1];
        }

        public int getDirect(){
            return this.d;
        }

        public int getDistance(){
            return this.s;
        }

    }

    private class Basket {

        private int water;

        Basket(int water){
            this.water = water;
        }

        public void increaseWater(){
            this.water += 1;
        }
        public void increaseWater(int water){
            this.water += water;
        }
        public void decreaseWater(int water){
            this.water -= water;
        }


        public int getWater() {
            return water;
        }

        public boolean hasWater() {
            return water > 0;
        }
    }


    private class Grid {

        private Basket[][] baskets;
        private List<int[]> cloudPositions;
        private List<int[]> deletedCloud;
        int n;

        public Grid(int n, int[][] A){
            baskets = new Basket[n][n];
            for(int r = 0 ; r < n ; r++){
                for(int c = 0 ; c < n ; c++){
                    baskets[r][c] = new Basket(A[r][c]);
                }
            }
            this.n = n;
            cloudPositions = initCloud(n);
        }

        private List<int[]> initCloud(int n) {
            List<int[]> position = new ArrayList<>();
            position.add(new int[]{n-2, 0});
            position.add(new int[]{n-2, 1});
            position.add(new int[]{n-1, 0});
            position.add(new int[]{n-1, 1});

            return position;
        }


        //1. 모든 구름이 d방향으로 si칸 이동한다.
        public void moveCloudsDirection(Direct direct) {
            int d = direct.getDirect();
            int s = direct.getDistance();

            for(int i = 0; i < s; i++){
                moveCloud(d, n);
            }
        }
        //구름이동 인덱스 계산(한칸씩이동)
        private List<int[]> moveCloud(int d, int n) {

            for(int i = 0 ; i < cloudPositions.size() ; i++){
                int[] cloud = cloudPositions.get(i);
                int r = cloud[0];
                int c = cloud[1];
                switch (d){
                    case 1://←
                        cloud[1] = toUpOrLeft(c, n);
                        break;
                    case 2://↖
                        cloud[0] = toUpOrLeft(r, n);
                        cloud[1] = toUpOrLeft(c, n);
                        break;
                    case 3://↑
                        cloud[0] = toUpOrLeft(r, n);
                        break;
                    case 4://↗
                        cloud[0] = toDownOrRight(r, n);
                        cloud[1] = toUpOrLeft(c, n);
                        break;
                    case 5://→
                        cloud[1] = toDownOrRight(c, n);
                        break;
                    case 6://↘
                        cloud[0] = toDownOrRight(r, n);
                        cloud[1] = toDownOrRight(c, n);
                        break;
                    case 7://↓
                        cloud[0] = toDownOrRight(r, n);
                        break;
                    case 8://↙
                        cloud[0] = toDownOrRight(r, n);
                        cloud[1] = toUpOrLeft(c, n);
                        break;
                }
            }
            return cloudPositions;
        }

        //인덱스 감소(좌,상)
        private int toUpOrLeft(int i, int n){
            return i - 1 < 0 ? n - 1  : i - 1;
        }
        //인덱스 증가(우,하)
        private int toDownOrRight(int i, int n){
            return i + 1 >= n ? 0 : i + 1;
        }

        //2. 비를 내린다.
        public void makeItRain() {
            for(int[] cloud : cloudPositions){
                int r = cloud[0];
                int c = cloud[1];

                baskets[r][c].increaseWater();
            }
        }

        //3. 구름이 모두 사라진다.
        //(4단계에서 물복사를 해야 하기 때문에 구름을 없애지 않고, 5직전에 없앤다)
        public void clearCloud() {
            deletedCloud = List.copyOf(cloudPositions);
            cloudPositions = new ArrayList<>();
        }

        //4. 물이 증가한 칸에 물복사(대각선 칸에 물있으면 각각 +1씩)해서 더함.
        public void copyWater() {
            for(int i = 0 ; i < deletedCloud.size() ; i++){
                int[] cloud = deletedCloud.get(i);
                int r = cloud[0];
                int c = cloud[1];

                int counter = waterInDiagonalBasket(r - 1, c - 1)
                + waterInDiagonalBasket(r - 1 , c + 1)
                + waterInDiagonalBasket(r + 1, c - 1)
                + waterInDiagonalBasket(r + 1 , c + 1);

                baskets[r][c].increaseWater(counter);

            }
        }

        //대각선 방향의 바스켓 확인후 있으면 1 없으면 0
        private int waterInDiagonalBasket(int r, int c) {
            if(r < 0 || c < 0 || r > n - 1 || c > n - 1){
                return 0;
            }
            if(baskets[r][c].hasWater()){
                return 1;
            }
            return 0;
        }

        //5. 물의 양의 2 이상인 모든 칸에 구름 만들고 -2,
        //단 구름이 없던 칸에 만들어야 함.
        public void setCloud() {

            //물이 2이상인 칸에 구름 만들기(삭제 된 위치 빼고)
            for(int r = 0 ; r < n ; r++){
                for(int c = 0 ; c < n ; c++){
                    if(baskets[r][c].getWater() >= 2 && !isDeleteCloudPosition(r,c)){
                        baskets[r][c].decreaseWater(2);
                        cloudPositions.add(new int[]{r, c});
                    }
                }
            }
        }

        private boolean isDeleteCloudPosition(int r, int c) {
            for(int[] cloud : deletedCloud){
                if(cloud[0] == r && cloud[1] == c){
                    return true;
                }
            }
            return false;
        }

        public int getTotalWater() {
            int result = 0;
            for(Basket[] basketRow : baskets){
                for(Basket basket : basketRow){
                    result += basket.getWater();
                }
            }
            return result;
        }

    }



    private void solution(int n, int m, int[][] A, int[][] d) {

        Grid grid = new Grid(n, A);
        Direct[] directs = new Direct[m];

        for(int i = 0 ; i < m ; i++){
            directs[i] = new Direct(d[i]);
        }

        for(Direct direct : directs){
            grid.moveCloudsDirection(direct);
            grid.makeItRain();
            grid.clearCloud();
            grid.copyWater();
            grid.setCloud();

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(grid.baskets[i][j].getWater() + ", ");
                }
                System.out.println("");
            }
            System.out.println("----");
        }

        int totalWater = grid.getTotalWater();

        System.out.println(totalWater);
    }

    public static void main(String[] args) throws IOException {
        //n x n 격자, 격자엔 바구니, 바구니는 무제한으로 담음
        //(r,c) r행,c열 바구니,
        //A[r][c] 바구니의 저장 된 물의양
        //왼쪽 위가 (1,1) 오른쪽 아래 (n,n)
        //1행과 ,n행은 연결 되어 있음, 1열과 n열도 연결 되어 있음
        //비바라기 시전시 (n,1)(n,2)(n-1)(n-2) 네모칸에 비구름.
        //m 만큼 구름 이동,
        //i번째 이동 명령은 방향 di, 거리si로 이뤄짐.
        //방향은 8방향  1←, 2↖, 3↑, 4↗, 5→, 6↘, 7↓, 8↙
            //1 모든 구름이 di 방향으로 si칸 이동
            //2 각 구름에 비가 내려 구름칸의 바구니에 물양 1증가
            //3구름 사라진다
            //4 2에서 물이 증가한 칸에 물복사 마법 시전
                //대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼(바구나의 물양은 노상관)
                //(r,c)에 있는 바구니의 물이 양이 증가
                    //이때는 경계를 넘어서는 칸(n에서 1로)는 대각선이 아님.
            //바구니에 저장 된 물의 양이 2 이상인 모든 칸에 구름이 생기고
            //물의양이 2 줄어든다.
            //5이 때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아님
        //m번의 이동이 끝난 후 바구니에 있는 물의 합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][n];
        for(int r = 0 ; r < n ; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < n ; c++){
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[m][2];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            d[i][0] = Integer.parseInt(st.nextToken());
            d[i][1] = Integer.parseInt(st.nextToken());
        }

        new P21610().solution(n, m, A, d);


    }


}
