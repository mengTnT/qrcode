package com.tthome.qrcode.utils;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**背景图片与二维码合成
 * @author NBUG
 * @date 2018/8/19 16:45
 */
public class CompoundImg {


    public static void compound(String imgPath) {
        //背景图片
        String bgImg =  "D:\\QRcode\\loge\\bg.jpg";
        try {
            // 加载本地图片
            String imageLocalUrl = imgPath;
            BufferedImage imageLocal = ImageIO.read(new File(bgImg));
            // 加载用户的二维码
            BufferedImage imageCode = ImageIO.read(new File(imageLocalUrl));
            // 以本地图片为模板
            Graphics2D g = imageLocal.createGraphics();
            int x = imageLocal.getWidth()/2;
            int y = imageLocal.getHeight()/2;
            // 在模板上添加二维码(地址,左边距,上边距,图片宽度,图片高度,未知)
            g.drawImage(imageCode, x, y, 300, 300, null);

            // 完成模板修改
            g.dispose();
            // 获取新文件的地址
            File outputfile = new File(imageLocalUrl);
            // 生成新的合成过的二维码并写入新图片
            ImageIO.write(imageLocal, "png", outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
