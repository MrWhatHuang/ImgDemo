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
        pen.setFont(new Font("黑体",1,40));
        // 添加文字
        pen.drawString("巡检点位：2#车间名称",30,275);
        pen.drawString("单位/部门：",30,355);
        pen.drawString("No：123",30,425);

        pen.setFont(new Font("黑体",1,40));
        // 动态居中效果
        pen.drawString("静波集团有限公司",650 - (((40 + 2) * 8) / 2),70);

        pen.setFont(new Font("黑体",1,50));
        pen.drawString("巡检卡",575,145);

        // 读取二维码图片
        BufferedImage qrCode = ImageIO.read(new File("./static/baofeng/qrcode.png"));
        // 缩放二维码
        Image qrCodeFormat = qrCode.getScaledInstance(350, 350, Image.SCALE_SMOOTH);

        // 叠加二维码
        pen.drawImage(qrCodeFormat, 600, 235, null);

        File file = new File("output.png");
        ImageIO.write(backImg, "png", file);
    }
}
