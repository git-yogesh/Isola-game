package isola;


public class isola {
	int SIZE = 7;
	int grid[][] = new int[SIZE][SIZE];
	int curPlayer = 1;
	String invalidReason = "";
	int newMoveX,newMoveY;
	int newBlockX,newBlockY;
	int p1PosX = 0, p1PosY = 3;
	int p2PosX = 6, p2PosY = 3;

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


	boolean getMoveValidation()
	{
		int x = newMoveX;
		int y = newMoveY;

		if(x>6 || x<0){	//index out of bounds
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

	public boolean getBlockValidation(){

		int x = newBlockX;
		int y = newBlockY;

		if(x>6 || x<0){	//index out of bounds
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


	public int[][] getGrid() {
		return grid;
	}



	public void resetGrid(){
		int i,j;
		for(i=0;i<SIZE;i++){
			for(j=0;j<SIZE;j++){
				grid[i][j] =0;
			}
		}
	}


	public void updateGrid(){
		if(!(getMoveValidation() && getBlockValidation()))
			return;

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
			grid[p1PosX][p1PosY] = 1;
		}

		grid[newBlockX][newBlockY] = -1;
	}

	public boolean checkWin(){


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

}
