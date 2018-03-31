import java.awt.Color;
import java.awt.Graphics2D;

public class Apples {

  private int x;
  private int y;
  private int size;
  private Color color;


  public Apples() {
    x = 420 + randomCell(20);
    y = randomCell(20);
    color = Color.red;
    size = 54;
  }

  public int randomCell(int min, int max) {
    return (int) (min + Math.random() * (max - min + 1)) * size;
  }

  public int randomCell(int max) {
    return (int) (Math.random() * (max + 1)) * size;
  }

  public void drawing(Graphics2D g2){
    g2.setColor(color);
    g2.fillRect(x,y,size,size);
  }
}
