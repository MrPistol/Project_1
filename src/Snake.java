import java.awt.Color;
import java.awt.Graphics2D;

public class Snake {

  private int[][] coordinates;
  private int numbers;
  private Color color;
  private int size;
  private int dx;
  private int dy;
  private int score;


  public Snake() {
    numbers = 3;
    coordinates = new int[numbers][2];
    for (int[] position : coordinates) {
      position[0] = 420;
      position[1] = 0;
    }
    color = Color.white;
    dx = 1;
    dy = 0;
    size = 54;
    score = 0;
  }

  public void move() {
    for (int i = 0; i < coordinates.length; ++i) {
      int prevX = coordinates[i][0];
      int prevY = coordinates[i][1];
      int nextX = coordinates[i][0] + dx * size;
      int nextY = coordinates[i][1] + dy * size;
      coordinates[i][0] = nextX;
      coordinates[i][1] = nextY;
      if (i > 0) {
        coordinates[i - 1][0] = prevX;
        coordinates[i - 1][1] = prevY;
      }
    }

  }

  public void controller(int keyCode, int up, int right, int down, int left) {
    if (keyCode == up) {
      if (dy != 1) {
        dx = 0;
        dy = -1;
      }
    }
    if (keyCode == right) {
      if (dx != -1) {
        dx = 1;
        dy = 0;
      }
    }
    if (keyCode == down) {
      if (dy != -1) {
        dx = 0;
        dy = 1;
      }
    }
    if (keyCode == left) {
      if (dx != 1) {
        dx = -1;
        dy = 0;
      }
    }
  }

  public void eatApples(Apples apples) {
    if (coordinates[coordinates.length - 1][0] + size > apples.getX()
        && coordinates[coordinates.length - 1][0] < apples.getX() + size
        && coordinates[coordinates.length - 1][1] < apples.getY() + size
        && coordinates[coordinates.length - 1][1] + size > apples.getY()) {
      int[][] tempArray = copyArray(coordinates);
      apples.setX(-100);
      int currentX = coordinates[coordinates.length - 1][0];
      int currentY = coordinates[coordinates.length - 1][1];
      numbers++;
      score++;
      coordinates = new int[numbers][2];

      coordinates = copyArrayPlusOne(tempArray);
      coordinates[coordinates.length - 1][0] = currentX;
      coordinates[coordinates.length - 1][1] = currentY;
    }
  }

  public int[][] copyArray(int[][] array) {
    int[][] copy = new int[array.length][2];
    for (int i = 0; i < array.length; ++i) {
      copy[i][0] = array[i][0];
      copy[i][1] = array[i][1];
    }
    return copy;
  }

  public int[][] copyArrayPlusOne(int[][] array) {
    int[][] copy = new int[array.length + 1][2];
    for (int i = 0; i < array.length; ++i) {
      copy[i][0] = array[i][0];
      copy[i][1] = array[i][1];
    }
    return copy;
  }


  public void drawing(Graphics2D g2, Field field) {

    for (int[] position : coordinates) {

      if (position[0] >= 420 && position[0] < 1500 && position[1] >= 0 && position[1] < 1080) {
        g2.setColor(color);
        g2.fillRect(position[0], position[1], size, size);
        g2.fillRect(position[0], position[1], size, size);
      } else if (position[0] > 1450) {
        position[0] = 420;
      } else if (position[0] < 420) {
        position[0] = 1500;
      } else if (position[1] < 0) {
        position[1] = 1080;
      } else if (position[1] > 1080) {
        position[1] = 0;
      }
    }

    g2.drawString("Apples: "+score,20,40);

  }
}
