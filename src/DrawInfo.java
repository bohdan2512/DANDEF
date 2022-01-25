import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawInfo extends JPanel implements Runnable {

    private int x = 20;
    private int y = 20;
    private int startX = x;
    private DrawInfo.MyCanvas canvas;
//Контент вікна Task
    private class MyCanvas extends JPanel {

        public MyCanvas() {
            setDoubleBuffered(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("Arial",Font.BOLD,24));
            g.drawString("Реалізувати шифрування Даніеля Дефо",10,110);
             g.drawString("Сутність його у тому, що у зашифрованому тексті  значення мали лише літери, що стоять на парних",10,140);
             g.drawString("(або непарних) місцях. Наприклад, фраза \"КУРСОВА РОБОТА\" після зашифрування може виглядати так:",10,170);
             g.drawString("КЙУУРЕСИОЛВІАПРЮОЛБФОКТРАС",10,200);
            g.drawString("Шифрування Даніеля Дефо", x, y);
        }
    }
//Розміщення контенту
    public DrawInfo() {
        setLayout(new BorderLayout());
        canvas = new DrawInfo.MyCanvas();
        add(canvas, BorderLayout.CENTER);
        start();
    }
//Рух текстового рядка
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            x = x + 1;
            try {
                Thread.sleep(8);
            } catch (Exception e) {
            }
            if (x >= canvas.getWidth() - 335) {
                //x = startX;
                while (x!=0){
                    x = x-1;
                    try {
                        Thread.sleep(8);
                    } catch (Exception e) {
                    }
                    canvas.repaint();
                }
            }
            canvas.repaint();
        }
    }

}