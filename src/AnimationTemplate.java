import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AnimationTemplate extends JFrame {

  String title = "Snake";
  Color background = Color.black;
  int delay = 200;

  // Ваши переменные
  Field field;
  Snake snake;
  Apples apples;


  void start() {
    // код для инициализации

    field = new Field();
    snake = new Snake();
    apples = new Apples();


  }

  void update() {
    // код для обновления свойств объектов
    snake.move();


  }

  void draw(Graphics2D g2) {

    // код для рисования следующего кадра


    field.drawing(g2);
    snake.drawing(g2,field);
    apples.drawing(g2);




  }

  void input(int keyCode) {
    // код для обработки ввода
    snake.controller(keyCode, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);
    if (keyCode == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }
    if (keyCode == KeyEvent.VK_NUMPAD3) {
      delay=10;
    }
    if (keyCode == KeyEvent.VK_NUMPAD6) {
      delay=50;
    }
    if (keyCode == KeyEvent.VK_NUMPAD9) {
      delay=100;
    }

    if (keyCode == KeyEvent.VK_ENTER) {
      start();
    }// else if / switch...

  }

  public AnimationTemplate() {
    setTitle(title);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    DrawPanel panel = new DrawPanel();
    panel.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        input(e.getKeyCode());
      }
    });
    add(panel);

    start();

    javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        update();
        repaint();
      }
    });
    timer.start();

    setVisible(true);
  }

  public static void main(String[] args) {
    new AnimationTemplate();
  }

  class DrawPanel extends JPanel {

    public DrawPanel() {
      setBackground(background);
      setFocusable(true);
      requestFocusInWindow();
      setDoubleBuffered(true);
    }

    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      RenderingHints hints = new RenderingHints(
          RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON
      );
      g2.setRenderingHints(hints);

      super.paintComponent(g);
      draw(g2);
    }
  }

}
