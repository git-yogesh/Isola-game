package com.algosee.prerk.isola;

/**
 * Created by shrey on 20-12-2015.
 */
public class SinglePlayerLogic {

    int SIZE = 7;
    int compMoveX, compMoveY;
    int newcompMoveX, newcompMoveY;
    int compBlockX, compBlockY;
    int playX, playY;
    int grid[][] = new int[SIZE][SIZE];
    int sum[][] = new int[SIZE][SIZE];


    public void init() {

        int i, j;
        for (i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                grid[i][j] = 0;
            }
        }

        playX = 6;
        playY = 3;

        compMoveX = 0;
        compMoveY = 3;

        grid[playX][playY] = 1;
        grid[compMoveX][compMoveY] = 2;

    }


    private boolean isValid(int i, int j) {

        try {
            if (grid[i][j] == 0) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public boolean isMoveValid(int a, int b) {

        if (!isValid(a, b)) {
            return false;
        }

        if (Math.abs(a - playX) > 1 || Math.abs(b - playY) > 1)
            return false;

        return true;

    }

    public int getWinner() {

        int i, j;
        int f = 1;
        for (i = -1; i < 2; i++) {
            for (j = -1; j < 2; j++) {
                try {
                    if (grid[playX + i][playY + j] == 0) {
                        f = 0;
                        break;
                    }

                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
        }

        if (f != 0) {
            return 2;
        }

        f = 1;
        for (i = -1; i < 2; i++) {
            for (j = -1; j < 2; j++) {
                try {
                    if (grid[compMoveX + i][compMoveY + j] == 0) {
                        f = 0;
                        break;
                    }

                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
        }
        if (f != 0) {
            return 1;
        }

        return 0;
    }


    private void calSum() {

        int i, j, dx, dy;

        for (i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                sum[i][j] = 0;
                for (dx = -1; dx < 2; dx++) {
                    for (dy = -1; dy < 2; dy++) {
                        if (isValid(i + dx, j + dy)) {
                            sum[i][j]++;
                        }
                    }
                }
            }
        }
    }


    public int compMove() {

        int x = compMoveX;
        int y = compMoveY;
        int status = 0;

        calSum();

        //System.out.println("//hjj//"+ compMoveX+" "+compMoveY);


        int dx, dy;
        int maxSum = 0;
        for (dx = -1; dx < 2; dx++) {
            for (dy = -1; dy < 2; dy++) {
                if (isValid(x + dx, y + dy) && sum[x + dx][y + dy] > maxSum) {
                    newcompMoveX = x + dx;
                    newcompMoveY = y + dy;
                    maxSum = sum[x + dx][y + dy];
                }
            }
        }
        //System.out.println("////"+ newcompMoveX+" "+newcompMoveY);

        updateCompMoveGrid();

        return status;
    }

    public int compBlock() {

        int x = playX;
        int y = playY;
        int status = 0, w;

        calSum();

        int dx, dy;
        int maxSum = 0;
        for (dx = -1; dx < 2; dx++) {
            for (dy = -1; dy < 2; dy++) {
                if (isValid(x + dy, y + dy) && sum[x + dx][y + dy] > maxSum) {
                    compBlockX = x + dx;
                    compBlockY = y + dy;
                    maxSum = sum[x + dx][y + dy];
                }
            }
        }
        if (!isValid(compBlockX, compBlockY)) {

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (grid[i][j] == 0) {
                        compBlockX = i;
                        compBlockY = j;
                    }
                }
            }
        }

        updateBlockGrid(compBlockX, compBlockY);

        w = getWinner();
        if (w != 0) {
            status = w;
        }

        return status;

    }

    public void updatePlayerMoveGrid(int a, int b) {

        grid[playX][playY] = 0;
        playX = a;
        playY = b;
        grid[playX][playY] = 1;
    }


    public void updateCompMoveGrid() {

        grid[compMoveX][compMoveY] = 0;
        compMoveX = newcompMoveX;
        compMoveY = newcompMoveY;
        grid[compMoveX][compMoveY] = 2;
    }

    public void updateBlockGrid(int a, int b) {

        grid[a][b] = -1;
    }

    /*public void updateBlockGrid(){
        grid[compBlockX][compBlockY] = -1;
    }*/

    public int playerMove(int a, int b) {

        int status = -1;
        if (isMoveValid(a, b)) {
            status = 0;
            updatePlayerMoveGrid(a, b);
        }
        return status;
    }

    public int playerBlock(int a, int b) {

        int status = -2, w;
        if (isValid(a, b)) {
            status = 0;
            updateBlockGrid(a, b);
        }

        w = getWinner();
        if (w != 0) {
            status = w;
        }
        return status;
    }
}
