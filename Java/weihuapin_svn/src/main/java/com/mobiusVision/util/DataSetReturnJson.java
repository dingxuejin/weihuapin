package com.mobiusVision.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 8:56 2018/6/23/023
 * @Modify By:
 **/
public class DataSetReturnJson {

    //内层value输出
    public Map<String,Object> mapfunctionInValue(Object t1, Object t2){
        Map<String,Object> AllMap=new LinkedHashMap<>();
        AllMap.put("name",t1);
        AllMap.put("value",t2);

        return AllMap;
    }


    //外层data输出
    public Map<String,Object> mapfunctionOutData(Object t1, Object t2){
        Map<String,Object> AllMap=new LinkedHashMap<>();
        AllMap.put("name",t1);
        AllMap.put("data",t2);

        return AllMap;
    }

    //中层同比环比输出
    public Map<String,Object> mapfunctionMiddleTH(Object t1, Object t2){
        Map<String,Object> AllMap=new LinkedHashMap<>();
        AllMap.put("同比",t1);
        AllMap.put("环比",t2);

        return AllMap;
    }

    //中层运单数和周转量输出
    public Map<String,Object> mapfunctionMiddleTHAydsl(Object t1, Object t2){
        Map<String,Object> AllMap=new LinkedHashMap<>();
        AllMap.put("运单数",t1);
        AllMap.put("周转量",t2);

        return AllMap;
    }
}
