import Basic.Basic;
import component.Dialog;
import component.NewComponent;
import component.Pane;
import component.diy.TestJButtonUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        Basic.basic();

//        NewComponent.progressBar();
//        NewComponent.button();
//        NewComponent.tree();

//        Pane.pane();
//        Pane.separate();

//        Dialog.showDialog();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        frame.setVisible(true);

        JButton button = new JButton("Button");
        button.setSize(100, 30);
        button.setUI(new TestJButtonUI());
        frame.add(button, BorderLayout.CENTER);
    }
}
