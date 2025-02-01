package basic;

import java.awt.*;
import java.awt.event.*;

public class Listener {
    static Frame frame;

    public static void listen(Frame frame) {
        Listener.frame = frame;
        frame.addWindowListener(new WindowListener() {
            @Override//须在frame.setVisible(true)之前才会执行
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("窗口最小化");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("从最小化恢复");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗口失活");
            }

        });

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("键盘键入");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("键盘键出");
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX()+" "+e.getY());
                //1\2\3对应左中右
                System.out.println(e.getButton());
            }
        });

        //监听滚轮
        frame.addMouseWheelListener(e -> System.out.println(e.getScrollAmount()));
    }
}
