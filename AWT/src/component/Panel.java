package component;

import java.awt.*;

public class Panel {
    public static void panel(){
        Frame frame = new Frame("Panel");
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 300);

        GridLayout layout = new GridLayout(2,1);
        frame.setLayout(layout);

        java.awt.Panel panel1 = new java.awt.Panel();
        panel1.setBackground(java.awt.Color.white);
        panel1.setLayout(new FlowLayout());
        panel1.add(new Button("Button1"));
        panel1.add(new Button("Button2"));
        java.awt.Panel panel2 = new java.awt.Panel();
        panel2.setBackground(Color.blue);

        frame.add(panel1);
        frame.add(panel2);

    }

    public static void scroll(){
        Frame frame = new Frame("Scroll");
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 300);

        ScrollPane pane = new ScrollPane();
        frame.add(pane);

        GridLayout top = new GridLayout(2,20);
        frame.setLayout(top);

        java.awt.Panel panel1 = new java.awt.Panel();
        panel1.setBackground(Color.blue);
        panel1.setLayout(new FlowLayout());//横向排列
        for (int i = 0; i < 20; i++) {
            Button button = new Button("Button"+i);
            button.setPreferredSize(new Dimension(100, 50));//首选大小
            panel1.add(button);

        }

        List list = new List();
        list.setMultipleMode(true) ;//多选
        list.addItemListener(System.out::println);//打印选择的列表选项
        list.add("List1");
        list.add("List2");
        list.add("List3");
        list.add("List4");
        pane.add(list);
        pane.add(panel1);
    }
}
