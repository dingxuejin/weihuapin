package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusinessPxMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusinessPxATTT;
import com.mobiusVision.pojo.TbBusiness.TbBusinessPxOrTTT;
import com.mobiusVision.util.ApplicationContextUtil;
import com.mobiusVision.util.DataSetReturnJson;
import com.mobiusVision.util.TongHuanBi;
import org.springframework.context.ApplicationContext;

import java.util.*;

/**
 * @Author: zhangzhirong
 * @Description:人员培训信息查询
 * @Date:Created in 18:30 2018/6/21/021
 * @Modify By:
 **/
public class TbBusinessPxService {

    //总培训次数
    private String total_training_times;
    //总培训时长
    private String total_training_time;
    //总通过人数
    private String total_result_pass;

    //通过driver_id查询tb_subject_jxjy表及其到期天数和未学习时间数据
    public List<TbBusinessPxATTT> findPxByDidCodeDate(
            String driver_id,
            String training_type_code,
            String training_theme_code,
            String year,
            String month){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessPxMapper tbBusinessPxMapper =(TbBusinessPxMapper)aplc.getBean("tbBusinessPxMapper");

        List<TbBusinessPxATTT> tbBusinessPxATTTList=tbBusinessPxMapper.findPxByDidCodeDate(driver_id,training_type_code,training_theme_code,year,month);
        return tbBusinessPxATTTList;
    }


    //通过driver_id等数据查询Px表中人员培训次数,人员培训时长,培训通过人数
    public List<TbBusinessPxOrTTT> findAllTrainingTTT(
            String driver_id,
            String training_type_code,
            String training_theme_code,
            String year
    ) {

        //获取SpringBean
        ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
        TbBusinessPxMapper tbBusinessPxMapper = (TbBusinessPxMapper) aplc.getBean("tbBusinessPxMapper");
        List<TbBusinessPxOrTTT> tbBusinessPxOrTTTList=tbBusinessPxMapper.findAllTrainingTTT(driver_id,training_type_code,training_theme_code,year);
        return tbBusinessPxOrTTTList;
    }

    //通过String driver_id,String training_type_code,String training_theme_code,String year查询所有同环比
    //条件限制(查询次数不为0)
    public List<Map<String,Object>> findPxByDidCodeDateAType(
            String driver_id,
            String training_type_code,
            String training_theme_code,
            String year
    ) {
        //List今年
        List<TbBusinessPxOrTTT> tbBusinessPxOrTTTListNow=findAllTrainingTTT(driver_id,training_type_code,training_theme_code,year);

        //List去年
        List<TbBusinessPxOrTTT> tbBusinessPxOrTTTListYear=findAllTrainingTTT(driver_id,training_type_code,training_theme_code,Integer.toString(Integer.parseInt(year)-1));

        //处理输入数据
        //数据格式为：
        //｛月份：培训次数｝
        //｛月份：培训时长｝
        //｛月份：培训通过人数｝

        //今年数据
        Map<Integer,Double> mapTrainingTimesNow=new LinkedHashMap<>();
        Map<Integer,Double> mapTrainingTimeNow=new LinkedHashMap<>();
        Map<Integer,Double> mapPercentResultPassNow=new LinkedHashMap<>();
        //去年数据
        Map<Integer,Double> mapTrainingTimesYear=new LinkedHashMap<>();
        Map<Integer,Double> mapTrainingTimeYear=new LinkedHashMap<>();
        Map<Integer,Double> mapPercentResultPassYear=new LinkedHashMap<>();

        for(TbBusinessPxOrTTT tbBusinessPxOrTTT:tbBusinessPxOrTTTListNow){
            mapTrainingTimesNow.put(Integer.parseInt(tbBusinessPxOrTTT.getMonth()),Double.parseDouble(tbBusinessPxOrTTT.getTotal_training_times()));
            mapTrainingTimeNow.put(Integer.parseInt(tbBusinessPxOrTTT.getMonth()),Double.parseDouble(tbBusinessPxOrTTT.getTotal_training_time()));
            mapPercentResultPassNow.put(Integer.parseInt(tbBusinessPxOrTTT.getMonth()),Double.parseDouble(tbBusinessPxOrTTT.getTotal_result_pass()));
        }

        for(TbBusinessPxOrTTT tbBusinessPxOrTTT:tbBusinessPxOrTTTListYear){
            mapTrainingTimesYear.put(Integer.parseInt(tbBusinessPxOrTTT.getMonth()),Double.parseDouble(tbBusinessPxOrTTT.getTotal_training_times()));
            mapTrainingTimeYear.put(Integer.parseInt(tbBusinessPxOrTTT.getMonth()),Double.parseDouble(tbBusinessPxOrTTT.getTotal_training_time()));
            mapPercentResultPassYear.put(Integer.parseInt(tbBusinessPxOrTTT.getMonth()),Double.parseDouble(tbBusinessPxOrTTT.getTotal_result_pass()));
        }


        //培训次数同比数据
        List<Object> trainingTimesTMap=new ArrayList<>();
        //所需格式
        TongHuanBi tongHuanBi=new TongHuanBi();
        trainingTimesTMap=tongHuanBi.TongBiReturn(mapTrainingTimesNow,mapTrainingTimesYear);
//        //培训次数同比(Size==0)
//        for(int i=1;i<=12;i++){
//            //某月有数据并且去年此时也有数据
//            //培训次数同比
//            if(mapTrainingTimesNow.get(i)!=null) {
//                if (mapTrainingTimesYear.get(i) != null) {
//                    //今年参加培训去年参加培训
//                    Map<String,Object> trainingTimesTMapFormat=new LinkedHashMap<>();
//                    trainingTimesTMapFormat.put("name",i);
//                    trainingTimesTMapFormat.put("value",trainingTimesT(mapTrainingTimesNow.get(i), mapTrainingTimesYear.get(i)));
//                    trainingTimesTMap.add(trainingTimesTMapFormat);
//                }
//                else {
//                    //今年参加培训去年未参加培训
//                    Map<String,Object> trainingTimesTMapFormat=new LinkedHashMap<>();
//                    trainingTimesTMapFormat.put("name", i);
//                    trainingTimesTMapFormat.put("value", 100.0);
//                    trainingTimesTMap.add( trainingTimesTMapFormat);
//                }
//            }else {
//                if (mapTrainingTimesYear.get(i) != null) {
//                    //今年未参加培训去年参加培训
//                    Map<String,Object> trainingTimesTMapFormat=new LinkedHashMap<>();
//                    trainingTimesTMapFormat.put("name",i);
//                    trainingTimesTMapFormat.put("value",0.0);
//                    trainingTimesTMap.add(trainingTimesTMapFormat);
//                }
//                else {
//                    //今年未参加培训去年未参加培训
//                    Map<String,Object> trainingTimesTMapFormat=new LinkedHashMap<>();
//                    trainingTimesTMapFormat.put("name", i);
//                    trainingTimesTMapFormat.put("value", 0.0);
//                    trainingTimesTMap.add(trainingTimesTMapFormat);
//                }
//            }
//        }

        //培训次数环比数据
        List<Object> trainingTimesHMap=new ArrayList<>();
        //所需格式

        trainingTimesHMap=tongHuanBi.HuanBiReturn(mapTrainingTimesNow,mapTrainingTimesYear);

        //培训次数环比(Size==0)
//        for(int i=1;i<=12;i++){
//            //某月有数据并且上个月也有数据
//            //培训次数环比
//            //1月
//            if(i==1) {
//                if (mapTrainingTimesNow.get(i) != null) {
//                    if (mapTrainingTimesYear.get(12) != null) {
//                        //今月参加培训去月参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name",i);
//                        trainingTimesHMapFormat.put("value", trainingTimesH(mapTrainingTimesNow.get(i), mapTrainingTimesYear.get(12)));
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    } else {
//                        //今月参加培训去月未参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name", i);
//                        trainingTimesHMapFormat.put("value", 100.0);
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    }
//                } else {
//                    if (mapTrainingTimesYear.get(12) != null) {
//                        //今月未参加培训去月参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name",i);
//                        trainingTimesHMapFormat.put("value", 0.0);
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    } else {
//                        //今月未参加培训去月未参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name", i);
//                        trainingTimesHMapFormat.put("value", 0.0);
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    }
//                }
//            }
//            else {
//                if (mapTrainingTimesNow.get(i) != null) {
//                    if (mapTrainingTimesNow.get(i-1) != null) {
//                        //今月参加培训去月参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name",i);
//                        trainingTimesHMapFormat.put("value",trainingTimesH(mapTrainingTimesNow.get(i), mapTrainingTimesNow.get(i-1)));
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    } else{
//                        //今月参加培训去月未参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name",i);
//                        trainingTimesHMapFormat.put("value",100.0);
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    }
//                } else {
//                    if (mapTrainingTimesNow.get(i-1) != null) {
//                        //今月未参加培训去月参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name",i);
//                        trainingTimesHMapFormat.put("value",0.0);
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    } else {
//                        //今月未参加培训去月未参加培训
//                        Map<String,Object> trainingTimesHMapFormat=new LinkedHashMap<>();
//                        trainingTimesHMapFormat.put("name", i);
//                        trainingTimesHMapFormat.put("value", 0.0);
//                        trainingTimesHMap.add(trainingTimesHMapFormat);
//                    }
//                }
//            }
//        }

        //培训时长同比数据
        List<Object> trainingTimeTMap=new ArrayList<>();

        //所需格式

        //培训时长同比(Size==0)
        for(int i=1;i<=12;i++){
            //某月有数据并且去年此时也有数据
            //培训次数同比
            if(mapTrainingTimeNow.get(i)!=null) {
                if (mapTrainingTimeYear.get(i) != null) {
                    //今年参加培训去年参加培训
                    Map<String,Object> trainingTimeTMapFormat=new LinkedHashMap<>();
                    trainingTimeTMapFormat.put("name",i);
                    trainingTimeTMapFormat.put("value",trainingTimeT(mapTrainingTimesNow.get(i), mapTrainingTimeYear.get(i)));
                    trainingTimeTMap.add(trainingTimeTMapFormat);
                }
                else {
                    //今年参加培训去年未参加培训
                    Map<String,Object> trainingTimeTMapFormat=new LinkedHashMap<>();
                    trainingTimeTMapFormat.put("name", i);
                    trainingTimeTMapFormat.put("value", 100.0);
                    trainingTimeTMap.add(trainingTimeTMapFormat);
                }
            }else {
                if (mapTrainingTimeYear.get(i) != null) {
                    //今年未参加培训去年参加培训
                    Map<String,Object> trainingTimeTMapFormat=new LinkedHashMap<>();
                    trainingTimeTMapFormat.put("name",i);
                    trainingTimeTMapFormat.put("value",0.0);
                    trainingTimeTMap.add(trainingTimeTMapFormat);
                }
                else {
                    //今年未参加培训去年未参加培训
                    Map<String,Object> trainingTimeTMapFormat=new LinkedHashMap<>();
                    trainingTimeTMapFormat.put("name", i);
                    trainingTimeTMapFormat.put("value", 0.0);
                    trainingTimeTMap.add(trainingTimeTMapFormat);
                }
            }
        }

        //培训时长环比数据
        List<Object> trainingTimeHMap=new ArrayList<>();

        //所需格式


        //培训时长环比(Size==0)
        for(int i=1;i<=12;i++){
            //某月有数据并且上个月也有数据
            //培训时长环比
            //1月
            if(i==1) {
                if (mapTrainingTimeNow.get(i) != null) {
                    if (mapTrainingTimeYear.get(12) != null) {
                        //今月参加培训去月参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name",i);
                        trainingTimeHMapFormat.put("value",trainingTimeH(mapTrainingTimeNow.get(i), mapTrainingTimeYear.get(12)));
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    } else {
                        //今月参加培训去月未参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name", i);
                        trainingTimeHMapFormat.put("value", 100.0);
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    }
                } else {
                    if (mapTrainingTimeYear.get(12) != null) {
                        //今月未参加培训去月参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name",i);
                        trainingTimeHMapFormat.put("value", 0.0);
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    } else {
                        //今月未参加培训去月未参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name", i);
                        trainingTimeHMapFormat.put("value", 0.0);
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    }
                }
            }
            else {
                if (mapTrainingTimeNow.get(i) != null) {
                    if (mapTrainingTimeNow.get(i-1) != null) {
                        //今月参加培训去月参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name",i);
                        trainingTimeHMapFormat.put("value", trainingTimeH(mapTrainingTimeNow.get(i), mapTrainingTimeNow.get(i-1)));
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    } else {
                        //今月参加培训去月未参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name", i);
                        trainingTimeHMapFormat.put("value", 100.0);
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    }
                } else {
                    if (mapTrainingTimeNow.get(i-1) != null) {
                        //今月未参加培训去月参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name",i);
                        trainingTimeHMapFormat.put("value", 0.0);
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    } else {
                        //今月未参加培训去月未参加培训
                        Map<String,Object> trainingTimeHMapFormat=new LinkedHashMap<>();
                        trainingTimeHMapFormat.put("name", i);
                        trainingTimeHMapFormat.put("value", 0.0);
                        trainingTimeHMap.add(trainingTimeHMapFormat);
                    }
                }
            }
        }

        //培训通过率同比数据
        List<Object> percentResultPassTMap=new ArrayList<>();

        //所需格式

        //培训通过率同比(Size==0)
        for(int i=1;i<=12;i++){
            //某月有数据并且去年此时也有数据
            //培训次数同比
            if (mapPercentResultPassNow.get(i) != null) {
                if (mapPercentResultPassYear.get(i) != null) {
                    //今年参加培训去年参加培训
                    Map<String,Object> percentResultPassTMapFormat=new LinkedHashMap<>();
                    percentResultPassTMapFormat.put("name", i);
                    percentResultPassTMapFormat.put("value", percentResultPassT(
                            mapPercentResultPassNow.get(i),
                            mapPercentResultPassYear.get(i),
                            mapTrainingTimesNow.get(i),
                            mapTrainingTimesYear.get(i)));
                    percentResultPassTMap.add(percentResultPassTMapFormat);
                } else {
                    //今年参加培训去年未参加培训
                    Map<String,Object> percentResultPassTMapFormat=new LinkedHashMap<>();
                    percentResultPassTMapFormat.put("name", i);
                    percentResultPassTMapFormat.put("value", 100.0);
                    percentResultPassTMap.add(percentResultPassTMapFormat);
                }
            } else {
                if (mapPercentResultPassYear.get(i) != null) {
                    //今年未参加培训去年参加培训
                    Map<String,Object> percentResultPassTMapFormat=new LinkedHashMap<>();
                    percentResultPassTMapFormat.put("name",i);
                    percentResultPassTMapFormat.put("value", 0.0);
                    percentResultPassTMap.add(percentResultPassTMapFormat);
                } else {
                    //今年未参加培训去年未参加培训
                    Map<String,Object> percentResultPassTMapFormat=new LinkedHashMap<>();
                    percentResultPassTMapFormat.put("name", i);
                    percentResultPassTMapFormat.put("value", 0.0);
                    percentResultPassTMap.add(percentResultPassTMapFormat);
                }
            }
        }


        //培训通过率环比数据
        List<Object> percentResultPassHMap=new ArrayList<>();

        //所需格式

        //培训时长环比(Size==0)
        for(int i=1;i<=12;i++){
            //某月有数据并且上个月也有数据
            //培训通过率环比
            //1月
            if(i==1) {
                if (mapPercentResultPassNow.get(i) != null) {
                    if (mapPercentResultPassYear.get(12) != null) {
                        //今月参加培训去月参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name",i);
                        percentResultPassHMapFormat.put("value",
                                percentResultPassH(
                                        mapPercentResultPassNow.get(i),
                                        mapPercentResultPassYear.get(12),
                                        mapTrainingTimesNow.get(i),
                                        mapTrainingTimesYear.get(12)));
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    } else {
                        //今月参加培训去月未参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name", i);
                        percentResultPassHMapFormat.put("value", 100.0);
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    }
                } else {
                    if (mapTrainingTimeYear.get(12) != null) {
                        //今月未参加培训去月参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name",i);
                        percentResultPassHMapFormat.put("value", 0.0);
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    } else {
                        //今月未参加培训去月未参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name", i);
                        percentResultPassHMapFormat.put("value", 0.0);
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    }
                }
            }
            else {
                if (mapPercentResultPassNow.get(i) != null) {
                    if (mapPercentResultPassNow.get(i-1) != null) {
                        //今月参加培训去月参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name",i);
                        percentResultPassHMapFormat.put("value",
                                percentResultPassH(
                                        mapPercentResultPassNow.get(i),
                                        mapPercentResultPassNow.get(i-1),
                                        mapTrainingTimesNow.get(i),
                                        mapTrainingTimesNow.get(i-1)));
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    } else {
                        //今月参加培训去月未参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name", i);
                        percentResultPassHMapFormat.put("value", 100.0);
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    }
                } else {
                    if (mapPercentResultPassNow.get(i-1) != null) {
                        //今月未参加培训去月参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name",i);
                        percentResultPassHMapFormat.put("value", 0.0);
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    } else {
                        //今月未参加培训去月未参加培训
                        Map<String,Object> percentResultPassHMapFormat=new LinkedHashMap<>();
                        percentResultPassHMapFormat.put("name", i);
                        percentResultPassHMapFormat.put("value", 0.0);
                        percentResultPassHMap.add(percentResultPassHMapFormat);
                    }
                }
            }
        }

        //转成特定格式
        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //返回all数据map
        Map<String,Object> AllMap=null;
        List<Map<String,Object>> AllList=new ArrayList<>();
        //中间层Json数据封装
        AllMap=dataSetReturnJson.mapfunctionMiddleTH(trainingTimesTMap,trainingTimesHMap);
        for (String i:AllMap.keySet()){
            //外层Json数据封装
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        AllMap=dataSetReturnJson.mapfunctionMiddleTH(trainingTimeTMap,trainingTimeHMap);
        for (String i:AllMap.keySet()){
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        AllMap=dataSetReturnJson.mapfunctionMiddleTH(percentResultPassTMap,percentResultPassHMap);
        for (String i:AllMap.keySet()){
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }


        return AllList;
    }


    //培训通过率同比
    public Double percentResultPassT(
            Double resultPassNow,
            Double resultPassYear,
            Double trainingTimes,
            Double trainingTimesYear
    ) {
        //培训通过率相关
        Double percent_result_passT=null;
        //同比
        percent_result_passT = tongBiAHuanBiFunction(
                passPercent(trainingTimes, resultPassNow),
                passPercent(trainingTimesYear,resultPassYear));
        if(percent_result_passT.isInfinite())percent_result_passT=100.0;
        return percent_result_passT;
    }

    //培训通过率环比
    public Double percentResultPassH(
            Double resultPassNow,
            Double resultPassMonth,
            Double trainingTimes,
            Double trainingTimesMonth
    ) {
        //培训通过率相关
        Double percent_result_passH = null;
        //环比
        percent_result_passH = tongBiAHuanBiFunction(
                passPercent(trainingTimes, resultPassNow),
                passPercent(trainingTimesMonth,resultPassMonth));
        if(percent_result_passH.isInfinite())percent_result_passH=100.0;
        return percent_result_passH;
    }

    //培训时长同比
    public Double trainingTimeT(
            Double trainingTime,
            Double trainingTimeYear
    ) {
        //培训时长相关
        Double training_timeT = null;
        //同比
        training_timeT = tongBiAHuanBiFunction(trainingTime, trainingTimeYear);
        return training_timeT;
    }

    //培训时长环比
    public Double trainingTimeH(
            Double trainingTime,
            Double trainingTimeMonth
    ) {
        //培训时长相关
        Double training_timeH = null;
        //环比
        training_timeH = tongBiAHuanBiFunction(trainingTime, trainingTimeMonth);
        return training_timeH;
    }

    //培训次数同比
    public Double trainingTimesT(
            Double trainingTimes,
            Double trainingTimesYear
    ) {
        //培训次数相关
        Double training_timesT=null;
        //同比
        training_timesT = tongBiAHuanBiFunction(trainingTimes,trainingTimesYear);
        return training_timesT;
    }

    //培训次数环比
    public Double trainingTimesH(
            Double trainingTimes,
            Double trainingTimesMonth
    ) {
        //培训次数相关
        Double training_timesH = null;
        //环比
        training_timesH = tongBiAHuanBiFunction(trainingTimes, trainingTimesMonth);
        return training_timesH;
    }

    //培训通过率
    private Double passPercent(Double all,Double pass){
        Double passpercent=pass/all*100.0;
        return passpercent;
    }

    //同比和环比计算
    private Double tongBiAHuanBiFunction(Double now,Double last){
        Double result=(now-last)/last*100.0;
        return result;
    }
}
