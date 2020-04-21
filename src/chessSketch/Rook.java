package chessSketch;

public class Rook extends Piece {
	boolean firstMove;
	public Rook(int _posX, int _posY, int _color) {
		super(_posX, _posY, _color);
		// TODO Auto-generated constructor stub
		firstMove = true;
	}

	char getType() {
		return this.getColor() == 0? 'r' : 'R';
	}
	
	@Override
	void makeMove(int x, int y) {
		super.makeMove(x, y);
		firstMove = false;
	}
	@Override
	boolean checkLegal(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		boolean ans = true;
		//Check if final pos is either blank or opposite color
		if(!(board[x2][y2] == null || board[x2][y2].getColor() != this.getColor())) return false;
		
		//Check vertical or horizontal move
		if (x2 - x1 == 0 || y2 - y1 == 0)
			ans = true;
		else
			ans = false;

		// CHECK BLOCKING
		int i = x2-x1 == 0 ? Math.min(x1,  x2): Math.min(x1, x2) +1;
		int j = y2-y1 == 0 ? Math.min(y1,  y2):Math.min(y1, y2) +1;

		if (x2 - x1 == 0) {
			
			while (j < Math.max(y1, y2)) {
				if (board[i][j] != null)
					ans = false;

				j++;
			}
		} else if (y2 - y1 == 0) {
			while (i < Math.max(x1, x2)) {
				
				if (board[i][j] != null)
					ans = false;

				i++;
			}
		}

		return ans;
	}

}
