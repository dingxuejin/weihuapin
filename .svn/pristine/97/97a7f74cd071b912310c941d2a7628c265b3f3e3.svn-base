package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectXlzbMapper;
import com.mobiusVision.pojo.TbBusiness.TbSubjectXlzbTjXxExtends;
import com.mobiusVision.util.ApplicationContextUtil;
import com.mobiusVision.util.DataSetReturnJson;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:线路指标统计相关
 * @Date:Created in 18:52 2018/6/29/029
 * @Modify By:
 **/
public class TbSubjectXlzbService {

    //获取SpringBean
    ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
    TbSubjectXlzbMapper tbSubjectXlzbMapper = (TbSubjectXlzbMapper) aplc.getBean("tbSubjectXlzbMapper");

    //通过driver_id查询人员线路所有年和某年所有月的相关统计信息信息
    public List<TbSubjectXlzbTjXxExtends> findAllTjXxYearMonthByDId(
            String driver_id,
            String route_id,
            String year){
        List<TbSubjectXlzbTjXxExtends> tbSubjectXlzbTjXxExtendsList=tbSubjectXlzbMapper.findAllTjXxYearMonthByDId(driver_id,route_id,year);
        return tbSubjectXlzbTjXxExtendsList;
    }

    private DataSetReturnJson dataSetReturnJson=new DataSetReturnJson();
    //通过driver_id查询人员线路所有年和某年所有月的相关统计信息信息toJson
    public List<Map<String ,Object>> findAllTjXxYearMonthToJsonByDId(
            String driver_id,
            String route_id,
            String year){
        List<TbSubjectXlzbTjXxExtends> tbSubjectXlzbTjXxExtendsList=null;

        //lastJsonList
        List<Map<String ,Object>> allListMap=new ArrayList<>();

        //middleJsonMap
        Map<String,Object> MapYearOrMonth=null;

        //运单量
        List<Map<String,Object>> list_waybill_quantity=new ArrayList<>();
        //平均运单量
        List<Map<String,Object>> list_avg_waybill_quantity=new ArrayList<>();

        //周转量
        List<Map<String,Object>> list_turnover=new ArrayList<>();
        //平均周转量
        List<Map<String,Object>> list_avg_turnover=new ArrayList<>();

        //平均油耗
        List<Map<String,Object>> list_average_fuel_cost=new ArrayList<>();
        //线路标准油耗
        List<Map<String,Object>> list_standard_oil_use=new ArrayList<>();
        //车队平均油耗
        List<Map<String,Object>> list_fleet_average_fuel_cost=new ArrayList<>();
        //公司平均油耗
        List<Map<String,Object>> list_company_average_fuel_cost=new ArrayList<>();

        //平均驾驶时长
        List<Map<String,Object>> list_average_driving_time=new ArrayList<>();
        //线路标准时长
        List<Map<String,Object>> list_standard_time=new ArrayList<>();
        //车队平均驾驶时长
        List<Map<String,Object>> list_fleet_average_driving_time=new ArrayList<>();
        //公司平均驾驶时长
        List<Map<String,Object>> list_company_average_driving_time=new ArrayList<>();

        //所有年数据(year==null)
        if(year == null) {
            //获取所有年最初数据
            tbSubjectXlzbTjXxExtendsList=findAllTjXxYearMonthByDId(driver_id,route_id,year);

            for (TbSubjectXlzbTjXxExtends tbSubjectXlzbTjXxExtends : tbSubjectXlzbTjXxExtendsList) {
                //运单量
                list_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getWaybill_quantity()));
                //平均运单量
                list_avg_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getAvg_waybill_quantity()));

                //周转量
                list_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getAvg_turnover()));
                //平均周转量
                list_avg_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getAvg_turnover()));

                //平均油耗
                list_average_fuel_cost.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getAverage_fuel_cost()));
                //线路标准油耗
                list_standard_oil_use.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getStandard_oil_use()));
                //车队平均油耗
                list_fleet_average_fuel_cost.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getFleet_average_fuel_cost()));
                //公司平均油耗
                list_company_average_fuel_cost.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getCompany_average_fuel_cost()));

                //平均驾驶时长
                list_average_driving_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getAverage_driving_time()));
                //线路标准时长
                list_standard_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getStandard_time()));
                //车队平均驾驶时长
                list_fleet_average_driving_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getFleet_average_driving_time()));
                //公司平均驾驶时长
                list_company_average_driving_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getYear(), tbSubjectXlzbTjXxExtends.getCompany_average_driving_time()));
            }
        }else{
            //获取所有月最初数据
            tbSubjectXlzbTjXxExtendsList=findAllTjXxYearMonthByDId(driver_id,route_id,year);

            for (TbSubjectXlzbTjXxExtends tbSubjectXlzbTjXxExtends : tbSubjectXlzbTjXxExtendsList) {
                //运单量
                list_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getWaybill_quantity()));
                //平均运单量
                list_avg_waybill_quantity.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getAvg_waybill_quantity()));

                //周转量
                list_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getAvg_turnover()));
                //平均周转量
                list_avg_turnover.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getAvg_turnover()));

                //平均油耗
                list_average_fuel_cost.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getAverage_fuel_cost()));
                //线路标准油耗
                list_standard_oil_use.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getStandard_oil_use()));
                //车队平均油耗
                list_fleet_average_fuel_cost.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getFleet_average_fuel_cost()));
                //公司平均油耗
                list_company_average_fuel_cost.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getCompany_average_fuel_cost()));

                //平均驾驶时长
                list_average_driving_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getAverage_driving_time()));
                //线路标准时长
                list_standard_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getStandard_time()));
                //车队平均驾驶时长
                list_fleet_average_driving_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getFleet_average_driving_time()));
                //公司平均驾驶时长
                list_company_average_driving_time.add(dataSetReturnJson.mapfunctionInValue(tbSubjectXlzbTjXxExtends.getMonth(), tbSubjectXlzbTjXxExtends.getCompany_average_driving_time()));
            }
        }

        //返回格式整理
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("运单数",list_waybill_quantity);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("线路平均运单数",list_avg_waybill_quantity);
        allListMap.add(MapYearOrMonth);

        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("周转量",list_turnover);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("线路平均周转量",list_avg_turnover);
        allListMap.add(MapYearOrMonth);

        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("驾驶员平均油耗",list_average_fuel_cost);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("线路标准油耗",list_standard_oil_use);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("车队平均油耗",list_fleet_average_fuel_cost);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("总公司平均油耗",list_company_average_fuel_cost);
        allListMap.add(MapYearOrMonth);

        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("驾驶员平均时长",list_average_driving_time);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("线路标准时长",list_standard_time);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("车队平均时长",list_fleet_average_driving_time);
        allListMap.add(MapYearOrMonth);
        MapYearOrMonth=dataSetReturnJson.mapfunctionOutData("总公司平均时长",list_company_average_driving_time);
        allListMap.add(MapYearOrMonth);

        return allListMap;
    }
}
