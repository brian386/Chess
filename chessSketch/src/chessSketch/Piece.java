package chessSketch;

public abstract class Piece extends Main {
	private int posX, posY, color;
	
	Piece(int _posX, int _posY, int _color){
		
		posX = _posX;
		posY= _posY;
		color = _color;
		
	}
	//accessors
	int getPosX() {
		return this.posX;
	}
	int getPosY() {
		return this.posY;
	}
	int getColor() {
		return this.color;
	}
	
	abstract char getType();
	
	//move
	void makeMove(int x, int y) {
	    pList.remove(board[x][y]);
		this.posX = x;
		this.posY = y;
		
	}
	abstract boolean checkLegal(int x1, int y1, int x2, int y2);
}
