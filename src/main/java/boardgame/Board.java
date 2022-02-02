package boardgame;

import lombok.Getter;
import lombok.Setter;

public class Board {
  @Getter @Setter private int rows;
  @Getter @Setter int columns;
  private Piece[][] pieces;

  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    pieces = new Piece[rows][columns];
  }	
  
  public Piece piece(int row, int column) {
    return pieces[row][column];
  }

  public Piece piece(Position position){
    return pieces[position.getRow()][position.getColumn()];
  }
}
