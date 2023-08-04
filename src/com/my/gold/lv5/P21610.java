package com.my.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//방향정보 클래스
class Direct{

    private final int d;
    private final int s;

    Direct(int[] ds){
        this.d = ds[0];
        this.s = ds[1];
    }

    int getDirect(){return this.d;}
    int getDistance(){
        return this.s;
    }

}

//구름 클래스
class Cloud {

    //구름의 좌표
    private int r;
    private int c;

    public Cloud(int r, int c){
        this.r = r;
        this.c = c;
    }

    int getRow(){return r;}
    int getCol(){return c;}
    void setRow(int r){this.r = r;}
    void setCol(int c){this.c = c;}

    //구름 이동하기
    void move(int direct, int n){
        switch (direct){
            case 1://←
                this.c = toUpOrLeft(this.c, n);
                break;
            case 2://↖
                this.r = toUpOrLeft(this.r, n);
                this.c = toUpOrLeft(this.c, n);
                break;
            case 3://↑
                this.r = toUpOrLeft(this.r, n);
                break;
            case 4://↗
                this.r = toUpOrLeft(this.r, n);
                this.c = toDownOrRight(this.c, n);
                break;
            case 5://→
                this.c = toDownOrRight(this.c, n);
                break;
            case 6://↘
                this.r = toDownOrRight(this.r, n);
                this.c = toDownOrRight(this.c, n);
                break;
            case 7://↓
                this.r = toDownOrRight(this.r, n);
                break;
            case 8://↙
                this.r = toDownOrRight(this.r, n);
                this.c = toUpOrLeft(this.c, n);
                break;
        }
    }

    //인덱스 감소(좌,상)
    private int toUpOrLeft(int i, int n){
        return i - 1 < 0 ? n - 1  : i - 1;
    }
    //인덱스 증가(우,하)
    private int toDownOrRight(int i, int n){
        return i + 1 >= n ? 0 : i + 1;
    }

}

//바구니(물의 양)
class Basket {

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

//NxN 격자 클래스
class Grid {

    private final Basket[][] baskets;   //바구니
    private final int n;                //격자의 사이즈
    private List<Cloud> cloudPositions; //구름의 위치
    private List<Cloud> deletedCloud;   //삭제한 구림

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

    //최초 구름의 위치 설정
    private List<Cloud> initCloud(int n) {
        List<Cloud> position = new ArrayList<>();
        position.add(new Cloud(n-2, 0));
        position.add(new Cloud(n-2, 1));
        position.add(new Cloud(n-1, 0));
        position.add(new Cloud(n-1, 1));

        return position;
    }


    //1. 모든 구름이 d 방향으로 si칸 이동한다.
    public void moveCloudsDirection(Direct direct) {
        int d = direct.getDirect();
        int s = direct.getDistance();

        for(int i = 0; i < s; i++){
            moveCloud(d, n);
        }
    }
    //구름이동 인덱스 계산(한칸씩이동)
    private void moveCloud(int d, int n) {

        for (Cloud cloud : cloudPositions) {
            cloud.move(d, n);
        }
    }



    //2. 비를 내린다.
    public void makeItRain() {
        for(Cloud cloud : cloudPositions){

            baskets[cloud.getRow()][cloud.getCol()].increaseWater();
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
        for (Cloud cloud : deletedCloud) {
            int r = cloud.getRow();
            int c = cloud.getCol();

            int counter = waterInDiagonalBasket(r - 1, c - 1)
                    + waterInDiagonalBasket(r - 1, c + 1)
                    + waterInDiagonalBasket(r + 1, c - 1)
                    + waterInDiagonalBasket(r + 1, c + 1);

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
                    cloudPositions.add(new Cloud(r, c));
                }
            }
        }
    }

    private boolean isDeleteCloudPosition(int r, int c) {
        for(Cloud cloud : deletedCloud){
            if(cloud.getRow() == r && cloud.getCol() == c){
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

public class P21610 {

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

        }

        int totalWater = grid.getTotalWater();

        System.out.println(totalWater);
    }

    public static void main(String[] args) throws IOException {

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
