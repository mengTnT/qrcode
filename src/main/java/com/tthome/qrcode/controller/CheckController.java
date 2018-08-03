package com.tthome.qrcode.controller;

import com.tthome.qrcode.entity.CheckData;
import com.tthome.qrcode.service.CheckDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author NBUG
 * @date 2018/8/2 16:53
 */
@RestController
public class CheckController {
    @Autowired
    private CheckDataService checkDataService;

    @GetMapping("/check")
    public Map check(String key) {
        Map map = new HashMap();
        String tip = "";
        CheckData checkData = checkDataService.selectByKey(key);
        if (checkData != null) {
            int id = checkData.getId();

            int isCheck = checkData.getIsCheck();
            if (isCheck == 1) {
                Date isCheckTime = checkData.getIsCheckTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String checkTime = sdf.format(isCheckTime);
                tip = "你所查询的防伪码已被查询过，首次查询时间：" + checkTime + ",请确认!敬告：如果该时间段非本人查询，谨防假冒！";
                map.put("tip", tip);
                map.put("code", 0);
                return map;
            }
            int updateCheck = checkDataService.updateCheck(id);
            if (updateCheck == 1) {
                tip = "您购买的是正品,感谢您支持卫诗理，卫诗理，一直为你";
                map.put("tip", tip);
                map.put("code", 1);
                return map;

            }

        }
        tip = "您所查询的防伪码不存在，谨防假冒! 或与公司客服人员联系!";
        map.put("tip", tip);
        map.put("code", -1);
        return map;
    }
}
