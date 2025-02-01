package Basic;

import javax.swing.*;

public class Basic {
    public static void basic() {
        JFrame frame = new JFrame("我是窗口");   //Swing中的窗口叫做JFrame，对应的就是AWT中的Frame
        //它实际上就是Frame的子类，所以说我们之前怎么用的，现在怎么用就行了
        frame.setSize(500, 300);
        //我们可以直接为窗口设定关闭操作，JFrame已经为我们预设好了一些常用的操作了
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //EXIT_ON_CLOSE就是直接退出程序，默认是只隐藏
        frame.setVisible(true);

        frame.setLayout(null);
        JButton button = new JButton("Link Start");  //Button组件对应的就是JButton了
        button.setBounds(20, 50, 100, 50);
        frame.add(button);

        JMenuBar bar = new JMenuBar();    //JMenuBar对应的就是MenuBar
        JMenu menu = new JMenu("我是菜单");
        menu.add(new JMenuItem("选项1"));
        menu.add(new JMenuItem("选项2"));
        bar.add(menu);
        frame.setJMenuBar(bar);
    }
}
