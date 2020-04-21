package chessSketch;

public class Knight extends Piece {

	public Knight(int _posX, int _posY, int _color) {
		super(_posX, _posY, _color);
		// TODO Auto-generated constructor stub
	}

	@Override
	char getType() {
		// TODO Auto-generated method stub
		return this.getColor() == 0? 'n' : 'N';
	}

	@Override
	boolean checkLegal(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		//Check if final pos is either blank or opposite color
		if(!(board[x2][y2] == null || board[x2][y2].getColor() != this.getColor())) return false;
		
		//Check normal move
		if((Math.abs(x2-x1)==1 && Math.abs(y2-y1) == 2) || (Math.abs(x2-x1) == 2 && Math.abs(y2-y1) == 1)){
			return true;
					
		}else return false;
	}

}
