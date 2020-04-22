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
	public static ArrayList<Piece> capturedPieces = new ArrayList<Piece>();
	static int playerTurn = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		King blackKing = new King(0, 4, 0);
		King whiteKing = new King(7, 4, 1);
		
		
        //add Pieces
		pList.add(new Rook(0, 0, 0));
		pList.add(new Rook(0, 7, 0));
		pList.add(new Knight(0, 1, 0));
		pList.add(new Knight(0, 6, 0));
		pList.add(new Bishop(0,2, 0));
		pList.add(new Bishop(0, 5, 0));
		pList.add(new Queen(0, 3, 0));
		pList.add(blackKing);
		
		pList.add(new Rook(7, 0, 1));
		pList.add(new Rook(7, 7, 1));
		pList.add(new Knight(7, 1, 1));
		pList.add(new Knight(7, 6, 1));
		pList.add(new Bishop(7, 2, 1));
		pList.add(new Bishop(7, 5, 1));
		pList.add(whiteKing);
		pList.add(new Queen(7, 3, 1));
		
//		for(int i = 0; i <= 7; i++) {
//			pList.add(new Pawn(1, i, 0));
//			pList.add(new Pawn(6, i, 1));
//		}
		String str;
		
		while (true) {

			for (Piece p : pList) {
				board[p.getPosX()][p.getPosY()] = p;
				 // System.out.println(p.getType());
			}
			// Display board
			displayBoard();
			System.out.println("Player " + playerTurn + "'s Turn");
//			int move = sc.nextInt();
//			int initialY = move / 1000;
//			int initialX = move % 1000 / 100;
//			int finalY = move % 100 / 10;
//			int finalX = move % 10;
			
			str = sc.nextLine();
			int initialCol =  str.charAt(0)-97;
			int initialRow = 8-(str.charAt(1)-48);
			int finalCol = str.charAt(2)-97;
			int finalRow = 8-(str.charAt(3)-48);

			System.out.println(initialRow + " " + initialCol + " " + finalRow + " " + finalCol);
			

			
			if (board[initialRow][initialCol] != null && board[initialRow][initialCol].checkLegal(initialRow, initialCol, finalRow, finalCol) 
				&& playerTurn == board[initialRow][initialCol].getColor() ){
				
			
				boolean didMoveCapture = board[finalRow][finalCol] != null;
				board[initialRow][initialCol].makeMove(finalRow, finalCol);

				//board[initialRow][initialCol] = null;
				
				boolean whiteKingInCheck = (playerTurn == 1 && whiteKing.inCheck());
				boolean blackKingInCheck = (playerTurn == 0 && blackKing.inCheck());
				boolean kingInCheck = whiteKingInCheck || blackKingInCheck;
				if(kingInCheck) {
					if(didMoveCapture) pList.add(capturedPieces.get(capturedPieces.size()-1));
					board[finalRow][finalCol].makeMove(initialRow, initialCol);
					System.out.println("Illegal Move (King not safe)");

				}else {
				    
					playerTurn = playerTurn == 0 ? 1 : playerTurn == 1 ? 0: 10000;
				}
			} else {
				System.out.println("Illegal Move");
				
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
