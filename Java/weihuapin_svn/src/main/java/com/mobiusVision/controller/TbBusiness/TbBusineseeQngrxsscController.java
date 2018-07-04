package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusineseeQngrxsscTjXx;
import com.mobiusVision.service.TbBusiness.TbBusineseeQngrxsscService;
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
 * @Description:人员行驶时长相关统计信息
 * @Date:Created in 12:23 2018/6/29/029
 * @Modify By:
 **/
@Api(description ="人员行驶时长相关统计信息（行驶时长、白昼行驶时长、夜间行驶时长相关）")
@Controller
public class TbBusineseeQngrxsscController {

    private TbBusineseeQngrxsscService tbBusineseeQngrxsscService=new TbBusineseeQngrxsscService();

    //YearMonthDay,allyear(if year and month ==null) or allmonth(if year!=null and month==null) or allday(if year!=null and month!=null)
    @ApiOperation(value = "查询人员行驶时长相关统计数据信息",
            notes = "年月不填则返回所有年份数据，年填月不填则返回所有月数据，年月都填则返回所有天数据(type:0行驶时长及平均,1白昼行驶时长及平均,2夜行驶时长及平均,3昼夜行驶时长比及平均)",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年", required = false, dataType = "String",defaultValue = "2014"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月（小于10都需要加0处理，如01）", required = false, dataType = "String",defaultValue = "01"),
            @ApiImplicitParam(paramType="query", name = "type", value = "类型", required = true, dataType = "String",defaultValue = "0")
    })
    @RequestMapping("/TbBusineseeQngrxsscTjXxByDId")
    public @ResponseBody List<Map<String ,Object>> findAllYearMonthDayTjXxByDIdToJson(
            String driver_id,
            String year,
            String month,
            String type){
        List<Map<String ,Object>> allListMap=tbBusineseeQngrxsscService.findAllYearMonthDayTjXxByDIdToJson(driver_id,year,month);
        List<Map<String ,Object>> allListMapPart=null;
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
            //昼夜行驶时长比及平均
            allListMapPart=allListMap.subList(6,8);
        return allListMapPart;
    }
}
