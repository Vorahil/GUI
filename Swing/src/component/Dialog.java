package component;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dialog {
    public static void showDialog() {
        JFrame frame = new JFrame("我是窗口");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);  //先将默认关闭行为设定为什么都不做
        frame.addWindowListener(new WindowAdapter() {   //我们自己来实现窗口关闭行为
            @Override
            public void windowClosing(WindowEvent e) {   //这里我们可以直接展示一个预设好的确认对话框
                int value = JOptionPane.showConfirmDialog(frame, "你真的要退出吗？", "退出程序", JOptionPane.YES_NO_OPTION);
                if (value == JOptionPane.OK_OPTION)    //返回值就是用户的选择结果，也是预置好的，这里判断如果是OK那么就退出
                    System.exit(0);
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeiconified(WindowEvent e) {
                String str = JOptionPane.showInputDialog("毕业后的你，将何去何从呢？");
                System.out.println(str);
            }
        });
        frame.setVisible(true);

    }
}
