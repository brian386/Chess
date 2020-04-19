/**
 * 
 */
package chessSketch;

import java.util.*;

/**
 * @author
 *
 */

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static Piece[][] board = new Piece[8][8];
	public static ArrayList<Piece> pList = new ArrayList<Piece>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        //add Pieces
		pList.add(new Rook(0, 0, 0));
		pList.add(new Rook(0, 7, 0));
		pList.add(new Knight(0, 1, 0));
		pList.add(new Knight(0, 6, 0));
		pList.add(new Bishop(0,2, 0));
		pList.add(new Bishop(0, 5, 0));
		pList.add(new Queen(0, 3, 0));
		pList.add(new King(0, 4, 0));
		
		pList.add(new Rook(7, 0, 1));
		pList.add(new Rook(7, 7, 1));
		pList.add(new Knight(7, 1, 1));
		pList.add(new Knight(7, 6, 1));
		pList.add(new Bishop(7, 2, 1));
		pList.add(new Bishop(7, 5, 1));
		pList.add(new King(7, 4, 1));
		pList.add(new Queen(7, 3, 1));
		
		for(int i = 0; i <= 7; i++) {
			pList.add(new Pawn(1, i, 0));
			pList.add(new Pawn(6, i, 1));
		}
		//String str;
		
		while (true) {
			//str = sc.nextLine();
			for (Piece p : pList) {
				board[p.getPosX()][p.getPosY()] = p;
				; // System.out.println(p.getType());
			}
			// Display board
			displayBoard();
			
			int move = sc.nextInt();
			int initialY = move / 1000;
			int initialX = move % 1000 / 100;
			int finalY = move % 100 / 10;
			int finalX = move % 10;

//			int initialY =  str.charAt(0)-97;
//			int initialX = str.charAt(1)-48;
//			int finalY = str.charAt(2)-97;
//			int finalX = str.charAt(3)-48;

			System.out.println(initialX + " " + initialY + " " + finalX + " " + finalY);
		
			if (board[initialX][initialY] != null && board[initialX][initialY].checkLegal(initialX, initialY, finalX, finalY) && 
					(board[finalX][finalY] == null || board[finalX][finalY].getColor() != board[initialX][initialY].getColor())){
				board[initialX][initialY].makeMove(finalX, finalY);
				board[initialX][initialY] = null;
				clearScreen();
			} else {
				System.out.println("Illegal Move");
				clearScreen();
				

			}
		}
	}

	public static void displayBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == null)
					System.out.print("-|");
				else
					System.out.print(board[i][j].getType() + "|");
			}
			System.out.println();
			// System.out.println("-----------------");
		}

	}

	public static void clearScreen() {
		//?????
	}
	


}
