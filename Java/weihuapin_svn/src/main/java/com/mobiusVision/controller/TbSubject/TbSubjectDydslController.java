package com.mobiusVision.controller.TbSubject;

import com.google.gson.internal.LinkedTreeMap;
import com.mobiusVision.pojo.TbSubject.TbSubjectDydslDay;
import com.mobiusVision.pojo.TbSubject.TbSubjectDydslMonth;
import com.mobiusVision.service.TbSubject.TbSubjectDydslService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:人员运单相关接口
 * @Date:Created in 16:53 2018/6/23/023
 * @Modify By:
 **/
@Api(description ="人员运单相关接口")
@Controller
public class TbSubjectDydslController {

    TbSubjectDydslService tbSubjectDydslService=new TbSubjectDydslService();

    //通过driver_id查询全月每天数据和全年每月数据
    @ApiOperation(value = "查询人员运单全月每天数据和全年每月数据和全月某天数据",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = true, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月份", required = false, dataType = "String",defaultValue = "10"),
            @ApiImplicitParam(paramType="query", name = "day", value = "天", required = false, dataType = "String",defaultValue = "01")
    })
    @RequestMapping("/TbSubjectDydslMonthADayByDid")
    public @ResponseBody Map<String,Object> findYdslAllMonthDayByDId(
            String driver_id,
            String year,
            String month,
            String day
    ){

        if(driver_id==null&&year==null)return null;

        Map<String,Object> map=new LinkedHashMap<>();
        //查询全年每月数据
        if(month==null && day==null)  map.put("全年每月数据",tbSubjectDydslService.findYdslAllMonthByDId(driver_id,year));
        //查询全月每天数据
        else if(day==null) map.put("全月每天数据",tbSubjectDydslService.findYdslAllDayByDId(driver_id,year,month));
        else if(month!=null&&day!=null) map.put("某月某天数据",tbSubjectDydslService.findYdslAllOneDayByDId(driver_id,year,month,day));
        else return null;
        return map;
    }

    //通过driver_id查询tb_subject_dydsl_day表计算每天运单数量的同比环比
    @ApiOperation(value = "查询人员（某年某月某日(年月必写)/某年某月(年必写)/某年(无必写)）运单量和周转量同环比",
            notes = "type:0=日份运单量和周转量同比；1=日份运单量和周转量环比",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = false, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月份", required = false, dataType = "String",defaultValue = "10"),
            @ApiImplicitParam(paramType="query", name = "capacity_unit_code", value = "货物计量单位代码", required = true, dataType = "String",defaultValue = "1"),
            @ApiImplicitParam(paramType="query", name = "type", value = "查询类型", required = false, dataType = "String",defaultValue = "0")
    })
    @RequestMapping("/TbSubjectDydslYearMonthDayTongHuanbiByDid")
    public @ResponseBody List<Map<String,Object>> findYdslAllYearMonthDayTongHuanbiByDId(
            String driver_id,
            String year,
            String month,
            String capacity_unit_code,
            String type
    ){
        //检测输入合法性
        if(driver_id==null && capacity_unit_code==null) return null;

        //如果year，month都不为空
        if(year!=null && month!=null && Integer.parseInt(month)<=12 && Integer.parseInt(month)>0) {
            List<Map<String, Object>> mapList = tbSubjectDydslService.findYdslAllDayTongHuanbiByDId(driver_id, year, month, capacity_unit_code);

            List<Map<String, Object>> AllMapNow = mapList;
            if (type != null) {
                //运单量和周转量同比
                if (type.equals("0"))
                    AllMapNow = mapList.subList(0, 2);
                    //运单量和周转量环比
                else if (type.equals("1"))
                    AllMapNow = mapList.subList(2, 4);
            }

            return AllMapNow;
        }else if(year!=null && month==null){
            List<Map<String,Object>> mapList=tbSubjectDydslService.findYdslAllMonthTongHuanbiByDId(driver_id,year,capacity_unit_code);

            List<Map<String,Object>> AllMapNow=mapList;
            if(type!=null) {
                //运单量和周转量同比
                if (type.equals("0"))
                    AllMapNow=mapList.subList(0, 2);
                    //运单量和周转量环比
                else if (type.equals("1"))
                    AllMapNow=mapList.subList(2, 4);
            }
            return AllMapNow;
        }else if(year==null && month==null){
            List<Map<String,Object>> mapList=tbSubjectDydslService.findYdslAllYearTongHuanbiByDId(driver_id,capacity_unit_code);

            List<Map<String,Object>> AllMapNow=mapList;
            if(type!=null) {
                //运单量和周转量同比
                if (type.equals("0"))
                    AllMapNow=mapList.subList(0, 2);
                    //运单量和周转量环比
                else if (type.equals("1"))
                    AllMapNow=mapList.subList(2, 4);
            }
            return AllMapNow;
        }

        return null;
    }

    //合并成一个接口
//    //通过driver_id查询tb_subject_dydsl_day表计算每天运单数量的同比环比
//    @ApiOperation(value = "查询人员某年月份运单量和周转量同环比",
//            notes = "type:0=月份运单量和周转量同比；1=月份运单量和周转量环比",httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
//            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = true, dataType = "String",defaultValue = "2017"),
//            @ApiImplicitParam(paramType="query", name = "capacity_unit_code", value = "货物计量单位代码", required = true, dataType = "String",defaultValue = "1"),
//            @ApiImplicitParam(paramType="query", name = "type", value = "查询类型", required = false, dataType = "String",defaultValue = "0")
//    })
//    @RequestMapping("/TbSubjectDydslMonthTongHuanbiByDid")
//    public @ResponseBody List<Map<String,Object>> findYdslAllMonthTongHuanbiByDId(
//            String driver_id,
//            String year,
//            String capacity_unit_code,
//            String type
//    ){
//        //检测输入合法性
//        if(driver_id==null && year==null && capacity_unit_code==null) return null;
//        List<Map<String,Object>> mapList=tbSubjectDydslService.findYdslAllMonthTongHuanbiByDId(driver_id,year,capacity_unit_code);
//
//        List<Map<String,Object>> AllMapNow=mapList;
//        if(type!=null) {
//            //运单量和周转量同比
//            if (type.equals("0"))
//                AllMapNow=mapList.subList(0, 2);
//                //运单量和周转量环比
//            else if (type.equals("1"))
//                AllMapNow=mapList.subList(2, 4);
//        }
//        return AllMapNow;
//    }
//
//    //通过driver_id查询tb_subject_dydsl_month表计算每年运单数量的同比环比
//    @ApiOperation(value = "查询人员每年运单量和周转量同环比",
//            notes = "type:0=每年运单量和周转量同比；1=每年运单量和周转量环比",httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
//            @ApiImplicitParam(paramType="query", name = "capacity_unit_code", value = "货物计量单位代码", required = true, dataType = "String",defaultValue = "1"),
//            @ApiImplicitParam(paramType="query", name = "type", value = "查询类型", required = false, dataType = "String",defaultValue = "0")
//    })
//    @RequestMapping("/TbSubjectDydslYearTongHuanbiByDid")
//    public @ResponseBody List<Map<String,Object>> findYdslAllYearTongHuanbiByDId(
//            String driver_id,
//            String capacity_unit_code,
//            String type
//    ){
//        //检测输入合法性
//        if(driver_id==null && capacity_unit_code==null) return null;
//        List<Map<String,Object>> mapList=tbSubjectDydslService.findYdslAllYearTongHuanbiByDId(driver_id,capacity_unit_code);
//
//        List<Map<String,Object>> AllMapNow=mapList;
//        if(type!=null) {
//            //运单量和周转量同比
//            if (type.equals("0"))
//                AllMapNow=mapList.subList(0, 2);
//                //运单量和周转量环比
//            else if (type.equals("1"))
//                AllMapNow=mapList.subList(2, 4);
//        }
//        return AllMapNow;
//    }
}
