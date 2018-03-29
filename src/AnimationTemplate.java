import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AnimationTemplate extends JFrame {

  String title = "Snake";
  Color background = Color.black;
  int delay = 10;

  // Ваши переменные
  int size;
  Field field;

  void start() {
    // код для инициализации

    field = new Field();

  }

  void update() {
    // код для обновления свойств объектов

  }

  void draw(Graphics2D g2) {

    // код для рисования следующего кадра


    field.drawing(g2);



  }

  void input(int keyCode) {
    // код для обработки ввода
    if (keyCode == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    } // else if / switch...

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
