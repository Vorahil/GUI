import basic.Basic;
import basic.Listener;
import component.*;
import component.Dialog;
import component.Menu;
import component.Panel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
//        Frame frame = Basic.show(Optional.empty(), Optional.of(true), Optional.of(5));
//        Listener.listen(frame);

//        Layout.border();
//        Layout.flow();
//        Layout.card();
//        Layout.grid();

//        Panel.panel();
//        Panel.scroll();

//        Menu.menuBar();

//        Dialog.dialog();

//        Frame frame = new Frame();//自定义组件
//        frame.add(new ImageView("test.png"));
//        frame.setBounds(100, 100, 450, 300);
//        frame.setVisible(true);

        Frame frame = new Frame("我是窗口") {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getWidth(), 28);   //先绘制标题栏
                g.setColor(Color.BLACK);
                g.drawString(getTitle(), getWidth() / 2, 20);   //绘制标题名称
                super.paint(g);   //原本的绘制别覆盖了，该怎么做还要怎么做
            }
        };
        frame.addMouseMotionListener(new MouseMotionAdapter() {   //只需要写一个监听器就可以搞定了
            int oldX, oldY;

            public void mouseDragged(MouseEvent e) {   //鼠标拖动时如果是标题栏，就将窗口位置修改
                if (e.getY() <= 28)
                    frame.setLocation(e.getXOnScreen() - oldX, e.getYOnScreen() - oldY);
            }

            public void mouseMoved(MouseEvent e) {   //记录上一次的鼠标位置
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        frame.setUndecorated(true);
        frame.setSize(200, 200);
        //注意，只有窗口在非修饰状态下才能设定形状
        //这里我们使用圆角矩形，形状最好跟窗口大小一样
        frame.setShape(new RoundRectangle2D.Double(0, 0, 200, 200, 20, 20));
        frame.setVisible(true);
    }
}
