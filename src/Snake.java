import java.awt.Color;
import java.awt.Graphics2D;

public class Snake {

  private int[][] coordinates;
  private int numbers;
  private Color color;
  private int size;
  private int dx;
  private int dy;


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
  }

  public void setNumbers(int numbers) {
    this.numbers = numbers;
  }

  public void move() {
    for (int i = 0; i < numbers; ++i) {
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

  }
}
