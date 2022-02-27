import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Piece Class
public class Piece extends Tile{
	public enum Direction {
		UP, 
		DOWN 
	}

	public Direction dir;
	public final char color;

	//Constructor
	public Piece(int posX, int posY, Grid grid, char color){
		super(posX, posY, grid);
		this.color = color;
		dir = color == 'w' ? Direction.DOWN : Direction.UP;

		setSelected(false);
	}

	//Returns all possible move coordinates
	public ArrayList<Tile> possibleMoves(){
		return new ArrayList<Tile>();
	}

	//Move tile to new location
	public void move(int newX, int newY){
		grid.grid[posX][posY] = new Tile(posX, posY, grid);
		grid.grid[newX][newY] = this;
		this.posX = newX;
		this.posY = newY;
	}
}
