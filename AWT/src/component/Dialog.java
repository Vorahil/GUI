package component;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dialog {
    public static void dialog() {
        Frame frame = new Frame("Dialog");
        frame.setBounds(100, 100, 450, 300);
        frame.setVisible(true);

        java.awt.Dialog dialog = new java.awt.Dialog(frame, "提示", true);//model为true表示去除提示框才可以进入下一步
        dialog.setSize(500, 300);
        dialog.setResizable(false);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.add(new Label("Exit?"), BorderLayout.NORTH);
        Button ok = new Button("OK");
        ok.addActionListener(e -> {
            frame.dispose();
        });
        Button cancel = new Button("Cancel");
        cancel.addActionListener(e -> {
            dialog.setVisible(false);
        });
        dialog.add(ok, BorderLayout.WEST);
        dialog.add(cancel, BorderLayout.EAST);

//        FileDialog fileDialog = new FileDialog(frame, "请选择一个文件", FileDialog.LOAD);
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                fileDialog.setVisible(true);   //注意，需要将对话框展示出来之后，才能进行选择
//                //选择完成之后getDirectory和getFile方法就可以返回结果了，否则会阻塞
//                System.out.println("选择的文件为：" + fileDialog.getDirectory() + fileDialog.getFile());
//            }
//        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(true);
            }
        });
    }
}
