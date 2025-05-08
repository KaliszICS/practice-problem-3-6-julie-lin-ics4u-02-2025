public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {
		int row = arr.length - 1;
		int col = 0;
		int moves = 0;

		return searchMazeMovesHelper(arr, row, col, moves);
		
	}
	
	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {

		if (row < 0 || row >= arr.length || col < 0 || col >= arr[row].length || arr[row][col].equals("*")){
			return -1;
		}

		if (arr[row][col].equals("F")){
			return moves;
		}

		int right = searchMazeMovesHelper(arr, row, col + 1, moves +1);
		int up = searchMazeMovesHelper(arr, row - 1, col, moves +1);

		if (right != -1 && up != -1){
			return Math.min(right, up);
		} else if (right == -1){
			return up;
		} else {
			return right;
		}
	}
		
	public static int noOfPaths(String[][] arr) {
		int row = arr.length - 1;
		int col = 0;

		return noOfPathsHelper(arr, row, col);
		
	}
	
	public static int noOfPathsHelper(String[][] arr, int row, int col) {

		if (row < 0 || row >= arr.length || col < 0 || col >= arr[row].length || arr[row][col].equals("*")){
			return -1;
		}

		if (arr[row][col].equals("F")){
			return 1;
		}

		int right = noOfPathsHelper(arr, row, col + 1);
		int up = noOfPathsHelper(arr, row - 1, col);

		if (right == -1){
			right = 0;
		} 

		if (up == -1){
			up = 0;
		}
		return right + up;
	}
}