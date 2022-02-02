package chess;

import boardgame.Board;
import boardgame.Piece;
import lombok.Getter;

public class ChessPiece extends Piece{
  @Getter private Color color;

  public ChessPiece(Board board, Color color) {
    super(board);
    this.color = color;
  }

  
}
