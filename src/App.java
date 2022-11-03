import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/* 参考文献：
 * https://zhuanlan.zhihu.com/p/541683859
 * https://blog.csdn.net/m0_56231540/article/details/124651516
 */

public class App {
    public static void main(String[] args) throws Exception {
        // 读取背景图层
        BufferedImage backImg = ImageIO.read(new File("./static/baofeng/background.jpg"));

        // 创建画笔
        Graphics2D pen = backImg.createGraphics();
        // 设置画笔颜色
        pen.setColor(Color.BLACK);

        // 设置画笔样式 Font.PLAIN（正常） 0，Font.BOLD（粗体） 1，Font.ITALIC（斜体） 2
        pen.setFont(new Font("黑体",0,30));
        // 添加文字
        pen.drawString("巡检点位：2#车间名称",30,350);

        // 读取二维码图片
        BufferedImage qrCode = ImageIO.read(new File("./static/baofeng/qrcode.png"));
        // 缩放二维码
        Image qrCodeFormat = qrCode.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

        // 叠加二维码
        pen.drawImage(qrCodeFormat, 500, 200, null);

        File file = new File("output.png");
        ImageIO.write(backImg, "png", file);
    }
}
