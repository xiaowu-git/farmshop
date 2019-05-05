package com.farm.task;

import com.farm.bean.FsMarketinfo;
import com.farm.bean.FsOrderUser;
import com.farm.service.interfaces.IFsMarketInfoService;
import com.farm.service.interfaces.IFsOrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TaskTest {

    private static boolean method_flag = true;

    @Autowired
    private IFsOrderUserService fsOrderUserService;

    @Autowired
    private IFsMarketInfoService fsMarketInfoService;

    @Scheduled(cron = "1 0 0 * * ?")
    public void myJob() {
        System. out.println( "task myJob execing ..."+new Date());
    }

    @Scheduled(cron = "1 0 * * * ?") //1 0 0 * * ? 零点
    public void createMarketInfo() {
        if(method_flag){

            System. out.println( "task createMarketInfo starting ..."+new Date());
            /*List<FsMarketinfo> fsMarketinfoList = fsMarketInfoService.getAllFsMarketinfo();
            List<FsOrderUser> fsOrderUserList = fsOrderUserService.getAllOrder();
            FsMarketinfo marketinfo = new FsMarketinfo();
            marketinfo.setCreateTime(new Date());
            marketinfo.setEffectiveTime(new Date());*/

            int num = fsMarketInfoService.saveFsMarketinfoBProduct();
            System. out.println( "task createMarketInfo ending ..."+new Date()+ "createMarketInfo数量："+num);

        }
    }
}
