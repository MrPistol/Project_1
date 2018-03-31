import java.awt.Color;
import java.awt.Graphics2D;

public class Apples {

  private int x;
  private int y;
  private int size;
  private Color color;


  public Apples() {

    size = 54;
    x = randomCell(19)+420 ;
    y = randomCell(19) ;
    color = Color.red;

  }

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

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int randomCell(int min, int max) {
    return (int) (min + Math.random() * (max - min + 1)) * size;
  }

  public int randomCell(int max) {
    return (int) (Math.random() * (max + 1)) * size;
  }

  public void drawing(Graphics2D g2) {
    g2.setColor(color);
    g2.fillRect(x, y, size, size);
  }


}
