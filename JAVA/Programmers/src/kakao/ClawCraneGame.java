package kakao;

import java.util.Stack;

public class ClawCraneGame {

	public static int solution(int[][] board, int[] moves) {

		int answer = 0;
		int pick = 0; // 잡은 인형 번호
		int col = 0;

		Stack<Integer> basket = new Stack<Integer>();

		for (int i = 0; i < moves.length; i++) {
			col = moves[i] - 1;

			for (int row = 0; row < board.length; row++) {
				if (board[col][row] != 0) {
					pick = board[col][row];
					board[col][row] = 0;
				}
				
				if(basket.isEmpty()) basket.push(pick);
				else if(basket.peek()==pick) {
					basket.pop();
					answer += 2;
				}
			}

		}

		return answer;
	}

	public static void main(String[] args) {

		// 입출력 예시
		int[][] board = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 3 }, 
				{ 0, 2, 5, 0, 1 }, 
				{ 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		
		System.out.println(ClawCraneGame.solution(board, moves));

	}

}
