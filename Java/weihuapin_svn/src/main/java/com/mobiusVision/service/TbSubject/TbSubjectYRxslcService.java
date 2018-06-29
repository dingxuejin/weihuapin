package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectYRxslcMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectYRxslc;
import com.mobiusVision.util.ApplicationContextUtil;
import com.mobiusVision.util.DataSetReturnJson;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:行驶里程、重车里程、空车里程、空重里程比统计信息
 * @Date:Created in 14:59 2018/6/28/028
 * @Modify By:
 **/
public class TbSubjectYRxslcService {
    //获取SpringBean
    ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
    TbSubjectYRxslcMapper tbSubjectYRxslcMapper = (TbSubjectYRxslcMapper) aplc.getBean("tbSubjectYRxslcMapper");

    //通过driver_id查询所有年和某年所有月的信息及平均信息
    public List<TbSubjectYRxslc> findAllYearAMonthByDId(
            String driver_id,
            String year){
        List<TbSubjectYRxslc> tbSubjectYRxslcListYearAMonth=tbSubjectYRxslcMapper.findAllYearAMonthByDId(driver_id,year);
        return tbSubjectYRxslcListYearAMonth;
    }

    //通过driver_id查询某年某月所有天的信息及平均信息
    public List<TbSubjectYRxslc> findAllDayByDId(
            String driver_id,
            String year,
            String month){
        List<TbSubjectYRxslc> tbSubjectYRxslcListDay=tbSubjectYRxslcMapper.findAllDayByDId(driver_id,year,month);
        return tbSubjectYRxslcListDay;
    }

    private DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();
    //YearAMonth,Type:year(if year and month ==null) or month(if year!=null)
    public List<Map<String ,Object>> findAllYearAMonthJsonByDId(
            String driver_id,
            String year){

        //lastJsonList
        List<Map<String ,Object>> allListMap=new ArrayList<>();

        //middleJsonMap
        Map<String,Object> MapYearOrMonth=null;

        //行驶里程List
        List<Map<String,Object>> list_xslc=new ArrayList<>();

        //平均行驶里程List
        List<Map<String,Object>> avg_list_xslc=new ArrayList<>();

        //重车里程List
        List<Map<String,Object>> list_zclc=new ArrayList<>();

        //平均重车里程List
        List<Map<String,Object>> avg_list_zclc=new ArrayList<>();

        //空车里程List
        List<Map<String,Object>> list_kclc=new ArrayList<>();

        //平均空车里程List
        List<Map<String,Object>> avg_list_kclc=new ArrayList<>();

        //空重里程比List
        List<Map<String,Object>> list_kzclcb=new ArrayList<>();

        //平均空重里程比List
        List<Map<String,Object>> avg_list_kzclcb=new ArrayList<>();

        //所有年数据(year==null)
        if(year == null) {
            //获取所有年最初数据
            List<TbSubjectYRxslc> tbSubjectYRxslcListYear=findAllYearAMonthByDId(driver_id,year);

            for (TbSubjectYRxslc tbSubjectYRxslc : tbSubjectYRxslcListYear) {
                //行驶里程
                list_xslc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getTotal_km()));
                //平均行驶里程
                avg_list_xslc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getAvg_total_km()));
                //重车里程
                list_zclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getLoaded_km()));
                //平均重车里程
                avg_list_zclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getAvg_loaded_km()));
                //空车里程
                list_kclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getEmpty_km()));
                //平均空车里程
                avg_list_kclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getAvg_empty_km()));
                //空重里程比
                list_kzclcb.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getEmpty_loaded_rate()));
                //平均空重里程比
                avg_list_kzclcb.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getYear(), tbSubjectYRxslc.getAvg_empty_loaded_rate()));
            }
        }else{
            //获取所有月最初数据
            List<TbSubjectYRxslc> tbSubjectYRxslcListMonth=findAllYearAMonthByDId(driver_id,year);

            for (TbSubjectYRxslc tbSubjectYRxslc : tbSubjectYRxslcListMonth) {
                //行驶里程
                list_xslc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getTotal_km()));
                //平均行驶里程
                avg_list_xslc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getAvg_total_km()));
                //重车里程
                list_zclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getLoaded_km()));
                //平均重车里程
                avg_list_zclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getAvg_loaded_km()));
                //空车里程
                list_kclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getEmpty_km()));
                //平均空车里程
                avg_list_kclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getAvg_empty_km()));
                //空重里程比
                list_kzclcb.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getEmpty_loaded_rate()));
                //平均空重里程比
                avg_list_kzclcb.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getMonth(), tbSubjectYRxslc.getAvg_empty_loaded_rate()));
            }
        }

        //返回格式整理
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("行驶里程",list_xslc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均行驶里程",avg_list_xslc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("重车里程",list_zclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均重车里程",avg_list_zclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("空车里程",list_kclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均空车里程",avg_list_kclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("空重里程比",list_kzclcb);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均空重里程比",avg_list_kzclcb);
        allListMap.add(MapYearOrMonth);

        return allListMap;
    }

    //Day,year and month !=null
    public List<Map<String ,Object>> findAllDayJsonByDId(
            String driver_id,
            String year,
            String month){

        //lastJsonList
        List<Map<String ,Object>> allListMap=new ArrayList<>();

        //middleJsonMap
        Map<String,Object> MapYearOrMonth=null;

        //行驶里程List
        List<Map<String,Object>> list_xslc=new ArrayList<>();

        //平均行驶里程List
        List<Map<String,Object>> avg_list_xslc=new ArrayList<>();

        //重车里程List
        List<Map<String,Object>> list_zclc=new ArrayList<>();

        //平均重车里程List
        List<Map<String,Object>> avg_list_zclc=new ArrayList<>();

        //空车里程List
        List<Map<String,Object>> list_kclc=new ArrayList<>();

        //平均空车里程List
        List<Map<String,Object>> avg_list_kclc=new ArrayList<>();

        //空重里程比List
        List<Map<String,Object>> list_kzclcb=new ArrayList<>();

        //平均空重里程比List
        List<Map<String,Object>> avg_list_kzclcb=new ArrayList<>();


        //获取所有天最初数据
        List<TbSubjectYRxslc> tbSubjectYRxslcListDay=findAllDayByDId(driver_id,year,month);

        for (TbSubjectYRxslc tbSubjectYRxslc : tbSubjectYRxslcListDay) {
            //行驶里程
            list_xslc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getTotal_km()));
            //平均行驶里程
            avg_list_xslc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getAvg_total_km()));
            //重车里程
            list_zclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getLoaded_km()));
            //平均重车里程
            avg_list_zclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getAvg_loaded_km()));
            //空车里程
            list_kclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getEmpty_km()));
            //平均空车里程
            avg_list_kclc.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getAvg_empty_km()));
            //空重里程比
            list_kzclcb.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getEmpty_loaded_rate()));
            //平均空重里程比
            avg_list_kzclcb.add(dataSetReturnJson.mapfunctionInValue(tbSubjectYRxslc.getDay(), tbSubjectYRxslc.getAvg_empty_loaded_rate()));
        }


        //返回格式整理
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("行驶里程",list_xslc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均行驶里程",avg_list_xslc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("重车里程",list_zclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均重车里程",avg_list_zclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("空车里程",list_kclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均空车里程",avg_list_kclc);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("空重里程比",list_kzclcb);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("平均空重里程比",avg_list_kzclcb);
        allListMap.add(MapYearOrMonth);

        return allListMap;
    }
}
