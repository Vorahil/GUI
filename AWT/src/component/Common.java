package component;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class Common {
    public static Label label(){
        Label label = new Label("Hello World");
        label.setBounds(400, 200, 100, 20);
        label.setFont(new Font("SimSong", Font.BOLD, 10));
        label.setForeground(Color.GREEN);
        label.setBackground(Color.yellow);
        return label;
    }

    public static Button button(){
        Button button = new Button("Happy Birthday");
        button.setBounds(400, 300, 100, 20);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static TextField textField(){//文本行
        TextField textField = new TextField();
        textField.setBounds(450, 400, 100, 20);
        textField.setEchoChar('@');
        return textField;
    }

    public static TextArea textArea(){//文本域
        TextArea textArea = new TextArea();
        textArea.setBounds(450, 500, 100, 80);
        return textArea;
    }

    public static Checkbox checkbox(){//单选框
        Checkbox checkbox = new Checkbox("Remember me");
        checkbox.setBounds(300, 400, 100, 20);
        return checkbox;
    }
}
