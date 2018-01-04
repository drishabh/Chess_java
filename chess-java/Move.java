/**
 * @author Rishabh Dalal
 *
 */


public class Move {
	private int ox, oy, nx, ny;
	private boolean castling = false;

	/**
	 * 
	 */
	public Move(int x1, int y1, int x2, int y2) {
		this.ox = x1;
		this.oy = y1;
		this.nx = x2;
		this.ny = y2;
	}
	
	public Move(int x1, int y1, int x2, int y2, boolean castling) {
		this.ox = x1;
		this.oy = y1;
		this.nx = x2;
		this.ny = y2;
		this.castling = castling;
	}

	public int getXOld() {
		return ox;
	}

	public void setXOld(int x1) {
		this.ox = x1;
	}

	public int getXNew() {
		return nx;
	}

	public void setXNew(int x2) {
		this.nx = x2;
	}

	public int getYOld() {
		return oy;
	}

	public void setYOld(int y1) {
		this.oy = y1;
	}

	public int getYNew() {
		return ny;
	}

	public void setYNew(int y2) {
		this.ny = y2;
	}
	
	public boolean isCastling() {
		return castling;
	}
	
	public String toString(){ // TODO change to a1 to b4 etc
		//return x1 + " " + y1 + " " + x2 + " " + y2;
		return (char)('A'+ox) + "" + (oy+1) + " " + (char)('A'+nx) + "" + (ny+1);
	}
	
	public boolean equals(Object o){
		Move op = (Move) o;
		
		if(op.getXOld() == ox && op.getYOld() == oy && op.getXNew() == nx && op.getYNew() == ny){
			return true;
		}
		else
			return false;
	}
}
