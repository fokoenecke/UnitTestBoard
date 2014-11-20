public class Board{ 
	int n = 3;
	private String[][] board = new String[n][n];
	private boolean hasWinner = false;
	
	public Board(){} 
	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		
		boolean set = false;
		if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
			if (mark.equals("X") || mark.equals("O")) {
				if (null == board[x][y]) {
					board[x][y] = mark;
					set = true;
				}	
			}
		}
		if (!set) throw new InvalidPositionException("fehlerhafte eingabe");

    	for(int i = 0; i < n; i++){
    		if(board[x][i] != mark)
    			break;
    		if(i == n-1){
    			hasWinner = true;
    		}
    	}

    	for(int i = 0; i < n; i++){
    		if(board[i][y] != mark)
    			break;
    		if(i == n-1){
    			hasWinner = true;
    		}
    	}

    	if(x == y){
    		for(int i = 0; i < n; i++){
    			if(board[i][i] != mark)
    				break;
    			if(i == n-1){
    				hasWinner = true;
    			}
    		}
    	}

    	for(int i = 0;i<n;i++){
    		if(board[i][(n-1)-i] != mark)
    			break;
    		if(i == n-1){
    			hasWinner = true;
    		}
    	}

	}
	
	public boolean hasWinner() {
		return hasWinner;
	} 
} 