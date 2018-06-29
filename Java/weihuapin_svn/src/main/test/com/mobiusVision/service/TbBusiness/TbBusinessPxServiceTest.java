package com.mobiusVision.service.TbBusiness;

import com.alibaba.fastjson.JSON;
import com.google.gson.internal.LinkedTreeMap;
import com.mobiusVision.pojo.TbBusiness.TbBusinessPxATTT;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 8:55 2018/6/22/022
 * @Modify By:
 **/
public class TbBusinessPxServiceTest {

    private TbBusinessPxService tbBusinessPxService=new TbBusinessPxService();
    @Test
    public void findPxByDidCodeDate() {

        List<TbBusinessPxATTT> tbBusinessPxATTTList=tbBusinessPxService.findPxByDidCodeDate("201408000001","12","10","2017","07");
        System.out.println(tbBusinessPxATTTList.size());
    }

    private String name;
    private String value;

    @Test
    public void findPxByDidCodeDateAType() {
//        System.out.println(tbBusinessPxService.findAllTrainingTTT("201408000001","12","10","2017","07"));
        System.out.println("0"+ Integer.toString(Integer.parseInt("07") - 1));
        Map<String,Double> mapTrainingTimesNow=new LinkedHashMap<>();
        mapTrainingTimesNow.put("1",0.0);
        System.out.println(mapTrainingTimesNow.get("2"));

        Map map1 = new HashMap();
        map1.put("msg", "yes");//map里面装有yes
        String jsonObject = JSON.toJSONString(map1);
        System.out.println("输出的结果是：" + jsonObject);
        //3、将json对象转化为json字符串
        String result = jsonObject.toString();
        System.out.println(result);

        Map<String,String> map = new HashMap<>();
        map.put("hello","{\"he\",\"llo\"}");
        map.put("hello","{\"he\",\"llo\"}1");
        map.put("world", JSON.toJSONString("{\"wor\":\"ld\"}"));
        for (String key : map.keySet()) {
            System.out.println(">>>>>>>>>>>>>"+map.get(key));
        }

        Map<String,Object> AllMap=new LinkedTreeMap<>();
        AllMap.put(new String("name"),"asdf1");
        AllMap.put(new String("name"),"asdf2");
        AllMap.put(new String("name"),"asdf3");
        AllMap.put(new String("name"),"asdf4");

        tbBusinessPxService.findPxByDidCodeDateAType("201408000001","12","10","2017");

        int a=1;
    }
}