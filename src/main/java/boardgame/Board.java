package boardgame;

import lombok.Getter;

public class Board {
  @Getter
  private int rows;
  @Getter
  int columns;
  private Piece[][] pieces;

  public Board(int rows, int columns) {
    if (rows < 1 || columns < 1){
      throw new BoardException("Erro criando tabuleiro é necessário que haja pelo menos 1 linha e 1 coluna.");
    }
    this.rows = rows;
    this.columns = columns;
    pieces = new Piece[rows][columns];
  }

  public Piece piece(int row, int column) {
    if(!positionExists(row, column)){
      throw new BoardException("Posição inexistente.");
    }
    return pieces[row][column];
  }

  public Piece piece(Position position) {
    if(!positionExists(position)){
      throw new BoardException("Posição inexistente.");
    }
    return pieces[position.getRow()][position.getColumn()];
  }

  public void placePiece(Piece piece, Position position) {
    if (thereIsAPiece(position)){
      throw new BoardException("Ja tem uma peça na posição "+position);
    }
    pieces[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  private boolean positionExists(int row, int column) {
    return row >= 0 && row < rows && column >= 0 && column < columns;
  }

  public boolean positionExists(Position position) {
    return positionExists(position.getRow(), position.getColumn());
  }

  public boolean thereIsAPiece(Position position){
    if(!positionExists(position)){
      throw new BoardException("Posição inexistente.");
    }
    return piece(position) != null;
  }
}
