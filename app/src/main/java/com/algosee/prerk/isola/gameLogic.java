package com.algosee.prerk.isola;

/**
 * Created by shrey on 19-12-2015.
 */
public class gameLogic {
    int SIZE = 7;
    int grid[][] = new int[SIZE][SIZE];
    int curPlayer;
    int statusCode;
    int newMoveX,newMoveY;
    int newBlockX,newBlockY;
    int p1PosX , p1PosY;
    int p2PosX , p2PosY;

    public void init(){

        int i,j;
        for(i=0;i<SIZE;i++){
            for(j=0;j<SIZE;j++){
                grid[i][j] =0;
            }
        }
        curPlayer = 1;

        p1PosX = 6;
        p1PosY = 3;

        p2PosX = 0;
        p2PosY = 3;

        grid[p1PosX][p1PosY] = 1;
        grid[p2PosX][p2PosY] = 2;

    }

    public int getCurPlayer() {
        return curPlayer;
    }

    public void setCurPlayer(int curPlayer) {
        this.curPlayer = curPlayer;
    }

    public int togglePlayer(){
        int i = getCurPlayer();
        if(i==1)
            setCurPlayer(2);
        else setCurPlayer(1);

        return curPlayer;
    }


    boolean isMoveValid()
    {
        int x = newMoveX;
        int y = newMoveY;

        if(x>6 || x<0){    //index out of bounds
            return false;
        }
        if(y>6 || y<0){
            return false;
        }

        if(grid[x][y] != 0){ //actual validation
            return false;
        }
        int p = getCurPlayer();

        if(p==1){
            if(Math.abs(newMoveX-p1PosX)>1 || Math.abs(newMoveY-p1PosY)>1 )
                return false;
        }

        if(p==2){
            if(Math.abs(newMoveX-p2PosX)>1 || Math.abs(newMoveY-p2PosY)>1 )
                return false;
        }

        return true;
    }


    public boolean isBlockValid(){

        int x = newBlockX;
        int y = newBlockY;

        if(x>6 || x<0){    //index out of bounds
            return false;
        }
        if(y>6 || y<0){
            return false;
        }

        if(grid[x][y] == 0){ //actual validation
            return true;
        }
        return false;
    }


    public void updateGridMove(){


        int p = curPlayer;
        if(p==1){
            grid[p1PosX][p1PosY] = 0;
            p1PosX = newMoveX;
            p1PosY = newMoveY;
            grid[p1PosX][p1PosY] = 1;
        }

        if(p==2){
            grid[p2PosX][p2PosY] = 0;
            p2PosX = newMoveX;
            p2PosY = newMoveY;
            grid[p2PosX][p2PosY] = 2;
        }
    }

    public void updateGridBlock(){

        grid[newBlockX][newBlockY] = -1;
    }

    public boolean isWinner(){


        int opp = getCurPlayer();
        if(opp==1)
            opp = 2;
        else opp =1;

        int i,j;
        for(i=-1;i<2;i++){
            for(j=-1;j<2;j++){
                if(grid[newMoveX+i][newMoveY+j] == 0)
                    return false;
            }
        }

        return true;

    }

    public int gameMove(int a,int b){

        newMoveX = a;
        newMoveY = b;

        if(!isMoveValid()){
            statusCode = -1;
        }
        else{
            updateGridMove();
            statusCode = 0;
        }
        return statusCode;
    }

    public int gameBlock(int a, int b){

        newBlockX = a;
        newBlockY = b;

        if(!isBlockValid()){
            statusCode = -2;
        }

        else{
            updateGridBlock();
            if(isWinner()){
                statusCode = getCurPlayer();
            }
            togglePlayer();
            statusCode = 0;
        }
        return statusCode;
    }


}