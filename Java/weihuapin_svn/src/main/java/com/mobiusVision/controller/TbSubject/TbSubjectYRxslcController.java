package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.service.TbSubject.TbSubjectYRxslcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:行驶里程、重车里程、空车里程、空重里程比统计信息
 * @Date:Created in 16:00 2018/6/28/028
 * @Modify By:
 **/
@Api(description ="行驶里程、重车里程、空车里程、空重里程比统计信息")
@Controller
public class TbSubjectYRxslcController {
    TbSubjectYRxslcService tbSubjectYRxslcService=new TbSubjectYRxslcService();

    //YearAMonth,Type:year(if year and month ==null) or month(if year!=null)
    @ApiOperation(value = "查询人员年月日的行驶里程、重车里程、空车里程、空重里程比统计信息",
            notes = "年月不填则返回所有年数据，月不填则返回所有月数据，都填则返回所有日数据，数据表默认单位为天(type:0行驶里程及平均,1重车里程及平均,2空车里程及平均,3空重里程比及平均)",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = false, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月份", required = false, dataType = "String",defaultValue = "1"),
            @ApiImplicitParam(paramType="query", name = "type", value = "类型", required = true, dataType = "String",defaultValue = "0")
    })
    @RequestMapping("/TbSubjectYRxslcYearAMonthByDId")
    public @ResponseBody List<Map<String ,Object>> findAllYearAMonthJsonByDId(
            String driver_id,
            String year,
            String month,
            String type){
        if(driver_id==null)return null;
        List<Map<String ,Object>> allListMap=null;

        List<Map<String ,Object>> allListMapPart=null;

        //所有天的数据
        if(year!=null && month!=null) {
            allListMap = tbSubjectYRxslcService.findAllDayJsonByDId(driver_id, year, month);
            if(type.equals("0"))
                //行驶时长及平均
                allListMapPart=allListMap.subList(0,2);
            else if(type.equals("1"))
                //白昼行驶时长及平均
                allListMapPart=allListMap.subList(2,4);
            else if(type.equals("2"))
                //夜行驶时长及平均
                allListMapPart=allListMap.subList(4,6);
            else if(type.equals("3"))
                //夜行驶时长及平均
                allListMapPart=allListMap.subList(6,8);
        }
        else if(month==null) {
            //所有年或者所有月的数据
            allListMap = tbSubjectYRxslcService.findAllYearAMonthJsonByDId(driver_id, year);
            if(type.equals("0"))
                //行驶时长及平均
                allListMapPart=allListMap.subList(0,2);
            else if(type.equals("1"))
                //白昼行驶时长及平均
                allListMapPart=allListMap.subList(2,4);
            else if(type.equals("2"))
                //夜行驶时长及平均
                allListMapPart=allListMap.subList(4,6);
            else if(type.equals("3"))
                //夜行驶时长及平均
                allListMapPart=allListMap.subList(6,8);
        }
        return allListMapPart;
    }
}
