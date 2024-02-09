import java.util.ArrayList;
import java.util.Collections;

// to represent a connect four board
class Board {
    ArrayList<Integer> state;
    // string of numbers representing the current board state.
    // see documentation for more information

    int[][] board;
    // 2D array representing the current board, where
    // 1 is a red piece, -1 is a yellow piece, and 0 is empty

    int move;
    // 1 means it is red's turn, -1 means it is yellow's turn

    final int WIDTH = 7;
    final int HEIGHT = 6;

    Board(ArrayList<Integer> state) {
        this.state = state;
        this.move = 1;
        for (int i = 0; i < this.state.size(); i++) {
            this.placeInCol(state.get(i));
            this.move = -this.move;
        }
    }

    Board(){
        this.state = new ArrayList<Integer>();
        this.board = new int[HEIGHT][WIDTH];
        this.move = 1;
    }

    // can you place a piece in the given column
    public boolean canPlay(int col){
        // if the column appears in the state at least 6 times, then the column is full
        return Collections.frequency(this.state, col) < 6;
    }

    // place a piece in the given column
    public void play(int col){
        this.state.add(col);
        this.placeInCol(col);
    }

    public void placeInCol(int col){
        for(int row=this.board.length - 1; row>=0; row--){
            if(this.board[row][col]==0){
                this.board[row][col] = this.move;
                this.move = -this.move;
                break;
            }
        }
    }

    public boolean isWinningMove(int col){

    }

    public void printBoard(){
        for (int row=0; row<this.board.length; row++){
            for (int col=0; col<this.board[row].length; col++){
                System.out.print(" " + Integer.toString(this.board[row][col]));
            }
            System.out.println();
        }
    }
}