package component.diy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;

public class ImageView extends Component {   //继承自Component表示是一个组件
    Image image;
    public ImageView(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            image = ImageIO.read(fis);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth()/2, getHeight());
        g.setColor(Color.RED);    //画笔改成红色
        //在中间画个圆角矩形边框
        g.drawRoundRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2, 30, 30);
        g.drawImage(image, 0,0, this.getWidth(), this.getHeight(), this);
    }

}
