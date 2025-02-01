package component.diy;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public class TestJButtonUI extends ButtonUI {   //继承对应的UI父类
    @Override
    public void paint(Graphics g, JComponent c) {   //我们只需要重写对应UI的paint方法就可以了
        int width = c.getWidth(), height = c.getHeight();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        JButton button = (JButton) c;
        g.drawString(button.getText(), 0, 20);
    }
}
