package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 113
// Finish time:
public class PlanetExplorer {
	private int[][] planet;
	private int width, height;
	private int x, y;
	private int face;
	private char[] turn = {'N', 'E', 'S', 'W'};

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.planet = new int[x][y];
		int i = 0, j = 0;
		for (; i < x; i++)
		{
			for (j = 0; j < y; j++)
			{
				this.planet[i][j] = 0;
			}
		}
		int k = 0;
		int l = obstacles.length();
		for (; k < l; k++)
		{
			if (obstacles.charAt(k) == '(')
			{
				i = 0;
				j = 0;
				for (k++; obstacles.charAt(k) != ','; k++)
				{
					i *= 10;
					i += obstacles.charAt(k) - '0';
				}
				for (k++; obstacles.charAt(k) != ')'; k++)
				{
					j *= 10;
					j += obstacles.charAt(k) - '0';
				}
				this.planet[i][j] = 1;
			}
		}
		this.width = x;
		this.height = y;
		this.x = 0;
		this.y = 0;
		this.face = 0;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		int l = command.length();
		int i = 0;
		for (; i < l; i++)
		{
			if (command.charAt(i) == 'r')
			{
				this.face = (this.face + 1) % 4;
			}
			else if (command.charAt(i) == 'l')
			{
				this.face = (this.face + 3) % 4;
			}
			else if (command.charAt(i) == 'f')
			{
				if(this.face == 0)
					this.y = (this.y + 1) % height;
				if(this.face == 1)
					this.x = (this.x + 1) % width;
				if(this.face == 2)
					this.y = (this.y + height - 1) % height;
				if(this.face == 3)
					this.x = (this.x + width - 1) % width;
			}
			else if (command.charAt(i) == 'b')
			{
				if(this.face == 2)
					this.y = (this.y + 1) % height;
				if(this.face == 3)
					this.x = (this.x + 1) % width;
				if(this.face == 0)
					this.y = (this.y + height - 1) % height;
				if(this.face == 1)
					this.x = (this.x + width - 1) % width;
			}
		}
		String ans = "(" + this.x + ',' + this.y + ',' + this.turn[this.face] + ')';
		return ans;
	}
}
