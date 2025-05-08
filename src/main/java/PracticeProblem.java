public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {
		int col = 0;
		int row = arr.length -1;
		int moves = 0;
		return searchMazeMovesHelper(arr, row, col, moves); 
	}

	public static int searchMazeMovesHelper (String [][] arr, int col, int row, int moves) {
		if (col >= arr[row].length || row >= arr.length || col < 0 || row < 0) {
			return -1;
		}

		if (arr[col][row].equals("F")) {
			return moves;
		}

		if (arr[row][col].equals("*")) {
			return -1;
		}

		int right = searchMazeMovesHelper(arr, col + 1, row, moves +1);
		int up = searchMazeMovesHelper(arr, col, row - 1, moves+1);

		if (right != -1 && up != -1) {
			return Math.min(right, up);
		}
		else if (right == -1) {
			return up;
		}
		else {
			return right;
		}
	}

	public static int noOfPaths(String[][] arr) {
		int col = 0;
		int row = arr.length -1;
		return noOfPathsHelper(arr, row, col); 
	}

	public static int noOfPathsHelper(String[][] arr, int row, int col) {
		if (col >= arr[row].length || row >= arr.length || col < 0 || row < 0) {
			return -1;
		}

		if (arr[col][row].equals("F")) {
			return 1;
		}

		if (arr[row][col].equals("*")) {
			return -1;
		}

		int right = noOfPathsHelper(arr, col + 1, row);
		int up = noOfPathsHelper(arr, col, row - 1);

		if (right == -1) {
			right = 0;
		}
		if (right == -1) {
			up = 0;
		}
		return right+up;

	}
}
