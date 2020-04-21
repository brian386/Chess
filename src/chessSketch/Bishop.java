package chessSketch;

public class Bishop extends Piece {

	public Bishop(int _posX, int _posY, int _color) {
		super(_posX, _posY, _color);
		// TODO Auto-generated constructor stub
	}

	@Override
	char getType() {
		// TODO Auto-generated method stub
		return this.getColor() == 0? 'b' : 'B';
	}

	@Override
	boolean checkLegal(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
		//Check if final pos is either blank or opposite color
		if(!(board[x2][y2] == null || board[x2][y2].getColor() != this.getColor())) return false; 
		
		boolean ans = true;
		if(Math.abs(x2-x1) == Math.abs(y2-y1)) {
			ans = true;
		} else ans = false;
		
		
		int i = x1;
		int j = y1;
		
		//Check blocking
		if(x2>x1 && y2>y1) {
			i += 1;
			j += 1;
			while(i < x2 && j < y2) {
				if(board[i][j] != null) ans = false;
				i++;
				j++;
			}
		}
		
		if(x2<x1 && y2 >y1) {
			i -=1;
			j +=1;
			while(i > x2 && j < y2) {
				if(board [i][j] != null) ans = false;
				i--;
				j++;
			}
		}
		
		if(x2>x1 && y2<y1) {
			i++;
			j--;
			while( i < x2 && j > y2) {
				if(board[i][j] != null) ans = false;
				i++;
				j--;
			}
			
		}
		
		if(x2 < x1 && y2 < y1) {
			i--;
			j--;
			while( i > x2 && j > y2) {
				if(board[i][j] != null) ans = false;
				i--;
				j--;
			}
		}
		return ans;
		
	}

}
