package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusineseeQngrxsscMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusineseeQngrxsscTjXx;
import com.mobiusVision.util.ApplicationContextUtil;
import com.mobiusVision.util.DataSetReturnJson;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:人员行驶时长相关统计信息
 * @Date:Created in 11:15 2018/6/29/029
 * @Modify By:
 **/
public class TbBusineseeQngrxsscService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbBusineseeQngrxsscMapper tbBusineseeQngrxsscMapper =(TbBusineseeQngrxsscMapper)aplc.getBean("tbBusineseeQngrxsscMapper");

    private DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

    //通过driver_id查询TB_BUSINESEE_QNGRXSSC查询全年各日行驶时长表（档案Excel）中年月日所有行驶里程相关统计信息
    public List<TbBusineseeQngrxsscTjXx> findAllYearMonthDayTjXxByDId(
            String driver_id,
            String year,
            String month){
        List<TbBusineseeQngrxsscTjXx> tbBusineseeQngrxsscTjXxList=tbBusineseeQngrxsscMapper.findAllYearMonthDayTjXxByDId(driver_id,year,month);
        return tbBusineseeQngrxsscTjXxList;
    }

    //YearMonthDay,allyear(if year and month ==null) or allmonth(if year!=null and month==null) or allday(if year!=null and month!=null)
    public List<Map<String ,Object>> findAllYearMonthDayTjXxByDIdToJson(
            String driver_id,
            String year,
            String month){
        //lastJsonList
        List<Map<String ,Object>> allListMap=new ArrayList<>();

        //middleJsonMap
        Map<String,Object> MapYearOrMonthOrDay=null;

        //行驶时长List
        List<Map<String,Object>> list_drive_time=new ArrayList<>();

        //平均行驶时长List
        List<Map<String,Object>> avg_list_drive_time=new ArrayList<>();

        //白昼行驶时长List
        List<Map<String,Object>> list_day_drive_time=new ArrayList<>();

        //平均白昼行驶时长List
        List<Map<String,Object>> avg_list_day_drive_time=new ArrayList<>();

        //夜行驶时长List
        List<Map<String,Object>> list_night_drive_time=new ArrayList<>();

        //平均夜行驶时长List
        List<Map<String,Object>> avg_list_night_drive_time=new ArrayList<>();

        //昼夜行驶时长比List
        List<Map<String,Object>> list_day_night_drive_time_rate=new ArrayList<>();

        //平均昼夜行驶时长比List
        List<Map<String,Object>> avg_list_day_night_drive_time_rate=new ArrayList<>();

        List<TbBusineseeQngrxsscTjXx> tbBusineseeQngrxsscTjXxList=null;

        if(year==null && month==null){
            //所有年的统计信息
            tbBusineseeQngrxsscTjXxList=findAllYearMonthDayTjXxByDId(driver_id,year,month);
            for(TbBusineseeQngrxsscTjXx tbBusineseeQngrxsscTjXx:tbBusineseeQngrxsscTjXxList){
                //行驶时长
                list_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getDrive_time()));
                //平均行驶时长
                avg_list_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getAvg_drive_time()));
                //白昼行驶时长
                list_day_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getDay_drive_time()));
                //平均白昼行驶时长
                avg_list_day_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getAvg_day_drive_time()));
                //夜行驶时长
                list_night_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getNight_drive_time()));
                //平均夜行驶时长
                avg_list_night_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getAvg_night_drive_time()));
                //昼夜行驶时长比
                list_day_night_drive_time_rate.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getDay_night_drive_time_rate()));
                //平均昼夜行驶时长比
                avg_list_day_night_drive_time_rate.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getYear(),tbBusineseeQngrxsscTjXx.getAvg_day_night_drive_time_rate()));
            }
        }else if(year!=null && month==null){
            //所有月的统计信息
            tbBusineseeQngrxsscTjXxList=findAllYearMonthDayTjXxByDId(driver_id,year,month);
            for(TbBusineseeQngrxsscTjXx tbBusineseeQngrxsscTjXx:tbBusineseeQngrxsscTjXxList){
                //行驶时长
                list_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getDrive_time()));
                //平均行驶时长
                avg_list_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getAvg_drive_time()));
                //白昼行驶时长
                list_day_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getDay_drive_time()));
                //平均白昼行驶时长
                avg_list_day_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getAvg_day_drive_time()));
                //夜行驶时长
                list_night_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getNight_drive_time()));
                //平均夜行驶时长
                avg_list_night_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getAvg_night_drive_time()));
                //昼夜行驶时长比
                list_day_night_drive_time_rate.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getDay_night_drive_time_rate()));
                //平均昼夜行驶时长比
                avg_list_day_night_drive_time_rate.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getMonth(),tbBusineseeQngrxsscTjXx.getAvg_day_night_drive_time_rate()));
            }
        }else if(year!=null && month!=null){
            //所有天的统计信息
            tbBusineseeQngrxsscTjXxList=findAllYearMonthDayTjXxByDId(driver_id,year,month);
            for(TbBusineseeQngrxsscTjXx tbBusineseeQngrxsscTjXx:tbBusineseeQngrxsscTjXxList){
                //行驶时长
                list_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getDrive_time()));
                //平均行驶时长
                avg_list_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getAvg_drive_time()));
                //白昼行驶时长
                list_day_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getDay_drive_time()));
                //平均白昼行驶时长
                avg_list_day_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getAvg_day_drive_time()));
                //夜行驶时长
                list_night_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getNight_drive_time()));
                //平均夜行驶时长
                avg_list_night_drive_time.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getAvg_night_drive_time()));
                //昼夜行驶时长比
                list_day_night_drive_time_rate.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getDay_night_drive_time_rate()));
                //平均昼夜行驶时长比
                avg_list_day_night_drive_time_rate.add(dataSetReturnJson.mapfunctionInValue(tbBusineseeQngrxsscTjXx.getDay(),tbBusineseeQngrxsscTjXx.getAvg_day_night_drive_time_rate()));
            }
        }

        //返回格式整理
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("行驶时长",list_drive_time);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("平均行驶时长",avg_list_drive_time);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("白昼行驶时长",list_day_drive_time);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("平均白昼行驶时长",avg_list_day_drive_time);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("夜间行驶时长",list_night_drive_time);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("平均夜间行驶时长",avg_list_night_drive_time);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("昼夜行驶时长比",list_day_night_drive_time_rate);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("平均昼夜行驶时长比",avg_list_day_night_drive_time_rate);
        allListMap.add(MapYearOrMonthOrDay);

        return allListMap;
    }
}
