import java.util.ArrayList;

//Grid Class
public class Grid {
	public final int TILE_SIZE;
	public Tile[][] grid;
	public Set setW;
	public Set setB;
	public Tile selectedTile;

	//Constructor
	public Grid(int TILE_SIZE){
		grid = new Tile[8][8];
		setW = new Set('w');
		setB = new Set('b');
		this.TILE_SIZE = TILE_SIZE;

		setBaseGrid();
		initPieces();

		//Add pieces to grid
		for (int x = 0; x < setW.pieces.size(); x++){
			grid[setW.pieces.get(x).x][setW.pieces.get(x).y] = setW.pieces.get(x);
			grid[setB.pieces.get(x).x][setB.pieces.get(x).y] = setB.pieces.get(x);
		}
	}	

	//Return a copy of this grid
	public Grid getDummyGrid(){
		Grid copy = new Grid(TILE_SIZE);
		copy.grid = new Tile[8][8];
		copy.setW = new Set('w');
		copy.setB = new Set('b');
		copy.setBaseGrid();

		//Copy whites
		for (int x = 0; x < this.setW.pieces.size(); x++){
			Piece equivalentW = this.setW.pieces.get(x);
			copy.setW.pieces.add(new Piece(equivalentW.x, equivalentW.y, TILE_SIZE, 'w', equivalentW.type, copy));	
			copy.grid[copy.setW.pieces.get(x).x][copy.setW.pieces.get(x).y] = copy.setW.pieces.get(x);
                       
			if (equivalentW.type.equals("king")){
				copy.setW.king = copy.setW.pieces.get(x);
			}
		}

		//Copy blacks
		for (int x = 0; x < this.setB.pieces.size(); x++){
                        Piece equivalentB = this.setB.pieces.get(x);
                        copy.setB.pieces.add(new Piece(equivalentB.x, equivalentB.y, TILE_SIZE, 'b', equivalentB.type, copy));
                        copy.grid[copy.setB.pieces.get(x).x][copy.setB.pieces.get(x).y] = copy.setB.pieces.get(x);

                        if (equivalentB.type.equals("king")){
                                copy.setB.king = copy.setB.pieces.get(x);
                        }
		}

		return copy;
	}

	//Set basic grid to non-null tiles
	private void setBaseGrid(){
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[0].length; y++){
				grid[x][y] = new Tile(x, y, TILE_SIZE);
			}
		}
	}

	private void initPieces(){
		//Pawns
		for (int x = 0; x < grid.length; x++){
                        setW.pieces.add(new Piece(x, 1, TILE_SIZE, 'w', "pawn", this));
                	setB.pieces.add(new Piece(x, 6, TILE_SIZE, 'b', "pawn", this));
		}

		//Bishops
		setW.pieces.add(new Piece(2, 0, TILE_SIZE, 'w', "bishop", this));
                setW.pieces.add(new Piece(5, 0, TILE_SIZE, 'w', "bishop", this));
                setB.pieces.add(new Piece(2, 7, TILE_SIZE, 'b', "bishop", this));
                setB.pieces.add(new Piece(5, 7, TILE_SIZE, 'b', "bishop", this));

		//Knights
		setW.pieces.add(new Piece(1, 0, TILE_SIZE, 'w', "knight", this));
                setW.pieces.add(new Piece(6, 0, TILE_SIZE, 'w', "knight", this));
                setB.pieces.add(new Piece(1, 7, TILE_SIZE, 'b', "knight", this));
                setB.pieces.add(new Piece(6, 7, TILE_SIZE, 'b', "knight", this));
	
		//Rooks
		setW.pieces.add(new Piece(0, 0, TILE_SIZE, 'w', "rook", this));
                setW.pieces.add(new Piece(7, 0, TILE_SIZE, 'w', "rook", this));
                setB.pieces.add(new Piece(0, 7, TILE_SIZE, 'b', "rook", this));
                setB.pieces.add(new Piece(7, 7, TILE_SIZE, 'b', "rook", this));
	
		//Queens
		setW.pieces.add(new Piece(4, 0, TILE_SIZE, 'w', "queen", this));
                setB.pieces.add(new Piece(4, 7, TILE_SIZE, 'b', "queen", this));
                
		setW.king = new Piece(3, 0, TILE_SIZE, 'w', "king", this);
		setW.pieces.add(setW.king);

		setB.king = new Piece(3, 7, TILE_SIZE, 'b', "king", this);
                setB.pieces.add(setB.king);
	}
}
