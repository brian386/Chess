package chessSketch;

public class King extends Piece {
	boolean firstMove;
	public King(int _posX, int _posY, int _color) {
		super(_posX, _posY, _color);
		// TODO Auto-generated constructor stub
		firstMove = true;	
	}

	@Override
	char getType() {
		// TODO Auto-generated method stub
		return this.getColor() == 0? 'k' : 'K';
	}
	
	@Override
	void makeMove(int x,int y) {
		super.makeMove(x, y);
		firstMove = false;
	}
	@Override
	boolean checkLegal(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
		//Check if final pos is either blank or opposite color
		if(!(board[x2][y2] == null || board[x2][y2].getColor() != this.getColor())) return false;
		
		//Check normal move
		if(((x2 - x1 == 0 || y2-y1 == 0) && Math.abs(x2-x1+y2-y1) == 1)|| (Math.abs(x2-x1) == Math.abs(y2-y1) && Math.abs(x2-x1)==1) ) return true;
		else return false;
	}
	
	boolean inCheck() {
		for(Piece p : pList) {
			if(p.getColor() != this.getColor() && p.checkLegal(p.getPosX(), p.getPosY(), this.getPosX(), this.getPosY())) {
				return true;
			}
			
		}
		
		return false;
	}

}
