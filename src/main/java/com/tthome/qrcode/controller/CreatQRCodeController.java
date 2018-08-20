package com.tthome.qrcode.controller;

import com.tthome.qrcode.entity.CheckData;
import com.tthome.qrcode.service.CheckDataService;
import com.tthome.qrcode.utils.CompoundImg;
import com.tthome.qrcode.utils.EncryptUtil;
import com.tthome.qrcode.utils.QRCodeUtil;
import com.tthome.qrcode.utils.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class CreatQRCodeController {
    @Autowired
    private CheckDataService checkDataService;
    //图片文件保存路径
    @Value("${img.path}")
    private String imgPath;

    //二维码访问的地址
    @Value("${qrcode.url}")
    private  String url;

    /**
     *
     * @param response
     * @param num 生成二维码的数量
     * @throws Exception
     */
    @RequestMapping("/downloadFile")
    public void downloadFile(HttpServletResponse response, int num) throws Exception {
        String filePath="";
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        for (int i=0;i<num;i++){
            //随机字符串
            String str = UUID.randomUUID().toString().replace("-", "").substring(0, 20)+String.valueOf(System.currentTimeMillis());
            CheckData checkData=new CheckData();
            //对str加密
            String encryptString = EncryptUtil.encrypt_Base64(str);
            //把数据添加到数据库
            checkData.setKey(encryptString);
            checkDataService.insert(checkData);
            //根据key创建二维码
            String[] strings = QRCodeUtil.creatQRcode(encryptString, url, imgPath);
            filePath=strings[0];
            CompoundImg.compound(filePath+strings[1]);

        }
        //把生成的二维码压缩成zip
        String[] srcDir = { filePath,};
        //压缩后的文件输出路径
        String outDir = imgPath+dateNowStr+".zip";
        ZipUtil.toZip(srcDir, outDir, true);


        response.setCharacterEncoding("utf-8");
        //下载文件的路径
        String zipFilePath=imgPath;
        //要下载的文件名
        String zipFileName=dateNowStr+".zip";
        try {
            File file=new File(zipFilePath,zipFileName);
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + zipFileName);
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
