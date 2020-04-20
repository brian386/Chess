package chessSketch;

public class Pawn extends Piece {
	boolean firstMove;
	public Pawn(int _posX, int _posY, int _color) {
		super(_posX, _posY, _color);
		firstMove = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	char getType() {
		// TODO Auto-generated method stub
		return this.getColor() == 0? 'p' : 'P';
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
		if(this.getColor() == 0) {
			if(board[x2][y2] == null) {
				if((x2 - x1 == 1 && y2== y1) || (x2-x1 == 2 && firstMove && y2==y1)) ans =true;
				else ans = false;
			}else {
				if(x2-x1 == 1 && y2-y1 ==1) ans = true;
				else ans = false;
			}
		}
		
		if(this.getColor() == 1) {
			if(board[x2][y2] == null) {
				if((x1 - x2 == 1 && y2==y1) || (x1-x2 == 2 && firstMove && y2==y1)) ans =true;
				else ans = false;
			}else {
				if(x1-x2 == 1 && y1-y2 ==1) ans = true;
				else ans = false;
			}
			
		}
		
		return ans;
	}

}
