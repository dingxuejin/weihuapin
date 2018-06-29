package com.mobiusVision.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 9:19 2018/6/23/023
 * @Modify By:
 **/
public class TongHuanBi {


    //同比（上一年，同月）
    public List<Object> TongBiReturn(Map<Integer,Double> mapNow,Map<Integer,Double> mapYear){

        List<Object> tongBiList=new ArrayList<>();

        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        for(int i=1;i<=12;i++){
            //某月有数据并且去年此时也有数据
            //培训次数同比
            if(mapNow.get(i)!=null) {
                if (mapYear.get(i) != null) {
                    //今年参加培训去年参加培训
                    Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapYear.get(i)));
                    tongBiList.add(mapFormat);
                }
                else {
                    //今年参加培训去年未参加培训
                    Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                    tongBiList.add(mapFormat);
                }
            }else {
                if (mapYear.get(i) != null) {
                    //今年未参加培训去年参加培训
                    Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                    tongBiList.add(mapFormat);
                }
                else {
                    //今年未参加培训去年未参加培训
                    Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                    tongBiList.add(mapFormat);
                }
            }
        }
        return tongBiList;
    }

    //同比（上月，同日）
    public List<Object> TongBiReturnDay(Map<Integer,Double> mapNow,Map<Integer,Double> mapMonth,Map<Integer,Double> mapYearMonth,long year,int month) {

        List<Object> tongBiList=new ArrayList<>();

        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();


        if(month==1){
            //1月份（和去年12月份相比）
            for(int i=1;i<=31;i++){
                if(mapNow.get(i)!=null) {
                    if (mapYearMonth.get(i) != null) {
                        //今年参加培训去年参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapYearMonth.get(i)));
                        tongBiList.add(mapFormat);
                    }
                    else {
                        //今年参加培训去年未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                        tongBiList.add(mapFormat);
                    }
                }else {
                    if (mapMonth.get(i) != null) {
                        //今年未参加培训去年参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                        tongBiList.add(mapFormat);
                    }
                    else {
                        //今年未参加培训去年未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                        tongBiList.add(mapFormat);
                    }
                }
            }
        }else if (month==2 || month==3){
            //2,3月份
            //若闰年
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                for (int i = 1; i <= 29; i++) {
                    if(mapNow.get(i)!=null) {
                        if (mapMonth.get(i) != null) {
                            //今年参加培训去年参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapMonth.get(i)));
                            tongBiList.add(mapFormat);
                        }
                        else {
                            //今年参加培训去年未参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                            tongBiList.add(mapFormat);
                        }
                    }else {
                        if (mapMonth.get(i) != null) {
                            //今年未参加培训去年参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                            tongBiList.add(mapFormat);
                        }
                        else {
                            //今年未参加培训去年未参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                            tongBiList.add(mapFormat);
                        }
                    }
                }
            }
            //若非闰年
            else{
                for (int i = 1; i <= 28; i++) {
                    if(mapNow.get(i)!=null) {
                        if (mapMonth.get(i) != null) {
                            //今年参加培训去年参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapMonth.get(i)));
                            tongBiList.add(mapFormat);
                        }
                        else {
                            //今年参加培训去年未参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                            tongBiList.add(mapFormat);
                        }
                    }else {
                        if (mapMonth.get(i) != null) {
                            //今年未参加培训去年参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                            tongBiList.add(mapFormat);
                        }
                        else {
                            //今年未参加培训去年未参加培训
                            Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                            tongBiList.add(mapFormat);
                        }
                    }
                }
            }
        }else if(month==8){
            //8月份
            for (int i = 1; i <= 31; i++) {
                if(mapNow.get(i)!=null) {
                    if (mapMonth.get(i) != null) {
                        //今年参加培训去年参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapMonth.get(i)));
                        tongBiList.add(mapFormat);
                    }
                    else {
                        //今年参加培训去年未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                        tongBiList.add(mapFormat);
                    }
                }else {
                    if (mapMonth.get(i) != null) {
                        //今年未参加培训去年参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                        tongBiList.add(mapFormat);
                    }
                    else {
                        //今年未参加培训去年未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                        tongBiList.add(mapFormat);
                    }
                }
            }
        }
        else {
            //正常
            for (int i = 1; i <= 30; i++) {
                if(mapNow.get(i)!=null) {
                    if (mapMonth.get(i) != null) {
                        //今年参加培训去年参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapMonth.get(i)));
                        tongBiList.add(mapFormat);
                    }
                    else {
                        //今年参加培训去年未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                        tongBiList.add(mapFormat);
                    }
                }else {
                    if (mapMonth.get(i) != null) {
                        //今年未参加培训去年参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                        tongBiList.add(mapFormat);
                    }
                    else {
                        //今年未参加培训去年未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                        tongBiList.add(mapFormat);
                    }
                }
            }
        }
        return tongBiList;
    }

    //环比（不同年份总数据）
    public List<Object> HuanBiReturnYear(Map<Integer,Double> mapNow){
        //环比数据
        List<Object> huanBiList=new ArrayList<>();

        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //环比(Size==0)
        for(int i:mapNow.keySet()){
                if (mapNow.get(i) != null) {
                    if (mapNow.get(i-1) != null) {
                        //今年数据和去年数据都存在
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapNow.get(i-1)));
                        huanBiList.add(mapFormat);
                    } else{
                        //今年数据存在和去年数据不存在
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                        huanBiList.add(mapFormat);
                    }
                } else {
                    if (mapNow.get(i-1) != null) {
                        //今年数据不存在和去年数据存在
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                        huanBiList.add(mapFormat);
                    } else {
                        //今年数据不存在和去年数据不存在
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,0.0);
                        huanBiList.add(mapFormat);
                    }
                }
            }
        return huanBiList;
    }

    //环比（同年，上一个月）
    public List<Object> HuanBiReturn(Map<Integer,Double> mapNow,Map<Integer,Double> mapYear){
        //环比数据
        List<Object> huanBiList=new ArrayList<>();

        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //培训次数环比(Size==0)
        for(int i=1;i<=12;i++){
            //某月有数据并且上个月也有数据
            //培训次数环比
            //1月
            if(i==1) {
                if (mapNow.get(i) != null) {
                    if (mapYear.get(12) != null) {
                        //今月参加培训去月参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapYear.get(12)));
                        huanBiList.add(mapFormat);
                    } else {
                        //今月参加培训去月未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 100.0);
                        huanBiList.add(mapFormat);
                    }
                } else {
                    if (mapYear.get(12) != null) {
                        //今月未参加培训去月参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, -100.0);
                        huanBiList.add(mapFormat);
                    } else {
                        //今月未参加培训去月未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i, 0.0);
                        huanBiList.add(mapFormat);
                    }
                }
            }
            else {
                if (mapNow.get(i) != null) {
                    if (mapNow.get(i-1) != null) {
                        //今月参加培训去月参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,tongBiAHuanBiFunction(mapNow.get(i), mapNow.get(i-1)));
                        huanBiList.add(mapFormat);
                    } else{
                        //今月参加培训去月未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,100.0);
                        huanBiList.add(mapFormat);
                    }
                } else {
                    if (mapNow.get(i-1) != null) {
                        //今月未参加培训去月参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,-100.0);
                        huanBiList.add(mapFormat);
                    } else {
                        //今月未参加培训去月未参加培训
                        Map<String,Object> mapFormat=dataSetReturnJson.mapfunctionInValue(i,0.0);
                        huanBiList.add(mapFormat);
                    }
                }
            }
        }
        return huanBiList;
    }

    //环比（同月，昨天）
    public List<Object> HuanBiReturnDay(Map<Integer,Double> mapNow,Map<Integer,Double> mapMonth,Map<Integer,Double> mapYearMonth,long year,int month){
        //环比数据
        List<Object> huanBiList=new ArrayList<>();

        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //获取某年某月天数
        int days=DateUtil.getDays(Long.toString(year)+Integer.toString(month));
        //获取某年某月上个月天数
        int daysMonth=DateUtil.getDays(Long.toString(year)+Integer.toString(month-1));

        if(month==1){
            //1月份（和去年12月份相比）
            for(int i=1;i<=31;i++) {
                if (i == 1) {
                    //1月1日
                    if (mapNow.get(i) != null) {
                        if (mapYearMonth.get(31) != null) {
                            //今月参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, tongBiAHuanBiFunction(mapNow.get(i), mapYearMonth.get(31)));
                            huanBiList.add(mapFormat);
                        } else {
                            //今月参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 100.0);
                            huanBiList.add(mapFormat);
                        }
                    } else {
                        if (mapYearMonth.get(31) != null) {
                            //今月未参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, -100.0);
                            huanBiList.add(mapFormat);
                        } else {
                            //今月未参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 0.0);
                            huanBiList.add(mapFormat);
                        }
                    }
                } else {
                    if (mapNow.get(i) != null) {
                        if (mapNow.get(i-1) != null) {
                            //今月参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, tongBiAHuanBiFunction(mapNow.get(i), mapNow.get(i-1)));
                            huanBiList.add(mapFormat);
                        } else {
                            //今月参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 100.0);
                            huanBiList.add(mapFormat);
                        }
                    } else {
                        if (mapNow.get(i-1) != null) {
                            //今月未参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, -100.0);
                            huanBiList.add(mapFormat);
                        } else {
                            //今月未参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 0.0);
                            huanBiList.add(mapFormat);
                        }
                    }
                }
            }
        }else{
            //其他月份
            for(int i=1;i<=days;i++) {
                if (i == 1) {
                    //其他月份1日
                    if (mapNow.get(i) != null) {
                        if (mapMonth.get(daysMonth) != null) {
                            //今月参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, tongBiAHuanBiFunction(mapNow.get(i), mapMonth.get(daysMonth)));
                            huanBiList.add(mapFormat);
                        } else {
                            //今月参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 100.0);
                            huanBiList.add(mapFormat);
                        }
                    } else {
                        if (mapMonth.get(daysMonth) != null) {
                            //今月未参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, -100.0);
                            huanBiList.add(mapFormat);
                        } else {
                            //今月未参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 0.0);
                            huanBiList.add(mapFormat);
                        }
                    }
                } else {
                    if (mapNow.get(i) != null) {
                        if (mapNow.get(i-1) != null) {
                            //今月参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, tongBiAHuanBiFunction(mapNow.get(i), mapNow.get(i-1)));
                            huanBiList.add(mapFormat);
                        } else {
                            //今月参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 100.0);
                            huanBiList.add(mapFormat);
                        }
                    } else {
                        if (mapNow.get(i-1) != null) {
                            //今月未参加培训去月参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, -100.0);
                            huanBiList.add(mapFormat);
                        } else {
                            //今月未参加培训去月未参加培训
                            Map<String, Object> mapFormat = dataSetReturnJson.mapfunctionInValue(i, 0.0);
                            huanBiList.add(mapFormat);
                        }
                    }
                }
            }
        }
        return huanBiList;
    }

    //同比和环比计算
    private Double tongBiAHuanBiFunction(Double now,Double last){
        Double result=(now-last)/last*100.0;
        return result;
    }

}
