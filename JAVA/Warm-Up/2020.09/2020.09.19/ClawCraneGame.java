/* 인형의 처음 상태는 문제에 주어진 예시와 같습니다. 
 * 크레인이 [1, 5, 3, 5, 1, 2, 1, 4] 번 위치에서 차례대로 인형을 집어서 바구니에 옮겨 담은 후, 
 * 상태는 아래 그림과 같으며 바구니에 담는 과정에서 터트려져 사라진 인형은 4개 입니다.*/

package programmer;
import java.util.Stack;

public class ClawCraneGame {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<Integer>();
		for(int i=0; i<moves.length; i++) {
			int col = moves[i]-1;
			for(int row=0; row<board.length; row++) {
				if(board[row][col] != 0) {		// 스택이 비어있는경우 -> 해당 인형 넣기
					if(basket.isEmpty()) basket.push(board[row][col]);
					else {		// 스택이 비어있지 않을 경우 
						if(basket.peek() == board[row][col]) {
							basket.pop();	//인형이 동일하면 pop()
							answer += 2;
						}
						else {								//인형이 동일하지 않으면 
							basket.push(board[row][col]);	//스택에 인형 넣기
						}
					}
					board[row][col] = 0;	//인형이 뽑힌 board[][]는 0으로 만든다.
					break;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int [][] board = { 	{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 3 }, 
							{ 0, 2, 5, 0, 1 }, 
							{ 4, 2, 4, 4, 2 },
							{ 3, 5, 1, 3, 1 } 	};
		
		int [] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		
		ClawCraneGame ccg = new ClawCraneGame();
		int result = ccg.solution(board, moves);
		System.out.println(result);
	}

}
