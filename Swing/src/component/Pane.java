package component;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Pane {
    public static void pane() {//多界面
        JTabbedPane pane = new JTabbedPane();
        pane.setBounds(0, 0, 500, 300);
        pane.addTab("一号", new JPanel() {{
            setBackground(Color.ORANGE);
        }});
        pane.addTab("二号", new JPanel() {{
            setBackground(Color.PINK);
        }});

        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setVisible(true);
    }

    public static void separate() {//分隔界面
        JSplitPane pane = new JSplitPane();
        pane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  //设定为横向分割

        JTextArea area = new JTextArea();   //右边就是我们需要编辑的文本域

        File file = new File(".idea");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file);
        File[] files = Optional.ofNullable(file.listFiles()).orElseGet(() -> new File[0]);
        for (File f : files)
            root.add(new DefaultMutableTreeNode(f.getName()));
        JTree tree = new JTree(root);   //左边就是我们的文件树
        tree.addTreeSelectionListener(e -> {   //点击文件之后，我们需要变换编辑窗口中的文本内容，这里加个监听器
            area.setText("");   //先清空
            try (FileReader reader = new FileReader(".idea/" + e.getPath().getLastPathComponent().toString())) {
                char[] chars = new char[128];   //直接开始读取内容
                int len;
                while ((len = reader.read(chars)) > 0)
                    area.setText(area.getText() + new String(chars, 0, len));   //开始写入到编辑窗口中
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        pane.setLeftComponent(new JScrollPane(tree));   //文件树和编辑区域都套一个滚动面板，因为有可能会撑得很大
        pane.setRightComponent(new JScrollPane(area));

        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setVisible(true);
    }
}
