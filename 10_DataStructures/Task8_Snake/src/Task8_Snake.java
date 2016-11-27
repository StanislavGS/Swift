
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import javax.swing.Timer;
import java.util.Random;

public class Task8_Snake extends Frame implements ActionListener, MouseListener {

    final static int WIDTH = 60, HEIGHT = 20;
    Timer tm = new Timer(250, this);
    //int x=50,velX=3,y=50;
    Deque<Veneer> snake = new ArrayDeque<>();
    int directionOfSnake = 1;//0-up, 1-right, 2-down, 3-left
    Veneer apple = new Veneer(0, 0);
    static Random rand = new Random();
    Boolean isFnish = false;
    String strFinish = "";

    public static void main(String args[]) {
        new Task8_Snake();
    }

    public Task8_Snake() {
        super("Snake Task 8");
        //initialization of snake;
        int x = rand.nextInt(WIDTH / 3), y = rand.nextInt(HEIGHT);
        for (int i = 0; i < 5; i++) {
            snake.add(new Veneer(x, y));
            x++;
        }
        setSize(WIDTH * 20, HEIGHT * 20);
        this.apple.setX(rand.nextInt(WIDTH));
        this.apple.setY(rand.nextInt(HEIGHT));
        setResizable(false);
        setVisible(true);
        addMouseListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        }
        );
    }

    public void paint(Graphics g) {
        if (isFnish) {
            g.drawString(strFinish, 50, 50);
            tm.stop();
            return;
        }
        g.setColor(Color.blue);
        for (int j = 20; j < this.getWidth(); j += 20) {
            g.drawLine(j, 0, j, this.getHeight());
        }
        for (int j = 20; j < this.getHeight(); j += 20) {
            g.drawLine(0, j, this.getWidth(), j);
        }
        for (Veneer sn : snake) {
            g.fillRoundRect(sn.getX() * 20 + 21, sn.getY() * 20 + 21, 18, 18, 5, 5);
        }
        g.setColor(Color.ORANGE);
        g.fillRoundRect(apple.getX() * 20 + 22, apple.getY() * 20 + 22, 18, 18, 5, 5);
        tm.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Veneer newPositionOfHead = new Veneer(snake.peekLast().getX(), snake.peekLast().getY());
        newPositionOfHead.setX(newPositionOfHead.getX() + (2 - directionOfSnake) % 2);
        newPositionOfHead.setY(newPositionOfHead.getY() + (1 - directionOfSnake) % 2);

        if (newPositionOfHead.getX() < 0 || newPositionOfHead.getX() >= WIDTH
                || newPositionOfHead.getY() < 0 || newPositionOfHead.getY() >= HEIGHT) {

            strFinish = "Snake is out of bounds.";
            isFnish = true;
        }

        if (snake.contains(newPositionOfHead)) {
            strFinish = "Snake eat herself.";
            isFnish = true;
        }
        snake.add(newPositionOfHead);
        if (newPositionOfHead.equals(apple)) {
            do {
                apple = new Veneer(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
            } while (snake.contains(apple));
        } else {
            snake.poll();
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //isFnish=true;strFinish=e.getX()+","+e.getY();
        changeDirection(e.getX() / 20, e.getY() / 20);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        changeDirection(e.getX() / 20, e.getY() / 20);
    }

    private void changeDirection(int x, int y) {
        Veneer head = snake.peekLast();
        int in = directionOfSnake;
        if (x + y > head.getX() + head.getY() && x - y < head.getX() - head.getY()) {
            in = 0;//isFnish=true;strFinish=directionOfSnake+",---"+in+","+x+","+y+","+head[0]+","+head[1];
        } else if (x + y > head.getX() + head.getY() && x - y > head.getX() - head.getY()) {
            in = 1;
        } else if (x + y < head.getX() + head.getY() && x - y > head.getX() - head.getY()) {
            in = 2;
        } else if (x + y < head.getX() + head.getY() && x - y < head.getX() - head.getY()) {
            in = 3;
        }
        if (Math.abs(directionOfSnake - in) != 2) {
            directionOfSnake = in;
        }
        //isFnish=true;strFinish=directionOfSnake+",---"+in+","+x+","+y+","+head[0]+","+head[1];
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
