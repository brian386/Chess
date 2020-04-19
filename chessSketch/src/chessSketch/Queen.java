package chessSketch;

public class Queen extends Piece {

	public Queen(int _posX, int _posY, int _color) {
		super(_posX, _posY, _color);
		// TODO Auto-generated constructor stub
	}

	@Override
	char getType() {
		// TODO Auto-generated method stub
		return this.getColor() == 0? 'q' : 'Q';
	}

	@Override
	boolean checkLegal(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		boolean ans = true;
		
		if((x2 - x1 == 0 || y2-y1 == 0) || (Math.abs(x2-x1) == Math.abs(y2-y1))) ans = true;
		else ans = false;
		
		int i = y2-y1 == 0 ? Math.min(x1, x2) + 1 : x1;
		int j = (x2 - x1 == 0) ? Math.min(y1, y2) +1: y1;

		if (x2 - x1 == 0) {
			while (j < Math.max(x1, x2)) {
				if (board[i][j] != null)
					ans = false;
				//System.out.println(i);
				j++;
			}
			//System.out.print("a");
		}

		if (y2 - y1 == 0) {
			while (i < Math.max(y1, y2)) {
				if (board[i][j] != null)
					ans = false;
				//System.out.println(j);
				i++;
			}
			//System.out.print("a");
		}
		
		
		if(x2>x1 && y2>y1) {
			i += 1;
			j += 1;
			while(i < x2 && j < y2) {
				if(board[i][j] != null) ans = false;
				//System.out.print("a");
				i++;
				j++;
			}
		}
		
		if(x2<x1 && y2 >y1) {
			i -=1;
			j +=1;
			while(i > x2 && j < y2) {
				if(board [i][j] != null) ans = false;
				//System.out.print("a");
				i--;
				j++;
			}
		}
		
		if(x2>x1 && y2<y1) {
			i++;
			j--;
			while( i < x2 && j > y2) {
				if(board[i][j] != null) ans = false;
				//System.out.print("a");
				i++;
				j--;
			}
			
		}
		
		if(x2 < x1 && y2 < y1) {
			i--;
			j--;
			while( i > x2 && j > y2) {
				if(board[i][j] != null) ans = false;
				//System.out.print("a");
				i--;
				j--;
			}
		}
	
		return ans;
	}
	
	

}
