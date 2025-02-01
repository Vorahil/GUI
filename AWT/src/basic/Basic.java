package basic;

import component.Common;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;

public class Basic {
    static Frame frame = new Frame();

    public static Frame show(Optional<Boolean> alwaysOn, Optional<Boolean> ifResizable, Optional<Integer> cursorChoice) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕大小
        boolean a = alwaysOn.orElse(false);
        boolean i = ifResizable.orElse(false);
        int c = cursorChoice.orElse(0);

        //设置标题
        frame.setTitle("test");//或者直接在frame构造器里传参

        //设置背景色彩
        frame.setBackground(Color.gray);

        //设置窗口位置(坐标原点在左上角)与设置大小(单位像素)
//        frame.setBounds(screenSize.width/2-frame.getWidth()/2,screenSize.height/2-frame.getHeight()/2,1000,600);
        frame.setSize(1000, 600);
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2, screenSize.height / 2 - frame.getHeight() / 2);
        if (a) {
            //始终悬浮在其他窗口之上
            frame.setAlwaysOnTop(true);
        }
        if (i) {
            //窗口大小是否可以通过鼠标变化
            frame.setResizable(false);
        }
        //设置光标
        switch (c) {
            case 0:
                frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
            case 1:
                frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                break;
            case 2:
                frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                break;
            case 4:
                frame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                break;
            default:
                frame.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        }

//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//                System.out.println("windowOpened");
//            }
//        });

//        手动控制窗口内所有组件的大小和位置
        frame.setLayout(null);
        Label label = Common.label();
        Button button = Common.button();
        TextField field = Common.textField();
        TextArea textArea = Common.textArea();

        Checkbox checkbox1 = Common.checkbox();
        checkbox1.setLabel("Checkbox 1");
        Checkbox checkbox2 = new Checkbox("Checkbox 2");
        checkbox2.setBounds(300, 500, 100, 20);
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        checkbox1.setCheckboxGroup(checkboxGroup);
        checkbox2.setCheckboxGroup(checkboxGroup);

        button.addActionListener(e-> System.out.println(field.getText()));
        button.addActionListener(e-> System.out.println(checkboxGroup.getSelectedCheckbox().getLabel()));
        frame.add(label);
        frame.add(button);
        frame.add(field);
        frame.add(checkbox1);
        frame.add(checkbox2);
        frame.add(textArea);
        //开始展示(false不会关闭只会隐藏)
        frame.setVisible(true);
        return frame;
    }

}
