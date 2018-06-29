package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectDydslMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectDydslDay;
import com.mobiusVision.pojo.TbSubject.TbSubjectDydslMonth;
import com.mobiusVision.util.ApplicationContextUtil;
import com.mobiusVision.util.DataSetReturnJson;
import com.mobiusVision.util.TongHuanBi;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:人员运单相关业务层
 * @Date:Created in 16:47 2018/6/23/023
 * @Modify By:
 **/
public class TbSubjectDydslService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectDydslMapper tbSubjectJxjyMapper =(TbSubjectDydslMapper)aplc.getBean("tbSubjectDydslMapper");

    //通过driver_id查询tb_subject_dydsl_day表全月某天数据
    public List<TbSubjectDydslDay> findYdslAllOneDayByDId(
            String driver_id,
            String year,
            String month,
            String day){
        List<TbSubjectDydslDay> tbSubjectDydslDayList=tbSubjectJxjyMapper.findYdslAllOneDayByDId(driver_id,year,month,day);
        return tbSubjectDydslDayList;
    }

    //通过driver_id查询tb_subject_dydsl_day表全月每天数据
    public List<TbSubjectDydslDay> findYdslAllDayByDId(
            String driver_id,
            String year,
            String month
    ){

        List<TbSubjectDydslDay> tbSubjectDydslDayList=tbSubjectJxjyMapper.findYdslAllDayByDId(driver_id,year,month);
        return tbSubjectDydslDayList;
    }

    //通过driver_id查询tb_subject_dydsl_day表全年每月数据
    public List<TbSubjectDydslMonth> findYdslAllMonthByDId(
            String driver_id,
            String year
    ){

        List<TbSubjectDydslMonth> tbSubjectDydslMonthList=tbSubjectJxjyMapper.findYdslAllMonthByDId(driver_id,year);
        return tbSubjectDydslMonthList;
    }

    //通过driver_id查询tb_subject_dydsl_day表计算每天运单数量的同比环比
    public List<Map<String,Object>> findYdslAllDayTongHuanbiByDId(
            String driver_id,
            String year,
            String month,
            String capacity_unit_code){
        //当月数据
        List<TbSubjectDydslDay> tbSubjectDydslDayListNow=tbSubjectJxjyMapper.findYdslAllDayTongHuanbiByDId(driver_id,year,month,capacity_unit_code);
        //上月数据
        List<TbSubjectDydslDay> tbSubjectDydslDayListMonth=tbSubjectJxjyMapper.findYdslAllDayTongHuanbiByDId(driver_id,year,month,capacity_unit_code);
        //上年12月份数据
        List<TbSubjectDydslDay> tbSubjectDydslDayListLastYear=tbSubjectJxjyMapper.findYdslAllDayTongHuanbiByDId(driver_id,Integer.toString(Integer.parseInt(year)-1),"12",capacity_unit_code);
        //处理输入数据
        //数据格式为：
        //｛日：日运单数量｝
        //｛日：货物量｝

        //当月数据
        Map<Integer,Double> mapWaybillQuantityNow=new LinkedHashMap<>();
        Map<Integer,Double> mapVolumeNow=new LinkedHashMap<>();
        //上月数据
        Map<Integer,Double> mapWaybillQuantityMonth=new LinkedHashMap<>();
        Map<Integer,Double> mapVolumeMonth=new LinkedHashMap<>();
        //上年12月份数据
        Map<Integer,Double> mapWaybillQuantityLastYear=new LinkedHashMap<>();
        Map<Integer,Double> mapVolumeLastYear=new LinkedHashMap<>();

        for(TbSubjectDydslDay tbSubjectDydslDay:tbSubjectDydslDayListNow){
            mapWaybillQuantityNow.put(Integer.parseInt(tbSubjectDydslDay.getDay()),Double.parseDouble(tbSubjectDydslDay.getWaybill_Quantity()));
            mapVolumeNow.put(Integer.parseInt(tbSubjectDydslDay.getDay()),Double.parseDouble(tbSubjectDydslDay.getVolume()));
        }

        for(TbSubjectDydslDay tbSubjectDydslDay:tbSubjectDydslDayListMonth){
            mapWaybillQuantityMonth.put(Integer.parseInt(tbSubjectDydslDay.getDay()),Double.parseDouble(tbSubjectDydslDay.getWaybill_Quantity()));
            mapVolumeMonth.put(Integer.parseInt(tbSubjectDydslDay.getDay()),Double.parseDouble(tbSubjectDydslDay.getVolume()));
        }

        for(TbSubjectDydslDay tbSubjectDydslDay:tbSubjectDydslDayListLastYear){
            mapWaybillQuantityLastYear.put(Integer.parseInt(tbSubjectDydslDay.getDay()),Double.parseDouble(tbSubjectDydslDay.getWaybill_Quantity()));
            mapVolumeLastYear.put(Integer.parseInt(tbSubjectDydslDay.getDay()),Double.parseDouble(tbSubjectDydslDay.getVolume()));
        }

        //计算同环比
        //同比
        //waybillQuantity同比数据
        List<Object> waybillQuantityTList=new ArrayList<>();
        //所需格式
        TongHuanBi tongHuanBi=new TongHuanBi();
        waybillQuantityTList=tongHuanBi.TongBiReturnDay(mapWaybillQuantityNow,mapWaybillQuantityMonth,mapWaybillQuantityLastYear,Long.parseLong(year),Integer.parseInt(month));
        //volume同比数据
        List<Object> volumeTList=new ArrayList<>();
        //所需格式
        volumeTList=tongHuanBi.TongBiReturnDay(mapVolumeNow,mapVolumeMonth,mapVolumeLastYear,Long.parseLong(year),Integer.parseInt(month));

        //环比
        //waybillQuantity环比数据
        List<Object> waybillQuantityHList=new ArrayList<>();
        //所需格式
        waybillQuantityHList=tongHuanBi.HuanBiReturnDay(mapWaybillQuantityNow,mapWaybillQuantityMonth,mapWaybillQuantityLastYear,Long.parseLong(year),Integer.parseInt(month));
        //volume环比数据
        List<Object> volumeHList=new ArrayList<>();
        //所需格式
        volumeHList=tongHuanBi.HuanBiReturnDay(mapVolumeNow,mapVolumeMonth,mapVolumeLastYear,Long.parseLong(year),Integer.parseInt(month));

        //转成特定格式
        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //返回all数据map
        Map<String,Object> AllMap=null;
        List<Map<String,Object>> AllList=new ArrayList<>();
        //运单量和周转量特殊中间层Json数据封装
        AllMap=dataSetReturnJson.mapfunctionMiddleTHAydsl(waybillQuantityTList,volumeTList);
        for (String i:AllMap.keySet()){
            //外层Json数据封装
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        AllMap=dataSetReturnJson.mapfunctionMiddleTHAydsl(waybillQuantityHList,volumeHList);
        for (String i:AllMap.keySet()){
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }

        return AllList;
    }

    //通过driver_id查询tb_subject_dydsl_month表计算每月运单数量的同比环比
    public List<Map<String,Object>> findYdslAllMonthTongHuanbiByDId(
            String driver_id,
            String year,
            String capacity_unit_code){
        //当年分月数据
        List<TbSubjectDydslMonth> tbSubjectDydslMonthListNow=tbSubjectJxjyMapper.findYdslAllMonthTongHuanbiByDId(driver_id,year,capacity_unit_code);
        //去年分月数据
        List<TbSubjectDydslMonth> tbSubjectDydslMonthListYear=tbSubjectJxjyMapper.findYdslAllMonthTongHuanbiByDId(driver_id,year,capacity_unit_code);

        //处理输入数据
        //数据格式为：
        //｛月：月运单数量｝
        //｛月：月货物量｝

        //当年分月数据
        Map<Integer,Double> mapWaybillQuantityNow=new LinkedHashMap<>();
        Map<Integer,Double> mapVolumeNow=new LinkedHashMap<>();
        //去年分月数据
        Map<Integer,Double> mapWaybillQuantityYear=new LinkedHashMap<>();
        Map<Integer,Double> mapVolumeYear=new LinkedHashMap<>();

        for(TbSubjectDydslMonth tbSubjectDydslMonth:tbSubjectDydslMonthListNow){
            mapWaybillQuantityNow.put(Integer.parseInt(tbSubjectDydslMonth.getMonth()),Double.parseDouble(tbSubjectDydslMonth.getWaybill_Quantity()));
            mapVolumeNow.put(Integer.parseInt(tbSubjectDydslMonth.getMonth()),Double.parseDouble(tbSubjectDydslMonth.getVolume()));
        }

        for(TbSubjectDydslMonth tbSubjectDydslMonth:tbSubjectDydslMonthListYear){
            mapWaybillQuantityYear.put(Integer.parseInt(tbSubjectDydslMonth.getMonth()),Double.parseDouble(tbSubjectDydslMonth.getWaybill_Quantity()));
            mapVolumeYear.put(Integer.parseInt(tbSubjectDydslMonth.getMonth()),Double.parseDouble(tbSubjectDydslMonth.getVolume()));
        }

        //计算同环比
        //同比
        //waybillQuantity同比数据
        List<Object> waybillQuantityTList=new ArrayList<>();
        //所需格式
        TongHuanBi tongHuanBi=new TongHuanBi();
        waybillQuantityTList=tongHuanBi.TongBiReturn(mapWaybillQuantityNow,mapWaybillQuantityYear);
        //volume同比数据
        List<Object> volumeTList=new ArrayList<>();
        //所需格式
        volumeTList=tongHuanBi.TongBiReturn(mapVolumeNow,mapVolumeYear);

        //环比
        //waybillQuantity环比数据
        List<Object> waybillQuantityHList=new ArrayList<>();
        //所需格式
        waybillQuantityHList=tongHuanBi.HuanBiReturn(mapWaybillQuantityNow,mapWaybillQuantityYear);
        //volume环比数据
        List<Object> volumeHList=new ArrayList<>();
        //所需格式
        volumeHList=tongHuanBi.HuanBiReturn(mapVolumeNow,mapVolumeYear);

        //转成特定格式
        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //返回all数据map
        Map<String,Object> AllMap=null;
        List<Map<String,Object>> AllList=new ArrayList<>();
        //运单量和周转量特殊中间层Json数据封装
        AllMap=dataSetReturnJson.mapfunctionMiddleTHAydsl(waybillQuantityTList,volumeTList);
        for (String i:AllMap.keySet()){
            //外层Json数据封装
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        AllMap=dataSetReturnJson.mapfunctionMiddleTHAydsl(waybillQuantityHList,volumeHList);
        for (String i:AllMap.keySet()){
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        return AllList;
    }

    //通过driver_id查询tb_subject_dydsl_month表计算每年运单数量的同比环比
    public List<Map<String,Object>> findYdslAllYearTongHuanbiByDId(
            String driver_id,
            String capacity_unit_code){
        //所有年份数据
        List<TbSubjectDydslMonth> tbSubjectDydslYearListNow=tbSubjectJxjyMapper.findYdslAllYearTongHuanbiByDId(driver_id,capacity_unit_code);

        //处理输入数据
        //数据格式为：
        //｛年：年运单数量｝
        //｛年：年货物量｝

        //所有年份数据
        Map<Integer,Double> mapWaybillQuantity=new LinkedHashMap<>();
        Map<Integer,Double> mapVolume=new LinkedHashMap<>();

        for(TbSubjectDydslMonth tbSubjectDydslMonth:tbSubjectDydslYearListNow){
            mapWaybillQuantity.put(Integer.parseInt(tbSubjectDydslMonth.getYear()),Double.parseDouble(tbSubjectDydslMonth.getWaybill_Quantity()));
            mapVolume.put(Integer.parseInt(tbSubjectDydslMonth.getYear()),Double.parseDouble(tbSubjectDydslMonth.getVolume()));
        }

        TongHuanBi tongHuanBi=new TongHuanBi();
        //环比
        //waybillQuantity环比数据
        List<Object> waybillQuantityHList=new ArrayList<>();
        //所需格式
        waybillQuantityHList=tongHuanBi.HuanBiReturnYear(mapWaybillQuantity);
        //volume环比数据
        List<Object> volumeHList=new ArrayList<>();
        //所需格式
        volumeHList=tongHuanBi.HuanBiReturnYear(mapVolume);

        //转成特定格式
        DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

        //返回all数据map
        Map<String,Object> AllMap=null;
        List<Map<String,Object>> AllList=new ArrayList<>();
        //运单量和周转量特殊中间层Json数据封装
        AllMap=dataSetReturnJson.mapfunctionMiddleTHAydsl(null,null);
        for (String i:AllMap.keySet()){
            //外层Json数据封装
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        AllMap=dataSetReturnJson.mapfunctionMiddleTHAydsl(waybillQuantityHList,volumeHList);
        for (String i:AllMap.keySet()){
            AllList.add(dataSetReturnJson.mapfunctionOutData(i,AllMap.get(i)));
        }
        return AllList;
    }
}
