/*
 



 */
package game;


public class Game {
   
    public int turn = 0; 
    // zero for 0 
    // 1 for X
    private boolean tie;
    private int winnerInput;
    private String winner;
    
    public static void main(int[] args) {
        
        int[][] board= new int[3][3];
        User user = new User();
        AI ai = new AI();
    
    
    }
    public void showWinner(){
        if(winnerInput == 0 ){
            winner = "O";
        }
        else{
            winner = "X";
        }
    }
   
    
    public boolean checkSmall(int a, int b, int c){
        if((a == b) && (b==c)){
            winnerInput = a;
            return true;
        }
            return false;
    }
    
    private boolean checkrows(int[][] board){
        for(int i=0; i<3; i++){
            if(checkSmall(board[0][i], board[1][i], board[2][i]))
                tie=false; 
                return true;
            }
        tie=true;
        return false; 
        
    }
    
    private boolean checkcolumn(int[][] board){
        for(int i=0; i<3; i++){
            if(checkSmall(board[i][0], board[i][1], board[i][2])){
                tie=false;
                return true;
            }
        }
        tie=false;
        return false;
    } 
    private boolean checkDiagonal(int[][] board){
        
            if(checkSmall(board[0][0],board[1][1], board[2][2])){
                tie=false;
                return true;
            }
            if(checkSmall(board[0][2], board[1][1], board[2][0])){ 
                tie = false;
                return true;
            }
    tie=true;
    return false;
    }
}
