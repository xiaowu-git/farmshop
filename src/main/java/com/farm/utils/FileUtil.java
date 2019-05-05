package com.farm.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/13 0013
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public class FileUtil {

    private static Logger log = Logger.getLogger(FileUtil.class);

    public String getSupplyImgName(){
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date())+random.nextInt(5);
        return "supply"+subjectno+".jpg";
    }

    public String getProcurementImgName(){
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date())+random.nextInt(5);
        return "procure"+subjectno+".jpg";
    }

    public  String getFarmNewsImgName(){
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date())+random.nextInt(5);
        return "news"+subjectno+".jpg";
    }

    public  String getFarmStudyImgName(){
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date())+random.nextInt(5);
        return "study"+subjectno+".jpg";
    }



    public String uploadFile(MultipartFile prodPicture, String type,String realPath){
        log.info("==================开始上传文件======================");
        log.info("文件长度: " + prodPicture.getSize());
        log.info("文件类型: " + prodPicture.getContentType());
        log.info("文件名称: " + prodPicture.getName());
        log.info("文件原名: " + prodPicture.getOriginalFilename());

        String nameNew = "";
        if(type!= null && type.equals("PROCURE")){
            nameNew = getProcurementImgName();
        }else if(type!= null && type.equals("SUPPLY")){
            nameNew = getSupplyImgName();
        }else if(type!= null && type.equals("NEWS")){
            nameNew = getFarmNewsImgName();
        } else if(type!= null && type.equals("STUDY")){
            nameNew = getFarmStudyImgName();
        }else {
            nameNew = prodPicture.getOriginalFilename();
        }

        //{服务发布位置}\\WEB-INF\\upload\\文件夹中
        //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
        try {
            //开发环境使用路径
            realPath = "D:\\workspace\\template\\farmshop\\src\\main\\webapp\\resources\\upload";
            FileUtils.copyInputStreamToFile(prodPicture.getInputStream(), new File(realPath, nameNew));
            log.info("========================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("===================上传文件结束=====================");
        return nameNew;
    }




}
