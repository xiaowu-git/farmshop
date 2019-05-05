package com.farm.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {


    public Map getPaging(Integer page, List listAll, List listPage){
        Map map = new HashMap();
        int pageCount = listAll.size();  //数据条数
        int pageSize = 8;  //分页条数
        int pageMax = pageCount / pageSize;  //最大页数
        int pagePointer = 1;  //当前指向页
        if (pageMax != 0 && pageCount % pageSize != 0) {
            ++pageMax;
        }
        if (pageMax == 0) {
            pageMax = 1;
        }
        if (page < 1 || page > pageMax) {
            pagePointer = 1;
        } else {
            pagePointer = page;
        }
        if (pageMax == 1) {
            listPage.addAll(listAll);
        } else if (pagePointer == pageMax) {
            int tmp = pageCount % pageSize;
            if (tmp == 0) {
                tmp = pageSize;
            }
            for (int i = pageSize * (pagePointer - 1); i < pageSize * (pagePointer - 1) + tmp; ++i) {
                listPage.add(listAll.get(i));
            }
        } else {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * pagePointer; ++i) {
                listPage.add(listAll.get(i));
            }
        }

        map.put("pageMax", pageMax);
        map.put("pagePoint", pagePointer);
        map.put("listPage", listPage);
        return map;
    }
}
