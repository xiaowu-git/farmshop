package com.farm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderNum {


    //返回20位的订单号 时间戳加5位随机数
    public  String  getOrderNum(){
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date())+random.nextInt(5);
        return subjectno;
    }

}
