package component;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Layout {
    public static void border(){//优先居中排列
        Frame frame = new Frame("Border");
        frame.setBounds(100, 100, 500, 500);
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setVgap(5);//纵向布局
        borderLayout.setHgap(10);//横向布局
        frame.setLayout(borderLayout);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        frame.add(new Button("ButtonS"), BorderLayout.SOUTH);
        frame.add(new Button("ButtonE"), BorderLayout.EAST);
        frame.add(new Button("ButtonW"), BorderLayout.WEST);
        frame.add(new Button("ButtonN"), BorderLayout.NORTH);
        frame.add(new Button("ButtonC"),BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void flow(){//一个接一个
        Frame frame = new Frame("Flow");
        frame.setBounds(100, 100, 500, 500);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);//左对齐
        frame.setLayout(flowLayout);

        frame.add(new Button("Button1"));
        frame.add(new Button("Button2"));
        frame.add(new Button("Button3"));
        frame.add(new Button("Button4"));
        frame.add(new Button("Button5"));
        frame.add(new Button("Button6"));
        frame.add(new Button("Button7"));
        frame.add(new Button("Button8"));
        frame.add(new Button("Button9"));

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void card() throws InterruptedException {//卡片
        Frame frame = new Frame("Card");
        frame.setVisible(true);
        frame.setBounds(100, 100, 500, 500);
        CardLayout cardLayout = new CardLayout();
        frame.setLayout(cardLayout);

        frame.add(new Label("Card1"));
        frame.add(new Label("Card2"));
        frame.add(new Label("Card3"));
        frame.add(new Label("Card4"));

        while (true) {
            Thread.sleep(3000);
            cardLayout.next(frame);//每三秒一个新的卡片
        }

    }

    public static void grid(){//表格
        Frame frame = new Frame("Grid");
        frame.setVisible(true);
        frame.setBounds(100, 100, 1000, 600);

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(2);
        frame.setLayout(gridLayout);
        for (int i = 0; i < 9; i++) {
            frame.add(new Button("Button" + i));
        }

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
