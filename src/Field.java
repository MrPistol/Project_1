import java.awt.Color;
import java.awt.Graphics2D;

public class Field {

  private int[][][] field;
  private Color color;


  private int size;
  private int numberOfCells;

  public Field() {
    color = Color.gray;
    numberOfCells = 20;
    int x = 420;
    int y = 0;
    size = 54;

    field = new int[numberOfCells][numberOfCells][2];

    for (int i = 0; i < numberOfCells; ++i) {
      for (int j = 0; j < numberOfCells; ++j) {
        field[i][j][1] = x;
        field[i][j][0] = y;
        y += size;
      }
      y = 0;
      x += size;
    }
  }

  public int getSize() {
    return size;
  }

  public int getNumberOfCells() {
    return numberOfCells;
  }

  public void drawing(Graphics2D g2) {

    for (int i = 0; i < numberOfCells; ++i) {
      for (int j = 0; j < numberOfCells; ++j) {
        g2.setColor(Color.darkGray);
        g2.fillRect(field[i][j][1], field[i][j][0], size, size);
        g2.setColor(Color.black);
        g2.drawRect(field[i][j][1], field[i][j][0], size, size);
      }
    }
  }


}
