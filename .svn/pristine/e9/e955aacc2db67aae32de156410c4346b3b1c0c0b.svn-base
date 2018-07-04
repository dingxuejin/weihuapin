package com.mobiusVision.service.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyHwzzl;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyMryd;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyMyyd;
import com.mobiusVision.util.DataSetReturnJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:企业年月日运单和周转量统计信息相关
 * @Date:Created in 16:02 2018/7/3/003
 * @Modify By:
 **/
public class TbSubjectQyMYRydAndHwzzlService {

    //企业年月日运单统计表
    TbSubjectQyMYRydService tbSubjectQyMYRydService=new TbSubjectQyMYRydService();
    //企业年月周转量统计表
    TbSubjectQyHwzzlService tbSubjectQyHwzzlService=new TbSubjectQyHwzzlService();

    private DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();

    //通过entity_id查询年月日的运单和周转量统计信息
    public List<Map<String,Object>> findMYYDAndHwzzlAllYearMonthDayByEIdToJson(
            String entity_id,
            String year,
            List<String> monthlist){

        //lastJsonList
        List<Map<String ,Object>> allListMap=new ArrayList<>();

        //middleJsonMap
        Map<String,Object> MapYearOrMonthOrDay=null;

        //运单量
        List<Map<String,Object>> list_waybill_quantity=new ArrayList<>();

        //周转量
        List<Map<String,Object>> list_turnover=new ArrayList<>();

        //运单量周转量年月数据
        List<TbSubjectQyMyyd> tbSubjectQyMyydList=null;
        List<TbSubjectQyHwzzl> tbSubjectQyHwzzlList=null;
        //运单量日数据
        List<TbSubjectQyMryd> tbSubjectQyMrydList=null;

        if(year==null && monthlist.size()==0){
            //所有年的统计信息
            //运单量
            tbSubjectQyMyydList=tbSubjectQyMYRydService.findMYYDAllYearMonthByEId(entity_id,year,null);
            //周转量
            tbSubjectQyHwzzlList=tbSubjectQyHwzzlService.findHwzzlAllYearMonthByEId(entity_id,year,null);
            for(TbSubjectQyMyyd tbSubjectQyMyyd:tbSubjectQyMyydList){
                //运单量
                list_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyMyyd.getYear(),tbSubjectQyMyyd.getWaybill_quantity()));
            }
            for(TbSubjectQyHwzzl tbSubjectQyHwzzl:tbSubjectQyHwzzlList){
                //周转量
                list_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyHwzzl.getYear(),tbSubjectQyHwzzl.getTurnover()));
            }
        }else if(year!=null && monthlist.size()==0){
            //所有月的统计信息
            //运单量
            tbSubjectQyMyydList=tbSubjectQyMYRydService.findMYYDAllYearMonthByEId(entity_id,year,null);
            //周转量
            tbSubjectQyHwzzlList=tbSubjectQyHwzzlService.findHwzzlAllYearMonthByEId(entity_id,year,null);
            for(TbSubjectQyMyyd tbSubjectQyMyyd:tbSubjectQyMyydList){
                //运单量
                list_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyMyyd.getMonth(),tbSubjectQyMyyd.getWaybill_quantity()));
            }
            for(TbSubjectQyHwzzl tbSubjectQyHwzzl:tbSubjectQyHwzzlList){
                //周转量
                list_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyHwzzl.getMonth(),tbSubjectQyHwzzl.getTurnover()));
            }
        }else if(year!=null && monthlist.size()==1){
            //所有天的统计信息
            //运单量
            tbSubjectQyMrydList=tbSubjectQyMYRydService.findMYYDAllDayByEId(entity_id,year,monthlist.get(0));
            for(TbSubjectQyMryd tbSubjectQyMryd:tbSubjectQyMrydList){
                //运单量
                list_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyMryd.getDay(),tbSubjectQyMryd.getWaybill_quantity()));
            }
        }else if(year!=null && monthlist.size()>1){
            //部分月的统计信息
            //运单量
            tbSubjectQyMyydList=tbSubjectQyMYRydService.findMYYDAllYearMonthByEId(entity_id,year,monthlist);
            //周转量
            tbSubjectQyHwzzlList=tbSubjectQyHwzzlService.findHwzzlAllYearMonthByEId(entity_id,year,monthlist);
            for(TbSubjectQyMyyd tbSubjectQyMyyd:tbSubjectQyMyydList){
                //运单量
                list_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyMyyd.getMonth(),tbSubjectQyMyyd.getWaybill_quantity()));
            }
            for(TbSubjectQyHwzzl tbSubjectQyHwzzl:tbSubjectQyHwzzlList){
                //周转量
                list_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectQyHwzzl.getMonth(),tbSubjectQyHwzzl.getTurnover()));
            }
        }

        //返回格式整理
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("运单量",list_waybill_quantity);
        allListMap.add(MapYearOrMonthOrDay);
        MapYearOrMonthOrDay=dataSetReturnJson.mapfunctionOutData("周转量",list_turnover);
        allListMap.add(MapYearOrMonthOrDay);

        return allListMap;
    }
}
