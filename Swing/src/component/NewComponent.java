package component;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class NewComponent {
    //进度条
    public static void progressBar() {
        JProgressBar bar = new JProgressBar();   //进度条显示文件拷贝进度
        bar.setMaximum(1000);
        bar.setBounds(20, 50, 300, 10);

        JButton button = new JButton("点击开始");   //点击按钮开始拷贝文件
        button.setBounds(20, 100, 100, 30);
        button.addActionListener(e -> new Thread(() -> {
            //注意，不能直接在这个线程里面处理，因为这个线程是负责图形界面的，得单独创建一个线程处理，否则图形界面会卡死
            File file = new File("in.iso");
            try (FileInputStream in = new FileInputStream(file); FileOutputStream out = new FileOutputStream("out.iso")) {
                long size = file.length(), current = 0;
                int len;
                byte[] bytes = new byte[1024];
                while ((len = in.read(bytes)) > 0) {
                    current += len;
                    bar.setValue((int) (bar.getMaximum() * (double) current / size));   //每次拷贝都更新进度条
                    bar.repaint();  //因为并不是每次更新值都会使得组件重新绘制，如果视觉上比较卡，可以每次拷贝都重新绘制组件
                    out.write(bytes, 0, len);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }).start());
    }

    public static void button() {
        JFrame frame = new JFrame("我是窗口");   //Swing中的窗口叫做JFrame，对应的就是AWT中的Frame
        //它实际上就是Frame的子类，所以说我们之前怎么用的，现在怎么用就行了
        frame.setSize(500, 300);
        //我们可以直接为窗口设定关闭操作，JFrame已经为我们预设好了一些常用的操作了
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //EXIT_ON_CLOSE就是直接退出程序，默认是只隐藏
        frame.setVisible(true);

        frame.setLayout(null);

        JMenuBar bar = new JMenuBar();    //JMenuBar对应的就是MenuBar
        JMenu menu = new JMenu("我是菜单");
        menu.add(new JMenuItem("选项1"));
        menu.add(new JMenuItem("选项2"));
        bar.add(menu);
        frame.setJMenuBar(bar);
        JToggleButton button = new JToggleButton("我是切换按钮");   //开关按钮有两个状态，一个是开一个是关
        button.setBounds(100, 60, 100, 30);
        button.setToolTipText("Hello");
        frame.add(button);
    }

    public static void tree() {//文件结构树
        JFrame frame = new JFrame("Window");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //这里我们让JTree展示.idea目录下所有文件
        File file = new File(".idea");   //这里我们列出.idea目录下所有文件
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName()); //既然是树形关系，肯定有一个根结点
        //拿到当前目录下所有文件和文件夹
        File[] files = Optional.ofNullable(file.listFiles()).orElseGet(() -> new File[0]);
        for (File f : files)
            root.add(new DefaultMutableTreeNode(f.getName()));    //构造子结点并连接

        JTree tree = new JTree(root);    //设定默认的根结点
        tree.setBounds(0, 0, 200, 200);
    }
}
